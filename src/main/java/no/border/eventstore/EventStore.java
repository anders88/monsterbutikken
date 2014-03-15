package no.border.eventstore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trefsahl on 15/03/14.
 */
public class EventStore {

    private List<Event> events = new ArrayList<>();

    public void addEvent(Event event) {
        events.add(event);

    }

    public int size(){
        return events.size();
    }

    public void subscribe(EventSubscriber subscriber) {

    }


}
