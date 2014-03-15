package no.border.eventstore;

import junit.framework.Assert;
import no.borber.monsterShop.monsterTypes.MonsterTypeJson;
import no.borber.monsterShop.monsterTypes.MonsterTypesRepo;
import org.junit.Test;

import java.util.List;

public class TestHandlekurv {

    private MonsterTypeJson kraken = MonsterTypesRepo.getMonsterType("Kraken");
    private final Handlekurv handlekurv = new Handlekurv();

    @Test
    public void handlekurvHarMottatMonster() throws Exception {
        KundenLaTilMonsterIHandlekurven nyMonsterInstanse = new KundenLaTilMonsterIHandlekurven(kraken);
        handlekurv.eventAdded(nyMonsterInstanse);
        Assert.assertEquals(1, handlekurv.size());
        List<MonsterTypeJson> monsterTypeJsons = handlekurv.hentInnhold();
        Assert.assertEquals("Kraken",monsterTypeJsons.get(0).getName());
    }

    @Test
    public void monsterKanFjernesFraHandlekurven() throws Exception {
        handlekurv.eventAdded(new KundenLaTilMonsterIHandlekurven(kraken));
        handlekurv.eventAdded(new KundenFjernetMonsterFraHandlekurven(kraken));

        Assert.assertEquals(0,handlekurv.size());

    }
}
