package no.borber.aggregate;

import no.borber.monsterShop.monsterTypes.MonsterTypeJson;
import no.border.eventstore.Event;
import no.border.eventstore.EventSubscriber;
import no.border.eventstore.KundenFjernetMonsterFraHandlekurven;
import no.border.eventstore.KundenLaTilMonsterIHandlekurven;
import no.no.borber.command.KundeLeggerMonsterIHandlekurven;

import java.util.ArrayList;
import java.util.List;

public class HandlekurvAggregat implements EventSubscriber {

    List<MonsterTypeJson> handlekurven = new ArrayList<>();

    @Override
    public void eventAdded(Event event) {
        if (event instanceof KundenLaTilMonsterIHandlekurven){
            KundenLaTilMonsterIHandlekurven kundenLaTilMonsterIHandlekurven =(KundenLaTilMonsterIHandlekurven)event;
            handlekurven.add(kundenLaTilMonsterIHandlekurven.getMonster());
        }
        if (event instanceof KundenFjernetMonsterFraHandlekurven) {
            KundenFjernetMonsterFraHandlekurven fjernetMonsterFraHandlekurven = (KundenFjernetMonsterFraHandlekurven) event;
            handlekurven.remove(fjernetMonsterFraHandlekurven.getMonster());
        }
    }

    public boolean kanMonsterFjernes(MonsterTypeJson monster){
        return handlekurven.contains(monster);
    }

}
