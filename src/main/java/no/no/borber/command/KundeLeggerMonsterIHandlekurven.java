package no.no.borber.command;

import no.borber.monsterShop.monsterTypes.MonsterTypeJson;

public class KundeLeggerMonsterIHandlekurven {
    private MonsterTypeJson monsterTypeJson;

    public KundeLeggerMonsterIHandlekurven(MonsterTypeJson monsterTypeJson) {

        this.monsterTypeJson = monsterTypeJson;
    }

    public MonsterTypeJson getMonsterTypeJson() {
        return monsterTypeJson;
    }
}
