package br.com.saga.choreography.engine.process;

import br.com.saga.choreography.engine.builders.SagaActivity;
import br.com.saga.choreography.engine.builders.SagaChoreography;
import br.com.saga.choreography.engine.delegate.SagaJobMap;
import br.com.saga.choreography.error.SagaChoreographyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class ProccessSaga implements IProcessSaga {

    @Override
    public void execute(final SagaJobMap jobMap, final SagaChoreography queue) {
        log.debug("Iniciando o processamento da fila");
        while (!queue.getActivitiesIn().isEmpty()) {
            final SagaActivity activity = queue.getActivityInFirst();
            try {
                activity.getActivity().execute(jobMap);
            } catch (SagaChoreographyException e) {
                log.error("Erro durante o processamento da fila");
                this.compensation(jobMap, queue);
                throw new SagaChoreographyException(e.getMessage());
            } catch (Exception e) {
                log.error("Erro não esperado durante o processamento da fila");
                this.compensation(jobMap, queue);
                throw new SagaChoreographyException(e.getMessage());
            }

        }
        log.debug("Finalizando o processamento da fila");
    }

    @Override
    public void compensation(final SagaJobMap jobMap, final SagaChoreography queue) {
        log.debug("Iniciando o processamento da fila compensacao");
        while (!queue.getActivitiesOut().isEmpty()) {
            final SagaActivity activity = queue.getActivitiesOut().removeFirst();
            try {
                if (Objects.nonNull(activity.getCompensationActivity())) {
                    activity.getCompensationActivity().execute(jobMap);
                }
            } catch (SagaChoreographyException e) {
                log.error("Erro durante o processamento da fila de compensação");
            }
        }
        log.debug("Finalizando o processamento da fila");
    }
}
