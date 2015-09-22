package by.bsuir.drahun.database.query;

import java.io.Serializable;

import javax.persistence.metamodel.SingularAttribute;

public class SingleCondition<X, T> implements Serializable{
	
	private static final long serialVersionUID = -5462690883769505315L;

	private Operator operator;
	
	private SingularAttribute<X, T> field;
	
	private Condition condition;
	
	private T value;

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public SingularAttribute<X, T> getField() {
		return field;
	}

	public void setField(SingularAttribute<X, T> field) {
		this.field = field;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
}
