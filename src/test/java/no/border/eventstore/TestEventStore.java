package no.border.eventstore;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by trefsahl on 15/03/14.
 */
public class TestEventStore {

    @Test
    public void skalKunneLeggeTilEnOrdreIEventStore() {
        EventStore es = new EventStore();
        es.addEvent(new MonsterLagtTilIHandlekurven());
        Assert.assertEquals(1,es.size());
    }


}
