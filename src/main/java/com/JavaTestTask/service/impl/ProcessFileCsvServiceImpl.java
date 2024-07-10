package com.JavaTestTask.service.impl;

import com.JavaTestTask.model.entity.FileData;
import com.JavaTestTask.repository.FileDataRepository;
import com.JavaTestTask.service.FileProcessorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProcessFileCsvServiceImpl implements FileProcessorService {

    private final FileDataRepository repository;
    @Override
    public String processFile(MultipartFile file, String delimiter) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {

            List<FileData> data = new ArrayList<>();

            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {

                // Skip the header line
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] lineFields = line.split(delimiter);

                FileData fileData = new FileData();
                fileData.setName(lineFields[0]);
                fileData.setPhone(lineFields[1]);
                repository.save(fileData);
                data.add(fileData);
            }

            data.forEach(r -> {
                System.out.println(r.toString());
            });

            return "CSV uploaded and processed successfully.";
        }
    }

}
