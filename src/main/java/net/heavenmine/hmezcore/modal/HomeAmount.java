package net.heavenmine.hmezcore.modal;

public class HomeAmount {
    private String name;
    private int amount;

    @Override
    public String toString() {
        return "HomeAmount{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public HomeAmount(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
}
