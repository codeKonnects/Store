package services.impl;

import model.Cashier;
import model.Customer;
import model.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class CashierImplTest {
    Cashier daro;
    CashierImpl daroImpl;
    Customer david;
    CustomerImpl davidImpl;
    Customer uche;
    CustomerImpl ucheImpl;
    Customer segun;
    CustomerImpl segunImpl;
    Customer demi;
    CustomerImpl demiImpl;
    String product;
    int quantity;
    Store store = new Store();
    StoreImpl storeImpl = new StoreImpl(store);
    StoreImpl getStoreImpl = new StoreImpl();


    @BeforeEach
    void setUp() {
        daro = new Cashier("daro", "21-09", 0.0);
        daroImpl = new CashierImpl(daro);
        david = new Customer("david", 1200.0);
        davidImpl = new CustomerImpl(david);
        demi = new Customer("demi", 2000);
        demiImpl = new CustomerImpl(demi);
        uche = new Customer("Uche Obi", 120.0);
        ucheImpl = new CustomerImpl(uche);
        segun = new Customer("shegzy", 200);
        segunImpl = new CustomerImpl(segun);
        product ="chocolate chip";
        quantity = 122;
        storeImpl.stockProduct("/Users/dec/MyStore/src/main/java/model/FoodSales.csv");


    }



    @Test
    void sellOnFirstCome() {
        ucheImpl.buyProduct(product, 20);
        segunImpl.buyProduct(product, 30);
        demiImpl.buyProduct(product, 10);
        davidImpl.buyProduct(product, 50);
        String actual = daroImpl.sellOnFirstCome(product);
        String expected = "Chocolate Chip has been sold  to uche obi";
        Assertions.assertEquals(expected, actual);
    }
}