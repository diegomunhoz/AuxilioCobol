package geradores;

import java.util.ArrayList;
import java.util.List;
import modelos.DclgenTO;

import perfis.PerfilBradesco;

public class GeraUpdade {

	private static DclgenTO dclGenTO;

	private static StringBuffer comandoSQL = new StringBuffer();
	private static StringBuffer linhasDeCondicionais = new StringBuffer();
	private static StringBuffer linhasDeMovimentacoes = new StringBuffer();
	private static StringBuffer variaveisDeNulidade = new StringBuffer();

	private String prefixoDoBook = "xxxx".toUpperCase() + "-";
	private String prefixoNulidade = "WRK-";
	private String sufixoNulidade = "-NULL";

	public List<String> analizar(DclgenTO dclGen) {

		List<String> retornoCompleto = new ArrayList<String>();
		dclGenTO = dclGen;

		if (dclGen.getListaDeNaoNotNull() == null
				|| dclGen.getListaDeNaoNotNull().isEmpty()
				|| dclGen.getListaDeNotNull() == null
				|| dclGen.getListaDeNotNull().isEmpty()) {
			return null;
		}

		processar();

		retornoCompleto.add(variaveisDeNulidade.toString().toUpperCase());

		retornoCompleto.add(linhasDeMovimentacoes.toString().toUpperCase());

		retornoCompleto.add(linhasDeCondicionais.toString().toUpperCase());

		retornoCompleto.add(comandoSQL.toString().toUpperCase());

		return retornoCompleto;
	}

	private void processar() {

		geraSQLInicial();

		if (dclGenTO.getListaDeNaoNotNull() == null
				|| dclGenTO.getListaDeNaoNotNull().isEmpty()) {

			geraSQLSomenteNotNull();
			geraMovimentacoes();

		} else if (dclGenTO.getListaDeNotNull() == null
				|| dclGenTO.getListaDeNotNull().isEmpty()) {

			geraVariaveisDeNulidade();
			geraSQLSomenteNaoNotNull();
			geraCondicionais();

		} else {

			geraVariaveisDeNulidade();
			geraSQLSomenteNaoNotNullENorNull();
			geraMovimentacoes();
			geraCondicionais();

		}

		geraSQLFinal();

	}

	private void geraMovimentacoes() {
		for (String varNulidade : dclGenTO.getListaDeNotNull()) {
			linhasDeMovimentacoes.append("\n");
			linhasDeMovimentacoes
					.append(geraMovimentacoes(
							(PerfilBradesco.coluna8 + (PerfilBradesco.espacamentoDeTabulacao * 1)),
							"MOVE", prefixoDoBook
									+ varNulidade.replace("_", "-"), "TO",
							varNulidade.replace("_", "-"), "OF", dclGenTO
									.getNomeDaDclgen()));

			linhasDeMovimentacoes.append("\n");

		}
	}

	private void geraCondicionais() {

		for (String varNulidade : dclGenTO.getListaDeNaoNotNull()) {
			linhasDeCondicionais.append("\n");
			linhasDeCondicionais
					.append(geraLinhaCondicional(
							(PerfilBradesco.coluna8 + PerfilBradesco.espacamentoDeTabulacao),
							"IF",
							prefixoDoBook + varNulidade.replace("_", "-"),
							"EQUAL SPACES OR LOW-VALUES"));
			linhasDeCondicionais.append("\n");

			linhasDeCondicionais
					.append(geraMovimentacoes(
							(PerfilBradesco.coluna8 + (PerfilBradesco.espacamentoDeTabulacao * 2)),
							"MOVE", "-1", "TO", prefixoNulidade
									+ varNulidade.replace("_", "-")
									+ sufixoNulidade, "", ""));

			linhasDeCondicionais.append("\n");
			linhasDeCondicionais.append(getEspacos(PerfilBradesco.coluna8
					+ PerfilBradesco.espacamentoDeTabulacao));
			linhasDeCondicionais.append("ELSE");

			linhasDeCondicionais.append("\n");
			linhasDeCondicionais
					.append(geraMovimentacoes(
							(PerfilBradesco.coluna8 + (PerfilBradesco.espacamentoDeTabulacao * 2)),
							"MOVE", prefixoDoBook
									+ varNulidade.replace("_", "-"), "TO",
							varNulidade.replace("_", "-"), "OF", dclGenTO
									.getNomeDaDclgen()));

			linhasDeCondicionais.append("\n");
			linhasDeCondicionais.append(getEspacos(PerfilBradesco.coluna8
					+ PerfilBradesco.espacamentoDeTabulacao));
			linhasDeCondicionais.append("END-IF.");
			linhasDeCondicionais.append("\n");

		}
	}

