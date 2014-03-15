package no.border.eventstore;

/**
 * Created by trefsahl on 15/03/14.
 */
public abstract class Event {
    private final int agregatId;
    private final AgregatEnum agregatEnum;


    protected Event(int agregatId, AgregatEnum agregatEnum) {
        this.agregatId = agregatId;
        this.agregatEnum = agregatEnum;
    }
}
