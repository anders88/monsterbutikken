package no.borber.monsterShop;

import no.borber.aggregate.HandlekurvAggregat;
import no.borber.monsterShop.monsterTypes.MonsterTypeJson;
import no.borber.monsterShop.monsterTypes.MonsterTypesRepo;
import no.border.eventstore.EventStore;
import no.border.eventstore.Handlekurv;
import no.no.borber.command.CommandHandler;
import no.no.borber.command.KundeLeggerMonsterIHandlekurven;
import org.junit.Assert;
import org.junit.Test;

public class IntegrationTest {
    @Test
    public void skalFungereFraCommandoTilProjeksjon() throws Exception {
        EventStore eventStore = new EventStore();
        HandlekurvAggregat handlekurvAggregat = new HandlekurvAggregat();
        eventStore.subscribe(handlekurvAggregat);
        CommandHandler commandHandler = new CommandHandler(eventStore,handlekurvAggregat);
        Handlekurv handlekurv = new Handlekurv();
        eventStore.subscribe(handlekurv);

        MonsterTypeJson vampyr = MonsterTypesRepo.getMonsterType("Vampyr");
        KundeLeggerMonsterIHandlekurven monsterTilKurv = new KundeLeggerMonsterIHandlekurven(vampyr);
        commandHandler.handle(monsterTilKurv);

        Assert.assertTrue(handlekurv.hentInnhold().contains(vampyr));

    }
}