	private String geraLinhaCondicional(Integer numeroDeEspacamentos,
			String primeiraSintaxe, String primeiraVariavel,
			String segundaSintaxe) {

		StringBuffer linhaCondicional = new StringBuffer();

		linhaCondicional.append(getEspacos(numeroDeEspacamentos));
		linhaCondicional.append(primeiraSintaxe + "  ");
		linhaCondicional.append(primeiraVariavel);

		if (linhaCondicional.length() < (PerfilBradesco.colunaPadrao - PerfilBradesco.taxaDePerdaDoCarro)) {
			linhaCondicional
					.append(getEspacos(PerfilBradesco.colunaPadrao
							- (linhaCondicional.length() + PerfilBradesco.taxaDePerdaDoCarro)));
			linhaCondicional.append(segundaSintaxe);
		} else {
			linhaCondicional.append("\n");
			linhaCondicional
					.append(getEspacos((PerfilBradesco.colunaPadrao - PerfilBradesco.taxaDePerdaDoCarro)));
			linhaCondicional.append(segundaSintaxe);
		}

		return linhaCondicional.toString();
	}

	private String geraMovimentacoes(Integer numeroDeEspacamentos,
			String primeiraSintaxe, String primeiraVariavel,
			String segundaSintaxe, String segundaVariavel,
			String terceiraSintaxe, String terceiraVariavel) {

		StringBuffer linhaDaMovimentacao = new StringBuffer();

		linhaDaMovimentacao.append(getEspacos(numeroDeEspacamentos));
		linhaDaMovimentacao.append(primeiraSintaxe + " ");
		linhaDaMovimentacao.append(primeiraVariavel);

		if (linhaDaMovimentacao.length() < (PerfilBradesco.colunaPadrao - PerfilBradesco.taxaDePerdaDoCarro)) {
			linhaDaMovimentacao
					.append(getEspacos(PerfilBradesco.colunaPadrao
							- (linhaDaMovimentacao.length() + PerfilBradesco.taxaDePerdaDoCarro)));
			linhaDaMovimentacao.append(segundaSintaxe + " ");
		} else {
			linhaDaMovimentacao.append("\n");
			linhaDaMovimentacao.append(getEspacos(PerfilBradesco.colunaPadrao
					- PerfilBradesco.taxaDePerdaDoCarro));
			linhaDaMovimentacao.append(segundaSintaxe + " ");
		}
		linhaDaMovimentacao.append(segundaVariavel);

		if (terceiraSintaxe != null && !terceiraSintaxe.isEmpty()) {
			String linhaAux = linhaDaMovimentacao.toString() + " "
					+ terceiraSintaxe + " " + terceiraVariavel;
			if (linhaDaMovimentacao.length() > PerfilBradesco.colunaSecundaria
					|| linhaAux.length() > PerfilBradesco.coluna72) {
				linhaDaMovimentacao.append("\n");
				linhaDaMovimentacao
						.append(getEspacos(PerfilBradesco.colunaPadrao
								- PerfilBradesco.taxaDePerdaDoCarro));
			}
			linhaDaMovimentacao
					.append(getEspacos((PerfilBradesco.colunaSecundaria - (linhaDaMovimentacao
							.length() + PerfilBradesco.taxaDePerdaDoCarro)))
							+ terceiraSintaxe + " ");
			linhaDaMovimentacao.append(terceiraVariavel);
		}

		return linhaDaMovimentacao.toString();
	}

	private void geraSQLInicial() {

		comandoSQL.append("\n");
		comandoSQL
				.append(getEspacos((PerfilBradesco.coluna8 + PerfilBradesco.espacamentoDeTabulacao)));

		comandoSQL.append("EXEC SQL");

		comandoSQL.append("\n");
		comandoSQL
				.append(getEspacos((PerfilBradesco.coluna8 + (PerfilBradesco.espacamentoDeTabulacao * 2))));

		comandoSQL.append("UPDATE " + dclGenTO.getNomeDaTabela());

		comandoSQL.append("\n");
		comandoSQL
				.append(getEspacos((PerfilBradesco.coluna8 + (PerfilBradesco.espacamentoDeTabulacao * 3))));

		comandoSQL.append("SET");

		comandoSQL.append("\n");

	}

