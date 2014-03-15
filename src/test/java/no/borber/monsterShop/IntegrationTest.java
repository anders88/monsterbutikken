package no.borber.monsterShop;

import no.borber.monsterShop.monsterTypes.MonsterTypeJson;
import no.borber.monsterShop.monsterTypes.MonsterTypesRepo;
import no.border.eventstore.EventStore;
import no.border.eventstore.Handlekurv;
import no.no.borber.command.CommandHandler;
import no.no.borber.command.LeggerTilMonsterIHandlekurv;
import org.junit.Assert;
import org.junit.Test;

public class IntegrationTest {
    @Test
    public void skalFungereFraCommandoTilProjeksjon() throws Exception {
        EventStore eventStore = new EventStore();
        CommandHandler commandHandler = new CommandHandler(eventStore);
        Handlekurv handlekurv = new Handlekurv();
        eventStore.subscribe(handlekurv);

        MonsterTypeJson vampyr = MonsterTypesRepo.getMonsterType("Vampyr");
        LeggerTilMonsterIHandlekurv monsterTilKurv = new LeggerTilMonsterIHandlekurv(vampyr);
        commandHandler.handle(monsterTilKurv);

        Assert.assertTrue(handlekurv.hentInnhold().contains(vampyr));

    }
}
