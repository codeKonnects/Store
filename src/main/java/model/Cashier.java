package model;

public class Cashier extends Person {
    private double cashierWallet;
    public Cashier(String name, String id, double cashierWallet) {
        super(name, id);
        this.cashierWallet = cashierWallet;
    }

    public double getCashierWallet() {
        return cashierWallet;
    }

    public void setCashierWallet(double cashierWallet) {
        this.cashierWallet = cashierWallet;
    }
}
