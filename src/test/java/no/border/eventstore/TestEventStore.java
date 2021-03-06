package no.border.eventstore;

import junit.framework.Assert;
import no.borber.monsterShop.monsterTypes.MonsterTypeJson;
import no.borber.monsterShop.monsterTypes.MonsterTypesRepo;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestEventStore {

    private MonsterTypeJson kraken = MonsterTypesRepo.getMonsterType("Kraken");

    @Test
    public void skalKunneLeggeTilEnOrdreIEventStore() {
        EventStore es = new EventStore();
        es.addEvent(new KundenLaTilMonsterIHandlekurven(kraken));
        Assert.assertEquals(1,es.size());
    }

    @Test
    public void skalHenteUtEventerForAggregat() throws Exception {
        EventStore es = new EventStore();
        EventSubscriber subscriber = mock(EventSubscriber.class);
        es.subscribe(subscriber);
        KundenLaTilMonsterIHandlekurven event = new KundenLaTilMonsterIHandlekurven(kraken);
        es.addEvent(event);
        verify(subscriber).eventAdded(event);
    }


}
