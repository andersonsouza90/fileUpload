package com.JavaTestTask.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileSaveUploadService {
    boolean save(MultipartFile file);
}
