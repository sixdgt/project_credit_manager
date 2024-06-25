package dao;

import java.sql.ResultSet;
import controller.CustomerController;
import model.CustomerModel;

public interface CustomerDAO {
    /**
     * this method will store the data of customer
     * @param cc - here `cc` is an object of CustomerController
     * @return 
     */
    public abstract boolean createCustomer(CustomerController cc);
    
    public abstract CustomerModel selectCustomer();
    
    public abstract boolean updateCustomer(CustomerController cc);
    
    public abstract CustomerModel selectCustomerById(CustomerController cc);
    
    public abstract boolean deleteCustomer(CustomerController cc);
}
