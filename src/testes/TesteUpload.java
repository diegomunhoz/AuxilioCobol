package testes;

import telas.vo.FormMontaBook;
import analisadores.AnalisaDclgen;
import modelos.ArquivoCblTO;
import modelos.DclgenTO;
import geradores.GeraInsert;
import io.ArquivoInput;
import io.ArquivoOutput;

public class TesteUpload {
	public static void main(String[] args) throws Exception {
		ArquivoInput arquivoInput = new ArquivoInput();
		ArquivoCblTO arquivo = arquivoInput.arquivoUpado();
		StringBuffer conteudo = new StringBuffer();
		AnalisaDclgen analisaDclgen = new AnalisaDclgen();
		DclgenTO dclgen = analisaDclgen.ler(arquivo.getNomeArquivo(), arquivo
				.getProcedimentos());

		FormMontaBook formMontaBook = new FormMontaBook(dclgen);
		formMontaBook.setModal(true);
		formMontaBook.setLocationRelativeTo(null);
		formMontaBook.setVisible(true);

		dclgen = formMontaBook.dclGenTO();

		GeraInsert insert = new GeraInsert();
		for (String s : insert.analizar(dclgen)) {
			conteudo.append(s);
		}

		ArquivoOutput arquivoOutput = new ArquivoOutput();
		try {
			arquivoOutput.gravarArquivo(conteudo, arquivo.getNomeArquivo());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
