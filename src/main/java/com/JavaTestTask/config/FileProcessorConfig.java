package com.JavaTestTask.config;

import com.JavaTestTask.enuns.FileProcessorEnum;
import com.JavaTestTask.repository.FileDataRepository;
import com.JavaTestTask.service.FileProcessorService;
import com.JavaTestTask.service.impl.ProcessFileCsvServiceImpl;
import com.JavaTestTask.service.impl.ProcessFileExcelServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class FileProcessorConfig {

    @Bean
    public Map<FileProcessorEnum, FileProcessorService> fileProcessorMap(ProcessFileCsvServiceImpl csvService, ProcessFileExcelServiceImpl excelService) {
        Map<FileProcessorEnum, FileProcessorService> map = new HashMap<>();
        map.put(FileProcessorEnum.CSV, csvService);
        map.put(FileProcessorEnum.EXCEL, excelService);
        return map;
    }

}
