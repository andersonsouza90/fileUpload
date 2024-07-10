package com.JavaTestTask.model.mapper;

import com.JavaTestTask.model.FileDataDto;
import com.JavaTestTask.model.entity.FileData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FileDataMapper {
    FileDataMapper INSTANCE = Mappers.getMapper(FileDataMapper.class);

    FileDataDto toDto(FileData fileData);
    List<FileDataDto> toDtoList(List<FileData> fileDataList);

}
