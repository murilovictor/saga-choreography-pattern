package br.com.saga.choreography.engine.delegate;

import java.util.HashMap;
import java.util.Map;

public class SagaJobMap {
    private final Map<String, Object> jobMap;

    public SagaJobMap() {
        this.jobMap = new HashMap<>();
    }

    private Map<String, Object> getJobMap() {
        return jobMap;
    }

    public SagaJobMap addProperties(String s, Object o) {
        getJobMap().put(s, o);
        return this;
    }

    public Object getProperties(String s) {
        return getJobMap().get(s);
    }

}
