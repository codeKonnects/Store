package model;

import services.impl.StoreImpl;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;


public class Customer extends Person  {
    private int quantity;
    public Customer(String name, double wallet) {
        super(name, wallet);
    }

    public Customer() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return getQuantity() == customer.getQuantity();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getQuantity());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "quantity=" + quantity +
                " name="+getName()+
                '}';
    }
}
