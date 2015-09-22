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

public class SearchPanel extends JPanel {

	private static final long serialVersionUID = -5644408596769182938L;
	
	private JLabel titleLabel;
	
	private JTextField commonSearchField;
	
	private JButton commonSearchBtn;
	
	private JComboBox<Operator> operatorCbx;
	
	private JComboBox<String> fieldCbx;
	
	private JComboBox<Condition> conditionCbx;
	
	private JTextField queryField;
	
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
		
		add(getCommonSearchField(), gbcSearchField);
		
		GridBagConstraints gbcSearchBtn = new GridBagConstraints();
		gbcSearchBtn.gridx = 1;
		gbcSearchBtn.gridy = 1;
		gbcSearchBtn.weightx = 0.2;
		gbcSearchBtn.fill = GridBagConstraints.BOTH;
		gbcSearchBtn.insets = new Insets(5, 5, 5, 5);
		
		add(getCommonSearchBtn(), gbcSearchBtn);
		
		GridBagConstraints gbcOperatorCbx = new GridBagConstraints();
		gbcOperatorCbx.gridx = 0;
		gbcOperatorCbx.gridy = 2;
		gbcOperatorCbx.weightx = 0.2;
		gbcOperatorCbx.fill = GridBagConstraints.BOTH;
		gbcOperatorCbx.insets = new Insets(5, 5, 5, 5);
		
		add(getOperatorCbx(), gbcOperatorCbx);
		
		GridBagConstraints gbcFieldCbx = new GridBagConstraints();
		gbcFieldCbx.gridx = 1;
		gbcFieldCbx.gridy = 2;
		gbcFieldCbx.weightx = 0.2;
		gbcFieldCbx.fill = GridBagConstraints.BOTH;
		gbcFieldCbx.insets = new Insets(5, 5, 5, 5);
		
		add(getFieldCbx(), gbcFieldCbx);
		
		GridBagConstraints gbcConditionCbx = new GridBagConstraints();
		gbcConditionCbx.gridx = 2;
		gbcConditionCbx.gridy = 2;
		gbcConditionCbx.weightx = 0.2;
		gbcConditionCbx.fill = GridBagConstraints.BOTH;
		gbcConditionCbx.insets = new Insets(5, 5, 5, 5);
		
		add(getConditionCbx(), gbcConditionCbx);
		
		GridBagConstraints gbcQueryField = new GridBagConstraints();
		gbcQueryField.gridx = 3;
		gbcQueryField.gridy = 2;
		gbcQueryField.weightx = 0.2;
		gbcQueryField.fill = GridBagConstraints.BOTH;
		gbcQueryField.insets = new Insets(5, 5, 5, 5);
		
		add(getQueryField(), gbcQueryField);
	}
	
	public JLabel getTitleLabel() {
		if (titleLabel == null) {
			titleLabel = new JLabel("Search panel:");
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
}
