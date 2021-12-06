package by.epam.lab;

import java.util.Scanner;

public class PurchaseFactory {
    private enum PurchaseKind {
        PURCHASE_GENERAL, PURCHASE_PRICE_DISCOUNT, PURCHASE_PERCENT_DISCOUNT
    }
    public static Purchase getPurchaseFromFactory(Scanner scanner) {
        String pointer = scanner.next();
        PurchaseKind purchaseKind = PurchaseKind.valueOf(pointer);
        switch(purchaseKind) {
            case PURCHASE_GENERAL:
                return new Purchase(scanner);
            case PURCHASE_PRICE_DISCOUNT:
                return new PriceDiscountPurchase(scanner);
            case PURCHASE_PERCENT_DISCOUNT:
                return new PercentDiscountPurchase(scanner);
            default:
                throw new IllegalArgumentException();
        }
    }
}
