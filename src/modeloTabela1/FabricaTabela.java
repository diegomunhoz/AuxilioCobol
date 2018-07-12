package modeloTabela1;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class FabricaTabela extends JTable {

	protected JScrollPane scroller;

	public FabricaTabela(TableModel modelo) {
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
			if(i == 0){
				modeloDaColuna.getColumn(0).setMaxWidth(230);
				modeloDaColuna.getColumn(0).setMinWidth(230);
			}
			if(i == 1){
				modeloDaColuna.getColumn(1).setMaxWidth(80);
				modeloDaColuna.getColumn(1).setMinWidth(80);
			}
			//modeloDaColuna.getColumn(i).setMaxWidth(max);
			//modeloDaColuna.getColumn(i).setMinWidth(min);

		}

		scroller = new JScrollPane(this);
		//scroller.setBounds(max, min, altura, largura);
		scroller.setBounds(20, 20, 316, 290);
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
