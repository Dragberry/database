package by.bsuir.drahun.database.dao;

import java.util.List;

import by.bsuir.drahun.database.domain.ProductOffer;
import by.bsuir.drahun.database.query.ProductOfferQuery;

public interface ProductOfferDao {
	
	ProductOffer save(ProductOffer productOffer);
	
	List<ProductOffer> fetchProductOffers(ProductOfferQuery query);
	
	List<ProductOffer> fetchProductOffers(String query);
	
	ProductOffer findById(Long id);

}
