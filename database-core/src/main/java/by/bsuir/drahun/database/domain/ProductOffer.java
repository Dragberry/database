package by.bsuir.drahun.database.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_OFFER")
public class ProductOffer implements Serializable {

	private static final long serialVersionUID = 5482664253435548613L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OFFER_NUMBER")
	private long offerNumber;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "PRODUCT_CODE", referencedColumnName = "PRODUCT_CODE")
	private Product product;
	@Column(name = "QUANTITY")
	private int quantity;
	@Column(name = "COST")
	private BigDecimal cost;
	
	public long getOfferNumber() {
		return offerNumber;
	}
	public void setOfferNumber(long offerNumber) {
		this.offerNumber = offerNumber;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	
}
