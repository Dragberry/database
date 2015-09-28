package by.bsuir.drahun.database.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.bsuir.drahun.database.dao.ProductDao;
import by.bsuir.drahun.database.dao.ProductOfferDao;
import by.bsuir.drahun.database.domain.Product;
import by.bsuir.drahun.database.domain.ProductOffer;
import by.bsuir.drahun.database.model.ProductBean;
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

	public List<ProductBean> fetchOffers(ProductOfferQuery query) {
		return convertResult(productOfferDao.fetchProductOffers(query));
	}

	public List<ProductBean> fetchOffers(String query) {
		return convertResult(productOfferDao.fetchProductOffers(query));
	}
	
	private List<ProductBean> convertResult(List<ProductOffer> offers) {
		List<ProductBean> resultList = new ArrayList<>();
		for (ProductOffer offer : offers) {
			ProductBean bean = new ProductBean();
			bean.setProductCode(offer.getProduct().getProductCode());
			bean.setProductTitle(offer.getProduct().getProductTitle());
			bean.setCost(offer.getCost());
			bean.setQuantity(offer.getQuantity());
			resultList.add(bean);
		}
		return resultList;
	}

}
