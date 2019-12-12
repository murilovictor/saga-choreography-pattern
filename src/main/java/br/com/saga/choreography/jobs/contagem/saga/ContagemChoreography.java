package br.com.saga.choreography.jobs.contagem.saga;

import br.com.saga.choreography.engine.builders.SagaChoreography;
import br.com.saga.choreography.engine.builders.SagaChoreographyBuilder;
import br.com.saga.choreography.engine.delegate.Choreographer;
import br.com.saga.choreography.jobs.contagem.compensation.*;
import br.com.saga.choreography.jobs.contagem.steps.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author mvictor - 11/12/2019
 */
@Service
public class ContagemChoreography implements Choreographer {

    @Autowired
    ApplicationContext appCtx;

    public ContagemChoreography(ApplicationContext appCtx) {
        this.appCtx = appCtx;
    }

    @Override
    public SagaChoreography createChoreography() {
        return SagaChoreographyBuilder.newSagaChoreography()

                .step(appCtx.getBean(Step1.class))
                .withCompensationActivity(appCtx.getBean(Step1Compensation.class))

                .step(appCtx.getBean(Step2.class))
                .withCompensationActivity(appCtx.getBean(Step2Compensation.class))

                .step(appCtx.getBean(Step3.class))
                .withCompensationActivity(appCtx.getBean(Step3Compensation.class))

                .step(appCtx.getBean(Step4.class))
                .withCompensationActivity(appCtx.getBean(Step4Compensation.class))

                .step(appCtx.getBean(Step5.class))
                .withCompensationActivity(appCtx.getBean(Step5Compensation.class))

                .build();
    }

}
