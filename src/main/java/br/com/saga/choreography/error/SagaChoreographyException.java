package br.com.saga.choreography.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class SagaChoreographyException extends RuntimeException {
    public SagaChoreographyException(String message) {
        super(message);
    }
}