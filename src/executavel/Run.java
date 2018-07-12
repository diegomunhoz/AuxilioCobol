package executavel;

import io.ArquivoInputCPY;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import analisadores.AnalisaBook;

import telas.vo.TelaMovimentacao;

import modelos.ArquivoCblTO;
import modelos.BookTO;
import modelos.VariavelTO;

public class Run extends JFrame {

	public static void mudarAparencia() {

		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		mudarAparencia();

		VariavelTO variavelTO1 = new VariavelTO();
		VariavelTO variavelTO2 = new VariavelTO();
		VariavelTO variavelTO3 = new VariavelTO();
		VariavelTO variavelTO4 = new VariavelTO();
		VariavelTO variavelTO5 = new VariavelTO();
		VariavelTO variavelTO6 = new VariavelTO();

		List<VariavelTO> listaVariavelTO1 = new ArrayList<VariavelTO>();
		List<VariavelTO> listaVariavelTO2 = new ArrayList<VariavelTO>();

		/*
		 * variavelTO1.setNome("WKHE-NUM-CONSULTAS");
		 * variavelTO1.setPic("9(005)"); variavelTO1.isAlfaNumerica(true);
		 * variavelTO1.setInteiro(5); variavelTO1.setDecimais(2); //
		 * variavelTO1.setIsSinalizado(true);
		 * 
		 * variavelTO4.setNome("WKHE-CPSSOA-JURID");
		 * variavelTO4.setPic("X(050)"); variavelTO4.isAlfaNumerica(true);
		 * variavelTO4.setInteiro(50); variavelTO4.setDecimais(10);
		 * 
		 * variavelTO2.setNome("WK1S-NSEQ-POSTO-SERVC");
		 * variavelTO2.setPic("X(005)"); variavelTO2.isAlfaNumerica(false);
		 * variavelTO2.setInteiro(5); variavelTO2.setDecimais(2);
		 * 
		 * variavelTO3.setNome("WK1S-CPSSOA-JURID-SERVC");
		 * variavelTO3.setPic("X(012)"); variavelTO3.isAlfaNumerica(true);
		 * variavelTO3.setInteiro(12); variavelTO3.setDecimais(5);
		 * 
		 * variavelTO5.setNome("DB2-INSERT"); variavelTO5.setPic("X(004)");
		 * variavelTO5.isAlfaNumerica(true); variavelTO5.setInteiro(4);
		 * variavelTO5.setDecimais(5);
		 * 
		 * variavelTO6.setNome("WP5E-NSEQ-UND-ORGNZ");
		 * variavelTO6.setPic("9(008)"); variavelTO6.isAlfaNumerica(true);
		 * variavelTO6.setInteiro(8); variavelTO6.setDecimais(5);
		 * 
		 * listaVariavelTO1.add(variavelTO1); listaVariavelTO1.add(variavelTO4);
		 * listaVariavelTO1.add(variavelTO6);
		 * 
		 * listaVariavelTO2.add(variavelTO2); listaVariavelTO2.add(variavelTO3);
		 * listaVariavelTO2.add(variavelTO5);
		 */

		ArquivoCblTO arquivo = new ArquivoInputCPY().arquivoUpado();
		BookTO book1;
		BookTO book2;

		ArquivoCblTO arquivo2 = new ArquivoInputCPY().arquivoUpado();

		if (arquivo == null || arquivo.getProcedimentos() == null
				|| arquivo.getProcedimentos().isEmpty()) {
			return;
		}

		if (arquivo2 == null || arquivo2.getProcedimentos() == null
				|| arquivo2.getProcedimentos().isEmpty()) {
			return;
		}

		try {
			book1 = new AnalisaBook().ler(arquivo.getNomeArquivo(), arquivo
					.getProcedimentos());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage().toUpperCase());
			return;
		}

		if (book1 == null) {
			return;
		}

		try {
			book2 = new AnalisaBook().ler(arquivo2.getNomeArquivo(), arquivo2
					.getProcedimentos());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage().toUpperCase());
			return;
		}

		if (book2 == null) {
			return;
		}

		new TelaMovimentacao(book1.getVariaveis(), book1.getNome(), book2
				.getVariaveis(), book2.getNome());

		/*
		 * new TelaMovimentacao(listaVariavelTO1, "UORGWKHE", listaVariavelTO2,
		 * "UORGWK1S");
		 */
	}
}
