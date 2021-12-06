package by.epam.lab;

import java.util.Scanner;

public class PercentDiscountPurchase extends Purchase {
    private double discountPercent;
    private final int discountNumber = 17;

    public PercentDiscountPurchase(String name, int price, int number, double discountPercent) {
        super(name, price, number);
        this.discountPercent = discountPercent;
    }
    public PercentDiscountPurchase(Scanner scanner){
        setName(scanner.next());
        setPrice(scanner.nextInt());
        setNumber(scanner.nextInt());
        discountPercent = scanner.nextDouble();
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getDiscountNumber() {
        return discountNumber;
    }

    @Override
    public Byn getCost() {
        double innerDiscount = discountPercent;
        if (getNumber() <= discountNumber) {
            innerDiscount = 0;
        }
        return super.getCost().mul(1 - (innerDiscount / 100));
    }

    @Override
    protected String fieldsToString() {
        return String.format("%s;%.2f;%d", super.fieldsToString(), discountPercent, discountNumber);
    }
}
