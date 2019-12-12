package br.com.saga.choreography.engine.builders;

import br.com.saga.choreography.engine.delegate.SagaDelegate;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

import static java.util.Objects.isNull;

@Slf4j
public class SagaChoreographyBuilder {
    private LinkedList<SagaActivity> steps = new LinkedList<>();

    private SagaChoreographyBuilder() {
    }

    public static SagaChoreographyBuilder newSagaChoreography() {
        return new SagaChoreographyBuilder();
    }

    public SagaChoreographyBuilder step(final SagaDelegate activity) {
        SagaActivity sagaActivity = new SagaActivity(activity);
        steps.add(sagaActivity);
        return this;
    }

    public SagaChoreographyBuilder withCompensationActivity(final SagaDelegate activity) {
        if (this.steps.isEmpty()) {
            throw new IllegalArgumentException("Nao existe steps");
        }
        if (isNull(steps.getLast().getCompensationActivity())) {
            steps.getLast().withCompensationActivity(activity);
        } else {
            throw new IllegalArgumentException("Existe uma compensação para essa activity");
        }
        return this;
    }

    public SagaChoreography build() {
        return new SagaChoreography(this.steps, new LinkedList<>());
    }


}
