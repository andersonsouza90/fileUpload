package com.JavaTestTask.service;

import com.JavaTestTask.model.FileDataDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileSaveUploadService {
    boolean save(MultipartFile file);
}
