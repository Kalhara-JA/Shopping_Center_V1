/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.thogakade.db.DBConnection;
import lk.ijse.thogakade.model.OrderDetail;

public class OrderDetailController {

    public static boolean addOrderDetail(ArrayList<OrderDetail> orderDetailLost) {
            for (OrderDetail orderDetail : orderDetailLost) {
                boolean addOrderDetail = OrderController.addOrderDetail(orderDetail);
                if(!addOrderDetail){
                    return false;
                }
                    
            }
        return true;
 
    }
    public static boolean addOrderDetail(OrderDetail orderDetail) throws ClassNotFoundException, SQLException {
        PreparedStatement stm=DBConnection.getInstance().getConnection().prepareStatement("Insert into OrderDetail values(?,?,?,?)");
        stm.setObject(1, orderDetail.getOrderId());
        stm.setObject(2, orderDetail.getItemCode());
        stm.setObject(3, orderDetail.getQty());
        stm.setObject(4, orderDetail.getUnitPrice());
        
        return stm.executeUpdate()>0;
    }
        
}
