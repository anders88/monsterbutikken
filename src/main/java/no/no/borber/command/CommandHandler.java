package no.no.borber.command;

import no.border.eventstore.EventStore;
import no.border.eventstore.MonsterLagtTilIHandlekurven;

public class CommandHandler {

    private EventStore eventStore;

    public CommandHandler(EventStore eventStore) {

        this.eventStore = eventStore;
    }

    public void handle(LeggerTilMonsterIHandlekurv leggerTilMonsterIHandlekurv) {
        MonsterLagtTilIHandlekurven event = new MonsterLagtTilIHandlekurven(leggerTilMonsterIHandlekurv.getMonsterTypeJson());
        eventStore.addEvent(event);
    }
}
