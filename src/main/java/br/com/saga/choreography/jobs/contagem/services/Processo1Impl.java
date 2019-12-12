package br.com.saga.choreography.jobs.contagem.services;

import br.com.saga.choreography.engine.delegate.SagaJobMap;
import br.com.saga.choreography.engine.process.IProcessSaga;
import br.com.saga.choreography.jobs.contagem.interfaces.IProcesso1;
import br.com.saga.choreography.jobs.contagem.saga.ContagemChoreography;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mvictor - 11/12/2019
 */
@Service
public class Processo1Impl implements IProcesso1 {

    @Autowired
    private IProcessSaga processSaga;

    @Autowired
    private ContagemChoreography choreography;

    @Override
    public String adicionarMensagemSaga(String mensagem) {
        SagaJobMap sagaJobMap = new SagaJobMap().addProperties("Processo1Impl", mensagem);

        processSaga.execute(sagaJobMap, choreography.createChoreography());

        return (String) sagaJobMap.getProperties("Processo1Impl");
    }
}
