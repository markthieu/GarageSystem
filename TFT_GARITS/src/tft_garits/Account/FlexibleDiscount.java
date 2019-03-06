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

public class FlexibleDiscount extends Discount {

    private double currentValueOfOrders;
    private double percentageDiscount;
    private String currentMonth;

    public void deductFromFuturePayment() {
        // TODO - implement FlexibleDiscount.deductFromFuturePayment
        throw new UnsupportedOperationException();
    }

    public void sendCheque() {
        // TODO - implement FlexibleDiscount.sendCheque
        throw new UnsupportedOperationException();
    }

    public static FlexibleDiscount FlexibleDiscount() {
        // TODO - implement FlexibleDiscount.FlexibleDiscount
        throw new UnsupportedOperationException();
    }

    public double getCurrentValueOfOrders() {
        return this.currentValueOfOrders;
    }

    /**
     *
     * @param currentValueOfOrders
     */
    public void setCurrentValueOfOrders(double currentValueOfOrders) {
        this.currentValueOfOrders = currentValueOfOrders;
    }

    public double getPercentageDiscount() {
        return this.percentageDiscount;
    }

    /**
     *
     * @param percentageDiscount
     */
    public void setPercentageDiscount(double percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }

    public String getCurrentMonth() {
        return this.currentMonth;
    }

    /**
     *
     * @param currentMonth
     */
    public void setCurrentMonth(String currentMonth) {
        this.currentMonth = currentMonth;
    }

}
