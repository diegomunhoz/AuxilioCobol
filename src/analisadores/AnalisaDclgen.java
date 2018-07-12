package analisadores;

import java.util.ArrayList;
import java.util.List;

import modelos.DclgenTO;
import modelos.VariavelTO;
import util.MensagensFactory;

public class AnalisaDclgen {

	private String[] linhaAux;
	private List<VariavelTO> vars = new ArrayList<VariavelTO>(), varsAux = new ArrayList<VariavelTO>();
	private int x;
	private String nomeTabela;
	private DclgenTO dclgen;
	VariavelTO aux;
	private boolean pula;

	public DclgenTO ler(String nomeBook, List<String> book) throws Exception {
		return leituraDclgen(nomeBook, book);
	}

	/**
	 * Metodo para leitura e classificação de DCLGENs
	 */
	private DclgenTO leituraDclgen(String nomeBook, List<String> book) throws Exception {
		nomeBook = nomeBook.replace(".CPY", "");
		x = 0;
		for (String linha : book) {
			if(linha.trim().startsWith("(") && linha.contains(",")){
				x = 1;
			}
			if(!linha.trim().contains("END-EXEC.")){
				if (!linha.trim().equals(")")){
					if (!linha.trim().equals("")){
						if (!linha.trim().contains(nomeBook + ".")){
							if(!linha.trim().startsWith("*")){
								if (x == 2) {
									try{
										aux = new VariavelTO();
										// separando o nivel da variavel do resto da linha	
										aux.setNivel(encontraNivel(linha));
										// lendo o nome da variavel
										aux.setNome(encontraNome());
										if(linha.contains("PIC")){
											// separando a palavra "PIC" do restante da linha e lendo o tipo
											// da variavel
											aux.setPic(encontraPic());
											detalhaPic();
										}else{
											aux.setIsItenDeGrupo(true);
										}
										passaIsNotNull(aux.getNome());
										vars.add(aux);
									}catch(NumberFormatException e){
										throw new Exception(MensagensFactory.mensagemDeErroPicDesalinhada);
									}
								} else if (x == 1) {
									verificaNotNull(linha);
								} else {
									encotraNomeTabela(linha);
								}

							}
						}
					}
					if (linha.trim().equals("(")) {
						x = 1;
					}
					if (linha.contains(nomeBook + ".")) {
						x = 2;
					}
				}
			}
		}
		dclgen = new DclgenTO();
		dclgen.setNomeDaDclgen(nomeBook);
		dclgen.setNomeDaTabela(nomeTabela);
		picVarDeGrupo();
		dclgen.setVariaveisDaDCLGEN(vars);
		return dclgen;
	}

	private void verificaNotNull(String s) {
		s = s.trim();
		if(!pula){
			if (s.contains("NOT NULL")) {
				aux = new VariavelTO();
				if(s.trim().startsWith("(")){
					s = s.replace("(", " ").trim();	
				}	
				aux.setNome(s.replaceFirst(" ", "¥").split("¥")[0]);
				aux.setIsNotNull(true);
				varsAux.add(aux);
			} else if (!s.endsWith(",")){
				aux = new VariavelTO();
				if(s.trim().startsWith("(")){
					s = s.replace("(", "").trim();
				}
				aux.setNome(s.replaceFirst(" ", "¥").split("¥")[0]);
				varsAux.add(aux);
				pula = true;
			} else{
				aux = new VariavelTO();
				if(s.trim().startsWith("(")){
					s = s.replace("(", "").trim();
				}
				aux.setNome(s.replaceFirst(" ", "¥").split("¥")[0]);
				varsAux.add(aux);
			}
		}else{
			if (s.endsWith(",") || s.contains("NOT NULL")){
				varsAux.get(varsAux.size()-1).setIsNotNull(true);
			}else{
				varsAux.get(varsAux.size()-1).setIsNotNull(false);
			}
			pula = false;
		}
	}

	private int encontraNivel(String linha){
		linhaAux = linha.trim().replaceFirst(" ", "¥").split("¥");
		return Integer.parseInt(linhaAux[0]);
	}

	private String encontraNome(){
		linhaAux = linhaAux[1].trim().replaceFirst(" ", "¥").split("¥");
		if(linhaAux[0].endsWith(".")){
			linhaAux[0] = linhaAux[0].replace(".", "");
		}
		return linhaAux[0].replaceAll("-", "_");
	}

	private String encontraPic(){
		linhaAux[1] = linhaAux[1].trim().substring(4);
		linhaAux = linhaAux[1].trim().replaceFirst(" ", "¥").replace(
				".", "¥").split("¥");
		if (linhaAux[0].contains("S")) {
			aux.setIsSinalizado(true);			
			linhaAux[0] = linhaAux[0].replace("S", "").trim();
		}
		if (linhaAux[0].endsWith("V")){
			linhaAux[0] = linhaAux[0].replace("V", "").trim();
		}
		return linhaAux[0];
	}

	private void detalhaPic(){
		if(aux.getPic().startsWith("X")){
			aux.isAlfaNumerica(true);
			if(aux.getPic().contains("(")){
				aux.setInteiro(Integer.parseInt(aux.getPic().replace("X", "").replace("(", "").replace(")", "")));	
			}else{
				aux.setInteiro(aux.getPic().length());
			}
		} else if(aux.getPic().startsWith("9")){
			aux.setIsNumerica(true);
			if(aux.getPic().contains("V")){
				aux.setHaveDecimais(true);
				if(aux.getPic().split("V")[0].contains("(")){
					aux.setInteiro(Integer.parseInt(aux.getPic().split("V")[0].replaceFirst("9", "").replace("(", "").replace(")", "")));	
				}else{
					aux.setInteiro(aux.getPic().split("V")[0].length());
				}										
				if(aux.getPic().split("V")[1].contains("(")){
					aux.setDecimais(Integer.parseInt(aux.getPic().split("V")[1].replaceFirst("9", "").replace("(", "").replace(")", "")));	
				}else{
					aux.setDecimais(aux.getPic().split("V")[1].length());
				}								
			}else{
				if(aux.getPic().contains("(")){
					aux.setInteiro(Integer.parseInt(aux.getPic().replaceFirst("9", "").replace("(", "").replace(")", "")));	
				}else{
					aux.setInteiro(aux.getPic().length());
				}
			}
		}
	}

	private void encotraNomeTabela(String linha){
		linhaAux = linha.trim().replaceAll(" ", "¥").split("¥");
		for (String a : linhaAux) {
			if (a.contains(".")) {
				nomeTabela = a;
			}
		}
	}

	private void passaIsNotNull(String nome){
		for(VariavelTO v : varsAux){
			if(nome.equals(v.getNome())){
				aux.setIsNotNull(v.isNotNull());
			}
		}
	}

	private void picVarDeGrupo(){
		int total=0, nivelBase;
		nivelBase = vars.get(0).getNivel();
		for (int i=vars.size()-1; i>=0; i--){
			if(!vars.get(i).isItenDeGrupo()){
				if(nivelBase != vars.get(i).getNivel()){
					total = total + vars.get(i).getInteiro();
					if(vars.get(i).getDecimais() != null){
						total = total + vars.get(i).getDecimais();
					}
				}
			}else{
				vars.get(i).setInteiro(total);
				vars.get(i).isAlfaNumerica(true);
				if(i > 0){
					if (nivelBase == vars.get(i-1).getNivel()){
						total = 0;
					}	
				}
			}
		}
	}

}
