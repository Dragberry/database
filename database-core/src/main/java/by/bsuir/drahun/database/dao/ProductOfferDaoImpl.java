package by.bsuir.drahun.database.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.bsuir.drahun.database.domain.Product;
import by.bsuir.drahun.database.domain.ProductOffer;
import by.bsuir.drahun.database.domain.ProductOffer_;
import by.bsuir.drahun.database.domain.Product_;
import by.bsuir.drahun.database.query.Condition;
import by.bsuir.drahun.database.query.ProductOfferQuery;
import by.bsuir.drahun.database.query.SingleCondition;

@Repository
public class ProductOfferDaoImpl extends AbstractDao<ProductOffer> implements ProductOfferDao {
 
	private static final String COST_REGEXP = "\\d*\\.?\\d*";

	@Transactional
	public List<ProductOffer> fetchProductOffers(ProductOfferQuery query) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<ProductOffer> queryProduct = cb.createQuery(ProductOffer.class);
		Root<ProductOffer> rootProduct = queryProduct.from(ProductOffer.class);
		Join<ProductOffer, Product> joinOfferProduct = rootProduct.join(ProductOffer_.product, JoinType.INNER);
		
		Predicate where = null;
		
		for (SingleCondition condition : query.getConditions()) {
			Predicate pr = null;
			switch(condition.getField()) {
				case ProductOfferQuery.PRODUCT_CODE:
					pr = chooseCondition(cb, joinOfferProduct, Product_.productCode, condition.getCondition(), condition.getValue(), pr);
					break;
				case ProductOfferQuery.PRODUCT_TITLE:
					pr = chooseCondition(cb, joinOfferProduct, Product_.productTitle, condition.getCondition(), condition.getValue(), pr);
					break;	
				case ProductOfferQuery.QUANTITY:
					if (!StringUtils.isNumeric(condition.getValue())) {
						break;
					}
					Integer intValue = Integer.valueOf(condition.getValue());
					pr = chooseCondition(cb, rootProduct, ProductOffer_.quantity, condition.getCondition(), intValue, pr);
					break;
				case ProductOfferQuery.COST:
					Pattern p = Pattern.compile(COST_REGEXP);
					Matcher m = p.matcher(condition.getValue());
					if (!m.matches()) {
						break;
					}
					BigDecimal bdValue = new BigDecimal(condition.getValue());
					pr = chooseCondition(cb, rootProduct, ProductOffer_.cost, condition.getCondition(), bdValue, pr);
					break;
			}
			
			if (condition.getOperator() == null) {
				where = pr;
			} else {
				switch (condition.getOperator()) {
				case AND:
					where = cb.and(where, pr);
					break;
				case OR:
					where = cb.or(where, pr);
					break;
				}
			}
		}
		
		if (where != null) {
			queryProduct.where(where);
		}
		
		queryProduct.select(rootProduct);
		TypedQuery<ProductOffer> tq = getEntityManager().createQuery(queryProduct);
        return tq.getResultList();
	}

	@SuppressWarnings("unchecked")
	protected <T, X, V extends Comparable<V>> Predicate chooseCondition(CriteriaBuilder cb, From<T, X> from, SingularAttribute<X, V> attribute,
			Condition condition, V value, Predicate pr) {
		switch(condition) {
			case EQUALS:
				pr = cb.equal(from.get(attribute), value);
				break;
			case GREATER:
				pr = cb.greaterThan(from.get(attribute), value);
				break;
			case GREATER_OR_EQUALS:
				pr = cb.greaterThanOrEqualTo(from.get(attribute), value);
				break;
			case LESS:
				pr = cb.lessThan(from.get(attribute), value);
				break;
			case LESS_OR_EQUALS:
				pr = cb.lessThanOrEqualTo(from.get(attribute), value);
				break;
			case LIKE:
				if (value instanceof String) {
					pr = cb.like(from.get((SingularAttribute<X, String>)attribute), wrap((String)value));
				}
				break;
			case NOT_EQUALS:
				pr = cb.notEqual(from.get(attribute), value);
				break;
			case STARTS_WITH:
				if (value instanceof String) {
					pr = cb.like(from.get((SingularAttribute<X, String>)attribute), wrapEnd((String)value));
				}
				break;
			}
		return pr;
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
