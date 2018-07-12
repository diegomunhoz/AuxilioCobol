package telas.vo;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class TableModelFormMontaBook extends AbstractTableModel{

	private String[] columnNames = { "Marcar ", "Variavel"};
	static Object[][] data;
	

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}
	
	public String getColumnName(int col) {
        return columnNames[col];
    }
	
	@Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }
	
	public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
	
	
	public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col == 1) {
            return false;
        } else {
            return true;
        }
    }
	
	public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }

}
