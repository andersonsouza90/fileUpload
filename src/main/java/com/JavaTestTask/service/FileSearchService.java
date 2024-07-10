package com.JavaTestTask.service;

import com.JavaTestTask.model.FileDataDto;

import java.util.List;

public interface FileSearchService {
    List<FileDataDto> search(String search);
}
