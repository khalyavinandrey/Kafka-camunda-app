package app.delegate;

import app.dto.ApiDto;
import app.service.ServiceApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SendPostRequest implements JavaDelegate {

    private final ServiceApi serviceApi;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Integer httpStatus = serviceApi.sendRequest(new ApiDto(execution));

        log.info("HttpStatus: {}", httpStatus);

        execution.setVariable("httpStatus", httpStatus);
    }
}
