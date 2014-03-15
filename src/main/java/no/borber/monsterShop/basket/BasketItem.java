package no.borber.monsterShop.basket;

public class BasketItem {
    private String name;
    private double price;
    private int number=1;

    public BasketItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void addMonster() {
        this.number++;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void removeMonster() {
        number--;
    }

    public double getPrice() {
        return price;
    }
}
