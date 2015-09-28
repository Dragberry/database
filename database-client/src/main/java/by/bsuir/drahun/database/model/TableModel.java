package by.bsuir.drahun.database.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.apache.commons.collections4.CollectionUtils;

public class TableModel extends AbstractTableModel {

	private static final long serialVersionUID = -4189466602867014272L;

	private List<ProductBean> productList = new ArrayList<ProductBean>();

	private String[] columnList = { "Product Code", "Product Title", "Cost", "Quantity", "Sum" };

	public TableModel(List<ProductBean> productList) {
		this.productList = productList;
	}

	public int getRowCount() {
		return productList.size();
	}

	public int getColumnCount() {
		return columnList.length;
	}

	@Override
	public String getColumnName(int column) {
		return columnList[column];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		if (CollectionUtils.isEmpty(productList)) {
			return null;
		}
		ProductBean row = productList.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return row.getProductCode();
		case 1:
			return row.getProductTitle();
		case 2:
			return row.getCost().toString();
		case 3:
			return row.getQuantity();
		case 4:
			return row.getCost().multiply(new BigDecimal(row.getQuantity()));
		default:
			return null;
		}
	}

}
