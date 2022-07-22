package services.impl;

import model.Cashier;
import model.Customer;
import model.Product;
import services.CashierService;

public class CashierImpl implements CashierService {
    Cashier cashier;

    public CashierImpl(Cashier cashier) {
        this.cashier = cashier;
    }

    String saleSucceed = "", saleFailed = "";
    /*
        SellOnPriority checks if the customer queue is not empty
        if true, the first customer is removed and attended to by the cashier.
         */
    @Override
    public String sellProductOnPriority(String product) {
        if (!StoreImpl.getCustomerPriorityQueue().isEmpty()) {
            Customer customer = StoreImpl.getCustomerPriorityQueue().remove();
            int quantity = customer.getQuantity();

            for (Product eachProduct : StoreImpl.getProductList()) {
                double productPrice = eachProduct.getPrice() * quantity;
                if (eachProduct.getName().compareToIgnoreCase(product) == 0 &&
                        customer.getCustomerWallet() >= productPrice
                        && eachProduct.getQuantity() >= quantity) {

                    int newQuantity = eachProduct.getQuantity() - quantity;
                    eachProduct.setQuantity(newQuantity);

                    double newWallet = customer.getCustomerWallet() - productPrice;

                    customer.setCustomerWallet(newWallet);

                    double cashierCashUpdate = productPrice + cashier.getCashierWallet();

                    cashier.setCashierWallet(cashierCashUpdate);

                    return saleSucceed = eachProduct.getName() + " has been sold " + " to " + customer.getName();
                }
            }
            return saleFailed = product + " not sold";
        }
        return "Queue is empty";
    }

    /*
    SellOnFirstCome checks if the customer queue is not empty
    if true, the first customer is removed and attended to by the cashier.
     */
    @Override
    public String sellOnFirstCome(String product) {
        if (!StoreImpl.getCustomerQueue().isEmpty()) {
            Customer customer = StoreImpl.getCustomerQueue().remove();
            int quantity = customer.getQuantity();
            for (Product eachProduct : StoreImpl.getProductList()) {
                double productPrice = eachProduct.getPrice() * quantity;
                if (eachProduct.getName().compareToIgnoreCase(product) == 0 &&
                        customer.getCustomerWallet() >= productPrice
                        && eachProduct.getQuantity() >= quantity) {

                    int newQuantity = eachProduct.getQuantity() - quantity;
                    eachProduct.setQuantity(newQuantity);


                    double newWallet = customer.getCustomerWallet() - productPrice;

                    customer.setCustomerWallet(newWallet);

                    double cashierCashUpdate = productPrice + cashier.getCashierWallet();

                    cashier.setCashierWallet(cashierCashUpdate);

                    return saleSucceed = eachProduct.getName() + " has been sold " + " to " + customer.getName().toLowerCase();
                }
            }
            return saleFailed = product + " not sold";
        }
        return "Queue is empty";
    }

}
