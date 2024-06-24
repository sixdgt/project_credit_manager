package controller;

import dao.CustomerDAO;
import dao.impl.CustomerDAOImpl;

public class CustomerController {
    // attributes of customer
    public String full_name;
    public String dob;
    public String address;
    public String property_type;
    public String valuation_date;
    public String income_source;
    public String credit_type;
    public String is_eligible;
    public String credit_status;
    public double credit_amount = 0.00;
    public double property_valuation = 0.00;
    public double annual_income = 0.00;
    CustomerDAO cd;
    
    public boolean addCustomerCreditRequest(CustomerController cc){
        boolean status = false;
        cd = new CustomerDAOImpl();
        if(cd.createCustomer(cc)){
            status = true;
        }
        return status;
    }
}
