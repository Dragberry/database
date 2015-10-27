package by.bsuir.drahun.database.client;

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

	private static final long serialVersionUID = 3380081745406355225L;

	private JMenuBar menuBar;
	
	private ScreenComponent listScreen = new ListPanel();
	
	private ScreenComponent createScreen = new CreatePanel();

	public void init() {
		setMinimumSize(new Dimension(1024, 768));
		setTitle("Database Client");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setJMenuBar(getMenu());
		
		getContentPane().add((JPanel)getListScreen());

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
			createScreen = new ListPanel();
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
			
			createOfferItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					getContentPane().removeAll();
					getContentPane().add((JPanel)getCreateScreen());
					repaint();
				}
			});

			offerListItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					getContentPane().removeAll();
					getContentPane().add((JPanel)getListScreen());
					repaint();
				}
			});
			
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
