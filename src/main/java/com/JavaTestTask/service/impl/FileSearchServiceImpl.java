package com.JavaTestTask.service.impl;

import com.JavaTestTask.model.FileDataDto;
import com.JavaTestTask.model.mapper.FileDataMapper;
import com.JavaTestTask.repository.FileDataRepository;
import com.JavaTestTask.service.FileSearchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FileSearchServiceImpl implements FileSearchService {

    private final FileDataRepository repository;
    @Override
    public List<FileDataDto> search(String search) {

        return FileDataMapper.INSTANCE.toDtoList(repository.findByNameOrPhone(search));
    }
}
