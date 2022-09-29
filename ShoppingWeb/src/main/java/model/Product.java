package model;

/**
 * 
 * information of product
 *
 */
public class Product {
	private int id;
	private String name;
	private String description;
	private float price;
	private String src; // location of image of product
	private String type; // type of product
	private String brand; // product's category
	private int number;
	
	// constructor
	public Product() {}
	
	public Product(int id, String name, String description, float price, String src, String type, String brand,
			int number) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.src = src;
		this.type = type;
		this.brand = brand;
		this.number = number;
	}

	
	public Product(int id, String name, String description, float price, String src, String type, String brand) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.src = src;
		this.type = type;
		this.brand = brand;
	}

	
	
	

	public Product(String src, String name, int id, int number, float price) {
		super();
		this.src = src;
		this.name = name;
		this.id = id;
		this.number = number;
		this.price = price;	
	}

	// setter and getter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", src="
				+ src + ", type=" + type + ", brand=" + brand + ", number=" + number + "]";
	}
	
	
	
}
