package by.bsuir.drahun.database.client;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import by.bsuir.drahun.database.client.context.ContextProvider;

public class DatabaseFrame extends JFrame {

	private static final String CREATE_SCREEN_ID = "Create";

	private static final String LIST_SCREEN_ID = "List";

	private static final long serialVersionUID = 3380081745406355225L;

	private JMenuBar menuBar;
	
	private ScreenComponent listScreen;
	
	private ScreenComponent createScreen;

	public void init() {
		setMinimumSize(new Dimension(1024, 768));
		setTitle("Database Client");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setJMenuBar(getMenu());
		
		getContentPane().setLayout(new CardLayout());
		getContentPane().add((JPanel)getListScreen(), LIST_SCREEN_ID);
		getContentPane().add((JPanel)getCreateScreen(), CREATE_SCREEN_ID);

		setVisible(true);
		addWindowListener(new WindowListenerImpl());
	}
	
	public ScreenComponent getListScreen() {
		if (listScreen == null) {
			listScreen = new ListPanel();
		}
		return listScreen;
	}
	
	public ScreenComponent getCreateScreen() {
		if (createScreen == null) {
			createScreen = new CreatePanel();
		}
		return createScreen;
	}

	private JMenuBar getMenu() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			JMenu newMenu = new  JMenu("Menu");
			JMenuItem offerListItem = new JMenuItem("Offer list");
			newMenu.add(offerListItem);
			JMenuItem createOfferItem = new JMenuItem("Create offer");
			newMenu.add(createOfferItem);
			JMenuItem exitItem = new JMenuItem("Exit");
			newMenu.add(exitItem);
			
			createOfferItem.addActionListener(new MenuNavigationListener(CREATE_SCREEN_ID));
			offerListItem.addActionListener(new MenuNavigationListener(LIST_SCREEN_ID));
			
			exitItem.addActionListener(new ActionListener() {   
				
				@Override
	            public void actionPerformed(ActionEvent e) {
	                System.exit(0);             
	            }           
	        });
			
			menuBar.add(newMenu);
		}
		return menuBar;
	}
	
	private class MenuNavigationListener implements ActionListener {
		
		private String id;

		private MenuNavigationListener(String id) {
			this.id = id;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			((CardLayout) getContentPane().getLayout()).show(getContentPane(), id);
		}
		
	}

	private class WindowListenerImpl implements WindowListener {

		public void windowOpened(WindowEvent e) {
		}

		public void windowClosing(WindowEvent e) {
			ContextProvider.getContext().close();
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
