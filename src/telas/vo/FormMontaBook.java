/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Sobre.java
 *
 * Created on Jun 30, 2011, 2:32:40 PM
 */
package telas.vo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;

import modelos.DclgenTO;
import modelos.VariavelTO;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
@SuppressWarnings("serial")
public class FormMontaBook extends JDialog {

	private JButton btnUpload;
	private JButton btnRmvAll;
	private JButton btnAddAll;
	private JButton btnExecutar;
	private javax.swing.JTable gridVariaveis;
	private javax.swing.JScrollPane jScrollPane1;
	private List<VariavelTO> lista = new ArrayList<VariavelTO>();
	private Object[][] data;
	// static List<String> marcadasNotNull;
	// static List<String> marcadasNaoNotNull;
	private DclgenTO dclGen;

	public DclgenTO dclGenTO(){
		return dclGen;
	}
	
	public FormMontaBook() {
		this.data = new Object[0][0];
		initComponents();
	}

	public FormMontaBook(DclgenTO dcl) {
		lista = dcl.getVariaveisDaDCLGEN();
		popularTabela(dcl);
		initComponents();
	}

	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);
		setMinimumSize(new java.awt.Dimension(600, 320));
		this.setPreferredSize(new java.awt.Dimension(574, 575));
		this.setSize(574, 575);
		getContentPane().setLayout(null);

		btnUpload = new JButton();
		getContentPane().add(btnUpload);
		btnUpload.setText("Abrir");
		btnUpload.setBounds(12, 12, 75, 21);

		btnExecutar = new JButton();
		getContentPane().add(btnExecutar);
		btnExecutar.setText("Executar");
		btnExecutar.setBounds(468, 509, 86, 21);

		TableModelFormMontaBook.data = this.data;
		gridVariaveis = new javax.swing.JTable(new TableModelFormMontaBook());
		gridVariaveis.setColumnSelectionAllowed(true);
		gridVariaveis.getColumnModel().getColumn(0).setPreferredWidth(2);
		gridVariaveis.getColumnModel().getColumn(1).setPreferredWidth(350);

		jScrollPane1 = new JScrollPane(gridVariaveis);
		jScrollPane1.setBounds(12, 89, 450, 440);
		jScrollPane1.getVerticalScrollBar().setValueIsAdjusting(true);
		getContentPane().add(jScrollPane1);

		btnAddAll = new JButton();
		getContentPane().add(btnAddAll);
		btnAddAll.setText("Marcar Todos");
		btnAddAll.setBounds(12, 57, 117, 21);

		btnRmvAll = new JButton();
		getContentPane().add(btnRmvAll);
		btnRmvAll.setText("Desmarcar Todos");
		btnRmvAll.setBounds(140, 57, 143, 21);

		pack();

		btnExecutar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				executar();
			}
		});

		btnAddAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				addAll();

			}
		});

		btnRmvAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rmvAll();

			}
		});
	}// </editor-fold>//GEN-END:initComponents

	private void executar() {

		dclGen = new DclgenTO();

		List<String> marcadasNotNull = new ArrayList<String>();
		List<String> marcadasNaoNotNull = new ArrayList<String>();

		for (int i = 0; i < gridVariaveis.getRowCount(); i++) {
			if (gridVariaveis.getValueAt(i, 0).equals(true)) {
				if (lista.get(i).isNotNull()) {
					marcadasNotNull.add(lista.get(i).getNome());
				} else {
					marcadasNaoNotNull.add(lista.get(i).getNome());
				}
			}
		}

		dclGen.setListaDeNotNull(marcadasNotNull);
		dclGen.setListaDeNaoNotNull(marcadasNaoNotNull);

	}

	private void addAll() {
		for (int i = 0; i < gridVariaveis.getRowCount(); i++) {
			gridVariaveis.setValueAt(true, i, 0);
		}
	}

	private void rmvAll() {
		for (int i = 0; i < gridVariaveis.getRowCount(); i++) {
			gridVariaveis.setValueAt(false, i, 0);
		}
	}

	private void popularTabela(DclgenTO dcl) {

		data = new Object[dcl.getVariaveisDaDCLGEN().size()][2];
		for (int i = 0; i < dcl.getVariaveisDaDCLGEN().size(); i++) {
			data[i][0] = new Boolean(false);
			data[i][1] = new String(dcl.getVariaveisDaDCLGEN().get(i).getNome());

		}

	}

}
