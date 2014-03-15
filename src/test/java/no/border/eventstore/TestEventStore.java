package no.border.eventstore;

import junit.framework.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestEventStore {

    @Test
    public void skalKunneLeggeTilEnOrdreIEventStore() {
        EventStore es = new EventStore();
        es.addEvent(new MonsterLagtTilIHandlekurven());
        Assert.assertEquals(1,es.size());
    }

    @Test
    public void skalHenteUtEventerForAggregat() throws Exception {
        EventStore es = new EventStore();
        EventSubscriber subscriber = mock(EventSubscriber.class);
        MonsterLagtTilIHandlekurven event = new MonsterLagtTilIHandlekurven();
        es.addEvent(event);
        verify(subscriber).eventAdded(event);
        

    }
}
