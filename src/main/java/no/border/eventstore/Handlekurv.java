package no.border.eventstore;

public class Handlekurv implements EventSubscriber {

    int numberOfMonstersInBasket = 0;

    @Override
    public void eventAdded(Event event) {
        numberOfMonstersInBasket++;
    }

    public int size() {
        return numberOfMonstersInBasket;
    }
}
