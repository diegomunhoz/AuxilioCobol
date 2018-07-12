package modeloTabela3;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import modeloTabela1.NomeBook;
import modelos.VariavelTO;

public class ConstrucaoTabela3 extends AbstractTableModel {
	private List<NomeBook> books;

	private List<ModeloTabela3> modelos = new ArrayList<ModeloTabela3>();
	// private String[] colunas = { "VARIAVEIS BOOK2", "CHECKLIST" };
	// private Object[][] conteudo;
	// = { { "WRK-LIST", new Boolean(false) },
	// { "WRK-POL", new Boolean(false) } };

	private Integer VARIAVEL = 0;
	private Integer PIC = 1;
	private Integer VARIAVEL2 = 2;
	private Integer PIC2 = 3;

	@Override
	public int getColumnCount() {
		// return colunas.length;
		return 4;

	}

	@Override
	public int getRowCount() {
		// return conteudo.length;
		return modelos.size();
	}

	public void limparTabela() {
		modelos.clear();
		this.fireTableDataChanged();
	}

	// public boolean isCellEditable(int row, int col) {
	// return true;
	// }

	// public Class getColumnClass(int c) {
	// return getValueAt(1, c).getClass();
	// }

	@Override
	public Object getValueAt(int linha, int coluna) {
		if (coluna == VARIAVEL) {
			return modelos.get(linha).getVariavelOrigem().getNome();

		} else if (coluna == PIC) {
			return modelos.get(linha).getVariavelOrigem().getPic();

		} else if (coluna == VARIAVEL2) {
			return modelos.get(linha).getVariavelDestino().getNome();

		} else if (coluna == PIC2) {
			return modelos.get(linha).getVariavelDestino().getPic();

		} else {
			return null;
		}

	}

	public String getColumnName(int coluna) {
		// return colunas[coluna];
		if (coluna == VARIAVEL) {
			return books.get(0).getNome();
		}
		if (coluna == PIC) {
			return "PIC";
		}
		if (coluna == VARIAVEL2) {
			return books.get(1).getNome();
		}
		if (coluna == PIC2) {
			return "PIC";
		}

		return null;

	}

	// public void setValueAt(Object value, int row, int col) {
	// conteudo[row][col] = value;
	// modelos.get(row).setCheck((Boolean) value);
	// fireTableCellUpdated(row, col);
	// }

	// public void inserir(int i, String var, Boolean check) {
	public void inserir(ModeloTabela3 m) {
		modelos.add(m);
		this.fireTableDataChanged();
	}

	public void remover(int cont) {
		modelos.remove(cont);
		this.fireTableDataChanged();
	}

	public List<ModeloTabela3> getTabela() {
		return modelos;
	}

	public void setTabela(List<ModeloTabela3> modelos) {
		this.modelos = modelos;
		this.fireTableDataChanged();
	}

	public void setModelos(List<ModeloTabela3> modelos) {
		this.modelos = modelos;
	}

	public List<ModeloTabela3> getModelos() {
		return modelos;
	}

	public void setBooks(List<NomeBook> books) {
		this.books = books;
	}

	public List<NomeBook> getBooks() {
		return books;
	}

}
