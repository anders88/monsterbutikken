package no.borber.aggregate;

import no.borber.monsterShop.basket.BasketItem;
import no.borber.monsterShop.monsterTypes.MonsterTypeJson;
import no.border.eventstore.Event;
import no.border.eventstore.EventSubscriber;
import no.border.eventstore.KundenFjernetMonsterFraHandlekurven;
import no.border.eventstore.KundenLaTilMonsterIHandlekurven;
import no.no.borber.command.KundeLeggerMonsterIHandlekurven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HandlekurvAggregat implements EventSubscriber {

    private Map<String,Integer> handlekurven = new HashMap<>();

    @Override
    public void eventAdded(Event event) {
        if (event instanceof KundenLaTilMonsterIHandlekurven){
            KundenLaTilMonsterIHandlekurven kundenLaTilMonsterIHandlekurven =(KundenLaTilMonsterIHandlekurven)event;
            MonsterTypeJson monster = kundenLaTilMonsterIHandlekurven.getMonster();
            int items=0;
            if (handlekurven.containsKey(monster.getName())) {
                items = handlekurven.get(monster.getName());
            }
            items++;
            handlekurven.put(monster.getName(),items);
        }
        if (event instanceof KundenFjernetMonsterFraHandlekurven) {
            KundenFjernetMonsterFraHandlekurven fjernetMonsterFraHandlekurven = (KundenFjernetMonsterFraHandlekurven) event;

            MonsterTypeJson monster = fjernetMonsterFraHandlekurven.getMonster();
            int num = handlekurven.get(monster.getName());
            num--;
            if (num == 0) {
                handlekurven.remove(monster.getName());
            } else {
                handlekurven.put(monster.getName(),num);
            }
        }
    }

    public boolean kanMonsterFjernes(MonsterTypeJson monster){
        return handlekurven.containsKey(monster.getName());
    }

}
