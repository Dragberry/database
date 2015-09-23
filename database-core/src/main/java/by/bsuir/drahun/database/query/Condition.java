package by.bsuir.drahun.database.query;

public enum Condition {
	
	EQUALS("="), NOT_EQUALS("!="), GREATER(">"), GREATER_OR_EQUALS(">="), LESS("<"), LESS_OR_EQUALS("<="), LIKE("LIKE"), STARTS_WITH("STARTS WITH");

	private String value;
	
	private Condition(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
