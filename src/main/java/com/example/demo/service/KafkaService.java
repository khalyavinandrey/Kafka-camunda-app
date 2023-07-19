//package com.example.demo.service;
//
//import com.example.demo.dto.Dto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class KafkaService {
//
//    private final KafkaTemplate<String, Dto> kafkaTemplate;
//
//    public void sendDto(Dto dto) {
//        kafkaTemplate.send("demo_topic", dto);
//    }
//}
