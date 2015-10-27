package by.bsuir.drahun.database.client;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import by.bsuir.drahun.database.business.OfferService;
import by.bsuir.drahun.database.client.context.ContextProvider;
import by.bsuir.drahun.database.domain.Product;
import by.bsuir.drahun.database.domain.ProductOffer;
import by.bsuir.drahun.database.util.GridBagConstraintsCreator;

public class CreatePanel extends JPanel implements ScreenComponent {

	private static final long serialVersionUID = -5963895660513436643L;
	
	private JLabel titleLabel;
	
	private JTextField titleField;

	private JLabel codeLabel;
	
	private JTextField codeField;

	private JLabel costLabel;
	
	private JTextField costField;

	private JLabel quantityLabel;
	
	private JTextField quantityField;
	
	private JButton createButton;
	
	public CreatePanel() {
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setLayout(new GridBagLayout());
		
		add(getTitleLabel(), GridBagConstraintsCreator.create(0, 0, 0.5, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5)));
		add(getTitleField(), GridBagConstraintsCreator.create(1, 0, 0.5, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5)));
		
		add(getCodeLabel(), GridBagConstraintsCreator.create(0, 1, 0.5, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5)));
		add(getCodeField(), GridBagConstraintsCreator.create(1, 1, 0.5, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5)));
		
		add(getCostLabel(), GridBagConstraintsCreator.create(0, 2, 0.5, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5)));
		add(getCostField(), GridBagConstraintsCreator.create(1, 2, 0.5, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5)));
		
		add(getQuantityLabel(), GridBagConstraintsCreator.create(0, 3, 0.5, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5)));
		add(getQuantityField(), GridBagConstraintsCreator.create(1, 3, 0.5, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5)));
		
		add(getCreateButton(), GridBagConstraintsCreator.create(1, 5, 1, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5)));
		
		addActionListeners();
	}

	private void addActionListeners() {
		getCreateButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Product product = new Product();
					product.setProductCode(getCodeField().getText());
					product.setProductTitle(getTitleField().getText());
					ProductOffer offer = new ProductOffer();
					offer.setProduct(product);
					offer.setCost(new BigDecimal(getCostField().getText()));
					offer.setQuantity(Integer.valueOf(getQuantityField().getText()));
					ContextProvider.getContext().getBean(OfferService.class).saveOffer(offer);
					resetScreen();
					showSuccesMessage();
				} catch (Exception ex) {
					showErrorMessage();
				}
			}

			private void showErrorMessage() {
				
			}

			private void showSuccesMessage() {
				
			}

			private void resetScreen() {
				
			}
		});
		
	}

	public JLabel getTitleLabel() {
		if (titleLabel == null) {
			titleLabel = new JLabel("Product title");
		}
		return titleLabel;
	}

	public JTextField getTitleField() {
		if (titleField == null) {
			titleField = new JTextField();
		}
		return titleField;
	}

	public JLabel getCodeLabel() {
		if (codeLabel == null) {
			codeLabel = new JLabel("Product code");
		}
		return codeLabel;
	}

	public JTextField getCodeField() {
		if (codeField == null) {
			codeField = new JTextField();
		}
		return codeField;
	}

	public JLabel getCostLabel() {
		if (costLabel == null) {
			costLabel = new JLabel("Cost");
		}
		return costLabel;
	}

	public JTextField getCostField() {
		if (costField == null) {
			costField = new JTextField();
		}
		return costField;
	}

	public JLabel getQuantityLabel() {
		if (quantityLabel == null) {
			quantityLabel = new JLabel("Quantity");
		}
		return quantityLabel;
	}

	public JTextField getQuantityField() {
		if (quantityField == null) {
			quantityField = new JTextField();
		}
		return quantityField;
	}

	public JButton getCreateButton() {
		if (createButton == null) {
			createButton = new JButton("Create");
		}
		return createButton;
	}

	@Override
	public void fetchInitializationData() {
	}

}
