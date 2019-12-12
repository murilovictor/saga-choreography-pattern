package br.com.saga.choreography.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorDetails {
    protected String title;
    protected int status;
    protected String detail;
    protected long timestamp;
    protected String developerMessage;
}