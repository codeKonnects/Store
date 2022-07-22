package services.impl;

import model.Customer;
import model.Product;
import services.CustomerService;

public class CustomerImpl implements CustomerService {

    Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public CustomerImpl(Customer customer) {
        this.customer = customer;
    }

    String message = "";

    /*
    buyProduct checks if the product the customer wants is available
    if it's in store add the customers to the queues.
     */

    @Override
    public String buyProduct(String product, int quantity){
        for (Product productIn : StoreImpl.getProductList()){
            if (productIn.getName().equalsIgnoreCase(product) &&
                    productIn.getQuantity() >= quantity && productIn.getQuantity() !=0){
                customer.setQuantity(quantity);
                addCustomerToQueue();
                return message = product + " is available";
            }
        }
        return message = product + " is out of stock!";
    }
    public void addCustomerToQueue(){
        StoreImpl.getCustomerPriorityQueue().add(customer);
        StoreImpl.getCustomerQueue().add(customer);

    }
}

