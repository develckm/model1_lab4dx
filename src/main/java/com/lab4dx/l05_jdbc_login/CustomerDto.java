package com.lab4dx.l05_jdbc_login;

public class CustomerDto {
    /*
CUSTOMER_ID Number
CUSTOMER_NAME Varchar(100)
CUSTOMER_EMAIL Varchar(100)
CUSTOMER_PHONE Varchar(20)
    * */
    private int customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhone;

    @Override
    public String toString() {
        return "{" +
                "\"customerId\":" + customerId +
                ", \"customerName\":\"" + customerName + '\"' +
                ", \"customerEmail\":\"" + customerEmail + '\"' +
                ", \"customerPhone\":\"" + customerPhone + '\"' +
                '}';
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
}
