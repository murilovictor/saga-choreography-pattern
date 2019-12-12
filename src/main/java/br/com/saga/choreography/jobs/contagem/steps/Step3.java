package br.com.saga.choreography.jobs.contagem.steps;

import br.com.saga.choreography.engine.delegate.SagaDelegate;
import br.com.saga.choreography.engine.delegate.SagaJobMap;
import br.com.saga.choreography.error.SagaChoreographyException;
import org.springframework.stereotype.Service;

/**
 * @author mvictor - 11/12/2019
 */
@Service
public class Step3 implements SagaDelegate {
    @Override
    public void execute(SagaJobMap sagaJobMap) {
        System.out.println("Executando: " + this.getClass().getSimpleName());

        sagaJobMap.adicionarJob("quantidadeOciosas", 100);



//        throw new SagaChoreographyException("Erro ao Executar: " + this.getClass().getSimpleName());



    }
}
