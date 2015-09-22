package by.bsuir.drahun.database.domain;

import java.math.BigDecimal;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ProductOffer.class)
public class ProductOffer_ {
	
	public static volatile SingularAttribute<ProductOffer, Long> offerNumber;
	public static volatile SingularAttribute<ProductOffer, BigDecimal> cost;
	public static volatile SingularAttribute<ProductOffer, Integer> quantity;
	public static volatile SingularAttribute<ProductOffer, Product> product;

}
