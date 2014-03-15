package no.border.eventstore;

import no.borber.monsterShop.monsterTypes.MonsterTypeJson;

public class KundenFjernetMonsterFraHandlekurven extends Event {
    protected KundenFjernetMonsterFraHandlekurven(MonsterTypeJson kraken) {
        super(1, AgregatEnum.Handlekurv);
    }
}
