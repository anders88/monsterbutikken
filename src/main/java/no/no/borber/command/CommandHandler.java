package no.no.borber.command;

import no.border.eventstore.EventStore;
import no.border.eventstore.KundenLaTilMonsterIHandlekurven;

public class CommandHandler {

    private EventStore eventStore;

    public CommandHandler(EventStore eventStore) {

        this.eventStore = eventStore;
    }

    public void handle(KundeLeggerMonsterIHandlekurven kundeLeggerMonsterIHandlekurven) {
        KundenLaTilMonsterIHandlekurven event = new KundenLaTilMonsterIHandlekurven(kundeLeggerMonsterIHandlekurven.getMonsterTypeJson());
        eventStore.addEvent(event);
    }

    public void handle(KundeFjernerMonsterFraHandlekurven kundeFjernerMonsterFraHandlekurven) {
    }
}
