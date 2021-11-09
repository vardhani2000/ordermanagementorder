package com.orderManagement.DTO;



import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


public class ProductDTO {
	
	@Column(name="product_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    String productId;
    
	@Column(name = "product_name")
	String productName;
	
	@Column(name="price")
    float price;
    
	@Column(name="description")
    String description;
	
	@Column(name="category")
	String category;
	
	@Column(name="image")
	String image;
	
	@Column(name="product_rating")
	float productRating;
	
	@Column(name="stock")
	Integer stock;
	
	@Column(name="seller_id")
	String seller_id;
	
	@Column(name="subcategory")
	String subcategory;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public float getProductRating() {
		return productRating;
	}

	public void setProductRating(float productRating) {
		this.productRating = productRating;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public ProductDTO(String productId, String productName, float price, String description, String category,
			String image, float productRating, Integer stock, String seller_id, String subcategory) {
		//super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.category = category;
		this.image = image;
		this.productRating = productRating;
		this.stock = stock;
		this.seller_id = seller_id;
		this.subcategory = subcategory;
	}
	
	public ProductDTO() {}


	

}
