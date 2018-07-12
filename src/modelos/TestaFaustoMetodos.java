package modelos;

import java.util.List;

public class TestaFaustoMetodos {

	public static void main(String[] args) {
		FaustoMetodos f = new FaustoMetodos();

		VariavelTO v1 = new VariavelTO();
        VariavelTO v2 = new VariavelTO();

		
        v1.setHaveDecimais(false);
        v1.setInteiro(14);
        v1.setIsNumerica(false);
        v1.setIsSinalizado(false);
        v1.isAlfaNumerica(true);
        v1.setNome("WRK-ORIGEM");
        v1.setPic("X(014)");
        //v1.setDecimais(2);
        // listaOrigem.add(v1);
        v2.setHaveDecimais(false);
        v2.setInteiro(14);
        v2.setIsNumerica(true);
        v2.setIsSinalizado(true);
        v2.isAlfaNumerica(false);
        v2.setNome("WRK-DESTINO");
        v2.setPic("S9(014)");
        //v2.setDecimais(2);
              //listaDestino.add(v2);


		List<StringBuffer> s = f.xTOS9(v1, v2, 12);

		for (StringBuffer ss : s) {
			System.out.print(ss);
		}
		/*for (StringBuffer ss : s) {
			System.out.print(ss);
		}*/
	}

}
