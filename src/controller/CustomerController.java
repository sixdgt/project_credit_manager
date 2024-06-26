package controller;

import dao.CustomerDAO;
import dao.impl.CustomerDAOImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import model.CustomerModel;

public class CustomerController {
    // attributes of customer
    public int customer_id;
    public String full_name;
    public String dob;
    public String address;
    public String property_type;
    public String valuation_date;
    public String income_source;
    public String credit_type;
    public int is_eligible;
    public String credit_status;
    public double credit_amount = 0.00;
    public double property_valuation = 0.00;
    public double annual_income = 0.00;
    public String applied_date;
    
    CustomerDAO cd;
    
    public boolean addCustomerCreditRequest(CustomerController cc){
        boolean status = false;
        cd = new CustomerDAOImpl();
        if(cd.createCustomer(cc)){
            status = true;
        }
        return status;
    }
    
    public HashMap<Integer, CustomerModel> showAllCustomerCreditRequest(){
        CustomerDAO cdao = new CustomerDAOImpl();
        HashMap<Integer, CustomerModel> cm = cdao.selectCustomer();
        return cm;
    }
    
    public CustomerController getCustomerCreditRequest(CustomerController cc){
        CustomerDAO cdao = new CustomerDAOImpl();
        // here selectCustomerById() method returns CustomerModel object
        // so we are referencing CustomerModel object with the return object
        CustomerModel customer = cdao.selectCustomerById(cc);
        cc.customer_id = customer.getCustomerId();
        cc.full_name = customer.getFullName();
        cc.dob = customer.getDob();
        cc.address = customer.getAddress();
        cc.income_source = customer.getIncomeSource();
        cc.annual_income = customer.getAnnualIncome();
        cc.property_type = customer.getPropertyType();
        cc.property_valuation = customer.getPropertyValuation();
        cc.is_eligible = customer.getIsEligible();
        cc.credit_type = customer.getCreditType();
        cc.credit_status = customer.getCreditStatus();
        cc.credit_amount = customer.getCreditAmount();
        cc.applied_date = customer.getAppliedAt();
        cc.valuation_date = customer.getValuationDate();
        return cc;
    }
}   
