package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import account.Account;
import context.DBContext;
import model.Cart;
import model.Product;


public class LoginDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public Account login(String user, String pass) throws SQLException {
		conn = new DBContext().getJDBCConnection();
		String sql = "select * \r\n"
				+ "from Account\r\n"
				+ "where user_mail = ? and [password] = ?;";
		ps = conn.prepareStatement(sql);
		ps.setString(1, user);
		ps.setString(2, pass);
		rs = ps.executeQuery();
		
		if (rs.next()) {
			return new Account(rs.getString(1), 
					rs.getString(2), 
					rs.getInt(3), 
					rs.getString(4), 
					rs.getString(5), 
					rs.getString(6), 
					0);
		}		
		return null;
	}
	
	public Account checkAcc(String user) throws SQLException {
		conn = new DBContext().getJDBCConnection();
		String sql = "select * \r\n"
				+ "from Account\r\n"
				+ "where user_mail = ?;";
		ps = conn.prepareStatement(sql);
		ps.setString(1, user);
		rs = ps.executeQuery();
		
		if (rs.next()) {
			return new Account(rs.getString(1), 
					rs.getString(2), 
					rs.getInt(3), 
					rs.getString(4), 
					rs.getString(5), 
					rs.getString(6), 
					0);
		}		
		return null;
	}
	
	public void create(String user, String pass, int role, String name, String addr, String phone) throws SQLException {
		conn = new DBContext().getJDBCConnection();
		String sql = "insert into Account\r\n"
				+ "values (?, ?, ?, ?, ?, ?);";
		ps = conn.prepareStatement(sql);
		ps.setString(1, user);
		ps.setString(2, pass);
		ps.setInt(3, role);
		ps.setString(4, name);
		ps.setString(5, addr);
		ps.setString(6, phone);
		
		ps.executeUpdate();
		
	}
	
	public Cart getOrderDetail(String email) throws SQLException {
		conn = new DBContext().getJDBCConnection();
		String sql = "select product_img_source, product_name, b.product_id, amount_product, product_price \r\n"
				+ "from Orders_detail a\r\n"
				+ "join Products b\r\n"
				+ "on a.product_id = b.product_id\r\n"
				+ "where order_id = \r\n"
				+ "	(\r\n"
				+ "	select top 1 order_id \r\n"
				+ "	from Orders\r\n"
				+ "	where user_mail = ?\r\n"
				+ "	order by order_id desc\r\n"
				+ "	)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		rs = ps.executeQuery();
		Cart c = new Cart();
		while (rs.next()) {
			 c.add(new Product(
					rs.getString(1),
					rs.getString(2),
					rs.getInt(3),
					rs.getInt(4),
					rs.getFloat(5)));
		}
		return c;
	}
}
