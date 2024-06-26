package dao.impl;

import controller.CustomerController;
import dao.CustomerDAO;
import dbconfig.DbConnection;
import java.sql.ResultSet;
import model.CustomerModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CustomerDAOImpl implements CustomerDAO {

    DbConnection connect;

    public CustomerDAOImpl() {
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
                    + "'" + cm.getAddress() + "', " + cm.getAnnualIncome() + ","
                    + "'" + cm.getIncomeSource() + "', " + cm.getPropertyValuation() + ","
                    + "'" + cm.getPropertyType() + "', '" + cm.getValuationDate() + "',"
                    + "'" + cm.getCreditType() + "', '" + cm.getIsEligible() + "', "
                    + cm.getCreditAmount() + ", '" + cm.getCreditStatus() + "')";
            if (this.connect.iudQueryBuilder(sql)) {
                status = true;
            }
        } catch (Exception e) {
        }
        return status;
    }

    @Override
    public HashMap<Integer, CustomerModel> selectCustomer() {
        HashMap<Integer, CustomerModel> customers = new HashMap<>();
        try {
            String sql = "SELECT * FROM customer";
            ResultSet rs = this.connect.selectQueryBuilder(sql);
            int counter = 0;
            while (rs.next()) {
                CustomerModel cm = new CustomerModel();
                cm.setCustomerId(rs.getInt("customer_id"));
                cm.setFullName(rs.getString("full_name"));
                cm.setDob(rs.getString("dob"));
                cm.setAddress(rs.getString("address"));
                cm.setAnnualIncome(rs.getDouble("annual_income"));
                cm.setIncomeSource(rs.getString("income_source"));
                cm.setPropertyValuation(rs.getDouble("property_valuation"));
                cm.setPropertyType(rs.getString("property_type"));
                cm.setValuationDate(rs.getString("valuation_date"));
                cm.setCreditType(rs.getString("credit_type"));
                cm.setIsEligible(rs.getInt("is_eligible"));
                cm.setCreditAmount(rs.getDouble("credit_amount"));
                cm.setCreditStatus(rs.getString("credit_status"));
                cm.setAppliedAt(rs.getString("applied_at"));
                customers.put(counter, cm);
                counter++;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return customers;
    }

    @Override
    public boolean updateCustomer(CustomerController cc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CustomerModel selectCustomerById(CustomerController cc) {
        CustomerModel cm = new CustomerModel();
        try {
            String sql = "SELECT * FROM customer WHERE customer_id=" + cc.customer_id;
            ResultSet rs = this.connect.selectQueryBuilder(sql);
            while(rs.next()){
                cm.setCustomerId(rs.getInt("customer_id"));
                cm.setFullName(rs.getString("full_name"));
                cm.setDob(rs.getString("dob"));
                cm.setAddress(rs.getString("address"));
                cm.setAnnualIncome(rs.getDouble("annual_income"));
                cm.setIncomeSource(rs.getString("income_source"));
                cm.setPropertyValuation(rs.getDouble("property_valuation"));
                cm.setPropertyType(rs.getString("property_type"));
                cm.setValuationDate(rs.getString("valuation_date"));
                cm.setCreditType(rs.getString("credit_type"));
                cm.setIsEligible(rs.getInt("is_eligible"));
                cm.setCreditAmount(rs.getDouble("credit_amount"));
                cm.setCreditStatus(rs.getString("credit_status"));
                cm.setAppliedAt(rs.getString("applied_at"));
            }
        } catch (SQLException e) {
        }
        return cm;
    }

    @Override
    public boolean deleteCustomer(CustomerController cc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
