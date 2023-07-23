package app.service;

import app.dto.RequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.MessageCorrelationBuilder;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService {

    private final RuntimeService runtimeService;

    public MessageCorrelationResult correlate(RequestDto requestDto, String message) {
        log.info("Consuming message for camunda process: " + message);

        MessageCorrelationBuilder builder = runtimeService.createMessageCorrelation(message);

        builder.setVariable("data", requestDto);
        builder.setVariable("key", requestDto.getKey());

        return builder.correlateWithResult();
    }
}
