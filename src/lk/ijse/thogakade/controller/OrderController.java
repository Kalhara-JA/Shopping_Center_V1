/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lk.ijse.thogakade.db.DBConnection;
import lk.ijse.thogakade.model.Order;
import lk.ijse.thogakade.model.OrderDetail;

/**
 *
 * @author Kalhara
 */
public class OrderController {
    public static String getLastOrderId() throws ClassNotFoundException, SQLException{
        ResultSet rst=DBConnection.getInstance().getConnection().createStatement().executeQuery("Select id From Orders ORDER By id DESC LIMIT 1");
        return rst.next() ? rst.getString("id"): null;
    }
     public static boolean addOrder(Order order) throws ClassNotFoundException, SQLException{
         PreparedStatement stm=DBConnection.getInstance().getConnection().prepareStatement("Insert into orders values(?,?,?)");
         stm.setObject(1, order.getId());
         stm.setObject(2, order.getDate());
         stm.setObject(3, order.getCustomerId());
         
         boolean isAdded=stm.executeUpdate()>0;
         
         if(isAdded){
             boolean isAddedOrderDetails=OrderDetailController.addOrderDetail(order.getOrderDetailLost());
             if(isAddedOrderDetails){
                 boolean updateItems=ItemController.updateStock(order.getOrderDetailLost());
                 if(updateItems){
                     return true;
                 }
             }
         }
         return true;
     }

    static boolean addOrderDetail(OrderDetail orderDetail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
