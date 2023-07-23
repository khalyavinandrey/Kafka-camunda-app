package app.dto;

import lombok.Data;
import org.camunda.bpm.engine.delegate.DelegateExecution;

@Data
public class StatusDto {
     private Integer key;
     private Integer status;

    public StatusDto(DelegateExecution execution) {
        this.key = (Integer) execution.getVariable("key");
    }
}
