package com.example.demo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PayloadDto {

    private LocalDateTime localDateTime;
    private String message;

    public PayloadDto() {
        this.localDateTime = LocalDateTime.now();
        this.message = "Hello World";
    }
}
