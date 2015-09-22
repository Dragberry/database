package by.bsuir.drahun.database.application;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.bsuir.drahun.database.dao.ProductDao;
import by.bsuir.drahun.database.dao.ProductOfferDao;
import by.bsuir.drahun.database.domain.Product;
import by.bsuir.drahun.database.domain.ProductOffer;

public class Launcher {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductDao productDao = (ProductDao) context.getBean(ProductDao.class);
		
		ProductOfferDao productOfferDao =  (ProductOfferDao) context.getBean(ProductOfferDao.class);
		
		ProductOffer offer = new ProductOffer();
		offer.setCost(new BigDecimal("1000.00"));
		offer.setQuantity(15);
		
		Product p = new Product();
		p.setProductCode("aa5");
		p.setProductTitle("Test1");
		
		offer.setProduct(p);
		
		productOfferDao.save(offer);
		
		context.close();
	}

}
