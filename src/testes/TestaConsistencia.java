package testes;

import java.util.ArrayList;

import modelos.Consistencia;
import modelos.VariavelTO;

public class TestaConsistencia {

	public static void main(String[] args) {
		String prefixo = new String("UORGW89E");
		
		VariavelTO to = new VariavelTO();
		to.setNome("max-ocorr");
		to.setIsNumerica(true);
		
		ArrayList<VariavelTO> variaveis = new ArrayList<VariavelTO>();
		variaveis.add(to);
		
		to = new VariavelTO();
		to.setNome("CPSSOA-JURID");
		to.setIsNumerica(false);
		
		variaveis.add(to);
		
		to = new VariavelTO();
		to.setNome("max-ocorr");
		to.setIsNumerica(true);
		
		variaveis.add(to);
		
		Consistencia consistencia = new Consistencia();
		System.out.println(consistencia.consistir(variaveis, prefixo));
		
		//System.out.println(consistencia.getContador());

	}
}
