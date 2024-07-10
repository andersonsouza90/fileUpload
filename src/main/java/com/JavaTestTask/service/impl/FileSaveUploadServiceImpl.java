package com.JavaTestTask.service.impl;

import com.JavaTestTask.service.FileSaveUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileSaveUploadServiceImpl implements FileSaveUploadService {

    private static final String FILES_DIR = "uploads/";
    @Override
    public boolean save(MultipartFile file) {

        try {
            Path uploadPath = Paths.get(FILES_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return true;

        }catch (Exception e){
            throw new IllegalArgumentException("Error to save file: " + e.getMessage());
        }


    }
}
