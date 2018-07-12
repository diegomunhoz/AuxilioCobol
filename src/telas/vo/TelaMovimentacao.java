package telas.vo;

import geradores.GeraSaida;

import io.ArquivoOutput;
import io.OutputRedefines;

import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import com.sun.org.apache.xerces.internal.impl.dtd.models.DFAContentModel;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import modeloTabela1.ConstrucaoTabela;
import modeloTabela1.FabricaTabela;
import modeloTabela1.ModeloTabela;
import modeloTabela1.NomeBook;
import modeloTabela2.ConstrucaoTabela2;
import modeloTabela2.FabricaTabela2;
import modeloTabela2.ModeloTabela2;
import modeloTabela3.ConstrucaoTabela3;
import modeloTabela3.FabricaTabela3;
import modeloTabela3.ModeloTabela3;
import modelos.ArquivoCblTO;
import modelos.VariavelTO;

public class TelaMovimentacao extends JFrame implements ActionListener {

	private GeraSaida redefines;
	private Panel painel;
	private JButton adiciona;
	private JButton remover;
	private JButton redefinir;
	private static JScrollPane scroll;
	private JScrollPane scroll2;
	private JScrollPane scroll3 = new JScrollPane();
	private ConstrucaoTabela construcaoTabela;
	private ConstrucaoTabela2 construcaoTabela2;
	private ConstrucaoTabela3 construcaoTabela3 = new ConstrucaoTabela3();
	private static FabricaTabela table;
	private FabricaTabela2 table2;
	private FabricaTabela3 table3;
	private ModeloTabela modeloTabela;
	private ModeloTabela3 modeloTabela3;
	private Label jbMensagem;
	private NomeBook book = new NomeBook();
	private NomeBook book2 = new NomeBook();
	private List<NomeBook> books = new ArrayList<NomeBook>();

