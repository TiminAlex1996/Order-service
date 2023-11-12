package ru.sber.orderservice.api.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.sber.orderservice.dto.ResponseMsg;

import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseMsg> handleValidationErrors(MethodArgumentNotValidException exc) {
        String msg = exc.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(" | "));
        log.error("Invalid data for creating an order: {}", msg);
        return new ResponseEntity<>(new ResponseMsg(-1L, msg), HttpStatus.BAD_REQUEST);
    }
}
