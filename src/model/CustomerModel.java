package model;

public class CustomerModel {
    private int customer_id;
    private String full_name;
    private String dob;
    private String address;
    private double annual_income;
    private String income_source;
    private double property_valuation;
    private String property_type;
    private String valuation_date;
    private String credit_type;
    private int is_eligible;
    private double credit_amount;
    private String credit_status;
    private String applied_at;
    private String verified_at;

    public int getCustomerId() {
        return customer_id;
    }

    public void setCustomerId(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getFullName() {
        return full_name;
    }

    public void setFullName(String full_name) {
        this.full_name = full_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAnnualIncome() {
        return annual_income;
    }

    public void setAnnualIncome(double annual_income) {
        this.annual_income = annual_income;
    }

    public String getIncomeSource() {
        return income_source;
    }

    public void setIncomeSource(String income_source) {
        this.income_source = income_source;
    }

    public double getPropertyValuation() {
        return property_valuation;
    }

    public void setPropertyValuation(double property_valuation) {
        this.property_valuation = property_valuation;
    }

    public String getPropertyType() {
        return property_type;
    }

    public void setPropertyType(String property_type) {
        this.property_type = property_type;
    }

    public String getValuationDate() {
        return valuation_date;
    }

    public void setValuationDate(String valuation_date) {
        this.valuation_date = valuation_date;
    }

    public String getCreditType() {
        return credit_type;
    }

    public void setCreditType(String credit_type) {
        this.credit_type = credit_type;
    }

    public int getIsEligible() {
        return is_eligible;
    }

    public void setIsEligible(int is_eligible) {
        this.is_eligible = is_eligible;
    }

    public double getCreditAmount() {
        return credit_amount;
    }

    public void setCreditAmount(double credit_amount) {
        this.credit_amount = credit_amount;
    }

    public String getCreditStatus() {
        return credit_status;
    }

    public void setCreditStatus(String credit_status) {
        this.credit_status = credit_status;
    }

    public String getAppliedAt() {
        return applied_at;
    }

    public void setAppliedAt(String applied_at) {
        this.applied_at = applied_at;
    }

    public String getVerifiedAt() {
        return verified_at;
    }

    public void setVerifiedAt(String verified_at) {
        this.verified_at = verified_at;
    }
    

}
