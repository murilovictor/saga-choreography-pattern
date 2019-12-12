package br.com.saga.choreography.engine.builders;

import java.util.Deque;

public class SagaChoreography {
    private Deque<SagaActivity> activitiesIn;
    private Deque<SagaActivity> activitiesOut;

    public SagaChoreography(final Deque<SagaActivity> activitiesIn, final Deque<SagaActivity> activitiesOut) {
        this.activitiesIn = activitiesIn;
        this.activitiesOut = activitiesOut;
    }

    public Deque<SagaActivity> getActivitiesIn() {
        return activitiesIn;
    }

    public Deque<SagaActivity> getActivitiesOut() {
        return activitiesOut;
    }

    public SagaActivity getActivityInFirst() {
        SagaActivity activity = activitiesIn.removeFirst();
        this.activitiesOut.addFirst(activity);
        return activity;
    }

}
