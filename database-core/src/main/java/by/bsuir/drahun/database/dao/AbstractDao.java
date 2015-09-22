package by.bsuir.drahun.database.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.metamodel.SingularAttribute;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractDao<E extends Serializable> {

	private static final String PERCENT_QUOTE = "%";
	@PersistenceContext
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@Transactional
	public E save(E entity) {
		getEntityManager().persist(entity);
		return entity;
	}

	/**
	 * Add like expression with 'AND' logical operator to WHERE clause.
	 * 
	 * @param field
	 * @param attribute
	 * @param where
	 * @param cb
	 * @param root
	 * @return
	 */
	protected <Z, T> Predicate addAndLikeExpression(String field, SingularAttribute<T, String> attribute,
			Predicate where, CriteriaBuilder cb, From<Z, T> root) {
		if (StringUtils.isNotBlank(field)) {
			if (where != null) {
				where = cb.and(where, cb.like(root.get(attribute), wrap(field)));
			} else {
				where = cb.like(root.get(attribute), wrap(field));
			}
		}
		return where;
	}

	/**
	 * Add equals expression with 'AND' logical operator to WHERE clause.
	 * 
	 * @param field
	 * @param attribute
	 * @param where
	 * @param cb
	 * @param root
	 * @return
	 */
	protected <Z, T, F> Predicate addAndEqualsExpression(F field, SingularAttribute<T, F> attribute, Predicate where,
			CriteriaBuilder cb, From<Z, T> root) {
		if (field != null) {
			if (where != null) {
				where = cb.and(where, cb.equal(root.get(attribute), field));
			} else {
				where = cb.equal(root.get(attribute), field);
			}
		}
		return where;
	}

	/**
	 * Wrap string in percent quotes: %string%
	 * 
	 * @param str
	 * @return
	 */
	protected String wrap(String str) {
		return new StringBuilder(PERCENT_QUOTE).append(str).append(PERCENT_QUOTE).toString();
	}

	/**
	 * Null-safe add WHERE clause to query.
	 * 
	 * @param cq
	 * @param where
	 */
	protected <T> void addWhereClause(CriteriaQuery<T> cq, Predicate where) {
		if (where != null) {
			cq.where(where);
		}
	}

	/**
	 * Add predicate2 to predicate1 with 'AND' operator. Null-safe operation.
	 * 
	 * @param predicate1
	 * @param predicate2
	 * @param cb
	 * @return
	 */
	protected <T> Predicate andExpression(Predicate predicate1, Predicate predicate2, CriteriaBuilder cb) {
		if (predicate1 != null) {
			predicate1 = cb.and(predicate1, predicate2);
		} else {
			predicate1 = predicate2;
		}
		return predicate1;
	}

	/**
	 * Add range expression with 'AND' logical operator to WHERE clause. Using
	 * with BigDecimal values.
	 * 
	 * @param min
	 * @param max
	 * @param attribute
	 * @param where
	 * @param cb
	 * @param root
	 * @return
	 */
	public static <T> Predicate addRangeExpression(BigDecimal min, BigDecimal max,
			SingularAttribute<T, BigDecimal> attribute, Predicate where, CriteriaBuilder cb, Root<T> root) {
		if (min != null) {
			if (where != null) {
				where = cb.and(where, cb.ge(root.get(attribute), min));
			} else {
				where = cb.ge(root.get(attribute), min);
			}
		}
		if (max != null) {
			if (where != null) {
				where = cb.and(where, cb.le(root.get(attribute), max));
			} else {
				where = cb.le(root.get(attribute), max);
			}
		}
		return where;
	}

	/**
	 * Add range expression with 'AND' logical operator to WHERE clause. Using
	 * with Date values.
	 * 
	 * @param min
	 * @param max
	 * @param attribute
	 * @param where
	 * @param cb
	 * @param root
	 * @return
	 */
	public static <T> Predicate addRangeExpression(Date min, Date max, SingularAttribute<T, Date> attribute,
			Predicate where, CriteriaBuilder cb, Root<T> root) {
		if (min != null) {
			if (where != null) {
				where = cb.and(where, cb.greaterThanOrEqualTo(root.get(attribute), min));
			} else {
				where = cb.greaterThanOrEqualTo(root.get(attribute), min);
			}
		}
		if (max != null) {
			if (where != null) {
				where = cb.and(where, cb.lessThanOrEqualTo(root.get(attribute), max));
			} else {
				where = cb.lessThanOrEqualTo(root.get(attribute), max);
			}
		}
		return where;
	}

	/**
	 * Add predicate2 to predicate1 with 'AND' operator. Null-safe operation.
	 * 
	 * @param predicate1
	 * @param predicate2
	 * @param cb
	 * @return
	 */
	public static <T> Predicate addAndLikeExpression(Predicate predicate1, Predicate predicate2, CriteriaBuilder cb) {
		if (predicate1 != null) {
			predicate1 = cb.and(predicate1, predicate2);
		} else {
			predicate1 = predicate2;
		}
		return predicate1;
	}

	/**
	 * Add 'IN' expression with 'AND' operator. Null-safe operation
	 * 
	 * @param root
	 * @param cb
	 * @param collection
	 * @param attribute
	 * @param where
	 * @return
	 */
	protected <T, A> Predicate addAndInExpression(Root<T> root, CriteriaBuilder cb, Collection<A> collection,
			SingularAttribute<T, A> attribute, Predicate where) {
		if (CollectionUtils.isNotEmpty(collection)) {
			In<A> objectList = cb.in(root.get(attribute));
			for (A object : collection) {
				objectList.value(object);
			}
			where = addAndLikeExpression(where, objectList, cb);
		}
		return where;
	}

}
