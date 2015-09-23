package by.bsuir.drahun.database.client;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import by.bsuir.drahun.database.query.Condition;
import by.bsuir.drahun.database.query.Operator;
import by.bsuir.drahun.database.query.ProductOfferQuery;
import by.bsuir.drahun.database.query.SingleCondition;

public class SearchPanel extends JPanel {

	private static final long serialVersionUID = -5644408596769182938L;
	
	private JLabel titleLabel;
	
	private JTextField commonSearchField;
	
	private JButton commonSearchBtn;
	
	private JLabel conditionLabel;
	
	private JComboBox<Operator> operatorCbx;
	
	private JComboBox<String> fieldCbx;
	
	private JComboBox<Condition> conditionCbx;
	
	private JTextField queryField;
	
	private JTextField resultQueryField;
	
	private JButton addConditionBtn;
	
	private JButton searchBtn;
	
	private ProductOfferQuery offerQuery = new ProductOfferQuery();
	
	private String[] fields = {"Product title", "Product code", "Cost", "Quantity"};
	
	public SearchPanel() {
		super();
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbcLabel = new GridBagConstraints();
		gbcLabel.gridx = 0;
		gbcLabel.gridy = 0;
		gbcLabel.weightx = 0.2;
		gbcLabel.fill = GridBagConstraints.HORIZONTAL;
		gbcLabel.insets = new Insets(5, 5, 5, 5);
		
		add(getTitleLabel(), gbcLabel);
		
		GridBagConstraints gbcSearchField = new GridBagConstraints();
		gbcSearchField.gridx = 0;
		gbcSearchField.gridy = 1;
		gbcSearchField.weightx = 0.2;
		gbcSearchField.fill = GridBagConstraints.BOTH;
		gbcSearchField.insets = new Insets(5, 5, 5, 5);
		gbcSearchField.gridwidth = 2;
		
		add(getCommonSearchField(), gbcSearchField);
		
		GridBagConstraints gbcSearchBtn = new GridBagConstraints();
		gbcSearchBtn.gridx = 0;
		gbcSearchBtn.gridy = 2;
		gbcSearchBtn.weightx = 0.2;
		gbcSearchBtn.fill = GridBagConstraints.BOTH;
		gbcSearchBtn.insets = new Insets(5, 5, 5, 5);
		
		add(getCommonSearchBtn(), gbcSearchBtn);
		
		GridBagConstraints gvcCondLabel = new GridBagConstraints();
		gvcCondLabel.gridx = 0;
		gvcCondLabel.gridy = 3;
		gvcCondLabel.weightx = 0.2;
		gvcCondLabel.fill = GridBagConstraints.HORIZONTAL;
		gvcCondLabel.insets = new Insets(5, 5, 5, 5);
		
		add(getConditionLabel(), gvcCondLabel);
		
		GridBagConstraints gbcOperatorCbx = new GridBagConstraints();
		gbcOperatorCbx.gridx = 0;
		gbcOperatorCbx.gridy = 4;
		gbcOperatorCbx.weightx = 0.2;
		gbcOperatorCbx.fill = GridBagConstraints.BOTH;
		gbcOperatorCbx.insets = new Insets(5, 5, 5, 5);
		
		add(getOperatorCbx(), gbcOperatorCbx);
		
		GridBagConstraints gbcFieldCbx = new GridBagConstraints();
		gbcFieldCbx.gridx = 1;
		gbcFieldCbx.gridy = 4;
		gbcFieldCbx.weightx = 0;
		gbcFieldCbx.fill = GridBagConstraints.BOTH;
		gbcFieldCbx.insets = new Insets(5, 5, 5, 5);
		
		add(getFieldCbx(), gbcFieldCbx);
		
		GridBagConstraints gbcConditionCbx = new GridBagConstraints();
		gbcConditionCbx.gridx = 2;
		gbcConditionCbx.gridy = 4;
		gbcConditionCbx.weightx = 0;
		gbcConditionCbx.fill = GridBagConstraints.NONE;
		gbcConditionCbx.insets = new Insets(5, 5, 5, 5);
		
		add(getConditionCbx(), gbcConditionCbx);
		
		GridBagConstraints gbcQueryField = new GridBagConstraints();
		gbcQueryField.gridx = 3;
		gbcQueryField.gridy = 4;
		gbcQueryField.weightx = 0.8;
		gbcQueryField.fill = GridBagConstraints.BOTH;
		gbcQueryField.insets = new Insets(5, 5, 5, 5);
		
		add(getQueryField(), gbcQueryField);

		GridBagConstraints gbcAddBtn = new GridBagConstraints();
		gbcAddBtn.gridx = 4;
		gbcAddBtn.gridy = 4;
		gbcAddBtn.weightx = 0;
		gbcAddBtn.fill = GridBagConstraints.BOTH;
		gbcAddBtn.insets = new Insets(5, 5, 5, 5);
		
		add(getAddConditionBtn(), gbcAddBtn);
		
		GridBagConstraints gbcResultField = new GridBagConstraints();
		gbcResultField.gridx = 0;
		gbcResultField.gridy = 5;
		gbcResultField.weightx = 1;
		gbcResultField.fill = GridBagConstraints.BOTH;
		gbcResultField.insets = new Insets(5, 5, 5, 5);
		gbcResultField.gridwidth = 5;
		
		add(getResultQueryField(), gbcResultField);
		
		GridBagConstraints gbcSearchBtn2 = new GridBagConstraints();
		gbcSearchBtn2.gridx = 0;
		gbcSearchBtn2.gridy = 6;
		gbcSearchBtn2.weightx = 0.2;
		gbcSearchBtn2.fill = GridBagConstraints.BOTH;
		gbcSearchBtn2.insets = new Insets(5, 5, 5, 5);
		
		add(getSearchBtn(), gbcSearchBtn2);
	}
	
