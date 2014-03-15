package no.border.eventstore;

import junit.framework.Assert;
import no.borber.monsterShop.monsterTypes.MonsterTypeJson;
import no.borber.monsterShop.monsterTypes.MonsterTypesRepo;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestEventStore {

    private MonsterTypeJson kraken = MonsterTypesRepo.getMonsterType("kraken");

    @Test
    public void skalKunneLeggeTilEnOrdreIEventStore() {
        EventStore es = new EventStore();
        es.addEvent(new MonsterLagtTilIHandlekurven(kraken));
        Assert.assertEquals(1,es.size());
    }

    @Test
    public void skalHenteUtEventerForAggregat() throws Exception {
        EventStore es = new EventStore();
        EventSubscriber subscriber = mock(EventSubscriber.class);
        es.subscribe(subscriber);
        MonsterLagtTilIHandlekurven event = new MonsterLagtTilIHandlekurven(kraken);
        es.addEvent(event);
        verify(subscriber).eventAdded(event);
    }

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
