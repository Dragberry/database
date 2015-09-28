package by.bsuir.drahun.database.json;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AddConditionResult {
	
	@XmlElement
	private String resultQuery;
	
	@XmlElement
	private Boolean isQueryEmpty;

	public String getResultQuery() {
		return resultQuery;
	}

	public void setResultQuery(String resultQuery) {
		this.resultQuery = resultQuery;
	}

	public Boolean getIsQueryEmpty() {
		return isQueryEmpty;
	}

	public void setIsQueryEmpty(Boolean isQueryEmpty) {
		this.isQueryEmpty = isQueryEmpty;
	}
	
}
