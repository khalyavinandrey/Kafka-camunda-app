package app.delegate;

import app.service.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CheckDuplicatesDelegate implements JavaDelegate {

    private final DataService dataService;

    @Override
    public void execute(DelegateExecution execution) {
        dataService.checkForDuplicates(execution);

        execution.setVariable("counter", dataService.getCounter());

        log.info("Counter of duplicates: {}", execution.getVariable("counter"));
        log.info("Counter of requests in DB: {}", dataService.countRequests());
    }
}