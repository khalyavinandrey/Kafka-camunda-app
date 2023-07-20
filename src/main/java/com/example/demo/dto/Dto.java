package com.example.demo.dto;

import lombok.Data;

import java.util.Random;

@Data
public class Dto {
    private Long id;
    private PayloadDto payload;

    public Dto() {
        this.id = new Random().nextLong(31);
        this.payload = new PayloadDto();
    }
}
