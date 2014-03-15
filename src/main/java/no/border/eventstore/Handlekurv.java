package no.border.eventstore;

import no.borber.monsterShop.basket.BasketItem;
import no.borber.monsterShop.monsterTypes.MonsterTypeJson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Handlekurv implements EventSubscriber {

    Map<String,BasketItem> handlekurvItems = new HashMap<>();

    private int MONSTER_PRIS = 0;

    @Override
    public void eventAdded(Event event) {

        if (event instanceof KundenLaTilMonsterIHandlekurven) {
            KundenLaTilMonsterIHandlekurven monster = (KundenLaTilMonsterIHandlekurven)event;
            String monsterNavn = monster.getMonster().getName();
            if (handlekurvItems.containsKey(monsterNavn)) {
                handlekurvItems.get(monsterNavn).addMonster();
            } else {
                handlekurvItems.put(monsterNavn,new BasketItem(monsterNavn,MONSTER_PRIS));
            }
        }

        if (event instanceof KundenFjernetMonsterFraHandlekurven){
            KundenFjernetMonsterFraHandlekurven monster = (KundenFjernetMonsterFraHandlekurven) event;
            String monsterNavn = monster.getMonster().getName();
            BasketItem item = handlekurvItems.get(monsterNavn);
            if (item.getNumber() > 1) {
                item.removeMonster();
            } else{
                handlekurvItems.remove(monsterNavn);
            }
        }
    }

    public int size() {
        return handlekurvItems.size();
    }

    public Map<String,BasketItem> hentInnhold() {
        return handlekurvItems;
    }
}
