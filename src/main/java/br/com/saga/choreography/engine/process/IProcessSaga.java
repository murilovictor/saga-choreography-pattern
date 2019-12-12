package br.com.saga.choreography.engine.process;

import br.com.saga.choreography.engine.builders.SagaChoreography;
import br.com.saga.choreography.engine.delegate.SagaJobMap;

public interface IProcessSaga {
    void execute(final SagaJobMap jobMap, final SagaChoreography queue);

    void compensation(final SagaJobMap jobMap, final SagaChoreography queue);
}
