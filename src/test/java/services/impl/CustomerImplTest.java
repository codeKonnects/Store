package services.impl;

import model.Customer;
import model.Product;
import model.Store;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerImplTest {
    int quantity;
    String product;
    Customer customer;
    CustomerImpl customerImpl;
    Store store;
    StoreImpl storeImpl;



    @BeforeEach
    void setUp() {
        store = new Store();
        storeImpl = new StoreImpl(store);
        quantity = 50;
        product = "whole wheat";
        customer = new Customer("uche obi", 5000.0);
        customerImpl = new CustomerImpl(customer);
        storeImpl.stockProduct("/Users/dec/MyStore/src/main/java/model/FoodSales.csv");
    }

    @Test
    void buyProduct() {
        String successful = customerImpl.buyProduct(product, quantity);
        assertEquals("whole wheat is available", successful);

    }
}