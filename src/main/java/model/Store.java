package model;

import java.util.Objects;

public class Store {
    private Manager manager;
    private Customer customer;
    private Cashier cashier;

    public Store( Manager manager, Customer customer, Cashier cashier) {
        this.manager = manager;
        this.customer = customer;
        this.cashier = cashier;
    }

    public Store() {
    }

    public Manager getManager() {
        return manager;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Cashier getCashier() {
        return cashier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store)) return false;
        Store store = (Store) o;
        return getManager().equals(store.getManager()) && getCustomer().equals(store.getCustomer()) && getCashier().equals(store.getCashier());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getManager(), getCustomer(), getCashier());
    }
}
