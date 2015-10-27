package by.bsuir.drahun.database.client;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.springframework.context.ConfigurableApplicationContext;

import by.bsuir.drahun.database.business.OfferService;
import by.bsuir.drahun.database.client.context.ContextProvider;
import by.bsuir.drahun.database.model.ProductBean;
import by.bsuir.drahun.database.model.TableModel;
import by.bsuir.drahun.database.query.ProductOfferQuery;

public class ListPanel extends JPanel implements ScreenComponent {

	private static final long serialVersionUID = -7847152164232285161L;
	
	private SearchPanel searchPanel;

	private JPanel resultPanel;

	private JTable resultTable;

	private List<ProductBean> resultList;
	
	public ListPanel() {
		fetchInitializationData();
		init();
	}
	
	public void init() {
		GridBagConstraints gbcTop = new GridBagConstraints();
		gbcTop.gridx = 0;
		gbcTop.gridy = 0;
		gbcTop.weightx = 1.0;
		gbcTop.fill = GridBagConstraints.HORIZONTAL;
		gbcTop.insets = new Insets(10, 10, 10, 10);

		GridBagConstraints gbcBottom = new GridBagConstraints();
		gbcBottom.gridx = 0;
		gbcBottom.gridy = 1;
		gbcBottom.gridheight = 1;
		gbcBottom.fill = GridBagConstraints.BOTH;
		gbcBottom.weightx = 1.0;
		gbcBottom.weighty = 1.0;
		gbcBottom.insets = new Insets(10, 10, 10, 10);
		
		setLayout(new GridBagLayout());
		add(getSearchPanel(), gbcTop);
		add(getResultPanel(), gbcBottom);
		addActionListeners();
	}

	@Override
	public void fetchInitializationData() {
		String query = null;
		doSearch(query);
	}
	
	private void doSearch(ProductOfferQuery query) {
		OfferService offerService = getContext().getBean(OfferService.class);
		resultList = offerService.fetchOffers(query);
	}

	private void doSearch(String query) {
		OfferService offerService = getContext().getBean(OfferService.class);
		resultList = offerService.fetchOffers(query);
	}

	private void addActionListeners() {
		getSearchPanel().getCommonSearchBtn().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String query = getSearchPanel().getCommonSearchField().getText();
				doSearch(query);
				resultTable.setModel(new TableModel(resultList));
				resultPanel.repaint();
				repaint();
			}
		});
		
		getSearchPanel().getSearchBtn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				doSearch(getSearchPanel().getOfferQuery());
				resultTable.setModel(new TableModel(resultList));
				resultPanel.repaint();
				repaint();
			}
		});
		
        getSearchPanel().getAddConditionBtn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				getSearchPanel().addCondtion();
			}
		});
	}

	public ConfigurableApplicationContext getContext() {
		return ContextProvider.getContext();
	}

	private SearchPanel getSearchPanel() {
		if (searchPanel == null) {
			searchPanel = new SearchPanel();
		}
		return searchPanel;
	}

	private JPanel getResultPanel() {
		if (resultPanel == null) {
			resultPanel = new JPanel();
			resultPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			resultPanel.setLayout(new GridBagLayout());
			
			GridBagConstraints gbcLabel = new GridBagConstraints();
			gbcLabel.gridx = 0;
			gbcLabel.gridy = 0;
			gbcLabel.weightx = 1.0;
			gbcLabel.fill = GridBagConstraints.HORIZONTAL;
			
			resultPanel.add(new JLabel("Searc result:"), gbcLabel);
			
			GridBagConstraints gbcTable = new GridBagConstraints();
			gbcTable.gridx = 0;
			gbcTable.gridy = 1;
			gbcTable.gridheight = 1;
			gbcTable.fill = GridBagConstraints.BOTH;
			gbcTable.weightx = 1.0;
			gbcTable.weighty = 1.0;
			
			resultTable = new JTable(new TableModel(resultList));
			resultTable.setPreferredScrollableViewportSize(resultTable.getPreferredSize());
			resultTable.setFillsViewportHeight(true);
			JScrollPane scrollPane = new JScrollPane(resultTable);
			
			resultPanel.add(scrollPane, gbcTable);
		}
		return resultPanel;
	}

}
