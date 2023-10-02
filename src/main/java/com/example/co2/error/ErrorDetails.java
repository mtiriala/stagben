package com.example.co2.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class ErrorDetails {
    private String msg;
    private String url;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss ")
    private Date timestamp;

    public ErrorDetails(String message, String description) {

    }
}
