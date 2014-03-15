package no.no.borber.command;

import no.borber.monsterShop.monsterTypes.MonsterTypeJson;

public class LeggerTilMonsterIHandlekurv {
    private MonsterTypeJson monsterTypeJson;

    public LeggerTilMonsterIHandlekurv(MonsterTypeJson monsterTypeJson) {

        this.monsterTypeJson = monsterTypeJson;
    }

    public MonsterTypeJson getMonsterTypeJson() {
        return monsterTypeJson;
    }
}
