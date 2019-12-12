package br.com.saga.choreography.jobs.contagem.compensation;

import br.com.saga.choreography.engine.delegate.SagaDelegate;
import br.com.saga.choreography.engine.delegate.SagaJobMap;
import org.springframework.stereotype.Service;

/**
 * @author mvictor - 11/12/2019
 */
@Service
public class Step3Compensation implements SagaDelegate {
    @Override
    public void execute(SagaJobMap sagaJobMap) {
        System.out.println("Executando: " + this.getClass().getSimpleName());
    }
}
