package com.JavaTestTask.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileProcessorService {
    String processFile(MultipartFile file, String delimiter) throws IOException;
}
