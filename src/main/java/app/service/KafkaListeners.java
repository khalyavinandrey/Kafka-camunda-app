package app.service;

import app.dto.RequestDto;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaListeners {

    private String MESSAGE_TO_START = "StartMessage";
    private final MessageService messageService;

    @KafkaListener(topics = "start-process-message-topic", groupId = "groupId")
    public void startProcess(RequestDto requestDto) {
        log.info("Starting camunda process");

        messageService.correlate(requestDto, MESSAGE_TO_START);
    }
}
