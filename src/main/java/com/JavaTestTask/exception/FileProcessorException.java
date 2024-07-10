package com.JavaTestTask.exception;

import com.JavaTestTask.exception.dto.ErrorDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class FileProcessorException {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDto tratarErro500(Exception ex, HttpServletRequest req) {
        return new ErrorDto(
                LocalDateTime.now(),
                ex.getClass().toString(),
                ex.getMessage(),
                req.getRequestURI()
        );
    }
}