	private void geraSQLFinal() {

		comandoSQL.append("\n");
		comandoSQL
				.append(getEspacos((PerfilBradesco.coluna8 + (PerfilBradesco.espacamentoDeTabulacao * 2))));
		comandoSQL.append("WHERE");
		comandoSQL.append("\n");
		comandoSQL.append("\n");
		comandoSQL.append("\n");
		comandoSQL
				.append(getEspacos((PerfilBradesco.coluna8 + PerfilBradesco.espacamentoDeTabulacao)));

		comandoSQL.append("END-EXEC.");

	}

	private void geraSQLSomenteNaoNotNullENorNull() {

		comandoSQL.append(geraLinhasNotNullDeSQL(dclGenTO.getListaDeNotNull(),
				3, ":" + dclGenTO.getNomeDaDclgen().toUpperCase().trim() + ".",
				true));
		comandoSQL.append("\n");
		comandoSQL
				.append(geraLinhasNaoNotNullDeSQL(dclGenTO
						.getListaDeNaoNotNull(), 3,
						":" + dclGenTO.getNomeDaDclgen().toUpperCase().trim()
								+ ".", false));

	}

	private void geraSQLSomenteNaoNotNull() {

		comandoSQL.append(geraLinhasNaoNotNullDeSQL(dclGenTO
				.getListaDeNaoNotNull(), 3, "", true));
		comandoSQL.append(")");

		comandoSQL.append("\n");
		comandoSQL.append(getEspacos(PerfilBradesco.coluna8)
				+ getEspacos(PerfilBradesco.espacamentoDeTabulacao * 2)
				+ "VALUES");
		comandoSQL.append("\n");

		comandoSQL.append(geraLinhasNaoNotNullDeSQL(dclGenTO
				.getListaDeNaoNotNull(), 3, ":"
				+ dclGenTO.getNomeDaDclgen().toUpperCase().trim() + ".", true));
		comandoSQL.append(")");

	}

	private void geraSQLSomenteNotNull() {

		comandoSQL.append(geraLinhasNotNullDeSQL(dclGenTO.getListaDeNotNull(),
				3, ":" + dclGenTO.getNomeDaDclgen().toUpperCase().trim() + ".",
				true));

	}

	private StringBuffer geraLinhasNotNullDeSQL(List<String> listaASerGerada,
			Integer nivelDeTabulacao, String prefixoDeSQL, Boolean primeiraParte) {
		StringBuffer linhasSQL = new StringBuffer();
		StringBuffer linhaAuxiliar = new StringBuffer();

		linhaAuxiliar.append(getEspacos(PerfilBradesco.coluna8)
				+ getEspacos(PerfilBradesco.espacamentoDeTabulacao
						* nivelDeTabulacao));

		if (!primeiraParte) {
			linhaAuxiliar.append(",");
		}

		linhaAuxiliar.append(listaASerGerada.get(0).trim());
		auxiliarDeQuebraDeLinha(linhaAuxiliar);
		linhaAuxiliar.append("= ");

		linhaAuxiliar.append(prefixoDeSQL);
		linhaAuxiliar.append(listaASerGerada.get(0).replace("_", "-"));

		linhasSQL.append(linhaAuxiliar);

		for (int indice = 1; indice < listaASerGerada.size(); indice++) {
			linhaAuxiliar = new StringBuffer();
			linhaAuxiliar.append("\n");
			linhaAuxiliar.append(getEspacos(PerfilBradesco.coluna8)
					+ getEspacos(PerfilBradesco.espacamentoDeTabulacao
							* nivelDeTabulacao));

			linhaAuxiliar.append("," + listaASerGerada.get(indice).trim());
			auxiliarDeQuebraDeLinha(linhaAuxiliar);
			linhaAuxiliar.append("= ");

			linhaAuxiliar.append(prefixoDeSQL);
			linhaAuxiliar.append(listaASerGerada.get(indice).replace("_", "-"));

			linhasSQL.append(linhaAuxiliar);

		}

		return linhasSQL;
	}

	private void auxiliarDeQuebraDeLinha(StringBuffer linha) {

		if (linha.length() < (PerfilBradesco.colunaPadrao)) {
			linha.append(getEspacos((PerfilBradesco.colunaPadrao - (linha
					.length()))));
		} else {
			linha.append("\n");
			linha.append(getEspacos(PerfilBradesco.colunaPadrao
					- PerfilBradesco.taxaDePerdaDoCarro));
		}
	}

