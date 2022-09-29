package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;

import context.DBContext;
import model.Cart;
import model.Orders;
import model.Product;

public class OrdersDAO {
	Connection conn = null;
	PreparedStatement ps, ps2 = null;
	ResultSet rs = null;

	/* 
	 * insert information of Order to data source, that including list of 
	 * products in cart (c) and information of buyer in Orders (o)
	 */
	public void insertOrder(Orders d, Cart c) throws SQLException {
		conn = new DBContext().getJDBCConnection();
		String sql = "insert into Orders (user_mail, order_status, order_date, order_discount_code, order_address)\r\n"
				+ "values (?, ?, ?, ?, ?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, d.getUserMail());
		ps.setInt(2, d.getOrderStatus());
		ps.setString(3, d.getOrderDate());
		ps.setString(4, d.getOrderDiscountCode());
		ps.setString(5, d.getOrderAddress());
		
		ps.executeUpdate();
		
		for (Product x : c.getItems()) {
			String sql2 = "insert into Orders_detail (order_id ,product_id, amount_product, price_product)\r\n"
					+ "values (?, ?, ?, ?);";
			ps2 = conn.prepareStatement(sql2);
			ps2.setInt(1, getOrderId()); // get from method getOrderId
			ps2.setInt(2, x.getId());
			ps2.setInt(3, x.getNumber());
			ps2.setFloat(4, x.getPrice());
			
			ps2.executeUpdate();
		}
	}
	
	// get orderId 
	public int getOrderId() throws SQLException {
		conn = new DBContext().getJDBCConnection();
		String sql = "select order_id from Orders order by order_id desc";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			return rs.getInt(1);
		}
		return 0;
	}
}
