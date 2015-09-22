package by.bsuir.drahun.database.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductBean implements Serializable {

	private static final long serialVersionUID = 3024017105933488570L;
	
	private String productCode;
	
	private String productTitle;
	
	private BigDecimal cost;
	
	private Integer quantity;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
