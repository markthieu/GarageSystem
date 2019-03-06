/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tft_garits.Account;

/**
 *
 * @author George Kemp
 */
public class CustomerAccount {

    private int customerId;
    private Date Date;
    private String name;
    private String address;
    private String postCode;
    private String Tel;
    private String email;
    private List vehicles;
    private Discount discountType;
    private List outstandingInvoices;

    /**
     *
     * @param name
     * @param emailAddress
     * @param Tel
     * @param vehicles
     */
    public static CustomerAccount CustomerAccount(String name, String emailAddress, double Tel, List vehicles) {
        // TODO - implement CustomerAccount.CustomerAccount
        throw new UnsupportedOperationException();
    }

    public int getCustomerId() {
        return this.customerId;
    }

    /**
     *
     * @param customerId
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getDate() {
        // TODO - implement CustomerAccount.getDate
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param Date
     */
    public void setDate(Date Date) {
        // TODO - implement CustomerAccount.setDate
        throw new UnsupportedOperationException();
    }

    public String getName() {
        return this.name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return this.postCode;
    }

    /**
     *
     * @param postCode
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTel() {
        // TODO - implement CustomerAccount.getTel
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param Tel
     */
    public void setTel(String Tel) {
        // TODO - implement CustomerAccount.setTel
        throw new UnsupportedOperationException();
    }

    public String getEmail() {
        return this.email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public List getVehicles() {
        return this.vehicles;
    }

    /**
     *
     * @param vehicles
     */
    public void setVehicles(List vehicles) {
        this.vehicles = vehicles;
    }

    public Discount getDiscountType() {
        return this.discountType;
    }

    /**
     *
     * @param discountType
     */
    public void setDiscountType(Discount discountType) {
        this.discountType = discountType;
    }

    public List getOutstandingInvoices() {
        return this.outstandingInvoices;
    }

    /**
     *
     * @param outstandingInvoices
     */
    public void setOutstandingInvoices(List outstandingInvoices) {
        this.outstandingInvoices = outstandingInvoices;
    }

}
