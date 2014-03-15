package no.border.eventstore;

/**
 * Created by trefsahl on 15/03/14.
 */
public abstract class Event {
    private final int agregatId;
    private final AggregatEnum aggregatEnum;


    protected Event(int agregatId, AggregatEnum aggregatEnum) {
        this.agregatId = agregatId;
        this.aggregatEnum = aggregatEnum;
    }
}
