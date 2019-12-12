package br.com.saga.choreography.engine.delegate;


import br.com.saga.choreography.engine.builders.SagaChoreography;

@FunctionalInterface
public interface Choreographer {

    SagaChoreography createChoreography();

}
