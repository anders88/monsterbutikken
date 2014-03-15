package no.border.eventstore;

import no.borber.monsterShop.monsterTypes.MonsterTypeJson;

import java.util.List;

public class Handlekurv implements EventSubscriber {

    int numberOfMonstersInBasket = 0;

    @Override
    public void eventAdded(Event event) {
        numberOfMonstersInBasket++;
    }

    public int size() {
        return numberOfMonstersInBasket;
    }

    public List<MonsterTypeJson> hentInnhold() {
        return null;
    }
}
