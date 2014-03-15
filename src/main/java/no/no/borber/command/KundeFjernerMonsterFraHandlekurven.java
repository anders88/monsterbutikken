package no.no.borber.command;

import no.borber.monsterShop.monsterTypes.MonsterTypeJson;

public class KundeFjernerMonsterFraHandlekurven {
    private MonsterTypeJson monster;

    public KundeFjernerMonsterFraHandlekurven(MonsterTypeJson monster) {

        this.monster = monster;
    }

    public MonsterTypeJson getMonster() {
        return monster;
    }
}
