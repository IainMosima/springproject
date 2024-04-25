package com.javaproject.springproject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
    @JsonProperty("c-name")
    private String customerCare;
    @JsonProperty("p-name")
    private String productName;
    private int quantity;

    public String getCustomerCare() {
        return customerCare;
    }

    public void setCustomerCare(String customerCare) {
        this.customerCare = customerCare;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order [customerCare=" + customerCare + ", productName=" + productName + ", quantity=" + quantity + "]";
    }

}
