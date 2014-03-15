package no.border.eventstore;

import junit.framework.Assert;
import no.borber.monsterShop.basket.BasketItem;
import no.borber.monsterShop.monsterTypes.MonsterTypeJson;
import no.borber.monsterShop.monsterTypes.MonsterTypesRepo;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TestHandlekurv {

    private MonsterTypeJson kraken = MonsterTypesRepo.getMonsterType("Kraken");
    private final Handlekurv handlekurv = new Handlekurv();

    @Test
    public void handlekurvHarMottatMonster() throws Exception {
        KundenLaTilMonsterIHandlekurven nyMonsterInstanse = new KundenLaTilMonsterIHandlekurven(kraken);
        handlekurv.eventAdded(nyMonsterInstanse);
        Assert.assertEquals(1, handlekurv.size());
        Map<String,BasketItem> basketItems = handlekurv.hentInnhold();
        Assert.assertTrue(basketItems.containsKey("Kraken"));
    }

    @Test
    public void monsterKanFjernesFraHandlekurven() throws Exception {
        handlekurv.eventAdded(new KundenLaTilMonsterIHandlekurven(kraken));
        handlekurv.eventAdded(new KundenFjernetMonsterFraHandlekurven(kraken));
        Assert.assertEquals(0,handlekurv.size());
    }
}
