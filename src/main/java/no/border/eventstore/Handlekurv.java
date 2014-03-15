package no.border.eventstore;

import no.borber.monsterShop.monsterTypes.MonsterTypeJson;

import java.util.ArrayList;
import java.util.List;

public class Handlekurv implements EventSubscriber {

    List<MonsterTypeJson> listeMedMonstere = new ArrayList<>();

    int numberOfMonstersInBasket = 0;

    @Override
    public void eventAdded(Event event) {
        numberOfMonstersInBasket++;
        if (event instanceof KundenLaTilMonsterIHandlekurven) {
            KundenLaTilMonsterIHandlekurven monster = (KundenLaTilMonsterIHandlekurven)event;
            listeMedMonstere.add(monster.getMonster());
        }
    }

    public int size() {
        return listeMedMonstere.size();
    }

    public List<MonsterTypeJson> hentInnhold() {
        return listeMedMonstere;
    }
}
