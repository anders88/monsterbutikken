package no.border.eventstore;

import no.borber.monsterShop.basket.BasketItem;
import no.borber.monsterShop.monsterTypes.MonsterTypeJson;

import java.util.ArrayList;
import java.util.List;

public class Handlekurv implements EventSubscriber {

    List<BasketItem> handlekurvItems = new ArrayList<>();

    private int MONSTER_PRIS = 0;

    @Override
    public void eventAdded(Event event) {

        if (event instanceof KundenLaTilMonsterIHandlekurven) {
            KundenLaTilMonsterIHandlekurven monster = (KundenLaTilMonsterIHandlekurven)event;
            boolean monsterFinnes = false;
            for (BasketItem item:handlekurvItems){
                if (item.getMonsterType().equals(monster.getMonster().getName())){
                    item.addMonster();
                    monsterFinnes = true;
                }
            }
            if (!monsterFinnes) {
                handlekurvItems.add(new BasketItem(monster.getMonster().getName(),MONSTER_PRIS));
            }
        }

        if (event instanceof KundenFjernetMonsterFraHandlekurven){
            KundenFjernetMonsterFraHandlekurven monster = (KundenFjernetMonsterFraHandlekurven) event;
            BasketItem basketItem = null;
            for (BasketItem item:handlekurvItems){
                if (item.getMonsterType().equals(monster.getMonster().getName())){
                    if (item.getNumber() > 1) {
                        item.removeMonster();
                    } else {
                        basketItem = item;
                    }
                }
            }
            if (basketItem != null) {
                handlekurvItems.remove(basketItem);
            }
        }
    }

    public int size() {
        return handlekurvItems.size();
    }

    public List<BasketItem> hentInnhold() {
        return handlekurvItems;
    }
}
