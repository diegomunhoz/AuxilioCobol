package modelos;

import java.util.ArrayList;
import java.util.List;

import util.UtilProjeto;

public class RedefinesBruno {
	UtilProjeto util = new UtilProjeto();
	List<StringBuffer> listaStringBuffer = new ArrayList<StringBuffer>();
	StringBuffer cabecalho = new StringBuffer();
	StringBuffer redefines = new StringBuffer();
	StringBuffer movimentacoes = new StringBuffer();

	public List<StringBuffer> xTOS9(VariavelTO v1, VariavelTO v2, int space) {
		cabecalho.append(UtilProjeto.geraMovimentacoes(space, "05", "WRK-"
				+ "X" + "-" + v1.getInteiro(), "PIC", v1.getPic(), "VALUE",
				"SPACES" + "."));
		redefines.append("      *--------[ *PIC " + v1.getPic() + " *TO *PIC "
				+ v2.getPic() + "\n");
		redefines
				.append("               10  FILLER              REDEFINES WRK-"
						+ "X" + "-" + v1.getInteiro() + ".\n");
		if (v1.getInteiro() < 10) {
			redefines.append(UtilProjeto.geraMovimentacoes(15, "15", " WRK-"
					+ "X" + "-" + v1.getInteiro() + "-TO-" + "S9" + "-"
					+ v2.getInteiro(), "PIC", "9(00" + v1.getInteiro() + ").",
					"", "")
					+ "\n\n");
		} else {
			redefines.append(UtilProjeto.geraMovimentacoes(15, "15", " WRK-"
					+ "X" + "-" + v1.getInteiro() + "-TO-" + "S9" + "-"
					+ v2.getInteiro(), "PIC", "9(0" + v1.getInteiro() + ").",
					"", "")
					+ "\n\n");
		}

		movimentacoes.append(UtilProjeto.geraMovimentacoes(8, "MOVE", v1
				.getNome(), "TO", "WRK-" + "X" + "-" + v1.getInteiro() + ".\n",
				"", ""));
		movimentacoes.append(UtilProjeto.geraMovimentacoes(8, "MOVE", "WRK-"
				+ "X" + "-" + v1.getInteiro() + "-TO-" + "S9" + "-"
				+ v2.getInteiro(), "TO", v2.getNome() + ".\n", "", ""));
		listaStringBuffer.add(cabecalho);
		listaStringBuffer.add(redefines);
		listaStringBuffer.add(movimentacoes);
		return listaStringBuffer;
	}

