package no.border.eventstore;

import no.borber.monsterShop.monsterTypes.MonsterTypeJson;

public class MonsterLagtTilIHandlekurven extends Event {
    private final MonsterTypeJson monster;

    public MonsterLagtTilIHandlekurven(MonsterTypeJson monster) {
        super(1, AgregatEnum.Handlekurv);
        this.monster = monster;
    }

    public MonsterTypeJson getMonster() {
        return monster;
    }
}
