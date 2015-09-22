package by.bsuir.drahun.database.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.bsuir.drahun.database.domain.Product;

@Repository
public class ProductDaoImpl extends AbstractDao<Product> implements ProductDao {
	
	@Transactional
	public List<Product> fetchProducts() {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Product> queryProduct = cb.createQuery(Product.class);
		Root<Product> rootProduct = queryProduct.from(Product.class);
		queryProduct.select(rootProduct);
		TypedQuery<Product> tq = getEntityManager().createQuery(queryProduct);
		tq.getResultList();
        return tq.getResultList();
	}

}
