package by.epam.lab;

import java.util.Objects;
import java.util.Scanner;

public class Purchase {
    private String name;
    private Byn price;
    private int number;

    public Purchase() {
        this.name = null;
        this.price = null;
        this.number = 0;
    }

    public Purchase(String name, int price, int number) {
        this.name = name;
        this.price = new Byn(price);
        this.number = number;
    }

    public Purchase(Scanner scanner){
        name = scanner.next();
        price = new Byn(scanner.nextInt());
        number = scanner.nextInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byn getPrice() {
        return price;
    }

    public void setPrice(Byn price) {
        this.price = price;
    }

    public void setPrice(int i) {
        this.price = new Byn(i);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Byn getCost() {
        Byn obj = new Byn(price);
        return obj.mul(number);
    }

    @Override
    public String toString() {
        return String.format("%s;%s", fieldsToString(), getCost().toString());
    }

    protected String fieldsToString() {
        return String.format("%s;%s;%d", name, price.toString(), number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) o;
        return number == purchase.number && Objects.equals(name, purchase.name) && Objects.equals(price, purchase.price);
    }
}

