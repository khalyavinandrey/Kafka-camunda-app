package com.example.demo.dto;

import com.example.demo.util.RandomStringBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class PayloadDto {

    private String message_date;

    private String message;

    public PayloadDto() {
        this.message = RandomStringBuilder.generateRandomString();
        this.message_date = getFormattedTimestamp();
    }

    @JsonIgnore
    public String getFormattedTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}
