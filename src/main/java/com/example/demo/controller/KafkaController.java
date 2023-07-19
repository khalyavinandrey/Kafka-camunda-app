package com.example.demo.controller;

import com.example.demo.dto.Dto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaTemplate<String, Dto> kafkaTemplate;

    @PostMapping("/send")
    public void test() {
        kafkaTemplate.send("demo-topic", new Dto());
    }
}
