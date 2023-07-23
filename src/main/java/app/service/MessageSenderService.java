package app.service;

import app.dto.StatusDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageSenderService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(DelegateExecution execution) {
        Integer httpStatus = (Integer) execution.getVariable("httpStatus");

        if (httpStatus >= 200 && httpStatus < 230) {
            sendMessageIfSuccess(execution);
        } else if (httpStatus>=400 && httpStatus < 530){
            sendMessageIfFail(execution);
        }
    }


    private void sendMessageIfSuccess(DelegateExecution execution) {
        StatusDto statusDto = new StatusDto(execution);

        statusDto.setStatus(0);

        log.info("Sending message: " + statusDto);

        kafkaTemplate.send("request-succeeded", statusDto);
    }

    private void sendMessageIfFail(DelegateExecution execution) {
        StatusDto statusDto = new StatusDto(execution);

        statusDto.setStatus(-1);

        log.info("Sending message: " + statusDto);

        kafkaTemplate.send("request-failed", statusDto);
    }
}
