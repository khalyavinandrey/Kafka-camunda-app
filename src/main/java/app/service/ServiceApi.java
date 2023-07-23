package app.service;

import app.dto.ApiDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ServiceApi {

    private String url = "http://localhost:8081/api/v1/messages";

    public Integer sendRequest(ApiDto apiDto) {
        log.info("Sending request to wiremock server");

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ApiDto> request = new HttpEntity<>(apiDto, headers);

        log.info("Request: {}", apiDto);

        ResponseEntity<String> response;

        try {
            response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        } catch (HttpClientErrorException e) {
            log.info("Client error! " + e.getResponseBodyAsString());
            return e.getStatusCode().value();
        } catch (HttpServerErrorException e) {
            log.info("Server error! " + e.getResponseBodyAsString());
            return e.getStatusCode().value();
        }

        log.info("Request was successful");

        return response.getStatusCodeValue();
    }
}
