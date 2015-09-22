package by.bsuir.drahun.database.client;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchPanel extends JPanel {

	private static final long serialVersionUID = -5644408596769182938L;
	
	private JLabel titleLabel;
	
	private JTextField commonSearchField;
	
	private JButton commonSearchBtn;
	
	public SearchPanel() {
		super();
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setLayout(new GridBagLayout());
		
		GridBagConstraints gbcLabel = new GridBagConstraints();
		gbcLabel.gridx = 0;
		gbcLabel.gridy = 0;
		gbcLabel.weightx = 1.0;
		gbcLabel.fill = GridBagConstraints.HORIZONTAL;
		gbcLabel.insets = new Insets(5, 5, 5, 5);
		
		add(getTitleLabel(), gbcLabel);
		
		GridBagConstraints gbcSearchField = new GridBagConstraints();
		gbcSearchField.gridx = 0;
		gbcSearchField.gridy = 1;
		gbcSearchField.weightx = 0.4;
		gbcSearchField.fill = GridBagConstraints.BOTH;
		gbcSearchField.insets = new Insets(5, 5, 5, 5);
		
		add(getCommonSearchField(), gbcSearchField);
		
		GridBagConstraints gbcSearchBtn = new GridBagConstraints();
		gbcSearchBtn.gridx = 1;
		gbcSearchBtn.gridy = 1;
		gbcSearchBtn.weightx = 0.3;
		gbcSearchBtn.fill = GridBagConstraints.BOTH;
		gbcSearchBtn.insets = new Insets(5, 5, 5, 5);
		
		add(getCommonSearchBtn(), gbcSearchBtn);
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
			commonSearchField.setSize(100, 25);
		}
		return commonSearchField;
	}
	
	public JButton getCommonSearchBtn() {
		if (commonSearchBtn == null) {
			commonSearchBtn = new JButton("Search");
		}
		return commonSearchBtn;
	}
	
	
}
