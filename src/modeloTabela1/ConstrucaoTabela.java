package modeloTabela1;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ConstrucaoTabela extends AbstractTableModel {

	private ArrayList<ModeloTabela> modelos = new ArrayList<ModeloTabela>();
	private Integer VARIAVEL = 0;
	private Integer PIC = 1;
	private NomeBook book;

	public NomeBook getBook() {
		return book;
	}

	public void setBook(NomeBook book) {
		this.book = book;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return modelos.size();
	}

	public void limparTabela() {
		modelos.clear();
		this.fireTableDataChanged();
	}

	public boolean isCellEditable(int row, int col) {
		return true;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		if (coluna == VARIAVEL) {
			return modelos.get(linha).getVariavelOrigem().getNome();
		}
		if (coluna == PIC) {
			return modelos.get(linha).getVariavelOrigem().getPic();
		}
		return null;
	}

	public String getColumnName(int coluna) {

		if (coluna == VARIAVEL) {
			return book.getNome();
		}
		if (coluna == PIC) {
			return "PIC";
		} else {
			return null;
		}

	}

	public void inserir(ModeloTabela m) {
		modelos.add(m);
		this.fireTableDataChanged();
	}

	public void remover(int cont) {
		modelos.remove(cont);
		this.fireTableDataChanged();
	}

	public void setModelos(ArrayList<ModeloTabela> modelos) {
		this.modelos = modelos;
	}

	public ArrayList<ModeloTabela> getModelos() {
		return modelos;
	}
}
