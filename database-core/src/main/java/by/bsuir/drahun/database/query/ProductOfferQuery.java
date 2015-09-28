package by.bsuir.drahun.database.query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProductOfferQuery {
	
	public static final String PRODUCT_TITLE = "Product title";
	public static final String COST = "Cost";
	public static final String QUANTITY = "Quantity";
	public static final String PRODUCT_CODE = "Product code";
	
	public static final String[] FIELDS = {PRODUCT_TITLE, PRODUCT_CODE, COST, QUANTITY};
	
	private Map<String, SortOrder> orders = new LinkedHashMap<String, SortOrder>();
	
	private List<SingleCondition> conditions = new ArrayList<SingleCondition>();
	
	public void addCondition(SingleCondition condition) {
		conditions.add(condition);
	}
	
	public void addOrder(String field, SortOrder order) {
		orders.put(field, order);
	}
	
	public Map<String, SortOrder> getOrders() {
		return Collections.unmodifiableMap(orders);
	}
	
	public List<SingleCondition> getConditions() {
		return Collections.unmodifiableList(conditions);
	}

	public void removeLastCondition() {
		if (!conditions.isEmpty()) {
			conditions.remove(conditions.size() - 1);
		}
	}
	
	public boolean hasConditions() {
		return !conditions.isEmpty();
	}

}
