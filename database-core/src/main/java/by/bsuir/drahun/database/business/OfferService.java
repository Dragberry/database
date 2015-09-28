package by.bsuir.drahun.database.business;

import java.util.List;

import by.bsuir.drahun.database.domain.Product;
import by.bsuir.drahun.database.domain.ProductOffer;
import by.bsuir.drahun.database.model.ProductBean;
import by.bsuir.drahun.database.query.ProductOfferQuery;

public interface OfferService {
	
	Product saveProduct(Product product);
	
	ProductOffer saveOffer(ProductOffer offer);
	
	List<ProductBean> fetchOffers(ProductOfferQuery query);
	
	List<ProductBean> fetchOffers(String query);

}
