package modelos;

import java.util.ArrayList;
import java.util.List;

import util.UtilProjeto;

public class FaustoMetodos {

	UtilProjeto util = new UtilProjeto();
	List<StringBuffer> listaStringBuffer = new ArrayList<StringBuffer>();
	StringBuffer cabecalho = new StringBuffer();
	StringBuffer redefines = new StringBuffer();
	StringBuffer movimentacoes = new StringBuffer();

	public List<StringBuffer> xTOS9(VariavelTO v1, VariavelTO v2, int space) {
		cabecalho.append(UtilProjeto.geraMovimentacoes(space-1, "05", " WRK-"
				+ "X" + "-" + v1.getInteiro(), "PIC ", v1.getPic(), "VALUE",
				"SPACES" + ".\n"));
		redefines
				.append("           05  FILLER                  REDEFINES WRK-"
						+ "X" + "-" + v1.getInteiro() + ".\n");
		if (v1.getInteiro() < 10) {
			redefines.append(UtilProjeto.geraMovimentacoes(15, "10", " WRK-"
					+ "X" + "-" + v1.getInteiro() + "-TO-" + "S9" + "-"
					+ v2.getInteiro(), "PIC ", "9(00" + v1.getInteiro() + ").",
					"", "")
					+ "\n");
		} else {
			redefines.append(UtilProjeto.geraMovimentacoes(15, "10", " WRK-"
					+ "X" + "-" + v1.getInteiro() + "-TO-" + "S9" + "-"
					+ v2.getInteiro(), "PIC ", "9(0" + v1.getInteiro() + ").",
					"", "")
					+ "\n");
		}

		movimentacoes.append(UtilProjeto.geraMovimentacoes(11, "MOVE", v1
				.getNome(), "TO", "WRK-" + "X" + "-" + v1.getInteiro() + ".\n",
				"", ""));
		movimentacoes.append(UtilProjeto.geraMovimentacoes(11, "MOVE", "WRK-"
				+ "X" + "-" + v1.getInteiro() + "-TO-" + "S9" + "-"
				+ v2.getInteiro(), "TO", v2.getNome() + ".\n", "", ""));
		listaStringBuffer.add(cabecalho);
		listaStringBuffer.add(redefines);
		listaStringBuffer.add(movimentacoes);
		return listaStringBuffer;
	}

	public List<StringBuffer> xXTOS9(VariavelTO v1, VariavelTO v2, int space) {

		int x = (v1.getInteiro() - v2.getInteiro());

		cabecalho.append(UtilProjeto.geraMovimentacoes(space-1, "05", " WRK-"
				+ "X" + "-" + v1.getInteiro(), "PIC ", v1.getPic(), "VALUE",
				"SPACES" + ".\n"));
		redefines
				.append("           05  FILLER                  REDEFINES WRK-"
						+ "X" + "-" + v1.getInteiro() + ".\n");
		if (v2.getInteiro() < 10) {
			redefines.append(UtilProjeto.geraMovimentacoes(15, "10 ", "WRK-"
					+ "X" + "-" + v1.getInteiro() + "-TO-" + "S9" + "-"
					+ v2.getInteiro(), "PIC ", "9(00" + v2.getInteiro() + ").",
					"", "")
					+ "\n");
			if (x < 10) {
				redefines
						.append("               10  FILLER              PIC  X(00"
								+ (v1.getInteiro() - v2.getInteiro()) + ").\n");
			} else {
				redefines
						.append("               10  FILLER              PIC  X(0"
								+ (v1.getInteiro() - v2.getInteiro()) + ").\n");
			}

		} else {
			redefines.append(UtilProjeto.geraMovimentacoes(15, "10 ", "WRK-"
					+ "X" + "-" + v1.getInteiro() + "-TO-" + "S9" + "-"
					+ v2.getInteiro(), "PIC ", "9(0" + v2.getInteiro() + ").",
					"", "")
					+ "\n");
			if (x < 10) {
				redefines
						.append("               10  FILLER              PIC  X(00"
								+ (v1.getInteiro() - v2.getInteiro()) + ").\n");
			} else {
				redefines
						.append("               10  FILLER              PIC  X(0"
								+ (v1.getInteiro() - v2.getInteiro()) + ").\n");
			}
		}

		movimentacoes.append(UtilProjeto.geraMovimentacoes(11, "MOVE", v1
				.getNome(), "TO", "WRK-" + "X" + "-" + v1.getInteiro() + ".\n",
				"", ""));
		movimentacoes.append(UtilProjeto.geraMovimentacoes(11, "MOVE", "WRK-"
				+ "X" + "-" + v1.getInteiro() + "-TO-" + "S9" + "-"
				+ v2.getInteiro(), "TO", v2.getNome() + ".\n", "", ""));
		listaStringBuffer.add(cabecalho);
		listaStringBuffer.add(redefines);
		listaStringBuffer.add(movimentacoes);

		return listaStringBuffer;

	}

