package testes;

import io.ArquivoInputCPY;
import io.ArquivoOutput;

import javax.swing.JOptionPane;

import modelos.ArquivoCblTO;
import modelos.BookTO;
import telas.vo.TelaMovimentacao;
import util.ListasDeGravacao;
import analisadores.AnalisaBook;

public class TestaBook {

	/**
	 * @param args
	 * 
	 * 
	 */
	
	public static void mudarAparencia() {
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		JOptionPane.showMessageDialog(null,
				"modulo de testes para analise de book, selecione o book"
				.toUpperCase());

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
			book2 = new AnalisaBook().ler(arquivo.getNomeArquivo(), arquivo
					.getProcedimentos());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage().toUpperCase());
			return;
		}

		if (book2 == null) {
			return;
		}
		
		
	
		mudarAparencia();
		new TelaMovimentacao(book1.getVariaveis(), book1.getNome() , book2.getVariaveis(), book2.getNome());
					
		try {
			new ArquivoOutput().salvarArquivo(ListasDeGravacao
					.getArquivosParaExportar());
		} catch (Exception e) {
		}

		System.exit(0);
	}
}
