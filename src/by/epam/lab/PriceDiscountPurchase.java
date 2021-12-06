package by.epam.lab;

import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase {
    private Byn discount;

    public PriceDiscountPurchase (String name, int price, int number, int dis) {
        super(name, price, number);
        discount = new Byn (dis);
    }
    public PriceDiscountPurchase(Scanner scanner){
        setName(scanner.next());
        setPrice(scanner.nextInt());
        setNumber(scanner.nextInt());
        discount = new Byn(scanner.nextInt());
    }

    public Byn getDiscount() {
        return discount;
    }
    public void setDiscount(Byn o) {
        discount = o;
    }

    public void setDiscount(int i) {
        discount = new Byn(i);
    }
    @Override
    public Byn getCost() {
        Byn obj = new Byn(getPrice());
        return (obj.substract(discount)).mul(getNumber());
    }

    protected String fieldsToString() {
        return String.format("%s;%s", super.fieldsToString(), discount);
    }
}
