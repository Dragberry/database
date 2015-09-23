package by.bsuir.drahun.database.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.bsuir.drahun.database.dao.ProductDao;
import by.bsuir.drahun.database.dao.ProductOfferDao;
import by.bsuir.drahun.database.domain.Product;
import by.bsuir.drahun.database.domain.ProductOffer;
import by.bsuir.drahun.database.query.ProductOfferQuery;

@Service
public class OfferServiceBean implements OfferService {
	
	@Autowired
	private ProductOfferDao productOfferDao;
	@Autowired
	private ProductDao productDao;

	public Product saveProduct(Product product) {
		return productDao.save(product);
	}

	public ProductOffer saveOffer(ProductOffer offer) {
		return productOfferDao.save(offer);
	}

	public List<ProductOffer> fetchOffers(ProductOfferQuery query) {
		return productOfferDao.fetchProductOffers(query);
	}

	public List<ProductOffer> fetchOffers(String query) {
		return productOfferDao.fetchProductOffers(query);
	}

}
