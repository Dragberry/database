package by.bsuir.drahun.database;

import java.io.Serializable;
import by.bsuir.drahun.database.client.DatabaseFrame;

public class Launcher implements Serializable {

	private static final long serialVersionUID = -6409308447510017580L;
	
	public static void main(String[] args) {
		DatabaseFrame mainFrame = new DatabaseFrame();
		mainFrame.init();
	}

}
