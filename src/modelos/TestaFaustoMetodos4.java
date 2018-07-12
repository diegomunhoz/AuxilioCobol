package modelos;

import java.util.List;

public class TestaFaustoMetodos4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FaustoMetodos f = new FaustoMetodos();

		VariavelTO v1 = new VariavelTO();
		VariavelTO v2 = new VariavelTO();

        v1.setHaveDecimais(true);
        v1.setInteiro(14);
        v1.setIsNumerica(true);
        v1.setIsSinalizado(true);
        v1.isAlfaNumerica(false);
        v1.setNome("WRK-ORIGEM");
        v1.setPic("X(006)");
        v1.setDecimais(2);
        // listaOrigem.add(v1);
        v2.setHaveDecimais(true);
        v2.setInteiro(14);
        v2.setIsNumerica(true);
        v2.setIsSinalizado(false);
        v2.isAlfaNumerica(false);
        v2.setNome("WRK-DESTINO");
        v2.setPic("X(006)");
        v2.setDecimais(2);
		// listaDestino.add(v2);

		List<StringBuffer> s = f.s9V9TO9V9(v1, v2, 12);

		for (StringBuffer ss : s) {
			System.out.print(ss);
		}
		/*
		 * for (StringBuffer ss : s) { System.out.print(ss); }
		 */

	}

}
