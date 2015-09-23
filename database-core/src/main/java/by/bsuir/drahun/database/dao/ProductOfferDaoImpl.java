package by.bsuir.drahun.database.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.bsuir.drahun.database.domain.Product;
import by.bsuir.drahun.database.domain.ProductOffer;
import by.bsuir.drahun.database.domain.ProductOffer_;
import by.bsuir.drahun.database.domain.Product_;
import by.bsuir.drahun.database.query.ProductOfferQuery;
import by.bsuir.drahun.database.query.SingleCondition;

@Repository
public class ProductOfferDaoImpl extends AbstractDao<ProductOffer> implements ProductOfferDao {

 
	@Transactional
	public List<ProductOffer> fetchProductOffers(ProductOfferQuery query) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<ProductOffer> queryProduct = cb.createQuery(ProductOffer.class);
		Root<ProductOffer> rootProduct = queryProduct.from(ProductOffer.class);
		Join<ProductOffer, Product> joinOfferProduct = rootProduct.join(ProductOffer_.product, JoinType.INNER);
		
		for (SingleCondition condition : query.getConditions()) {
			
		}
		
		queryProduct.select(rootProduct);
		TypedQuery<ProductOffer> tq = getEntityManager().createQuery(queryProduct);
        return tq.getResultList();
	}
	
	@Transactional
	public List<ProductOffer> fetchProductOffers(String query) {
		
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<ProductOffer> queryProduct = cb.createQuery(ProductOffer.class);
		Root<ProductOffer> rootProduct = queryProduct.from(ProductOffer.class);
		Join<ProductOffer, Product> joinOfferProduct = rootProduct.join(ProductOffer_.product, JoinType.INNER);
		
		String[] words = null;
		if (query != null) {
			words = query.trim().split(" ");
			
			Predicate where = null;
			
			for (String word : words) {
				if (where == null) {
					where = cb.like(joinOfferProduct.get(Product_.productCode), wrap(word));
					
				} else {
					where = cb.or(where, cb.like(joinOfferProduct.get(Product_.productCode), wrap(word)));
				}
				where = cb.or(where, cb.like(joinOfferProduct.get(Product_.productTitle), wrap(word)));
				if (StringUtils.isNumeric(word)) {
					where = cb.or(where, cb.equal(rootProduct.get(ProductOffer_.cost), new BigDecimal(word)));
					where = cb.or(where, cb.equal(rootProduct.get(ProductOffer_.quantity), word));
				}
			}
			queryProduct.where(where);
		}
		
		queryProduct.select(rootProduct);
		TypedQuery<ProductOffer> tq = getEntityManager().createQuery(queryProduct);
        return tq.getResultList();
	}
	
	@Transactional
	public ProductOffer findById(Long id) {
		ProductOffer offer = getEntityManager().find(ProductOffer.class, id);
		return offer;
	}

}
