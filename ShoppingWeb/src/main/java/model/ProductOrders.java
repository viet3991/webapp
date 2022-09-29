package model;

/**
 * 
 * information of a product of order
 *
 */
public class ProductOrders {
	
	private int orderId;
	private int productId;
	private int amountProduct;
	private float priceProduct;
	
	
	// constructor
	public ProductOrders() {}
	
	public ProductOrders(int orderId, int productId, int amountProduct, float priceProduct) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.amountProduct = amountProduct;
		this.priceProduct = priceProduct;
	}


	
	
	// setter and getter
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getAmountProduct() {
		return amountProduct;
	}
	public void setAmountProduct(int amountProduct) {
		this.amountProduct = amountProduct;
	}

	public float getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(float priceProduct) {
		this.priceProduct = priceProduct;
	}
	
}
