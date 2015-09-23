package by.bsuir.drahun.database.query;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProductOfferQuery {
	
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

}
