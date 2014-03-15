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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MonsterLagtTilIHandlekurven)) {
            return false;
        }
        MonsterLagtTilIHandlekurven other = (MonsterLagtTilIHandlekurven) obj;
        return monster.equals(other.monster);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
