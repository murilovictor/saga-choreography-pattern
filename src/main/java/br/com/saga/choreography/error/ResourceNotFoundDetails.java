package br.com.saga.choreography.error;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ResourceNotFoundDetails extends ErrorDetails {

    @Builder
    public ResourceNotFoundDetails(String title, int status, String detail, long timestamp, String developerMessage) {
        super(title, status, detail, timestamp, developerMessage);
    }
}