	public List<StringBuffer> xTO9V9(VariavelTO v1, VariavelTO v2, int space) {
		cabecalho.append(UtilProjeto.geraMovimentacoes(space-1, "05", " WRK-"
				+ "X" + "-" + v1.getInteiro(), "PIC ", v1.getPic(), "VALUE",
				"SPACES" + ".\n"));
		redefines
				.append("           05  FILLER                  REDEFINES WRK-"
						+ "X" + "-" + v1.getInteiro() + ".\n");
		if (v1.getInteiro() < 10) {
			redefines.append(UtilProjeto.geraMovimentacoes(15, "10", " WRK-"
					+ "X" + "-" + v1.getInteiro() + "-TO-" + "9-"
					+ v2.getInteiro(), "PIC ", "9(00" + v1.getInteiro() + ").",
					"", "")
					+ "\n");
			movimentacoes.append(UtilProjeto.geraMovimentacoes(11, "MOVE", v1
					.getNome(), "TO", "WRK-" + "X" + "-" + v1.getInteiro()
					+ ".\n", "", ""));
			movimentacoes.append(UtilProjeto.geraMovimentacoes(11, "MOVE",
					"WRK-" + "X" + "-" + v1.getInteiro() + "-TO-" + "9-"
							+ v2.getInteiro(), "TO", v2.getNome() + ".\n", "",
					""));

		} else {
			redefines.append(UtilProjeto.geraMovimentacoes(15, "10", " WRK-"
					+ "X" + "-" + v1.getInteiro() + "-TO-" + "9-"
					+ v2.getInteiro(), "PIC ", "9(0" + v1.getInteiro() + ").",
					"", "")
					+ "\n");
			movimentacoes.append(UtilProjeto.geraMovimentacoes(11, "MOVE", v1
					.getNome(), "TO", "WRK-" + "X" + "-" + v1.getInteiro()
					+ ".\n", "", ""));
			movimentacoes.append(UtilProjeto.geraMovimentacoes(11, "MOVE",
					"WRK-" + "X" + "-" + v1.getInteiro() + "-TO-" + "9-"
							+ v2.getInteiro(), "TO", v2.getNome() + ".\n", "",
					""));

		}

		listaStringBuffer.add(cabecalho);
		listaStringBuffer.add(redefines);
		listaStringBuffer.add(movimentacoes);
		return listaStringBuffer;
	}

	public List<StringBuffer> xXTOX(VariavelTO v1, VariavelTO v2, int space) {

		int x = (v1.getInteiro() - v2.getInteiro());

		cabecalho.append(UtilProjeto.geraMovimentacoes(space-1, "05", " WRK-"
				+ "X" + "-" + v1.getInteiro(), "PIC ", v1.getPic(), "VALUE",
				"SPACES" + ".\n"));
		redefines
				.append("           05  FILLER                  REDEFINES WRK-"
						+ "X" + "-" + v1.getInteiro() + ".\n");
		if (v2.getInteiro() < 10) {
			redefines.append(UtilProjeto.geraMovimentacoes(15, "10", " WRK-"
					+ "X" + "-" + v1.getInteiro() + "-TO-" + "X" + "-"
					+ v2.getInteiro(), "PIC ", "X(00" + v2.getInteiro() + ").",
					"", "")
					+ "\n");
			if (x < 10) {
				redefines
						.append("               10  FILLER              PIC  X(00"
								+ (v1.getInteiro() - v2.getInteiro()) + ")\n");
			} else {
				redefines
						.append("               10  FILLER              PIC  X(0"
								+ (v1.getInteiro() - v2.getInteiro()) + ")\n");
			}

		} else {
			redefines.append(UtilProjeto.geraMovimentacoes(15, "10", " WRK-"
					+ "X" + "-" + v1.getInteiro() + "-TO-" + "X" + "-"
					+ v2.getInteiro(), "PIC ", "X(0" + v2.getInteiro() + ").",
					"", "")
					+ "\n");
			if (x < 10) {
				redefines
						.append("               10  FILLER              PIC  X(00"
								+ (v1.getInteiro() - v2.getInteiro()) + ")\n");
			} else {
				redefines
						.append("               10  FILLER              PIC  X(0"
								+ (v1.getInteiro() - v2.getInteiro()) + ")\n");
			}
		}

		movimentacoes.append(UtilProjeto.geraMovimentacoes(11, "MOVE", v1
				.getNome(), "TO", "WRK-" + "X" + "-" + v1.getInteiro() + ".\n",
				"", ""));
		movimentacoes.append(UtilProjeto.geraMovimentacoes(11, "MOVE", "WRK-"
				+ "X" + "-" + v1.getInteiro() + "-TO-" + "X" + "-"
				+ v2.getInteiro(), "TO", v2.getNome() + ".\n", "", ""));
		listaStringBuffer.add(cabecalho);
		listaStringBuffer.add(redefines);
		listaStringBuffer.add(movimentacoes);
		return listaStringBuffer;
	}

