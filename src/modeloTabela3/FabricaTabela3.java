package modeloTabela3;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class FabricaTabela3 extends JTable {

	protected JScrollPane scroller;

	public FabricaTabela3(TableModel modelo) {
		super(modelo);
	}

	public void adicionaOuvidor(MouseAdapter acao) {
		this.addMouseListener(acao);
	}

	public void adicionaOuvidor(KeyAdapter acao) {
		this.addKeyListener(acao);
	}

	public JScrollPane criaPainelTabela(Integer max, Integer min,
			Integer altura, Integer largura) {
		this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		JTableHeader header = this.getTableHeader();
		header.setReorderingAllowed(false);

		TableColumnModel modeloDaColuna = this.getColumnModel();
		for (Integer i = 0; i < modeloDaColuna.getColumnCount(); i++) {
			if(i == 0 || i == 2){
				modeloDaColuna.getColumn(i).setMaxWidth(210);
				modeloDaColuna.getColumn(i).setMinWidth(210);
			}
			if(i == 1 || i == 3){
				modeloDaColuna.getColumn(i).setMaxWidth(84);
				modeloDaColuna.getColumn(i).setMinWidth(84);
			}
		}

		scroller = new JScrollPane(this);
		//scroller.setBounds(max, min, altura, largura);
		scroller.setBounds(100, 360, 594, 290);
		//scroller.setPreferredSize(new Dimension(largura, altura));

		return scroller;
	}

	public Integer receberLinhasSelecionadas() {
		return this.getSelectedRow();
	}

	public int[] receberLinhasEscolhidas() {
		return this.getSelectedRows();
	}

}
