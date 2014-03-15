package no.border.eventstore;

import no.borber.monsterShop.monsterTypes.MonsterTypeJson;

public class KundenFjernetMonsterFraHandlekurven extends Event {

    private final MonsterTypeJson monsterTypeJson;

    protected KundenFjernetMonsterFraHandlekurven(MonsterTypeJson monsterTypeJson) {
        super(1, AgregatEnum.Handlekurv);
        this.monsterTypeJson = monsterTypeJson;
    }

    public MonsterTypeJson getMonster() {
        return monsterTypeJson;
    }
}
