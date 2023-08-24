package az.atlacademy.springjpaexample.exception;

import az.atlacademy.springjpaexample.model.dto.ErrorDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleProductNotFoundException(ProductNotFoundException e) {
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorDto(40401, e.getMessage(), LocalDateTime.now()));
    }

}
