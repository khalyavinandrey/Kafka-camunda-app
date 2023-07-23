package app.delegate;

import app.service.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SaveMessageDelegate implements JavaDelegate {

    private final DataService dataService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        dataService.saveToDB(execution);
    }
}
