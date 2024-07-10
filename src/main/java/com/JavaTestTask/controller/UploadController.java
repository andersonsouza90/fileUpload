package com.JavaTestTask.controller;

import com.JavaTestTask.enuns.FileProcessorEnum;
import com.JavaTestTask.model.FileDataDto;
import com.JavaTestTask.service.FileProcessorService;
import com.JavaTestTask.service.FileSaveUploadService;
import com.JavaTestTask.service.FileSearchService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;


import static com.JavaTestTask.Utils.getFileExtension;

@RestController
@RequestMapping(value = "/upload")
@AllArgsConstructor
public class UploadController {

    private final FileSaveUploadService fileSaveUploadService;
    private final Map<FileProcessorEnum, FileProcessorService> fileProcessorMap;
    private final FileSearchService fileSearchService;

    @GetMapping
    public ResponseEntity<List<FileDataDto>> searchFile(@RequestParam("search") String search){
        return ResponseEntity.status(HttpStatus.OK).body(fileSearchService.search(search));
    }

    @PostMapping
    public ResponseEntity<String> uploadCsv(@RequestParam("file") MultipartFile file,
                                            @RequestParam(value = "delimiter", defaultValue = ",") String delimiter) {

        String fileName = file.getOriginalFilename();
        FileProcessorEnum.toValidExtension(getFileExtension(fileName));

        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload a valid file.");
        }

        if (fileName == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid file name.");
        }

        try {

            fileSaveUploadService.save(file);

            FileProcessorEnum fileProcessorType;
            if (fileName != null && fileName.endsWith(".csv")) {
                fileProcessorType = FileProcessorEnum.CSV;
            } else {
                fileProcessorType = FileProcessorEnum.EXCEL;
            }

            FileProcessorService fileProcessor = fileProcessorMap.get(fileProcessorType);
            String message = fileProcessor.processFile(file, delimiter);

            return ResponseEntity.status(HttpStatus.OK).body(message);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing the file. " + e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }


    }

}