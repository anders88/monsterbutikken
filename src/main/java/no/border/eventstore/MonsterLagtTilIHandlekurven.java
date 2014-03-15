package no.border.eventstore;

import no.borber.monsterShop.monsterTypes.MonsterTypeJson;

public class MonsterLagtTilIHandlekurven extends Event {
    public MonsterLagtTilIHandlekurven(MonsterTypeJson monster) {
        super(1, AgregatEnum.Handlekurv);
    }
}
