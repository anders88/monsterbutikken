package no.border.eventstore;

import no.borber.monsterShop.monsterTypes.MonsterTypeJson;

public class KundenLaTilMonsterIHandlekurven extends Event {
    private final MonsterTypeJson monster;

    public KundenLaTilMonsterIHandlekurven(MonsterTypeJson monster) {
        super(1, AggregatEnum.Handlekurv);
        this.monster = monster;
    }

    public MonsterTypeJson getMonster() {
        return monster;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof KundenLaTilMonsterIHandlekurven)) {
            return false;
        }
        KundenLaTilMonsterIHandlekurven other = (KundenLaTilMonsterIHandlekurven) obj;
        return monster.equals(other.monster);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
