package by.bsuir.drahun.database.util;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public final class GridBagConstraintsCreator {
	
	private GridBagConstraintsCreator(){
	}
	
	public static GridBagConstraints create(int gridx, int gridy, double weightx, int fill, Insets insets) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.weightx = weightx;
		gbc.fill = fill;
		gbc.insets = insets;
		return gbc;
	}

}
