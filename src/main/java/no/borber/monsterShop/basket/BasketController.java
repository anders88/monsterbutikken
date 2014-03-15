package no.borber.monsterShop.basket;

import no.borber.monsterShop.MonsterShopController;
import no.borber.monsterShop.monsterTypes.MonsterTypeJson;
import no.borber.monsterShop.monsterTypes.MonsterTypesRepo;
import no.border.eventstore.Handlekurv;
import no.border.eventstore.KundenFjernetMonsterFraHandlekurven;
import no.border.eventstore.ServiceFactory;
import no.no.borber.command.CommandHandler;
import no.no.borber.command.KundeFjernerMonsterFraHandlekurven;
import no.no.borber.command.KundeLeggerMonsterIHandlekurven;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
public class BasketController extends MonsterShopController{

    /**
     * Gets the current state of a customers basket
     *
     * @return Map of String monsterType og basketItem for the applicable monster type.
     */
    @RequestMapping(value = "/basket/",  method=RequestMethod.GET)
    @ResponseBody()
    public Map<String, BasketItem> getBasket(){
        Handlekurv handlekurv = ServiceFactory.handlekurv();
        return handlekurv.hentInnhold();
    }

    /**
     * Adds a new monster of a specified type to the customers basket. If there is an existing basket item the number
     * of monsters is incremented, otherwise a new order baslet item is created.
     *
     * @param monstertype name of the monstertype to be added
     */
    @RequestMapping(value = "/basket/{monstertype}",  method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void add(@PathVariable String monstertype){
        CommandHandler commandHandler = ServiceFactory.commandHandler();
        MonsterTypeJson monsterType = MonsterTypesRepo.getMonsterType(monstertype);
        KundeLeggerMonsterIHandlekurven kundeLeggerMonsterIHandlekurven = new KundeLeggerMonsterIHandlekurven(monsterType);
        commandHandler.handle(kundeLeggerMonsterIHandlekurven);
    }

    /**
     * Removes a monster from the customers basket. If the resulting number of monsters reaches 0, the basket item is
     * removed.
     *
     * @param monstertype name of the monstertype to be removed
     */
    @RequestMapping(value = "/basket/{monstertype}",  method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void remove(@PathVariable String monstertype){
        CommandHandler commandHandler = ServiceFactory.commandHandler();
        MonsterTypeJson monsterType = MonsterTypesRepo.getMonsterType(monstertype);
        KundeFjernerMonsterFraHandlekurven kundeFjernerMonsterFraHandlekurven = new KundeFjernerMonsterFraHandlekurven(monsterType);
        commandHandler.handle(kundeFjernerMonsterFraHandlekurven);
    }

    /**
     * Calculates the sum of (price * number) for all items in the basket.
     */
    @RequestMapping(value = "/basket/sum",  method=RequestMethod.GET)
    @ResponseBody
    public BasketSum sum(){
        return new BasketSum(42d);
    }

}
