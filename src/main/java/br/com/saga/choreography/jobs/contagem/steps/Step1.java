package br.com.saga.choreography.jobs.contagem.steps;

import br.com.saga.choreography.engine.delegate.SagaDelegate;
import br.com.saga.choreography.engine.delegate.SagaJobMap;
import org.springframework.stereotype.Service;

/**
 * @author mvictor - 11/12/2019
 */
@Service
public class Step1 implements SagaDelegate {
    @Override
    public void execute(SagaJobMap sagaJobMap) {
    }
}