	public JLabel getTitleLabel() {
		if (titleLabel == null) {
			titleLabel = new JLabel("Common search");
		}
		return titleLabel;
	}
	
	public JTextField getCommonSearchField() {
		if (commonSearchField == null) {
			commonSearchField = new JTextField();
		}
		return commonSearchField;
	}
	
	public JButton getCommonSearchBtn() {
		if (commonSearchBtn == null) {
			commonSearchBtn = new JButton("Search");
		}
		return commonSearchBtn;
	}
	
	private JComboBox<Operator> getOperatorCbx() {
		if (operatorCbx == null) {
			operatorCbx = new JComboBox<Operator>(Operator.values());
		}
		return operatorCbx;
	}
	
	private JComboBox<String> getFieldCbx() {
		if (fieldCbx == null) {
			fieldCbx = new JComboBox<String>(fields);
		}
		return fieldCbx;
	}
	
	private JComboBox<Condition> getConditionCbx() {
		if (conditionCbx == null) {
			conditionCbx = new JComboBox<Condition>(Condition.values());
		}
		return conditionCbx;
	}
	
	private JTextField getQueryField() {
		if (queryField == null) {
			queryField = new JTextField();
		}
		return queryField;
	}
	
	public JButton getSearchBtn() {
		if (searchBtn == null) {
			searchBtn = new JButton("Search");
		}
		return searchBtn;
	}
	
	public JButton getAddConditionBtn() {
		if (addConditionBtn == null) {
			addConditionBtn = new JButton("Add");
		}
		return addConditionBtn;
	}
	
	public JLabel getConditionLabel() {
		if (conditionLabel == null) {
			conditionLabel = new JLabel("Conditional search");
		}
		return conditionLabel;
	}

	public void addCondtion() {
		SingleCondition condition = new SingleCondition();
		condition.setCondition((Condition) getConditionCbx().getSelectedItem());
		condition.setField((String) getFieldCbx().getSelectedItem());
		condition.setOperator((Operator) getOperatorCbx().getSelectedItem());
		condition.setValue(getQueryField().getText());
		offerQuery.addCondition(condition);
		String str = "";
		for (SingleCondition c : offerQuery.getConditions()) {
			str += c.toString();
		}
		getResultQueryField().setText(str);
	}
	
	public ProductOfferQuery getOfferQuery() {
		return offerQuery;
	}
	
	public JTextField getResultQueryField() {
		if (resultQueryField == null) {
			resultQueryField = new JTextField();
			resultQueryField.setEnabled(false);
		}
		return resultQueryField;
	}
	
	
}
