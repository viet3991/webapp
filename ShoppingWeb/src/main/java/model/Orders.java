package model;

import java.util.List;

/**
 * 
 * information of order, contain: list of product of order, information of customer
 *
 */
public class Orders {
	private String userMail;
	private int orderId;
	private int orderStatus;
	private String orderDate;
	private String orderDiscountCode;
	private String orderAddress;
	private List<ProductOrders> lp;
	
	public List<ProductOrders> getLp() {
		return lp;
	}

	public void setLp(List<ProductOrders> lp) {
		this.lp = lp;
	}

	// constructor
	public Orders() {}
	
	public Orders(String userMail, int orderStatus, String orderDate, String orderDiscountCode,
			String orderAddress) {
		super();
		this.userMail = userMail;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.orderDiscountCode = orderDiscountCode;
		this.orderAddress = orderAddress;
	}

	// getter and setter
	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderDiscountCode() {
		return orderDiscountCode;
	}

	public void setOrderDiscountCode(String orderDiscountCode) {
		this.orderDiscountCode = orderDiscountCode;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}
	
	
	
}