	public List<StringBuffer> xXTOS9(VariavelTO v1, VariavelTO v2, int space) {

		int x = (v1.getInteiro() - v2.getInteiro());

		cabecalho.append(UtilProjeto.geraMovimentacoes(space, "05", "WRK-"
				+ "X" + "-" + v1.getInteiro(), "PIC", v1.getPic(), "VALUE",
				"SPACES" + "."));
		redefines.append("      *--------[ *PIC " + v1.getPic() + " *TO *PIC "
				+ v2.getPic() + "\n");
		redefines
				.append("             10  FILLER                REDEFINES WRK-"
						+ "X" + "-" + v1.getInteiro() + ".\n");
		if (v2.getInteiro() < 10) {
			redefines.append(UtilProjeto.geraMovimentacoes(17, "15 ", "WRK-"
					+ "X" + "-" + v1.getInteiro() + "-TO-" + "S9" + "-"
					+ v2.getInteiro(), "PIC", "9(00" + v2.getInteiro() + ").",
					"", "")
					+ "\n");
			if (x < 10) {
				redefines
						.append("                 15  FILLER            PIC X(00"
								+ (v1.getInteiro() - v2.getInteiro()) + ")\n\n");
			} else {
				redefines
						.append("                 15  FILLER            PIC X(0"
								+ (v1.getInteiro() - v2.getInteiro()) + ")\n\n");
			}

		} else {
			redefines.append(UtilProjeto.geraMovimentacoes(17, "15 ", "WRK-"
					+ "X" + "-" + v1.getInteiro() + "-TO-" + "S9" + "-"
					+ v2.getInteiro(), "PIC", "9(0" + v2.getInteiro() + ").",
					"", "")
					+ "\n");
			if (x < 10) {
				redefines
						.append("                 15  FILLER            PIC X(00"
								+ (v1.getInteiro() - v2.getInteiro()) + ")\n\n");
			} else {
				redefines
						.append("                 15  FILLER            PIC X(0"
								+ (v1.getInteiro() - v2.getInteiro()) + ")\n\n");
			}
		}

		movimentacoes.append(UtilProjeto.geraMovimentacoes(8, "MOVE", v1
				.getNome(), "TO", "WRK-" + "X" + "-" + v1.getInteiro() + ".\n",
				"", ""));
		movimentacoes.append(UtilProjeto.geraMovimentacoes(8, "MOVE", "WRK-"
				+ "X" + "-" + v1.getInteiro() + "-TO-" + "S9" + "-"
				+ v2.getInteiro(), "TO", v2.getNome() + ".\n", "", ""));
		listaStringBuffer.add(cabecalho);
		listaStringBuffer.add(redefines);
		listaStringBuffer.add(movimentacoes);
		return listaStringBuffer;
	}
	
	
	public List<StringBuffer> xTO9V9(VariavelTO v1, VariavelTO v2, int space) {
		cabecalho.append(UtilProjeto.geraMovimentacoes(space, "05", "WRK-"
				+ "X" + "-" + v1.getInteiro(), "PIC", v1.getPic(), "VALUE",
				"SPACES" + "."));
		redefines.append("      *--------[ *PIC " + v1.getPic() + " *TO *PIC "
				+ v2.getPic() + "\n");
		redefines
				.append("               10  FILLER              REDEFINES WRK-"
						+ "X" + "-" + v1.getInteiro() + ".\n");
		if (v1.getInteiro() < 10) {
			redefines.append(UtilProjeto.geraMovimentacoes(15, "15", " WRK-"
					+ "X" + "-" + v1.getInteiro() + "-TO-" + "9V9" + "-"
					+ v2.getInteiro(), "PIC", "9(00" + v1.getInteiro() + ").",
					"", "")
					+ "\n\n");
		} else {
			redefines.append(UtilProjeto.geraMovimentacoes(15, "15", " WRK-"
					+ "X" + "-" + v1.getInteiro() + "-TO-" + "9V9" + "-"
					+ v2.getInteiro(), "PIC", "9(0" + v1.getInteiro() + ").",
					"", "")
					+ "\n\n");
		}

		movimentacoes.append(UtilProjeto.geraMovimentacoes(8, "MOVE", v1
				.getNome(), "TO", "WRK-" + "X" + "-" + v1.getInteiro() + ".\n",
				"", ""));
		movimentacoes.append(UtilProjeto.geraMovimentacoes(8, "MOVE", "WRK-"
				+ "X" + "-" + v1.getInteiro() + "-TO-" + "9V9" + "-"
				+ v2.getInteiro(), "TO", v2.getNome() + ".\n", "", ""));
		listaStringBuffer.add(cabecalho);
		listaStringBuffer.add(redefines);
		listaStringBuffer.add(movimentacoes);
		return listaStringBuffer;
	}

	
	public List<StringBuffer> xXTOX(VariavelTO v1, VariavelTO v2, int space) {

		int x = (v1.getInteiro() - v2.getInteiro());

		cabecalho.append(UtilProjeto.geraMovimentacoes(space, "05", "WRK-"
				+ "X" + "-" + v1.getInteiro(), "PIC", v1.getPic(), "VALUE",
				"SPACES" + "."));
		redefines.append("      *--------[ *PIC " + v1.getPic() + " *TO *PIC "
				+ v2.getPic() + "\n");
		redefines
				.append("             10  FILLER                REDEFINES WRK-"
						+ "X" + "-" + v1.getInteiro() + ".\n");
		if (v2.getInteiro() < 10) {
			redefines.append(UtilProjeto.geraMovimentacoes(17, "15 ", "WRK-"
					+ "X" + "-" + v1.getInteiro() + "-TO-" + "X" + "-"
					+ v2.getInteiro(), "PIC", "X(00" + v2.getInteiro() + ").",
					"", "")
					+ "\n");
			if (x < 10) {
				redefines
						.append("                 15  FILLER            PIC X(00"
								+ (v1.getInteiro() - v2.getInteiro()) + ")\n\n");
			} else {
				redefines
						.append("                 15  FILLER            PIC X(0"
								+ (v1.getInteiro() - v2.getInteiro()) + ")\n\n");
			}

		} else {
			redefines.append(UtilProjeto.geraMovimentacoes(17, "15 ", "WRK-"
					+ "X" + "-" + v1.getInteiro() + "-TO-" + "X" + "-"
					+ v2.getInteiro(), "PIC", "X(0" + v2.getInteiro() + ").",
					"", "")
					+ "\n");
			if (x < 10) {
				redefines
						.append("                 15  FILLER            PIC X(00"
								+ (v1.getInteiro() - v2.getInteiro()) + ")\n\n");
			} else {
				redefines
						.append("                 15  FILLER            PIC X(0"
								+ (v1.getInteiro() - v2.getInteiro()) + ")\n\n");
			}
		}

		movimentacoes.append(UtilProjeto.geraMovimentacoes(8, "MOVE", v1
				.getNome(), "TO", "WRK-" + "X" + "-" + v1.getInteiro() + ".\n",
				"", ""));
		movimentacoes.append(UtilProjeto.geraMovimentacoes(8, "MOVE", "WRK-"
				+ "X" + "-" + v1.getInteiro() + "-TO-" + "X" + "-"
				+ v2.getInteiro(), "TO", v2.getNome() + ".\n", "", ""));
		listaStringBuffer.add(cabecalho);
		listaStringBuffer.add(redefines);
		listaStringBuffer.add(movimentacoes);
		return listaStringBuffer;
	}

	
	
	

}
