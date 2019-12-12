package br.com.saga.choreography.engine.delegate;

@FunctionalInterface
public interface SagaDelegate {

    void execute(SagaJobMap sagaJobMap);

}