	private StringBuffer geraLinhasNaoNotNullDeSQL(
			List<String> listaASerGerada, Integer nivelDeTabulacao,
			String prefixoDeSQL, Boolean primeiraParte) {
		StringBuffer linhasSQL = new StringBuffer();
		StringBuffer linhaAuxiliar = new StringBuffer();

		String variavelDeNulidadeAuxiliar = prefixoNulidade
				+ listaASerGerada.get(0).trim().replace("_", "-").toUpperCase()
				+ sufixoNulidade;

		linhaAuxiliar.append(getEspacos(PerfilBradesco.coluna8)
				+ getEspacos(PerfilBradesco.espacamentoDeTabulacao
						* nivelDeTabulacao));

		if (!primeiraParte) {
			linhaAuxiliar.append(",");
		}

		linhaAuxiliar.append(listaASerGerada.get(0).trim());
		auxiliarDeQuebraDeLinha(linhaAuxiliar);
		linhaAuxiliar.append("= ");

		linhaAuxiliar.append(prefixoDeSQL);
		linhaAuxiliar.append(listaASerGerada.get(0).replace("_", "-"));

		linhaAuxiliar.append("\n"
				+ getEspacos(PerfilBradesco.colunaPadrao
						+ PerfilBradesco.espacamentoDeTabulacao
						- PerfilBradesco.taxaDePerdaDoCarro));

		linhaAuxiliar.append(":" + variavelDeNulidadeAuxiliar);

		linhasSQL.append(linhaAuxiliar);

		for (int indice = 1; indice < listaASerGerada.size(); indice++) {
			linhaAuxiliar = new StringBuffer();
			linhaAuxiliar.append("\n");
			linhaAuxiliar.append(getEspacos(PerfilBradesco.coluna8)
					+ getEspacos(PerfilBradesco.espacamentoDeTabulacao
							* nivelDeTabulacao));

			variavelDeNulidadeAuxiliar = prefixoNulidade
					+ listaASerGerada.get(indice).trim().replace("_", "-")
							.toUpperCase() + sufixoNulidade;

			linhaAuxiliar.append("," + listaASerGerada.get(indice).trim());
			auxiliarDeQuebraDeLinha(linhaAuxiliar);
			linhaAuxiliar.append("= ");

			linhaAuxiliar.append(prefixoDeSQL);
			linhaAuxiliar.append(listaASerGerada.get(indice).replace("_", "-"));

			linhaAuxiliar.append("\n"
					+ getEspacos(PerfilBradesco.colunaPadrao
							+ PerfilBradesco.espacamentoDeTabulacao
							- PerfilBradesco.taxaDePerdaDoCarro));

			linhaAuxiliar.append(":" + variavelDeNulidadeAuxiliar);

			linhasSQL.append(linhaAuxiliar);

		}

		return linhasSQL;
	}

	private void geraVariaveisDeNulidade() {

		StringBuffer linhaDaVariavel;

		variaveisDeNulidade.append(getEspacos(PerfilBradesco.coluna8)
				+ "01  WRK-NULIDADE.");
		for (String variavel : dclGenTO.getListaDeNaoNotNull()) {

			linhaDaVariavel = new StringBuffer();
			linhaDaVariavel.append("\n");

			linhaDaVariavel
					.append(getEspacos((PerfilBradesco.coluna8 + PerfilBradesco.espacamentoDeTabulacao)));
			linhaDaVariavel.append("05  ");
			linhaDaVariavel.append(prefixoNulidade);
			linhaDaVariavel.append(variavel.trim().replace("_", "-"));
			linhaDaVariavel.append(sufixoNulidade);
			if (linhaDaVariavel.toString().length() < PerfilBradesco.colunaPadrao) {
				linhaDaVariavel.append(getEspacos(PerfilBradesco.colunaPadrao
						- linhaDaVariavel.toString().length()));
			} else {
				linhaDaVariavel.append("\n");
				linhaDaVariavel.append(getEspacos(PerfilBradesco.colunaPadrao
						- PerfilBradesco.taxaDePerdaDoCarro));
			}
			linhaDaVariavel.append("PIC S9(004) COMP    VALUE ZEROS.");

			variaveisDeNulidade
					.append(linhaDaVariavel.toString().toUpperCase());
		}

	}

	private String getEspacos(Integer numeroDeEspacos) {

		StringBuffer acuEspacos = new StringBuffer();

		for (Integer ind = 0; ind < numeroDeEspacos; ind++) {
			acuEspacos.append(" ");
		}
		return String.valueOf(acuEspacos);
	}

}
