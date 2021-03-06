package no.border.eventstore;

import no.borber.monsterShop.monsterTypes.MonsterTypeJson;

public class KundenFjernetMonsterFraHandlekurven extends Event {

    private final MonsterTypeJson monsterTypeJson;

    public KundenFjernetMonsterFraHandlekurven(MonsterTypeJson monsterTypeJson) {
        super(1, AggregatEnum.Handlekurv);
        this.monsterTypeJson = monsterTypeJson;
    }

    public MonsterTypeJson getMonster() {
        return monsterTypeJson;
    }
}
