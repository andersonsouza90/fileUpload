package com.JavaTestTask.service.impl;

import com.JavaTestTask.model.entity.FileData;
import com.JavaTestTask.repository.FileDataRepository;
import com.JavaTestTask.service.FileProcessorService;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@AllArgsConstructor
public class ProcessFileExcelServiceImpl implements FileProcessorService {

    private final FileDataRepository repository;
    @Override
    public String processFile(MultipartFile file, String delimiter) throws IOException {

        try (Workbook w = new XSSFWorkbook(file.getInputStream())) {

            List<FileData> dataList = new ArrayList<>();
            Sheet sheet = w.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {

                Row row = rowIterator.next();
                FileData fileData = new FileData();
                fileData.setNome(String.valueOf(row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)));
                fileData.setTelefone(String.valueOf(row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK)));

                dataList.add(fileData);
            }

            repository.saveAll(dataList);

            dataList.forEach(r -> {
                System.out.println(r.toString());
            });

            return "Excel uploaded successfully.";
        }
    }
}
