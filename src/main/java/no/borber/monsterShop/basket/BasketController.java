package no.borber.monsterShop.basket;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
public class BasketController {

    @Resource
    private HttpServletRequest httpRequest;

    /**
     * Gets the current state of a customers basket
     *
     * @return Map of String monsterType og basketItem for the applicable monster type.
     */
    @RequestMapping(value = "/basket/",  method=RequestMethod.GET)
    @ResponseBody()
    public Map<String, BasketItem> getBasket(){
        return null;
    }

    /**
     * Removes a monster from the customers basket. If the resulting number of monsters reaches 0, the basket item is
     * removed.
     *
     * @param monstertype name of the monstertype to be removed
     */
    @RequestMapping(value = "/basket/remove/{monstertype}",  method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void removeMonster(@PathVariable String monstertype){}

    /**
     * Adds a new monster of a specified type to the customers basket. If there is an existing basket item the number
     * of monsters is incremented, otherwise a new order baslet item is created.
     *
     * @param monstertype name of the monstertype to be added
     */
    @RequestMapping(value = "/handlekurv/leggTil/{monstertype}",  method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addMonster(@PathVariable String monstertype){}

    /**
     * Generates a new order based on the contents of the customers basket, and empties the basket.
     * */
    @RequestMapping(value = "/basket/confirm",  method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void confirm(){}

    /**
     * Calculates the sum of (price * number) for all items in the basket.
     */
    @RequestMapping(value = "/basket/sum",  method=RequestMethod.GET)
    @ResponseBody
    public BasketSum getSum(){
        return null;
    }

    private String getCurrentCustomer() {
        return (String)httpRequest.getSession().getAttribute("customerName");
    }
}