package br.com.saga.choreography.error;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ValidationErrorDetails extends ErrorDetails {

    private String field;
    private String fieldMessage;

    @Builder
    public ValidationErrorDetails(String title, int status, String detail, long timestamp, String developerMessage, String field, String fieldMessage) {
        super(title, status, detail, timestamp, developerMessage);
        this.field = field;
        this.fieldMessage = fieldMessage;
    }
}