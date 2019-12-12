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
    private static final String INICIO_FILA = "INÍCIO PROCESSAMENTO DA FILA";
    private static final String FIM_FILA = "FIM PROCESSAMENTO DA FILA";
    private static final String ERRO_FILA = "HOUVE UM ERRO DURANTE O PROCESSAMENTO DO STEP: [%s], ERRO: [%s]";

    private static final String INICIO_COMPENSACAO = "INÍCIO PROCESSAMENTO DA FILA DE COMPENSAÇÃO";
    private static final String FIM_COMPENSACAO = "FIM PROCESSAMENTO DA FILA DE COMPENSAÇÃO";
    private static final String ERRO_COMPENSACAO = "HOUVE UM ERRO DURANTE O PROCESSAMENTO DO STEP DE COMPENSAÇÃO: [%s], ERRO: [%s]";

    private static final String LOG_EXECUTANDO = "EXECUTANDO: [%s]";
    private static final String LOG_EXECUTANDO_COMPENSACAO = "EXECUTANDO COMPENSAÇÃO: [%s]";


    @Override
    public void execute(final SagaJobMap jobMap, final SagaChoreography queue) {
        log.info(INICIO_FILA);

        while (!queue.getActivitiesIn().isEmpty()) {
            final SagaActivity activity = queue.getActivityInFirst();
            final String className = activity.getActivity().getClass().getSimpleName().toUpperCase();

            log.info(String.format(LOG_EXECUTANDO, className));

            try {
                activity.getActivity().execute(jobMap);
            } catch (Exception e) {
                String erroFormated = String.format(ERRO_FILA, className, e.getMessage()).toUpperCase();
                log.error(erroFormated);
                this.compensation(jobMap, queue);
                throw new SagaChoreographyException(erroFormated);
            }

        }
        log.info(FIM_FILA);
    }

    @Override
    public void compensation(final SagaJobMap jobMap, final SagaChoreography queue) {
        log.info(INICIO_COMPENSACAO);
        while (!queue.getActivitiesOut().isEmpty()) {
            final SagaActivity activity = queue.getActivitiesOut().removeFirst();
            final String className = activity.getActivity().getClass().getSimpleName().toUpperCase();

            log.info(String.format(LOG_EXECUTANDO_COMPENSACAO, className));

            try {
                if (Objects.nonNull(activity.getCompensationActivity())) {
                    activity.getCompensationActivity().execute(jobMap);
                }
            } catch (Exception e) {
                String erroFormated = String.format(ERRO_COMPENSACAO, className, e.getMessage()).toUpperCase();
                log.error(erroFormated);
            }
        }
        log.info(FIM_COMPENSACAO);
    }
}
