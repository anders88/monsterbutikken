package no.no.borber.command;

import no.borber.aggregate.HandlekurvAggregat;
import no.border.eventstore.EventStore;
import no.border.eventstore.Handlekurv;
import no.border.eventstore.KundenFjernetMonsterFraHandlekurven;
import no.border.eventstore.KundenLaTilMonsterIHandlekurven;

public class CommandHandler {

    private EventStore eventStore;
    private HandlekurvAggregat aggregat;

    public CommandHandler(EventStore eventStore) {
        this.eventStore = eventStore;
        this.aggregat = new HandlekurvAggregat();
        this.eventStore.subscribe(this.aggregat);
    }

    public void handle(KundeLeggerMonsterIHandlekurven kundeLeggerMonsterIHandlekurven) {
        KundenLaTilMonsterIHandlekurven event = new KundenLaTilMonsterIHandlekurven(kundeLeggerMonsterIHandlekurven.getMonsterTypeJson());
        eventStore.addEvent(event);
    }

    public void handle(KundeFjernerMonsterFraHandlekurven kundeFjernerMonsterFraHandlekurven) {
        if (aggregat.kanMonsterFjernes(kundeFjernerMonsterFraHandlekurven.getMonster())) {
            KundenFjernetMonsterFraHandlekurven kundenFjernetMonsterFraHandlekurven = new KundenFjernetMonsterFraHandlekurven(kundeFjernerMonsterFraHandlekurven.getMonster());
            eventStore.addEvent(kundenFjernetMonsterFraHandlekurven);
        } else
            throw new MonsterKanIkkeFjernesException();
    }
}
