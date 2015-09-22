package by.bsuir.drahun.database.business;

import java.util.List;

import by.bsuir.drahun.database.domain.Product;
import by.bsuir.drahun.database.domain.ProductOffer;
import by.bsuir.drahun.database.query.ProductOfferQuery;

public interface OfferService {
	
	Product saveProduct(Product product);
	
	ProductOffer saveOffer(ProductOffer offer);
	
	List<ProductOffer> fetchOffers(ProductOfferQuery query);
	
	List<ProductOffer> fetchOffers(String query);

}
