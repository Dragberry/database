package by.bsuir.drahun.database.dao;

import java.util.List;

import by.bsuir.drahun.database.domain.Product;

public interface ProductDao {
	
	Product save(Product product);
	
	List<Product> fetchProducts();

}
