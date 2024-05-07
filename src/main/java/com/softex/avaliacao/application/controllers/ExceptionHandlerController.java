package com.softex.avaliacao.application.controllers;

import com.softex.avaliacao.application.dto.exception.ExceptionResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;


@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {


    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<ExceptionResponseDTO> handleRunTimeException(final Exception e) {
        log.error("unexpected error", e);

        final ExceptionResponseDTO exceptionResponse = new ExceptionResponseDTO(e.getMessage(), INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(exceptionResponse, INTERNAL_SERVER_ERROR);
    }
}
