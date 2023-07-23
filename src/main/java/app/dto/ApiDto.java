package app.dto;

import lombok.Data;
import org.camunda.bpm.engine.delegate.DelegateExecution;

@Data
public class ApiDto {

    private Integer key;
    private Integer count;

    public ApiDto(DelegateExecution execution) {
        this.key = (Integer) execution.getVariable("key");
        this.count = (Integer) execution.getVariable("counter");
    }
}
