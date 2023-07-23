package app.service;

import app.dto.RequestDto;
import app.mapper.RequestMapper;
import app.model.MessageCounter;
import app.model.Request;
import app.repository.DataRepository;
import app.repository.MessageCounterRepository;
import app.util.exceptions.DataValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class DataService {

    private final DataRepository dataRepository;
    private final MessageCounterRepository messageCounterRepository;
    private final RequestMapper requestMapper;

    @Transactional
    public void checkForDuplicates(DelegateExecution execution) {
        Integer key = (Integer) execution.getVariable("key");

        Optional<Request> requestByKey = dataRepository.findFirstByKey(key);

        if (requestByKey.isPresent()) {
            log.info("Duplicate key: {}", key);
            incrementCounter();
        } else {
            log.info("New key: {}", key);
        }
    }

    @Transactional
    public void saveToDB(DelegateExecution execution) {
        RequestDto requestDto = (RequestDto) execution.getVariable("data");
        Request request = requestMapper.toEntity(requestDto);

        log.info("Saving to DB request: {}", request);

        dataRepository.save(request);
    }

    @Transactional
    public void incrementCounter() {
        MessageCounter messageCounter = messageCounterRepository.findById(1)
                .orElseThrow(() -> new DataValidationException("Counter not found"));

        messageCounter.setCounter(messageCounter.getCounter() + 1);

        log.info("Incrementing counter");

        messageCounterRepository.save(messageCounter);
    }

    public Integer getCounter() {
        MessageCounter messageCounter = messageCounterRepository.findById(1)
                .orElseThrow(() -> new DataValidationException("Counter not found"));

        return messageCounter.getCounter();
    }

    public Long countRequests() {
        return dataRepository.countRequests();
    }
}