	public List<StringBuffer> s9V9TO9V9(VariavelTO v1, VariavelTO v2, int space) {
		int resto = 0;

		resto = ((v1.getInteiro() + 1) - v2.getInteiro());

		if (v1.getInteiro() < 10) {
			cabecalho.append(UtilProjeto.geraMovimentacoes(space-1, "05", " WRK-"
					+ "S9" + "-" + v1.getInteiro() + "-V2", "PIC +9(00"
					+ v1.getInteiro() + ")V9(002)", "", "VALUE", "ZEROS"
					+ ".\n"));
		} else {
			cabecalho.append(UtilProjeto.geraMovimentacoes(space-1, "05", " WRK-"
					+ "S9" + "-" + v1.getInteiro() + "-V2", "PIC +9(0"
					+ v1.getInteiro() + ")V9(002)", "", "VALUE", "ZEROS"
					+ ".\n"));

		}
		redefines
				.append("           05  FILLER                  REDEFINES WRK-"
						+ "S9" + "-" + v1.getInteiro() + "-V2" + ".\n");
		if (v1.getInteiro() < 10) {
			if (resto < 10) {
				redefines.append(UtilProjeto.geraMovimentacoes(15, "10",
						" FILLER", "PIC ", "X(00" + resto + ").", "", "")
						+ "\n");
			} else {
				redefines.append(UtilProjeto.geraMovimentacoes(15, "10",
						" FILLER", "PIC ", "X(0" + resto + ").", "", "")
						+ "\n");
			}
			redefines.append(UtilProjeto.geraMovimentacoes(15, "10", " WRK-"
					+ "S9" + "-" + v1.getInteiro() + "-V2" + "-TO-" + "9-"
					+ v1.getInteiro() + "-V2", "PIC ", "9(00" + v1.getInteiro()
					+ ")V9(002).", "", "")
					+ "\n");
			movimentacoes.append(UtilProjeto.geraMovimentacoes(11, "MOVE", v1
					.getNome(), "TO", "WRK-" + "S9" + "-" + v1.getInteiro()
					+ "-V2" + ".\n", "", ""));
			movimentacoes.append(UtilProjeto.geraMovimentacoes(11, "MOVE",
					"WRK-" + "S9" + "-" + v1.getInteiro() + "-V2" + "-TO-"
							+ "9-" + v2.getInteiro() + "-V2", "TO", v2
							.getNome()
							+ ".\n", "", ""));

		} else {
			if (resto < 10) {
				redefines.append(UtilProjeto.geraMovimentacoes(15, "10",
						" FILLER", "PIC ", "X(00" + resto + ").", "", "")
						+ "\n");
			} else {
				redefines.append(UtilProjeto.geraMovimentacoes(15, "10",
						" FILLER", "PIC ", "X(0" + resto + ").", "", "")
						+ "\n");
			}
			redefines.append(UtilProjeto.geraMovimentacoes(15, "10", " WRK-"
					+ "S9" + "-" + v1.getInteiro() + "-V2" + "-TO-" + "9-"
					+ v2.getInteiro() + "-V2", "PIC ", "9(0" + v1.getInteiro()
					+ ")V9(002).", "", "")
					+ "\n");
			movimentacoes.append(UtilProjeto.geraMovimentacoes(11, "MOVE", v1
					.getNome(), "TO", "WRK-" + "S9" + "-" + v1.getInteiro()
					+ "-V2" + ".\n", "", ""));
			movimentacoes.append(UtilProjeto.geraMovimentacoes(11, "MOVE",
					"WRK-" + "S9" + "-" + v1.getInteiro() + "-V2" + "-TO-"
							+ "9-" + v2.getInteiro() + "-V2", "TO", v2
							.getNome()
							+ ".\n", "", ""));

		}

		listaStringBuffer.add(cabecalho);
		listaStringBuffer.add(redefines);
		listaStringBuffer.add(movimentacoes);
		return listaStringBuffer;
	}

}
