package services;

import model.Customer;

public interface CashierService {
    String sellProductOnPriority(String product);
    String sellOnFirstCome(String product);
}
