package com.chayton.i18n.web.controller;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ChaytonRiver
 * @Date: 2019-06-04 11:23
 */
@ControllerAdvice
public class ValidationAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity processMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, Object> responseBody = new HashMap<>(3);
        responseBody.put("status_code", "500");

        String errorMessage = ex.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                .reduce((s1, s2) -> s1.concat(",").concat(s2)).get();

        responseBody.put("status_msg", errorMessage);
        return new ResponseEntity(responseBody, null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