	public TelaMovimentacao(List<VariavelTO> nomeV1, String nomeLista1,
			List<VariavelTO> nomeV2, String nomeLista2) {
		super("Movimentação de books");
		painel = new Panel();
		painel.setLayout(null);
		painel.setBounds(100, 170, 400, 400);

		jbMensagem = new Label();
		jbMensagem.setBounds(310, 320, 200, 20);

		adiciona = new JButton("Adicionar");
		adiciona.setBounds(340, 30, 100, 30);
		adiciona.addActionListener(this);

		remover = new JButton("Remover");
		remover.setBounds(340, 80, 100, 30);
		remover.addActionListener(this);

		redefinir = new JButton("Executar");
		redefinir.setBounds(340, 130, 100, 30);
		redefinir.addActionListener(this);

		this.setLayout(null);

		book.setNome(nomeLista1);

		construcaoTabela = new ConstrucaoTabela();
		construcaoTabela.setBook(book);
		table = new FabricaTabela(construcaoTabela);
		table.setEnabled(true);

		scroll = table.criaPainelTabela(180, 350, 300, 300);

		for (int i = 0; i < nomeV1.size(); i++) {
			modeloTabela = new ModeloTabela();
			modeloTabela.setVariavelOrigem(nomeV1.get(i));
			construcaoTabela.inserir(modeloTabela);
		}

		book2.setNome(nomeLista2);

		construcaoTabela2 = new ConstrucaoTabela2();
		construcaoTabela2.setBook(book2);
		table2 = new FabricaTabela2(construcaoTabela2);

		scroll2 = table2.criaPainelTabela(210, 350, 100, 300);

		for (int i = 0; i < nomeV2.size(); i++) {
			ModeloTabela2 modeloTabela2 = new ModeloTabela2();
			modeloTabela2.setVariavelDestino((nomeV2.get(i)));
			construcaoTabela2.inserir(modeloTabela2);
		}

		books.add(book);
		books.add(book2);
		construcaoTabela3.setBooks(books);
		table3 = new FabricaTabela3(construcaoTabela3);
		scroll3 = table3.criaPainelTabela(180, 350, 100, 300);

		
		redefines = new GeraSaida(book.getNome(), book2.getNome());
		
		painel.add(scroll);
		this.add(scroll);
		painel.add(scroll2);
		painel.add(scroll3);
		this.add(scroll3);
		this.add(scroll2);
		this.add(adiciona);
		this.add(remover);
		this.add(redefinir);
		this.add(jbMensagem);

		this.setIconImage(new ImageIcon(this.getClass().getResource(
				"/icones/mensagem.png")).getImage());

		this.setSize(800, 700);
		this.setLocation(100, 50);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ((e.getSource() == adiciona && table2.getSelectedRow() >= 0 && table
				.getSelectedRowCount() == 1)) {
			try {
				ArrayList<String> listaNome = new ArrayList<String>();
				for (int i : table2.getSelectedRows()) {
					modeloTabela3 = new ModeloTabela3();

					modeloTabela3.setVariavelDestino(construcaoTabela2
							.getModelos().get(i).getVariavelDestino());
					modeloTabela3.setVariavelOrigem(construcaoTabela
							.getModelos().get(table.getSelectedRow())
							.getVariavelOrigem());

					listaNome.add(construcaoTabela2.getModelos().get(i)
							.getVariavelDestino().getNome());

					construcaoTabela3.inserir(modeloTabela3);

				}
				ArrayList<ModeloTabela> model = new ArrayList<ModeloTabela>();
				for (ModeloTabela m : construcaoTabela.getModelos()) {
					if (!m.getVariavelOrigem().getNome().equals(
							construcaoTabela.getModelos().get(
									table.getSelectedRow()).getVariavelOrigem()
									.getNome())) {
						model.add(m);
					}
				}
				construcaoTabela.setModelos(model);

				ArrayList<ModeloTabela2> model2 = new ArrayList<ModeloTabela2>();
				boolean existe = false;
				for (String s : listaNome) {
					for (ModeloTabela2 m : construcaoTabela2.getModelos()) {
						if (!m.getVariavelDestino().getNome().equals(s)) {
							for (ModeloTabela2 n : model2) {
								if (n.getVariavelDestino().getNome().equals(
										m.getVariavelDestino().getNome())) {
									existe = true;
								}
							}
							for (String z : listaNome) {
								if (z.equals(m.getVariavelDestino().getNome())) {
									existe = true;
								}
							}
							if (existe == false) {
								model2.add(m);
							}
							existe = false;
						}
					}
				}
				construcaoTabela2.setModelos(model2);

				table.setEnabled(true);
				table2.revalidate();
				table.revalidate();
				table.clearSelection();
				table2.clearSelection();
				jbMensagem.setText("");
			} catch (Exception e2) {
				jbMensagem.setText("Erro ao adicionar.");
			}
		} else if (e.getSource() == adiciona && table.getSelectedRowCount() > 1) {
			jbMensagem.setText("Selecione apenas uma origem.");
		} else if (e.getSource() == adiciona
				&& table.getSelectedRowCount() == 0) {
			jbMensagem.setText("Selecione a linha de origem.");
		} else if (e.getSource() == adiciona
				&& table2.getSelectedRowCount() >= 0) {
			jbMensagem.setText("Selecione a linha de destino.");
		} else if (e.getSource() == adiciona) {
			jbMensagem.setText("Nenhuma linha selecionada.");
		}

		if ((e.getSource() == remover) && (table3.getSelectedRowCount() == 1)) {
			try {
				HashSet<String> nomesDelTab1 = new HashSet<String>();
				HashSet<String> nomesDelTab2 = new HashSet<String>();
				ArrayList<String> nomesDelTab3V1 = new ArrayList<String>();

				boolean existe = false;
				if (table3.getSelectedRows() != null) {
					for (int i : table3.getSelectedRows()) {
						nomesDelTab1.add(construcaoTabela3.getModelos().get(i)
								.getVariavelOrigem().getNome());
						nomesDelTab2.add(construcaoTabela3.getModelos().get(i)
								.getVariavelDestino().getNome());
						nomesDelTab3V1.add(construcaoTabela3.getModelos()
								.get(i).getVariavelOrigem().getNome());
					}

					for (String s : nomesDelTab1) {
						for (ModeloTabela3 m : construcaoTabela3.getModelos()) {
							if (m.getVariavelOrigem().getNome().equals(s)) {
								for (ModeloTabela n : construcaoTabela
										.getModelos()) {
									if (n.getVariavelOrigem().getNome().equals(
											m.getVariavelOrigem().getNome())) {
										existe = true;
									}
								}
								if (existe == false) {
									ModeloTabela modelo1 = new ModeloTabela();
									modelo1.setVariavelOrigem((m
											.getVariavelOrigem()));
									construcaoTabela.inserir(modelo1);
								}
								existe = false;
							}
						}
					}
					table.repaint();

					for (String s : nomesDelTab2) {
						for (ModeloTabela3 m : construcaoTabela3.getModelos()) {
							if (m.getVariavelDestino().getNome().equals(s)) {
								for (ModeloTabela2 n : construcaoTabela2
										.getModelos()) {
									if (n.getVariavelDestino().getNome()
											.equals(
													m.getVariavelDestino()
															.getNome())) {
										existe = true;
									}
								}
								if (existe == false) {
									ModeloTabela2 modelo2 = new ModeloTabela2();
									modelo2.setVariavelDestino((m
											.getVariavelDestino()));
									construcaoTabela2.inserir(modelo2);
								}
								existe = false;
							}
						}
					}
					table2.repaint();

					ArrayList<ModeloTabela3> model3 = new ArrayList<ModeloTabela3>();
					for (String s : nomesDelTab3V1) {
						System.out.println("Comparando: " + s);
						for (ModeloTabela3 m : construcaoTabela3.getModelos()) {

							if (s.equals(m.getVariavelOrigem().getNome())) {
								for (ModeloTabela2 k : construcaoTabela2
										.getModelos()) {
									if (k.getVariavelDestino().getNome()
											.equals(
													m.getVariavelDestino()
															.getNome())) {
										existe = true;
									}
								}
								if (existe == false) {
									ModeloTabela2 modelo2 = new ModeloTabela2();
									modelo2.setVariavelDestino((m
											.getVariavelDestino()));
									construcaoTabela2.inserir(modelo2);
								}
								existe = false;
							} else {
								model3.add(m);
							}
						}
					}
					construcaoTabela3.setModelos(model3);
					table3.revalidate();
					table.setEnabled(true);

					table3.clearSelection();

				}
				jbMensagem.setText("");
			} catch (Exception e2) {
				jbMensagem.setText("Erro ao remover.");
			}
		} else if (e.getSource() == remover
				&& table3.getSelectedRowCount() == 0) {
			jbMensagem.setText("Selecione uma linha p/ deleção.");
		} else if (e.getSource() == remover && table3.getSelectedRowCount() > 1) {
			jbMensagem.setText("Selecione apenas uma linha.");
		}

		if (e.getSource() == redefinir) {
			ArrayList<VariavelTO> lista1 = new ArrayList<VariavelTO>();
			ArrayList<VariavelTO> lista2 = new ArrayList<VariavelTO>();

			for (ModeloTabela3 m : construcaoTabela3.getModelos()) {
				lista1.add(m.getVariavelOrigem());
				lista2.add(m.getVariavelDestino());
			}
			
			for (VariavelTO g: lista1)
				 System.out.println(g.getNome());
			
			for (VariavelTO g: lista2)
				 System.out.println(g.getNome());

			redefines.geraListas(lista1, lista2, 12);

			ArquivoOutput out = new ArquivoOutput();			
			ArquivoCblTO to = new ArquivoCblTO();			
			StringBuffer b = new StringBuffer();
			
			for (String s : redefines.getListaDeclaracao()){
				 b.append(s);
			}		
			for (String s : redefines.getListaMoves()){
				 b.append(s);
			}	
			
			to.setArquivoEmString(b);
			to.setNomeArquivo("REDEFINICAO.CBL");
			ArrayList<ArquivoCblTO> listArquivoCblTO = new ArrayList<ArquivoCblTO>();		
			listArquivoCblTO.add(to);
			
			try {
				out.salvarArquivo(listArquivoCblTO);
			} catch (Exception ee) {
				// TODO Auto-generated catch block
				ee.printStackTrace();
			}
			
			
			
		/*	try {
				OutputRedefines outputRedefines = new OutputRedefines
				(redefines.getListaDeclaracao(), redefines.getListaMoves());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				jbMensagem.setText("Erro ao gerar arquivo de saída!");
			}*/
			System.exit(0);
		}
	}
}
