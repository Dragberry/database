package by.bsuir.drahun.database.query;

import java.io.Serializable;

public class SingleCondition implements Serializable{
	
	private static final long serialVersionUID = -5462690883769505315L;

	private Operator operator;
	
	private String field;
	
	private Condition condition;
	
	private String value;

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return (operator == null ? "" : operator.toString()) + " " + field + " " + condition.getValue() + " " + value + " "; 
	}
	
}
