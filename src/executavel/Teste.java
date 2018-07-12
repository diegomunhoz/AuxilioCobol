package executavel;


import geradores.GeraSaida;
import io.ArquivoOutput;

import java.awt.List;
import java.util.ArrayList;

import modelos.ArquivoCblTO;
import modelos.VariavelTO;

public class Teste {

	public static void main(String[] args) {
	//	GeraSaida gs = new GeraSaida();
		ArrayList<String> lista = new ArrayList<String>();
		ArrayList<VariavelTO> listaOrigem = new ArrayList<VariavelTO>();
		ArrayList<VariavelTO> listaDestino = new ArrayList<VariavelTO>();
		
		Integer spaces = 12;
		VariavelTO v1 = new VariavelTO();
		VariavelTO v2 = new VariavelTO();
		
		// igual
		v1 = new VariavelTO();
        v2 = new VariavelTO();

		v1.setHaveDecimais(false);
		v1.setInteiro(8);
		v1.setIsNumerica(true);
		v1.setIsSinalizado(false);
		v1.isAlfaNumerica(false);
		v1.setNome("WRK-FAUSTO5");
		v1.setPic("9(008)");
		//v1.setDecimais(2);
		listaOrigem.add(v1);		
		
		v2.setHaveDecimais(false);
		v2.setInteiro(8);
		v2.setIsNumerica(true);
		v2.setIsSinalizado(false);
		v2.isAlfaNumerica(false);
		v2.setNome("WRK-FAUSTO5");
		v2.setPic("9(008)");
		//v2.setDecimais(2);
		listaDestino.add(v2);	
		
		v1 = new VariavelTO();
        v2 = new VariavelTO();
		
		// ED - S99ToX
		v1.setHaveDecimais(false);
		v1.setInteiro(10);
		v1.setIsNumerica(true);
		v1.setIsSinalizado(false);
		v1.isAlfaNumerica(false);
		v1.setNome("WRK-ED-001");
		v1.setPic("S9(010)");

		v2.setHaveDecimais(false);
		v2.setInteiro(9);
		v2.setIsNumerica(false);
		v2.setIsSinalizado(false);
		v2.isAlfaNumerica(true);
		v2.setNome("WRK-DESTINO");
		v2.setPic("X(009)");

		listaOrigem.add(v1);
		listaDestino.add(v2);

		// igual
		v1 = new VariavelTO();
        v2 = new VariavelTO();

		v1.setHaveDecimais(false);
		v1.setInteiro(8);
		v1.setIsNumerica(false);
		v1.setIsSinalizado(false);
		v1.isAlfaNumerica(true);
		v1.setNome("WRK-FAUSTO5");
		v1.setPic("X(008)");
		//v1.setDecimais(2);
		listaOrigem.add(v1);		
		
		v2.setHaveDecimais(false);
		v2.setInteiro(8);
		v2.setIsNumerica(false);
		v2.setIsSinalizado(false);
		v2.isAlfaNumerica(true);
		v2.setNome("WRK-FAUSTO5");
		v2.setPic("X(008)");
		//v1.setDecimais(2);
		listaDestino.add(v2);			
		
		// ED - _9V9ToX
		v1 = new VariavelTO();
		v2 = new VariavelTO();
		v1.setHaveDecimais(true);
		v1.setInteiro(10);
		v1.setDecimais(1);
		v1.setIsNumerica(true);
		v1.setIsSinalizado(false);
		v1.isAlfaNumerica(false);
		v1.setNome("WRK-ED-002");
		v1.setPic("9(010)V9(001)");

		v2.setHaveDecimais(false);
		v2.setInteiro(10);
		v2.setIsNumerica(false);
		v2.setIsSinalizado(false);
		v2.isAlfaNumerica(true);
		v2.setNome("WRK-DESTINO");
		v2.setPic("X(010)");

		listaOrigem.add(v1);
		listaDestino.add(v2);

		// ED - _9V9ToXX
		v1 = new VariavelTO();
		v2 = new VariavelTO();
		v1.setHaveDecimais(true);
		v1.setInteiro(10);
		v1.setDecimais(1);
		v1.setIsNumerica(true);
		v1.setIsSinalizado(false);
		v1.isAlfaNumerica(false);
		v1.setNome("WRK-ED-003");
		v1.setPic("9(010)V9(001)");

		v2.setHaveDecimais(false);
		v2.setInteiro(12);
		v2.setIsNumerica(false);
		v2.setIsSinalizado(false);
		v2.isAlfaNumerica(true);
		v2.setNome("WRK-DESTINO");
		v2.setPic("X(012)");

		listaOrigem.add(v1);
		listaDestino.add(v2);

		// igual
		v1 = new VariavelTO();
        v2 = new VariavelTO();

		v1.setHaveDecimais(false);
		v1.setInteiro(8);
		v1.setIsNumerica(false);
		v1.setIsSinalizado(false);
		v1.isAlfaNumerica(true);
		v1.setNome("WRK-FAUSTO5");
		v1.setPic("X(008)");
		//v1.setDecimais(2);
		listaOrigem.add(v1);		
		
		v2.setHaveDecimais(false);
		v2.setInteiro(8);
		v2.setIsNumerica(false);
		v2.setIsSinalizado(false);
		v2.isAlfaNumerica(true);
		v2.setNome("WRK-FAUSTO5");
		v2.setPic("X(008)");
		//v1.setDecimais(2);
		listaDestino.add(v2);			
		
		// ED - S99V9ToX
		v1 = new VariavelTO();
		v2 = new VariavelTO();
		v1.setHaveDecimais(true);
		v1.setInteiro(10);
		v1.setDecimais(1);
		v1.setIsNumerica(true);
		v1.setIsSinalizado(true);
		v1.isAlfaNumerica(false);
		v1.setNome("WRK-ED-004");
		v1.setPic("S9(010)V9(001)");

		v2.setHaveDecimais(false);
		v2.setInteiro(8);
		v2.setIsNumerica(false);
		v2.setIsSinalizado(false);
		v2.isAlfaNumerica(true);
		v2.setNome("WRK-DESTINO");
		v2.setPic("X(008)");

		listaOrigem.add(v1);
		listaDestino.add(v2);

		// ED - _9ToX
		v1 = new VariavelTO();
		v2 = new VariavelTO();
		v1.setHaveDecimais(false);
		v1.setInteiro(10);
		v1.setIsNumerica(true);
		v1.setIsSinalizado(false);
		v1.isAlfaNumerica(false);
		v1.setNome("WRK-ED-005");
		v1.setPic("9(010)");

		v2.setHaveDecimais(false);
		v2.setInteiro(10);
		v2.setIsNumerica(false);
		v2.setIsSinalizado(false);
		v2.isAlfaNumerica(true);
		v2.setNome("WRK-DESTINO");
		v2.setPic("X(010)");

		listaOrigem.add(v1);
		listaDestino.add(v2);

		// Andre 99to9
		v1 = new VariavelTO();
		v2 = new VariavelTO();
		v1.setHaveDecimais(false);
		v1.setInteiro(9);
		v1.setDecimais(1);
		v1.setIsNumerica(true);
		v1.setIsSinalizado(false);
		v1.isAlfaNumerica(false);
		v1.setNome("WRK-ANDRE1");
		v1.setPic("9(009)");

		v2.setHaveDecimais(false);
		v2.setInteiro(2);
		v2.setDecimais(1);
		v2.setIsNumerica(true);
		v2.setIsSinalizado(false);
		v2.isAlfaNumerica(false);
		v2.setNome("WRK-DESTINO");
		v2.setPic("9(002)");

		listaOrigem.add(v1);
		listaDestino.add(v2);

		// Andre 99toX
		v1 = new VariavelTO();
		v2 = new VariavelTO();
		v1.setHaveDecimais(false);
		v1.setInteiro(9);
		v1.setDecimais(1);
		v1.setIsNumerica(true);
		v1.setIsSinalizado(false);
		v1.isAlfaNumerica(false);
		v1.setNome("WRK-ANDRE2");
		v1.setPic("9(009)");

		v2.setHaveDecimais(false);
		v2.setInteiro(2);
		v2.setDecimais(1);
		v2.setIsNumerica(true);
		v2.setIsSinalizado(false);
		v2.isAlfaNumerica(false);
		v2.setNome("WRK-DESTINO");
		v2.setPic("X(002)");

		listaOrigem.add(v1);
		listaDestino.add(v2);

		// Andre S99To99
		v1 = new VariavelTO();
		v2 = new VariavelTO();
		v1.setHaveDecimais(false);
		v1.setInteiro(9);
		//v1.setDecimais(1);
		v1.setIsNumerica(true);
		v1.setIsSinalizado(true);
		v1.isAlfaNumerica(false);
		v1.setNome("WRK-ANDRE3");
		v1.setPic("S9(009)");

		listaOrigem.add(v1);

		v2.setHaveDecimais(false);
		v2.setInteiro(9);
		//v2.setDecimais(1);
		v2.setIsNumerica(true);
		v2.setIsSinalizado(false);
		v2.isAlfaNumerica(false);
		v2.setNome("WRK-DESTINO");
		v2.setPic("9(009)");

		listaDestino.add(v2);

		// Andre _99V9ToS9V9
		v1 = new VariavelTO();
		v2 = new VariavelTO();
		v1.setHaveDecimais(true);
		v1.setInteiro(9);
		v1.setDecimais(2);
		v1.setIsNumerica(true);
		v1.setIsSinalizado(false);
		v1.isAlfaNumerica(false);
		v1.setNome("WRK-ANDRE4");
		v1.setPic("9(009)V9(002)");

		listaOrigem.add(v1);

		v2.setHaveDecimais(true);
		v2.setInteiro(2);
		v2.setDecimais(2);
		v2.setIsNumerica(true);
		v2.setIsSinalizado(true);
		v2.isAlfaNumerica(false);
		v2.setNome("WRK-DESTINO");
		v2.setPic("S9(002)V9(002)");

		listaDestino.add(v2);

		// Andre S99V9To9V9
		v1 = new VariavelTO();
		v2 = new VariavelTO();
		v1.setHaveDecimais(true);
		v1.setInteiro(9);
		v1.setDecimais(2);
		v1.setIsNumerica(true);
		v1.setIsSinalizado(true);
		v1.isAlfaNumerica(false);
		v1.setNome("WRK-ANDRE5");
		v1.setPic("S9(009)V9(002)");

		listaOrigem.add(v1);

		v2.setHaveDecimais(true);
		v2.setInteiro(2);
		v2.setDecimais(2);
		v2.setIsNumerica(true);
		v2.setIsSinalizado(false);
		v2.isAlfaNumerica(false);
		v2.setNome("WRK-DESTINO");
		v2.setPic("9(002)V9(002)");

		listaDestino.add(v2);

		// Lucas S9V9ToS9
		v1 = new VariavelTO();
		v2 = new VariavelTO();
		v1.setDecimais(2);
		v1.setInteiro(3);
		v1.setNome("WRK-LUCAS-1");
		v1.setHaveDecimais(true);
		v1.setIsNumerica(true);
		v1.setIsSinalizado(true);
		v1.isAlfaNumerica(false);
		v1.setPic("S9(003)V9(002)");

		listaOrigem.add(v1);

		v2.setInteiro(3);
		v2.setNome("Var3");
		v2.setHaveDecimais(false);
		v2.setIsNumerica(true);
		v2.setIsSinalizado(true);
		v2.isAlfaNumerica(false);
		v2.setPic("S9(003)");

		listaDestino.add(v2);

		// Lucas S99ToS9
		v1 = new VariavelTO();
		v2 = new VariavelTO();
		v1.setInteiro(5);
		v1.setNome("WRK-LUCAS-2");
		v1.setHaveDecimais(false);
		v1.setIsNumerica(true);
		v1.setIsSinalizado(true);
		v1.isAlfaNumerica(false);
		v1.setPic("S9(005)");

		listaOrigem.add(v1);

		v2.setInteiro(3);
		v2.setNome("Var3");
		v2.setHaveDecimais(false);
		v2.setIsNumerica(true);
		v2.setIsSinalizado(true);
		v2.isAlfaNumerica(false);
		v2.setPic("S9(003)");

		listaDestino.add(v2);

		// Lucas S99To99V99
		v1 = new VariavelTO();
		v2 = new VariavelTO();
		v1.setInteiro(5);
		v1.setNome("WRK-LUCAS-3");
		v1.setHaveDecimais(false);
		v1.setIsNumerica(true);
		v1.setIsSinalizado(true);
		v1.isAlfaNumerica(false);
		v1.setPic("S9(005)");

		listaOrigem.add(v1);

		v2.setInteiro(5);
		v2.setNome("Var3");
		v2.setHaveDecimais(true);
		v2.setDecimais(2);
		v2.setIsNumerica(true);
		v2.setIsSinalizado(false);
		v2.isAlfaNumerica(false);
		v2.setPic("9(005)V9(002)");

		listaDestino.add(v2);

		// Lucas S99V9ToS9V9
		v1 = new VariavelTO();
		v2 = new VariavelTO();
		v1.setDecimais(2);
		v1.setInteiro(5);
		v1.setNome("WRK-LUCAS-4");
		v1.setHaveDecimais(true);
		v1.setIsNumerica(true);
		v1.setIsSinalizado(true);
		v1.isAlfaNumerica(false);
		v1.setPic("S9(005)V9(002)");

		listaOrigem.add(v1);

		v2.setDecimais(2);
		v2.setInteiro(3);
		v2.setNome("Var2");
		v2.setHaveDecimais(true);
		v2.setIsNumerica(true);
		v2.setIsSinalizado(true);
		v2.isAlfaNumerica(false);
		v2.setPic("S9(003)V9(002)");

		listaDestino.add(v2);

		// Lucas S99V9ToS9
		v1 = new VariavelTO();
		v2 = new VariavelTO();
		v1.setDecimais(2);
		v1.setInteiro(5);
		v1.setNome("WRK-LUCAS-5");
		v1.setHaveDecimais(true);
		v1.setIsNumerica(true);
		v1.setIsSinalizado(true);
		v1.isAlfaNumerica(false);
		v1.setPic("S9(005)V9(002)");

		listaOrigem.add(v1);

		// v2.setDecimais(2);
		v2.setInteiro(3);
		v2.setNome("Var2");
		v2.setHaveDecimais(false);
		v2.setIsNumerica(true);
		v2.setIsSinalizado(true);
		v2.isAlfaNumerica(false);
		v2.setPic("S9(003)");

		listaDestino.add(v2);

		// Bruno _99V9ToX
		v1 = new VariavelTO();
		v2 = new VariavelTO();

		v1.setHaveDecimais(true);
		v1.setInteiro(5);
		v1.setDecimais(2);
		v1.setIsNumerica(true);
		v1.setIsSinalizado(false);
		v1.setNome("WRK-BRUNO1");
		v1.setPic("9(005)V(002)");

		v2.setInteiro(3);
		v2.setIsNumerica(false);
		v2.setIsSinalizado(false);
		v2.setNome("WRK-DESTINO");
		v2.setPic("X(003)");

		listaOrigem.add(v1);
		listaDestino.add(v2);

		// Bruno_99V9To9V9
		v1.setHaveDecimais(true);
		v1.setInteiro(5);
		v1.setDecimais(2);
		v1.setIsNumerica(true);
		v1.setIsSinalizado(false);
		v1.setNome("WRK-BRUNO2");
		v1.setPic("9(005)V(002)");

		v2.setDecimais(2);
		v2.setHaveDecimais(true);
		v2.setInteiro(3);
		v2.setIsNumerica(true);
		v2.setIsSinalizado(false);
		v2.setNome("WRK-DESTINO");
		v2.setPic("9(003)V(002)");

		listaOrigem.add(v1);
		listaDestino.add(v2);

		// Bruno S9V9ToX
		v1.setHaveDecimais(true);
		v1.setInteiro(5);
		v1.setDecimais(2);
		v1.setIsNumerica(true);
		v1.setIsSinalizado(true);
		v1.setNome("WRK-BRUNO3");
		v1.setPic("9(005)V(002)");

		v2.setHaveDecimais(false);
		v2.setInteiro(5);
		v2.setIsNumerica(false);
		v2.setIsSinalizado(false);
		v2.setNome("WRK-DESTINO");
		v2.setPic("9(005)");

		listaOrigem.add(v1);
		listaDestino.add(v2);

		// Bruno _99To9

		v1.setInteiro(5);
		v1.setIsNumerica(true);
		v1.setNome("WRK-BRUNO4");
		v1.setPic("9(005)");

		v2.setHaveDecimais(false);
		v2.setInteiro(3);
		v2.setIsNumerica(true);
		v2.setIsSinalizado(false);
		v2.setNome("WRK-DESTINO");
		v2.setPic("9(003)");

		listaOrigem.add(v1);
		listaDestino.add(v2);

		// Fausto s9V9TO9V9
		v1 = new VariavelTO();
        v2 = new VariavelTO();
        v1.setHaveDecimais(true);
        v1.setInteiro(14);
        v1.setIsNumerica(true);
        v1.setIsSinalizado(true);
        v1.isAlfaNumerica(false);
        v1.setNome("WRK-FAUSTO1");
        v1.setPic("X(006)");
        v1.setDecimais(2);
        listaOrigem.add(v1);
        v2.setHaveDecimais(true);
        v2.setInteiro(14);
        v2.setIsNumerica(true);
        v2.setIsSinalizado(false);
        v2.isAlfaNumerica(false);
        v2.setNome("WRK-DESTINO");
        v2.setPic("X(006)");
        v2.setDecimais(2);
	    listaDestino.add(v2);
		
		// Fausto xXTOX
		v1 = new VariavelTO();
        v2 = new VariavelTO();

        v1.setHaveDecimais(false);
        v1.setInteiro(16);
        v1.setIsNumerica(false);
        v1.setIsSinalizado(false);
        v1.isAlfaNumerica(true);
        v1.setNome("WRK-FAUSTO2");
        v1.setPic("X(016)");
        //v1.setDecimais(2);
        listaOrigem.add(v1);
        v2.setHaveDecimais(false);
        v2.setInteiro(10);
        v2.setIsNumerica(false);
        v2.setIsSinalizado(false);
        v2.isAlfaNumerica(true);
        v2.setNome("WRK-DESTINO");
        v2.setPic("X(010)");
		listaDestino.add(v2);
		
		// Fausto xTO9V9
		v1 = new VariavelTO();
        v2 = new VariavelTO();
		
        v1.setHaveDecimais(false);
        v1.setInteiro(16);
        v1.setIsNumerica(false);
        v1.setIsSinalizado(false);
        v1.isAlfaNumerica(true);
        v1.setNome("WRK-FAUSTO3");
        v1.setPic("X(016)");
        //v1.setDecimais(2);
        listaOrigem.add(v1);
        v2.setHaveDecimais(true);
        v2.setInteiro(16);
        v2.setIsNumerica(true);
        v2.setIsSinalizado(false);
        v2.isAlfaNumerica(false);
        v2.setNome("WRK-DESTINO");
        v2.setPic("9(016)");
        v2.setDecimais(2);
        listaDestino.add(v2);
        
		// Fausto xTOS9
		v1 = new VariavelTO();
        v2 = new VariavelTO();
		
        v1.setHaveDecimais(false);
        v1.setInteiro(14);
        v1.setIsNumerica(false);
        v1.setIsSinalizado(false);
        v1.isAlfaNumerica(true);
        v1.setNome("WRK-FAUSTO4");
        v1.setPic("X(014)");
        //v1.setDecimais(2);
        listaOrigem.add(v1);
        v2.setHaveDecimais(false);
        v2.setInteiro(14);
        v2.setIsNumerica(true);
        v2.setIsSinalizado(true);
        v2.isAlfaNumerica(false);
        v2.setNome("WRK-DESTINO");
        v2.setPic("S9(014)");
        //v2.setDecimais(2);
        listaDestino.add(v2);	
        
		
		
		// Fausto xTOS9
		v1 = new VariavelTO();
        v2 = new VariavelTO();
		
        v1.setHaveDecimais(false);
        v1.setInteiro(14);
        v1.setIsNumerica(false);
        v1.setIsSinalizado(false);
        v1.isAlfaNumerica(true);
        v1.setNome("WRK-FAUSTO4");
        v1.setPic("X(014)");
        //v1.setDecimais(2);
        listaOrigem.add(v1);
        v2.setHaveDecimais(false);
        v2.setInteiro(14);
        v2.setIsNumerica(true);
        v2.setIsSinalizado(true);
        v2.isAlfaNumerica(false);
        v2.setNome("WRK-DESTINO");
        v2.setPic("S9(014)");
        //v2.setDecimais(2);
        listaDestino.add(v2);	
        
		// Fausto xXTOS9
		v1 = new VariavelTO();
        v2 = new VariavelTO();

		v1.setHaveDecimais(false);
		v1.setInteiro(8);
		v1.setIsNumerica(false);
		v1.setIsSinalizado(false);
		v1.isAlfaNumerica(true);
		v1.setNome("WRK-FAUSTO5");
		v1.setPic("X(008)");
		//v1.setDecimais(2);
		listaOrigem.add(v1);
		v2.setHaveDecimais(false);
		v2.setInteiro(5);
		v2.setIsNumerica(true);
		v2.setIsSinalizado(true);
		v2.isAlfaNumerica(false);
		v2.setNome("WRK-DESTINO");
		v2.setPic("S9(005)");
		//v2.setDecimais(2);
		listaDestino.add(v2);		
		
		//gs.geraListas(listaOrigem, listaDestino, spaces);
		
	//	lista = gs.getListaDeclaracao();
		
		ArquivoOutput out = new ArquivoOutput();
		
		ArquivoCblTO to = new ArquivoCblTO();
		
		StringBuffer b = new StringBuffer();
		
		//for (String s : gs.getListaMoves()){
		//	b.append(s);
		//}		
		to.setArquivoEmString(b);
		to.setNomeArquivo("qualqer.alguma");
		ArrayList<ArquivoCblTO> listArquivoCblTO = new ArrayList<ArquivoCblTO>();		
		listArquivoCblTO.add(to);
		
		try {
			out.salvarArquivo(listArquivoCblTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (String s : lista){
			System.out.print(s);
		}
		
		
		//lista = gs.getListaMoves();

		for (String s : lista){
			System.out.print(s);
		}
	}

}