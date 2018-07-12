package modeloTabela2;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import modeloTabela1.NomeBook;

public class ConstrucaoTabela2 extends AbstractTableModel {

	private ArrayList<ModeloTabela2> modelos = new ArrayList<ModeloTabela2>();
	// private String[] colunas = { "VARIAVEIS BOOK2", "CHECKLIST" };
	// private Object[][] conteudo;
	// = { { "WRK-LIST", new Boolean(false) },
	// { "WRK-POL", new Boolean(false) } };
	private Integer VARIAVEL = 0;
	private Integer PIC = 1;
	private NomeBook book;

	public ConstrucaoTabela2() {
		// this.conteudo = new Object[0][0];

	}

	@Override
	public int getColumnCount() {
		// return colunas.length;
		return 2;

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

	public boolean isCellEditable(int row, int col) {
		return true;
	}

	// public Class getColumnClass(int c) {
	// return getValueAt(1, c).getClass();
	// }

	@Override
	public Object getValueAt(int linha, int coluna) {
		// return conteudo[linha][coluna];

		if (coluna == VARIAVEL) {
			return modelos.get(linha).getVariavelDestino().getNome();
		}if(coluna == PIC){
			return modelos.get(linha).getVariavelDestino().getPic();
		}else {
			return null;
		}

	}

	public String getColumnName(int coluna) {
		// return colunas[coluna];
		if (coluna == VARIAVEL) {
			return book.getNome();
		}
		if (coluna == PIC){
			return "PIC";
		}

		return null;

	}

	// public void inserir(int i, String var, Boolean check) {
	public void inserir(ModeloTabela2 m) {
		// System.out.println(i);
		// conteudo = new Object[4][4];
		// conteudo[i][0] = var;
		// conteudo[i][1] = check;

		// conteudo = new Object[linha][coluna];
		modelos.add(m);
		// System.out.println(m.getVariavel());
		this.fireTableDataChanged();
	}

	public ArrayList<ModeloTabela2> pegaModelo() {
		return modelos;
	}

	public void remover(int cont) {
		modelos.remove(cont);
		this.fireTableDataChanged();
	}

	public void setModelos(ArrayList<ModeloTabela2> modelos) {
		this.modelos = modelos;
	}

	public ArrayList<ModeloTabela2> getModelos() {
		return modelos;
	}

	public void setBook(NomeBook book) {
		this.book = book;
	}

	public NomeBook getBook() {
		return book;
	}

}
