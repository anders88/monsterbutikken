package no.no.borber.command;

import no.border.eventstore.EventStore;
import no.border.eventstore.KundenLaTilMonsterIHandlekurven;

public class CommandHandler {

    private EventStore eventStore;

    public CommandHandler(EventStore eventStore) {

        this.eventStore = eventStore;
    }

    public void handle(LeggerTilMonsterIHandlekurv leggerTilMonsterIHandlekurv) {
        KundenLaTilMonsterIHandlekurven event = new KundenLaTilMonsterIHandlekurven(leggerTilMonsterIHandlekurv.getMonsterTypeJson());
        eventStore.addEvent(event);
    }
}
