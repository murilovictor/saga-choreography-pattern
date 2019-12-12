package br.com.saga.choreography.error;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorDetail extends ErrorDetails {

    @Builder
    public ErrorDetail(String title, int status, String detail, long timestamp, String developerMessage) {
        super(title, status, detail, timestamp, developerMessage);
    }
}