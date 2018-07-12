package geradores;

import java.util.ArrayList;

import modelos.VariavelTO;

public class GeraSaida {
	
	private ArrayList<String> listaMoves = new ArrayList<String>();
	private ArrayList<String> listaDeclaracao = new ArrayList<String>();
	GeraRedefines geraRedef = new GeraRedefines();
	private int ind = 0;
	private int ind2 = 0;
	private int indiceExist = 0;
	private boolean ultimoExist = false;
	private String declaracaoExist = "";
	
	public GeraSaida(String book1, String book2){
		String procedure = " ";
		procedure = "                                                                        \n";listaMoves.add(procedure);
		procedure = "      *================================================================*\n";listaMoves.add(procedure);
		procedure = "       PROCEDURE                       DIVISION.                        \n";listaMoves.add(procedure);
		procedure = "      *================================================================*\n";listaMoves.add(procedure);
		procedure = "                                                                        \n";listaMoves.add(procedure);
		procedure = "      *----------------------------------------------------------------*\n";listaMoves.add(procedure);
		procedure = "      *     ROTINA PARA MOVIMENTACAO                                   *\n";listaMoves.add(procedure);
		procedure = "      *----------------------------------------------------------------*\n";listaMoves.add(procedure);
		procedure = "       0000-ROTINA-MOVIMENTACAO        SECTION.                         \n";listaMoves.add(procedure);
		procedure = "      *----------------------------------------------------------------*\n";listaMoves.add(procedure);
		procedure = "                                                                        \n";listaMoves.add(procedure);

		procedure = "      *================================================================*\n";listaDeclaracao.add(procedure);
		procedure = "       WORKING-STORAGE                 SECTION.                         \n";listaDeclaracao.add(procedure);
		procedure = "      *================================================================*\n";listaDeclaracao.add(procedure);
		procedure = "                                                                        \n";listaDeclaracao.add(procedure);
		procedure = "      *----------------------------------------------------------------*\n";listaDeclaracao.add(procedure);
		procedure = "       01  FILLER                      PIC  X(050)         VALUE        \n";listaDeclaracao.add(procedure);
		procedure = "           'AREA DE DECLARACAO DE BOOKS'.                               \n";listaDeclaracao.add(procedure);
		procedure = "      *----------------------------------------------------------------*\n";listaDeclaracao.add(procedure);
		procedure = "                                                                        \n";listaDeclaracao.add(procedure);
		procedure = "           COPY '"+book1+"'.                                            \n";listaDeclaracao.add(procedure);
		procedure = "                                                                        \n";listaDeclaracao.add(procedure);
		procedure = "           COPY '"+book2+"'.                                            \n";listaDeclaracao.add(procedure);
		procedure = "                                                                        \n";listaDeclaracao.add(procedure);
		procedure = "      *----------------------------------------------------------------*\n";listaDeclaracao.add(procedure);
		procedure = "       01  FILLER                      PIC  X(050)         VALUE\n"        ;listaDeclaracao.add(procedure);
		procedure = "           'AREA PARA REDEFINES'.\n"                                       ;listaDeclaracao.add(procedure);
		procedure = "      *----------------------------------------------------------------*\n";listaDeclaracao.add(procedure);
		procedure = "                                                                        \n";listaDeclaracao.add(procedure);
		procedure = "       01  WRK-AREA-REDEFINES.\n"                                          ;listaDeclaracao.add(procedure);

	}

	public void geraListas(ArrayList<VariavelTO> listaOrigem, ArrayList<VariavelTO> listaDestino, int spaces ){
		ArrayList<String> listaAux = new ArrayList<String>();
		
		ind = 0;
		for (VariavelTO v1 : listaOrigem){		
			listaAux = geraRedef.gerarMovesRedefines(v1,listaDestino.get(ind),spaces);
			ind++;
			ind2 = 0;
			for (String s : listaAux){
				if  (ind2 == 0 || ind2 == 1){
					if (ultimoExist){
						addRedefinesAbaixo(s);
						ultimoExist = false;
					}else{
						if  (!verificaExistenciaVar(s)){					
							getListaDeclaracao().add(s);											
						}else if (ind2 == 0){
							declaracaoExist = s;
							ultimoExist = true;
						}
					}					
				}else{
					getListaMoves().add(s);
				}				
				ind2++;
			}
		}
	}
	
	public boolean verificaExistenciaVar(String s){
		int indiceAux = 0;
		for (String ss : listaDeclaracao){
			 if (ss.equals(s)){
				 setIndiceExist(indiceAux);
				 return true;
			 }	 
			 indiceAux++;
		}		
		
		return false;
	}
	
	public void addRedefinesAbaixo(String s){
		ArrayList<String> listaAuxAntes = new ArrayList<String>();
		ArrayList<String> listaAuxDepois = new ArrayList<String>();
		boolean para = false;
		for (String ss : listaDeclaracao){
			 if ((ss.equals(declaracaoExist))&&(!para)){
				 listaAuxDepois.add(ss);
				 listaAuxDepois.add(s);
				 para = true;
			 }else if (!para){
				 listaAuxAntes.add(ss);
			 }else{
				 listaAuxDepois.add(ss); 
			 }
		}
		//JUNTA LISTAS
		listaDeclaracao = new ArrayList<String>();
		for (String st: listaAuxAntes){
			listaDeclaracao.add(st);
		}
		for (String st: listaAuxDepois){
			listaDeclaracao.add(st);
		}
	}	

	public void setListaMoves(ArrayList<String> listaMoves) {
		this.listaMoves = listaMoves;
	}

	public ArrayList<String> getListaMoves() {
		return listaMoves;
	}

	public void setListaDeclaracao(ArrayList<String> listaDeclaracao) {
		this.listaDeclaracao = listaDeclaracao;
	}

	public ArrayList<String> getListaDeclaracao() {
		return listaDeclaracao;
	}

	public void setIndiceExist(int indiceExist) {
		this.indiceExist = indiceExist;
	}

	public int getIndiceExist() {
		return indiceExist;
	}
}