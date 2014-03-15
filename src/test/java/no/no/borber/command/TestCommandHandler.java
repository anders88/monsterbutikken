package no.no.borber.command;

import junit.framework.Assert;
import no.borber.aggregate.HandlekurvAggregat;
import no.borber.monsterShop.monsterTypes.MonsterTypeJson;
import no.borber.monsterShop.monsterTypes.MonsterTypesRepo;
import no.border.eventstore.EventStore;
import no.border.eventstore.KundenLaTilMonsterIHandlekurven;
import org.junit.Test;
import org.mockito.Mockito;
import sun.jvm.hotspot.utilities.AssertionFailure;

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
        KundeLeggerMonsterIHandlekurven kundeLeggerMonsterIHandlekurven = new KundeLeggerMonsterIHandlekurven(griff);
        KundeFjernerMonsterFraHandlekurven kundeFjernerMonsterFraHandlekurven = new KundeFjernerMonsterFraHandlekurven(griff);
        EventStore eventStore = new EventStore();
        CommandHandler commandHandler = new CommandHandler(eventStore);

        commandHandler.handle(kundeLeggerMonsterIHandlekurven);
        commandHandler.handle(kundeFjernerMonsterFraHandlekurven);

        Assert.assertEquals(2, eventStore.size());
    }

    @Test
    public void detSkalIkkeVaereLovAaFjerneEtMonsterSomIkkeLiggerIKurven() throws Exception {
        KundeFjernerMonsterFraHandlekurven kundeFjernerMonsterFraHandlekurven = new KundeFjernerMonsterFraHandlekurven(griff);
        EventStore eventStore = new EventStore();
        CommandHandler commandHandler = new CommandHandler(eventStore);
        try {
            commandHandler.handle(kundeFjernerMonsterFraHandlekurven);
            Assert.fail("Expected exception");
        } catch (MonsterKanIkkeFjernesException e) {

        }
        Assert.assertEquals(0, eventStore.size());
    }

    @Test
    public void aggregatMaaTaHensynTilTidligereFjerningerAvMonstere() throws Exception {
        KundeLeggerMonsterIHandlekurven kundeLeggerMonsterIHandlekurven = new KundeLeggerMonsterIHandlekurven(griff);
        KundeFjernerMonsterFraHandlekurven kundeFjernerMonsterFraHandlekurven = new KundeFjernerMonsterFraHandlekurven(griff);
        EventStore eventStore = new EventStore();
        CommandHandler commandHandler = new CommandHandler(eventStore);

        commandHandler.handle(kundeLeggerMonsterIHandlekurven);
        commandHandler.handle(kundeFjernerMonsterFraHandlekurven);

        try {
            commandHandler.handle(kundeFjernerMonsterFraHandlekurven);
            Assert.fail("Expected exception");
        } catch (MonsterKanIkkeFjernesException e) {

        }
    }

    @Test
    public void skalKunneLeggeTilToOgFjerneEn() throws Exception {
        KundeLeggerMonsterIHandlekurven kundeLeggerMonsterIHandlekurven = new KundeLeggerMonsterIHandlekurven(griff);
        KundeFjernerMonsterFraHandlekurven kundeFjernerMonsterFraHandlekurven = new KundeFjernerMonsterFraHandlekurven(griff);
        EventStore eventStore = new EventStore();
        CommandHandler commandHandler = new CommandHandler(eventStore);
        commandHandler.handle(kundeLeggerMonsterIHandlekurven);
        commandHandler.handle(kundeLeggerMonsterIHandlekurven);
        commandHandler.handle(kundeFjernerMonsterFraHandlekurven);

        Assert.assertEquals(3,eventStore.size());
    }
}
