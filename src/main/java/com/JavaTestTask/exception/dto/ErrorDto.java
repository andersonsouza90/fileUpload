package com.JavaTestTask.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDto {
    private LocalDateTime timestamp;
    private String error;
    private String message;
    private String path;
}
