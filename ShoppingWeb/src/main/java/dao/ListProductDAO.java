package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import context.DBContext;
import model.Product;

public class ListProductDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	// count all products
	public int countAll() throws SQLException {
		conn = new DBContext().getJDBCConnection();
		String sql = "select count(*)\r\n"
				+ "from Products";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			return rs.getInt(1);
		}
		return 0;
	}
		
	// get the list of products with paging
	public List<Product> getAll(int index) throws SQLException {
		List<Product> lp = new ArrayList<Product>();
		conn = new DBContext().getJDBCConnection();
		String sql = "select *\r\n"
				+ "from Products\r\n"
				+ "where product_id between ?*6-5 and ?*6;";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, index);
		ps.setInt(2, index);
		rs = ps.executeQuery();
		while (rs.next()) {
			lp.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), 
					rs.getString(5), rs.getString(6), rs.getString(7)));
		}
		return lp;
	}
	

	
	// count product by product_name
	public int countSearch(String characters) throws SQLException {
		conn = new DBContext().getJDBCConnection();
		String sql = "select count(*) from Products where product_name like ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, "%" + characters + "%");
		rs = ps.executeQuery();
		while (rs.next()) {
			return rs.getInt(1);
		}
		return 0;
	}
	
	
	// get the list of products by product name with paging
	public List<Product> getSearch(String characters, int index) throws SQLException {
		
		List<Product> lp = new ArrayList<Product>();
		conn = new DBContext().getJDBCConnection();
		String sql = "select * \r\n"
				+ "from Products \r\n"
				+ "where product_name like ? and\r\n"
				+ "	product_id between ?*6-5 and ?*6;";
		ps = conn.prepareStatement(sql);
		ps.setString(1, "%" + characters + "%");
		ps.setInt(2, index);
		ps.setInt(3, index);
		rs = ps.executeQuery();
		while (rs.next()) {
			lp.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), 
					rs.getString(5), rs.getString(6), rs.getString(7)));
		}
		return lp;
	
	}
	
	// return the product
	public Product getProduct(String characters) throws SQLException {
		if (characters.equals("") || characters == null) {
			return null;
		} else {
			Product p = new Product();
			conn = new DBContext().getJDBCConnection();
			String sql = "select * from Products where product_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(characters));
			rs = ps.executeQuery();
			while (rs.next()) {
				p = new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getFloat(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7));
			}
			return p;
		}
	}
	
	// get the list of products for admin
	public List<Product> getAll() throws SQLException {
		List<Product> lp = new ArrayList<Product>();
		conn = new DBContext().getJDBCConnection();
		String sql = "select *\r\n"
				+ "from Products\r\n;";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			lp.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), 
					rs.getString(5), rs.getString(6), rs.getString(7)));
		}
		return lp;
	}

	// get the list of products by product name for admin
	public List<Product> getSearch(String characters) throws SQLException {
		
		List<Product> lp = new ArrayList<Product>();
		conn = new DBContext().getJDBCConnection();
		String sql = "select * \r\n"
				+ "from Products \r\n"
				+ "where product_name like ? ;";
		ps = conn.prepareStatement(sql);
		ps.setString(1, "%" + characters + "%");
		rs = ps.executeQuery();
		while (rs.next()) {
			lp.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), 
					rs.getString(5), rs.getString(6), rs.getString(7)));
		}
		return lp;
	
	}
}
