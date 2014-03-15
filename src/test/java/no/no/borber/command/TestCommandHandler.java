package no.no.borber.command;

import junit.framework.Assert;
import no.borber.monsterShop.monsterTypes.MonsterTypeJson;
import no.borber.monsterShop.monsterTypes.MonsterTypesRepo;
import no.border.eventstore.EventStore;
import no.border.eventstore.KundenLaTilMonsterIHandlekurven;
import org.junit.Test;
import org.mockito.Mockito;

public class TestCommandHandler {

    private final MonsterTypeJson griff = MonsterTypesRepo.getMonsterType("Griff");

    @Test
    public void testAtEnKommandoLagerEtEvent() throws Exception {
        KundeLeggerMonsterIHandlekurven kundeLeggerMonsterIHandlekurven = new KundeLeggerMonsterIHandlekurven(griff);
        final EventStore eventStore = Mockito.mock(EventStore.class);
        CommandHandler commandHandler = new CommandHandler(eventStore);
        commandHandler.handle(kundeLeggerMonsterIHandlekurven);
        Mockito.verify(eventStore).addEvent(new KundenLaTilMonsterIHandlekurven(griff));
    }

    @Test
    public void testAtDetBlirOpprettetEtFjerneMonsterEventAvEnFjerneMonsterKommando() throws Exception {
        KundeFjernerMonsterFraHandlekurven kundeFjernerMonsterFraHandlekurven = new KundeFjernerMonsterFraHandlekurven(griff);
        EventStore eventStore = new EventStore();
        CommandHandler commandHandler = new CommandHandler(eventStore);
        commandHandler.handle(kundeFjernerMonsterFraHandlekurven);
        Assert.assertEquals(1, eventStore.size());
    }
}
