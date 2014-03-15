package no.border.eventstore;

import junit.framework.Assert;
import no.borber.monsterShop.monsterTypes.MonsterTypeJson;
import no.borber.monsterShop.monsterTypes.MonsterTypesRepo;
import org.junit.Test;

import java.util.List;

public class TestHandlekurv {

    private MonsterTypeJson kraken = MonsterTypesRepo.getMonsterType("kraken");

    @Test
    public void handlekurvHarMottatMonster() throws Exception {
        Handlekurv handlekurv = new Handlekurv();
        MonsterLagtTilIHandlekurven nyMonsterInstanse = new MonsterLagtTilIHandlekurven(kraken);
        handlekurv.eventAdded(nyMonsterInstanse);
        Assert.assertEquals(1, handlekurv.size());
        List<MonsterTypeJson> monsterTypeJsons = handlekurv.hentInnhold();
        Assert.assertEquals("Kraken",monsterTypeJsons.get(0).getName());
    }



}
