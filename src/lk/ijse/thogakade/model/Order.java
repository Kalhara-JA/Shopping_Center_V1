/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.model;

import java.util.ArrayList;

/**
 *
 * @author Kalhara
 */
public class Order {
    private String id;
    private String date;
    private String customerId;
    private ArrayList<OrderDetail>orderDetailLost;

    public Order() {
    }

    public Order(String id, String date, String customerId, ArrayList<OrderDetail> orderDetailLost) {
        this.id = id;
        this.date = date;
        this.customerId = customerId;
        this.orderDetailLost = orderDetailLost;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the orderDetailLost
     */
    public ArrayList<OrderDetail> getOrderDetailLost() {
        return orderDetailLost;
    }

    /**
     * @param orderDetailLost the orderDetailLost to set
     */
    public void setOrderDetailLost(ArrayList<OrderDetail> orderDetailLost) {
        this.orderDetailLost = orderDetailLost;
    }
    
    
    
}
