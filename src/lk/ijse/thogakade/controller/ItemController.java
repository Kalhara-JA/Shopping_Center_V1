/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.controller;

/*import com.mysql.cj.x.protobuf.MysqlxCrud.Update;*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.thogakade.db.DBConnection;
import lk.ijse.thogakade.model.Item;
import lk.ijse.thogakade.model.OrderDetail;

public class ItemController {
    public static boolean addItem(Item item) throws ClassNotFoundException, SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item VALUES (?,?,?,?)");

        pstm.setObject(1, item.getCode());
        pstm.setObject(2, item.getDescription());
        pstm.setObject(3, item.getUnitPrice());
        pstm.setObject(4, item.getQtyOnHand());

        int affectedRows = pstm.executeUpdate();

        return affectedRows > 0;

    }
    public static ArrayList<Item> loadAllItems() throws ClassNotFoundException, SQLException {

        ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("SELECT * FROM Item");

        ArrayList<Item> allItems = new ArrayList<>();

        while (rst.next()) {

            Item item = new Item();
            item.setCode(rst.getString(1));
            item.setDescription(rst.getString(2));
            item.setUnitPrice(rst.getDouble(3));
            item.setQtyOnHand(rst.getInt(4));

            allItems.add(item);
        }

        return allItems;

    }
    public static Item searchItem(String itemCode) throws ClassNotFoundException, SQLException {

        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Item WHERE code='" + itemCode + "'");

        if (rst.next()) {
            Item item = new Item();
            item.setCode(rst.getString(1));
            item.setDescription(rst.getString(2));
            item.setUnitPrice(rst.getDouble(3));
            item.setQtyOnHand(rst.getInt(4));

            return item;
        } else {
            return null;
        }

    }

    public static boolean updateStock(ArrayList<OrderDetail> orderDetailLost) throws ClassNotFoundException, ClassNotFoundException, ClassNotFoundException, ClassNotFoundException, SQLException, ClassNotFoundException {
        for (OrderDetail orderDetail : orderDetailLost) {
            if(!updateStock(orderDetail)){
                return false;
            }
        }
        return true;
    }
    
    public static boolean updateStock(OrderDetail orderDetail) throws SQLException, ClassNotFoundException {
        PreparedStatement stm=DBConnection.getInstance().getConnection().prepareStatement("Update item set qtyOnHand=qtyOnHand-? where code=?");
        
        stm.setObject(1, orderDetail.getQty());
        stm.setObject(2, orderDetail.getItemCode());
        return stm.executeUpdate()>0;
        
    }

}
