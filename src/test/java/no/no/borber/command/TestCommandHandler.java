package no.no.borber.command;

import no.borber.monsterShop.monsterTypes.MonsterTypeJson;
import no.borber.monsterShop.monsterTypes.MonsterTypesRepo;
import no.border.eventstore.EventStore;
import no.border.eventstore.KundenLaTilMonsterIHandlekurven;
import org.junit.Test;
import org.mockito.Mockito;

public class TestCommandHandler {

    @Test
    public void TestAtEnKommandoLagerEtEvent() throws Exception {

        final MonsterTypeJson griff = MonsterTypesRepo.getMonsterType("Griff");
        LeggerTilMonsterIHandlekurv leggerTilMonsterIHandlekurv = new LeggerTilMonsterIHandlekurv(griff);
        final EventStore eventStore = Mockito.mock(EventStore.class);
        CommandHandler commandHandler = new CommandHandler(eventStore);
        commandHandler.handle(leggerTilMonsterIHandlekurv);
        Mockito.verify(eventStore).addEvent(new KundenLaTilMonsterIHandlekurven(griff));

    }
}
