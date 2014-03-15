package no.border.eventstore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trefsahl on 15/03/14.
 */
public class EventStore {

    private List<Event> events = new ArrayList<>();
    private List<EventSubscriber> eventSubscribers = new ArrayList<>();

    public void addEvent(Event event) {
        events.add(event);
        for (EventSubscriber eventSubscriber : eventSubscribers){
            eventSubscriber.eventAdded(event);
        }
    }

    public int size(){
        return events.size();
    }

    public void subscribe(EventSubscriber subscriber) {
        eventSubscribers.add(subscriber);
    }


}
