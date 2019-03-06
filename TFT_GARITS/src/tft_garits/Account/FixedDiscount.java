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
public class FixedDiscount extends Discount {

    private String taskType;
    private double discountPercentage;

    /**
     *
     * @param percentage
     */
    public static FixedPercentage FixedPercentage(double percentage) {
        // TODO - implement FixedDiscount.FixedPercentage
        throw new UnsupportedOperationException();
    }

    public String getTaskType() {
        return this.taskType;
    }

    /**
     *
     * @param taskType
     */
    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public double getDiscountPercentage() {
        return this.discountPercentage;
    }

    /**
     *
     * @param discountPercentage
     */
    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

}
