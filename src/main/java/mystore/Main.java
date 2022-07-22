package mystore;

import model.Cashier;
import model.Customer;
import model.Product;
import services.impl.CashierImpl;
import services.impl.CustomerImpl;
import services.impl.StoreImpl;

public class Main {


    public static void main(String[] args) {
       // StoreImpl matrite = new StoreImpl(productList);
        Product product = new Product();
        StoreImpl store = new StoreImpl();
        String path = "/Users/dec/MyStore/src/main/java/model/FoodSales.csv";
        try {
            store.stockProduct(path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //display product list
        for (Product p : StoreImpl.getProductList()){
            System.out.println(p);
        }
        //display list of product under category
        System.out.println(store.productCategories("bars"));


        Customer demi = new Customer("demilade", 2500.4);
        Customer david = new Customer("david", 1200.0);
        Customer segun = new Customer("shegzy", 1300.0);
        Customer uche = new Customer("Uche Obi", 1500.0);


        CustomerImpl implDemi = new CustomerImpl(demi);
        CustomerImpl implDavid = new CustomerImpl(david);
        CustomerImpl implSegun = new CustomerImpl(segun);
        CustomerImpl implUche = new CustomerImpl(uche);

        //customer buying products

//        System.out.println(implDavid.buyProduct("carrot", 10));
//        System.out.println(implDemi.buyProduct("carrot", 20));
//        System.out.println(implSegun.buyProduct("carrot", 30));
//        System.out.println(implUche.buyProduct("carrot", 40));
        System.out.println(implDavid.buyProduct("banana", 20));
        System.out.println(implSegun.buyProduct("banana", 50));





        //list of customer in Queue
        for (Customer c : StoreImpl.getCustomerQueue()){
            System.out.println(c);
        }
        System.out.println("==================================");
        //list of customers in priorityQueue
        for (Customer a : StoreImpl.getCustomerPriorityQueue()){
            System.out.println(a);
        }



        Cashier cashier = new Cashier("david", "01-a-23", 0.0);
        CashierImpl cashierImpl = new CashierImpl(cashier);

        //selling to customer on FIFO
        //System.out.println(cashierImpl.sellOnFirstCome("banana"));

        //selling to customer on priority
       // System.out.println(cashierImpl.sellProductOnPriority("carrot"));
        System.out.println(cashierImpl.sellProductOnPriority("banana"));

        System.out.println();


        //selling to customer on FIFO
       // System.out.println(cashierImpl.sellOnFirstCome("carrot"));
        System.out.println(StoreImpl.getCustomerPriorityQueue());
        System.out.println();
        //checking the money cashier has made from product sales
        //System.out.println(cashier.getName() + " has made " + cashier.getCashierWallet() + " from product sales");


        //checking the money left in customers wallet
        System.out.printf("%.2f \n", implDavid.getCustomer().getCustomerWallet());
        System.out.printf("%.2f \n", implDemi.getCustomer().getCustomerWallet());
        System.out.printf("%.2f \n", implSegun.getCustomer().getCustomerWallet());
        System.out.printf("%.2f \n", implUche.getCustomer().getCustomerWallet());

        //searching for product in store
        System.out.println(store.searchProduct("whole wheat"));
        displayProduct();
    }
    public static void displayProduct(){
        System.out.printf("%-20s%-20s%-20s%-20s","PRODUCT CATEGORY", "PRODUCT NAME","PRODUCT QUANTITY", "PRODUCT PRICE");
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        for(Product product: StoreImpl.getProductList()){
            System.out.printf("%-20s%-20s%-20d%-20.2f",product.getCategory() , product.getName(),product.getQuantity(),product.getPrice());
            System.out.println();
        }
    }

}

