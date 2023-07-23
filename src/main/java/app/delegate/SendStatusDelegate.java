package app.delegate;

import app.service.MessageSenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SendStatusDelegate implements JavaDelegate {

    private final MessageSenderService messageSenderService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        messageSenderService.sendMessage(execution);
    }
}
