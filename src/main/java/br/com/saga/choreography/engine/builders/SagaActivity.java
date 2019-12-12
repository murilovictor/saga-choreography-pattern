package br.com.saga.choreography.engine.builders;

import br.com.saga.choreography.engine.delegate.SagaDelegate;

public class SagaActivity {
    private SagaDelegate activity;
    private SagaDelegate compensationActivity;

    public SagaActivity(final SagaDelegate activity) {
        this.activity = activity;
    }

    public void withCompensationActivity(final SagaDelegate compensationActivity) {
        this.compensationActivity = compensationActivity;
    }

    public SagaDelegate getActivity() {
        return activity;
    }

    public SagaDelegate getCompensationActivity() {
        return compensationActivity;
    }

}
