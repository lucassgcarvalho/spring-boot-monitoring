/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  br.com.forum.exceptions.DuplicidadeException
 *  br.com.forum.exceptions.ErrorHandler
 *  br.com.forum.exceptions.RestExceptionHandler
 *  javax.persistence.EntityNotFoundException
 *  org.springframework.http.HttpHeaders
 *  org.springframework.http.HttpStatus
 *  org.springframework.http.ResponseEntity
 *  org.springframework.http.converter.HttpMessageNotReadableException
 *  org.springframework.web.bind.annotation.ControllerAdvice
 *  org.springframework.web.bind.annotation.ExceptionHandler
 *  org.springframework.web.context.request.WebRequest
 *  org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
 */
package br.com.forum.exceptions;

import br.com.forum.exceptions.DuplicidadeException;
import br.com.forum.exceptions.ErrorHandler;
import javax.persistence.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler
extends ResponseEntityExceptionHandler {
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Malformed JSON request";
        return this.buildResponseEntity(new ErrorHandler(HttpStatus.BAD_REQUEST, error));
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorHandler apiError) {
        return new ResponseEntity((Object)apiError, apiError.getStatus());
    }

    @ExceptionHandler(value={EntityNotFoundException.class})
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
        ErrorHandler apiError = new ErrorHandler(HttpStatus.NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        return this.buildResponseEntity(apiError);
    }

    @ExceptionHandler(value={DuplicidadeException.class})
    protected ResponseEntity<Object> handleDuplicidade(DuplicidadeException ex) {
        ErrorHandler apiError = new ErrorHandler(HttpStatus.CONFLICT);
        apiError.setMessage(ex.getMessage());
        return this.buildResponseEntity(apiError);
    }
}

