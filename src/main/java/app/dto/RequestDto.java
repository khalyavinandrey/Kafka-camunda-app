package app.dto;

import lombok.Data;

import java.util.Random;

@Data
public class RequestDto {

    private Integer key;

    private PayloadDto payload;

    public RequestDto() {
        this.key = new Random().nextInt(31);
        this.payload = new PayloadDto();
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public PayloadDto getPayload() {
        return payload;
    }

    public void setPayload(PayloadDto payload) {
        this.payload = payload;
    }
}
