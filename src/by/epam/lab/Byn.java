package by.epam.lab;
public class Byn implements Comparable<Byn>{
    private int value;

    public Byn (){
        value = 0;
    }

    public Byn (int value) {
        this.value = value;
    }

    public Byn (Byn o) {
        value = o.value;
    }

    public Byn (int rubs, int coins) {
        value = rubs * 100 + coins;
    }

    public Byn mul(int i) {
        value *= i;
        return this;
    }
    public Byn mul(double i){
        value = (int)Math.round(value*i);
        return this;
    }

    public Byn substract(Byn obj) {
        value = value - obj.value;
        return this;
    }

    public int compareTo(Byn o) {
        return value - o.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        Byn byn = (Byn) o;
        return value == byn.value;
    }

    @Override
    public String toString() {
        return value / 100 + "." + value % 100 / 10 + value % 10;
    }
}