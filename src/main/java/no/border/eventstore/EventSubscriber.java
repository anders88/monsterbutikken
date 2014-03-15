package no.border.eventstore;

public interface EventSubscriber {
    public void eventAdded(Event event);
}
