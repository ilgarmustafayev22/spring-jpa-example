package az.atlacademy.springjpaexample.model.dto;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class ErrorDto {

    int errorCode;
    String errorMessage;
    LocalDateTime dateTime;

}
