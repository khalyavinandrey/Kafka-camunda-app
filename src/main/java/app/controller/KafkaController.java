package app.controller;

import app.dto.RequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping("/send")
    public void test() {
        kafkaTemplate.send("start-process-message-topic", new RequestDto());
    }
}
