import by.epam.lab.Byn;
import by.epam.lab.Purchase;
import by.epam.lab.PurchaseFactory;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args){
        final int PURCHASES_NUMBER = 6;
        Purchase[] purchases = new Purchase[PURCHASES_NUMBER];
        try {
            Scanner file = new Scanner(new FileReader("src/in.txt"));
            Byn maxCost = new Byn(0);
            Purchase maxPurchase = null;
            boolean status = true;
            int i = 0;
            for (Purchase p : purchases) {
                p = PurchaseFactory.getPurchaseFromFactory(file);
                purchases[i] = p;
                System.out.println(p);
                if (maxCost.compareTo(p.getCost()) < 0) {
                    maxCost = p.getCost();
                    maxPurchase = p;
                }
                if (status && i > 0) {
                    status = p.equals(purchases[i - 1]);
                }
                i++;
            }
            System.out.println(maxPurchase);
            System.out.printf("equality of purchases : %s", status);
        } catch (FileNotFoundException exc) {
            System.out.println("Not found");
        }
    }
}

