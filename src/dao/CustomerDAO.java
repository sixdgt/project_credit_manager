package dao;

import java.sql.ResultSet;
import controller.CustomerController;

public interface CustomerDAO {
    /**
     * this method will store the data of customer
     * @param cc - here `cc` is an object of CustomerController
     * @return 
     */
    public abstract boolean createCustomer(CustomerController cc);
    
    public abstract ResultSet selectCustomer(CustomerController cc);
    
    public abstract boolean updateCustomer(CustomerController cc);
    
    public abstract ResultSet selectCustomerById(CustomerController cc);
    
    public abstract boolean deleteCustomer(CustomerController cc);
}
