package by.bsuir.drahun.database.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Product.class)
public class Product_ {
	
	public static volatile SingularAttribute<Product, String> productCode;
	public static volatile SingularAttribute<Product, String> productTitle;

}
