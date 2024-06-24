package dao.impl;

import controller.CustomerController;
import dao.CustomerDAO;
import dbconfig.DbConnection;
import java.sql.ResultSet;
import model.CustomerModel;

public class CustomerDAOImpl implements CustomerDAO {
    DbConnection connect;
    public CustomerDAOImpl(){
        connect = DbConnection.getConnection();
    }
    
    @Override
    public boolean createCustomer(CustomerController cc) {
        boolean status = false;
        CustomerModel cm = new CustomerModel();
        cm.setFullName(cc.full_name);
        cm.setDob(cc.dob);
        cm.setAddress(cc.address);
        cm.setAnnualIncome(cc.annual_income);
        cm.setIncomeSource(cc.income_source);
        cm.setPropertyValuation(cc.property_valuation);
        cm.setPropertyType(cc.property_type);
        cm.setValuationDate(cc.valuation_date);
        cm.setCreditType(cc.credit_type);
        cm.setIsEligible(cc.is_eligible);
        cm.setCreditAmount(cc.credit_amount);
        cm.setCreditStatus(cc.credit_status);
        try {
            String sql = "INSERT INTO customer(full_name, dob, address, annual_income, "
                    + "income_source, property_valuation, property_type, valuation_date,"
                    + "credit_type, is_eligible, credit_amount, credit_status) VALUES("
                    + "'" + cm.getFullName() + "', '" + cm.getDob() + "',"
                    + "'"+ cm.getAddress() +"', "+ cm.getAnnualIncome()+ ","
                    + "'"+cm.getIncomeSource()+"', "+cm.getPropertyValuation() + ","
                    + "'"+cm.getPropertyType() + "', '"+cm.getValuationDate()+"',"
                    + "'"+cm.getCreditType() + "', '"+ cm.getIsEligible() + "', "
                    + cm.getCreditAmount() + ", '" +cm.getCreditStatus() + "')";
            if(this.connect.iudQueryBuilder(sql)){
                status = true;
            }
        } catch (Exception e) {
        }
        return status;
    }

    @Override
    public ResultSet selectCustomer(CustomerController cc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateCustomer(CustomerController cc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResultSet selectCustomerById(CustomerController cc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteCustomer(CustomerController cc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
