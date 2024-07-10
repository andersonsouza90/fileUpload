package com.JavaTestTask.service;

import com.JavaTestTask.model.FileDataDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileProcessorService {
    String processFile(MultipartFile file, String delimiter) throws IOException;
}
