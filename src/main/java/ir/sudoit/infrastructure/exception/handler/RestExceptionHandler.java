package ir.sudoit.infrastructure.exception.handler;

import ir.sudoit.infrastructure.crud.persistence.model.MetaModel;
import ir.sudoit.infrastructure.exception.AccessException;
import ir.sudoit.infrastructure.exception.InputException;
import ir.sudoit.infrastructure.exception.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value
            = {NotFoundException.class})
    protected ResponseEntity<Object> handleApplicationException(
            NotFoundException ex, WebRequest request) {
        MetaModel bodyOfResponse = new MetaModel(HttpStatus.NOT_FOUND.value(),
                ex.getCode(), ex.getMessage());
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value
            = {AccessException.class})
    protected ResponseEntity<Object> handleUserAccessException(
            AccessException ex, WebRequest request) {
        MetaModel bodyOfResponse = new MetaModel(HttpStatus.FORBIDDEN.value(),
                ex.getCode(), ex.getMessage());
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    @ExceptionHandler(value
            = {InputException.class})
    protected ResponseEntity<Object> handleIllegalArgumentException(
            InputException ex, WebRequest request) {
        MetaModel bodyOfResponse = new MetaModel(HttpStatus.BAD_REQUEST.value(),
                "8020", ex.getMessage());
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }


    @Override
    protected @NonNull ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                           @NonNull HttpHeaders headers,
                                                                           @NonNull HttpStatus status,
                                                                           @NonNull WebRequest request) {
        List<String> details = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            details.add(error.getDefaultMessage());
        }
        MetaModel bodyOfResponse = new MetaModel(HttpStatus.BAD_REQUEST.value(),
                "8020", details.toString());

        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);

    }


}