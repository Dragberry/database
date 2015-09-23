package by.bsuir.drahun.database.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.bsuir.drahun.database.business.OfferService;
import by.bsuir.drahun.database.domain.ProductOffer;
import by.bsuir.drahun.database.model.ProductBean;
import by.bsuir.drahun.database.model.TableModel;
import by.bsuir.drahun.database.query.ProductOfferQuery;

public class DatabaseFrame extends JFrame {

	private static final long serialVersionUID = 3380081745406355225L;

	private ClassPathXmlApplicationContext context;

	private SearchPanel searchPanel;

	private JPanel resultPanel;

	private JTable resultTable;

	private List<ProductBean> resultList;

	public void init() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		fetchInitializationData();
		setMinimumSize(new Dimension(1024, 768));
		setTitle("Database Client");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

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

		getContentPane().setLayout(new GridBagLayout());
		getContentPane().add(getSearchPanel(), gbcTop);
		getContentPane().add(getResultPanel(), gbcBottom);
		setVisible(true);
		addWindowListener(new WindowListenerImpl());
		addActionListeners();
	}

	private void fetchInitializationData() {
		String query = null;
		doSearch(query);
	}
	
	private void doSearch(ProductOfferQuery query) {
		resultList = new ArrayList<ProductBean>();
		OfferService offerService = getContext().getBean(OfferService.class);
		List<ProductOffer> offers = offerService.fetchOffers(query);
		convertResult(offers, resultList);
	}

	private void doSearch(String query) {
		resultList = new ArrayList<ProductBean>();
		OfferService offerService = getContext().getBean(OfferService.class);
		List<ProductOffer> offers = offerService.fetchOffers(query);
		convertResult(offers, resultList);
	}

	protected void convertResult(List<ProductOffer> offers, List<ProductBean> resultList) {
		for (ProductOffer offer : offers) {
			ProductBean bean = new ProductBean();
			bean.setProductCode(offer.getProduct().getProductCode());
			bean.setProductTitle(offer.getProduct().getProductTitle());
			bean.setCost(offer.getCost());
			bean.setQuantity(offer.getQuantity());
			resultList.add(bean);
		}
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

	public ClassPathXmlApplicationContext getContext() {
		return context;
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

	private class WindowListenerImpl implements WindowListener {

		public void windowOpened(WindowEvent e) {
		}

		public void windowClosing(WindowEvent e) {
			getContext().close();
		}

		public void windowClosed(WindowEvent e) {
		}

		public void windowIconified(WindowEvent e) {

		}

		public void windowDeiconified(WindowEvent e) {

		}

		public void windowActivated(WindowEvent e) {

		}

		public void windowDeactivated(WindowEvent e) {

		}

	}

}
