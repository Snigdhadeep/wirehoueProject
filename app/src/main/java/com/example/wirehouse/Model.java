package com.example.wirehouse;

public class Model {

   public String pallet_number,client_type,date_of_entry,product_name,date_of_delivery,date,location_type,customer_name,
            location_name,product_type,pallet_type,pallet_name,company_name;

    public Model() {
    }

    public Model(String pallet_number, String client_type, String date_of_entry, String product_name, String date_of_delivery, String date, String location_type, String customer_name, String location_name, String product_type, String pallet_type, String pallet_name, String company_name) {
        this.pallet_number = pallet_number;
        this.client_type = client_type;
        this.date_of_entry = date_of_entry;
        this.product_name = product_name;
        this.date_of_delivery = date_of_delivery;
        this.date = date;
        this.location_type = location_type;
        this.customer_name = customer_name;
        this.location_name = location_name;
        this.product_type = product_type;
        this.pallet_type = pallet_type;
        this.pallet_name = pallet_name;
        this.company_name = company_name;
    }

    public String getPallet_number() {
        return pallet_number;
    }

    public void setPallet_number(String pallet_number) {
        this.pallet_number = pallet_number;
    }

    public String getClient_type() {
        return client_type;
    }

    public void setClient_type(String client_type) {
        this.client_type = client_type;
    }

    public String getDate_of_entry() {
        return date_of_entry;
    }

    public void setDate_of_entry(String date_of_entry) {
        this.date_of_entry = date_of_entry;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDate_of_delivery() {
        return date_of_delivery;
    }

    public void setDate_of_delivery(String date_of_delivery) {
        this.date_of_delivery = date_of_delivery;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation_type() {
        return location_type;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getPallet_type() {
        return pallet_type;
    }

    public void setPallet_type(String pallet_type) {
        this.pallet_type = pallet_type;
    }

    public String getPallet_name() {
        return pallet_name;
    }

    public void setPallet_name(String pallet_name) {
        this.pallet_name = pallet_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
}
