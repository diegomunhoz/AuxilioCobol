package geradores;

import java.util.ArrayList;
import java.util.List;

import util.UtilProjeto;
import modelos.VariavelTO;

public class GeraRedefines {

	
	public ArrayList<String> gerarMovesRedefines(VariavelTO v1, VariavelTO v2, Integer spaces){
		
		ArrayList<String> lista = new ArrayList<String>();
		
			if (v1.isNumerica() && v2.isNumerica()) {

				if (v1.isSinalizado() && v2.isSinalizado()) {

					if (v1.haveDecimais() && v2.haveDecimais()) {

						if (v1.getInteiro() == v2.getInteiro()) {

							if (v1.getDecimais() == v2.getDecimais()) {
								lista = (ArrayList<String>) VARIguais(v1,v2,spaces);
							} else if (v1.getDecimais() < v2.getDecimais()) {
								lista = (ArrayList<String>) VARIguais(v1,v2,spaces);
							} else if (v1.getDecimais() > v2.getDecimais()) {								
								String s = v1.getPic()+" to "+v2.getPic()+"? ?";
								lista.add(s);
								//----------BRUNO - NÃO FAZER
								// chamar método redefinir pois ambos são
								// sinalizadas de inteiro igual a origem para
								// decimal menor (ex: S9V99 para S9V9)
							}

						} else if (v1.getInteiro() < v2.getInteiro()) {
							if (v1.getDecimais() == v2.getDecimais()) {
								lista = (ArrayList<String>) VARIguais(v1,v2,spaces);
							} else if (v1.getDecimais() < v2.getDecimais()) {
								lista = (ArrayList<String>) VARIguais(v1,v2,spaces);
							} else if (v1.getDecimais() > v2.getDecimais()) {
								String s = v1.getPic()+" to "+v2.getPic()+"? ?";
								lista.add(s);
								//----------BRUNO - NÃO FAZER
								// chamar método redefinir pois ambos são
								// sinalizadas (de inteiro menor origem), pois
								// decimal de origem é maior que decimal de
								// destino (ex: S9V99 para S99V9)
							}
						} else {							
							if (v1.getDecimais() == v2.getDecimais()) {	
								lista = (ArrayList<String>) S99V9ToS9V9(v1, v2, spaces);								
							} else if (v1.getDecimais() < v2.getDecimais()) {
								String s = v1.getPic()+" to "+v2.getPic()+"? ?";
								lista.add(s);
								//ED - CANCELADO
								// chamar método redefinir pois ambos são
								// sinalizadas, inteiro origem é maior que
								// inteiro destino,(obs - decimais de origem é
								// menor que decimais de destino), ex: S99V9
								// para S9V99
							} else if (v1.getDecimais() > v2.getDecimais()) {
								String s = v1.getPic()+" to "+v2.getPic()+"? ?";
								lista.add(s);
								//CANCELADO
								// lucas - não feito
							}
						}
					} else if (v1.haveDecimais()) {
						if (v1.getInteiro() == v2.getInteiro()) {
							lista = (ArrayList<String>) S9V9ToS9(v1,v2,spaces);							
						} else if (v1.getInteiro() < v2.getInteiro()) {
							lista = (ArrayList<String>) S9V9ToS9(v1,v2,spaces);
						} else if (v1.getInteiro() > v2.getInteiro()) {
							lista = (ArrayList<String>) S99V9ToS9(v1,v2,spaces);							
						}
					} else if (v2.haveDecimais()) {
						if (v1.getInteiro() == v2.getInteiro()) {
							lista = (ArrayList<String>) VARIguais(v1,v2,spaces);
						} else if (v1.getInteiro() > v2.getInteiro()) {
							lista = (ArrayList<String>) S99ToS9(v1,v2,spaces);
						} else if (v1.getInteiro() < v2.getInteiro()) {							
							lista = (ArrayList<String>) VARIguais(v1,v2,spaces);
						}
					} else {
						if (v1.getInteiro() == v2.getInteiro()) {
							lista = (ArrayList<String>) VARIguais(v1,v2,spaces);
						} else if (v1.getInteiro() < v2.getInteiro()) {
							lista = (ArrayList<String>) VARIguais(v1,v2,spaces);
						} else if (v1.getInteiro() > v2.getInteiro()) {
							lista = (ArrayList<String>) S99ToS9(v1,v2,spaces);
						}
					}
				} else if (v1.isSinalizado()) {
					if (v1.haveDecimais() && v2.haveDecimais()) {

						if (v1.getInteiro() == v2.getInteiro()) {

							if (v1.getDecimais() == v2.getDecimais()) {
								lista = (ArrayList<String>) S9V9To9V9(v1,v2,spaces);
							} else if (v1.getDecimais() < v2.getDecimais()) {
								String s = v1.getPic()+" to "+v2.getPic()+"? ?";
								lista.add(s);
								//CANCELADO
								// chamar método redefinir para tirar o sinal da
								// origem pois destino não tem sinal(ex: S9V9
								// para 9V99)
							} else if (v1.getDecimais() > v2.getDecimais()) {
								String s = v1.getPic()+" to "+v2.getPic()+"? ?";
								lista.add(s);
								//CANCELADO
								// chamar método redefinir para tirar o sinal da
								// origem pois destino não tem sinal e decimal
								// de origem é maior que destino(ex: S9V99 para
								// 9V9)
							}

						} else if (v1.getInteiro() < v2.getInteiro()) {
							if (v1.getDecimais() == v2.getDecimais()) {								
								lista = (ArrayList<String>) S9V9To9V9(v1, v2, spaces);
							} else if (v1.getDecimais() < v2.getDecimais()) {
								String s = v1.getPic()+" to "+v2.getPic()+"? ?";
								lista.add(s);
								//CANCELADO - ANDRE
								// chamar método redefinir para tirar o sinal da
								// origem pois destino não tem sinal (ex: S9V9
								// para 99V99)
							} else if (v1.getDecimais() > v2.getDecimais()) {
								String s = v1.getPic()+" to "+v2.getPic()+"? ?";
								lista.add(s);
								//CANCELADO - ANDRE
								// chamar método redefinir para tirar o sinal da
								// origem pois destino não tem sinal e decimal
								// da origem é maior que o decimal do destino
								// (ex: S9V99 para 99V9)
							}
						} else if (v1.getInteiro() > v2.getInteiro()) {
							if (v1.getDecimais() == v2.getDecimais()) {
								lista = (ArrayList<String>) S99V9To9V9(v1,v2,spaces);
							} else if (v1.getDecimais() < v2.getDecimais()) {
								String s = v1.getPic()+" to "+v2.getPic()+"? ?";
								lista.add(s);
								//CANCELADO - ANDRE
								// chamar método redefinir para tirar o sinal da
								// origem pois destino não tem sinal e inteiro
								// da origem é maior que inteiro do destino(ex:
								// S99V9 para 9V99)
							} else if (v1.getDecimais() > v2.getDecimais()) {
								String s = v1.getPic()+" to "+v2.getPic()+"? ?";
								lista.add(s);
								//CANCELADO - ANDRE
								// chamar método redefinir para tirar o sinal da
								// origem pois destino não tem sinal e inteiro
								// da origem é maior que inteiro do destino e
								// decimal da origem é maior que decimal do
								// destino(ex: S99V99 para 9V9)
							}
						}
					}else if (!v1.haveDecimais() && !v2.haveDecimais()){
						if (v1.getInteiro() == v2.getInteiro()){
							 lista = (ArrayList<String>) S99To99(v1,v2,spaces);							  
						  }
					}else if (v2.haveDecimais()){
						if (v1.getInteiro() == v2.getInteiro()){
							lista = (ArrayList<String>) S99To99V99(v1,v2,spaces);
							  
						  }						
					}

				} else if (v2.isSinalizado()) {
					if (v1.haveDecimais() && v2.haveDecimais()) {

						if (v1.getInteiro() == v2.getInteiro()) {

							if (v1.getDecimais() == v2.getDecimais()) {
								lista = (ArrayList<String>) VARIguais(v1,v2,spaces);
							} else if (v1.getDecimais() < v2.getDecimais()) {
								lista = (ArrayList<String>) VARIguais(v1,v2,spaces);
							} else if (v1.getDecimais() > v2.getDecimais()) {
								String s = v1.getPic()+" to "+v2.getPic()+"? ?";
								lista.add(s);
								//CANCELADO - ANDRE
								// chamar método redefinir pois os decimais da
								// origem são maiores que o do destino, destino
								// é sinalizado (ex: 9V99 to S9V9)
							}

						} else if (v1.getInteiro() < v2.getInteiro()) {
							if (v1.getDecimais() == v2.getDecimais()) {
								lista = (ArrayList<String>) VARIguais(v1,v2,spaces);
							} else if (v1.getDecimais() < v2.getDecimais()) {
								lista = (ArrayList<String>) VARIguais(v1,v2,spaces);
							} else if (v1.getDecimais() > v2.getDecimais()) {
								String s = v1.getPic()+" to "+v2.getPic()+"? ?";
								lista.add(s);
								//CANCELADO - ANDRE
								// chamar método redefinir pois os decimais da
								// origem são maiores que o do destino, destino
								// é sinalizado (ex: 9V99 to S99V9)
							}
						} else if (v1.getInteiro() > v2.getInteiro()) {
							if (v1.getDecimais() == v2.getDecimais()) {
								lista = (ArrayList<String>) _99V9ToS9V9(v1,v2,spaces);
								
							} else if (v1.getDecimais() < v2.getDecimais()) {
								String s = v1.getPic()+" to "+v2.getPic()+"? ?";
								lista.add(s);
								//CANCELADO - ANDRE
								// chamar método redefinir, pois o inteiro da
								// origem é maior que o inteiro do destino, o
								// destino é sinalizado e a origem não, ex: 99V9
								// to S9V99
							} else if (v1.getDecimais() > v2.getDecimais()) {
								String s = v1.getPic()+" to "+v2.getPic()+"? ?";
								lista.add(s);
								//CANCELADO - ANDRE
								// chamar método redefinir, pois o inteiro da
								// origem é maior que o inteiro do destino e o
								// decimal de origem é maior que o decimal de
								// destino, o destino é sinalizado e a origem
								// não, ex: 99V99 to S9V9
							}

						}
					}
				} else {
					if (v1.haveDecimais() && v2.haveDecimais()) {

						if (v1.getInteiro() == v2.getInteiro()) {

							if (v1.getDecimais() == v2.getDecimais()) {
								lista = (ArrayList<String>) VARIguais(v1,v2,spaces);
							} else if (v1.getDecimais() < v2.getDecimais()) {
								lista = (ArrayList<String>) VARIguais(v1,v2,spaces);
							} else if (v1.getDecimais() > v2.getDecimais()) {
								String s = v1.getPic()+" to "+v2.getPic()+"? ?";
								lista.add(s);
								//----------BRUNO NÃO FAZER
								// chamar método redefinir pois os decimais da
								// origem são maiores que o do destino, (ex:
								// 9V99 to 9V9)
							}

						} else if (v1.getInteiro() < v2.getInteiro()) {
							if (v1.getDecimais() == v2.getDecimais()) {
								lista = (ArrayList<String>) VARIguais(v1,v2,spaces);
							} else if (v1.getDecimais() < v2.getDecimais()) {
								lista = (ArrayList<String>) VARIguais(v1,v2,spaces);
							} else if (v1.getDecimais() > v2.getDecimais()) {
								String s = v1.getPic()+" to "+v2.getPic()+"? ?";
								lista.add(s);
								//--------------------NÃO FAZER
								// chamar método redefinir pois os decimais da
								// origem são maiores que o do destino, (ex:
								// 9V99 to 99V9)
							}
						} else if (v1.getInteiro() > v2.getInteiro()) {
							if (v1.getDecimais() == v2.getDecimais()) {
								lista = (ArrayList<String>) _99V9To9V9(v1,v2,spaces);
							} else if (v1.getDecimais() < v2.getDecimais()) {
								String s = v1.getPic()+" to "+v2.getPic()+"? ?";
								lista.add(s);
								//-----------------bruno nao fazer
								// chamar método redefinir, pois o inteiro da
								// origem é maior que o inteiro do destino, ex:
								// 99V9 to 9V99
							} else if (v1.getDecimais() > v2.getDecimais()) {
								String s = v1.getPic()+" to "+v2.getPic()+"? ?";
								lista.add(s);
								//-----------------bruno nao fazer
								// chamar método redefinir, pois o inteiro da
								// origem é maior que o inteiro do destino e o
								// decimal de origem é maior que o decimal de
								// destino, ex: 99V99 to 9V9
							}

						}
					}if (!v1.haveDecimais() && !v2.haveDecimais()){
						if (v1.getInteiro() > v2.getInteiro()){
							lista = (ArrayList<String>) _99To9(v1,v2,spaces);
						}else if (v1.getInteiro() == v2.getInteiro()){
							lista = (ArrayList<String>) VARIguais(v1,v2,spaces);
						}else{
							lista = (ArrayList<String>) VARIguais(v1,v2,spaces);
						}
					}
				}
			} else if (v1.isNumerica() && v2.isAlfaNumerica()) {
				if (v1.isSinalizado()) {
					if (v1.haveDecimais()) {
						if (v1.getInteiro() == v2.getInteiro()) {
							lista = (ArrayList<String>) S9V9ToX(v1,v2,spaces);
						} else if (v1.getInteiro() < v2.getInteiro()) {							
							lista = (ArrayList<String>) S9V9ToX(v1, v2, spaces);
						} else if (v1.getInteiro() > v2.getInteiro()) {
							lista = (ArrayList<String>) S99V9ToX(v1,v2,spaces);
						}
					} else if (v1.haveDecimais() == false) {
						if (v1.getInteiro() == v2.getInteiro()) {
							lista = (ArrayList<String>) S9V9ToX(v1, v2, spaces);
						} else if (v1.getInteiro() < v2.getInteiro()) {
							lista = (ArrayList<String>) S9V9ToX(v1, v2, spaces);						
						} else if (v1.getInteiro() > v2.getInteiro()) {
							lista = (ArrayList<String>) S99ToX(v1,v2,spaces);
						}
					}
				} else if (v1.isSinalizado() == false) {
					if (v1.haveDecimais()) {
						if (v1.getInteiro() == v2.getInteiro()) {
							lista = (ArrayList<String>) _9V9ToX(v1,v2,spaces);
						} else if (v1.getInteiro() < v2.getInteiro()) {
							lista = (ArrayList<String>) _9V9ToXX(v1,v2,spaces);
						} else if (v1.getInteiro() > v2.getInteiro()) {
							lista = (ArrayList<String>) _99V9ToX(v1,v2,spaces);							
						}
					} else if (v1.isSinalizado() == false) {
						if (v1.getInteiro() == v2.getInteiro()) {
							lista = (ArrayList<String>) _9ToX(v1, v2, spaces);
						} else if (v1.getInteiro() < v2.getInteiro()) {					
						    lista = (ArrayList<String>) _9ToX(v1, v2, spaces);							
						} else if (v1.getInteiro() > v2.getInteiro()) {
							lista = (ArrayList<String>) _99ToX(v1,v2,spaces);						
						}
					}

				}

			} else if (v1.isAlfaNumerica() && v2.isNumerica()) {
				if (v2.isSinalizado()) {
					if (v2.haveDecimais()) {
						if (v1.getInteiro() == v2.getInteiro()) {
							lista = (ArrayList<String>) XToS9(v1, v2, spaces);							
						} else if (v1.getInteiro() < v2.getInteiro()) {
							lista = (ArrayList<String>) XToS9(v1, v2, spaces);
						} else if (v1.getInteiro() > v2.getInteiro()) {				
							lista = (ArrayList<String>) XXToS9(v1, v2, spaces);
						}
					} else if (v2.haveDecimais() == false) {
						if (v1.getInteiro() == v2.getInteiro()) {
							lista = (ArrayList<String>) XToS9(v1,v2,spaces);
						} else if (v1.getInteiro() < v2.getInteiro()) {
							lista = (ArrayList<String>) XToS9(v1,v2,spaces);
						} else if (v1.getInteiro() > v2.getInteiro()) {
							lista = (ArrayList<String>) XXToS9(v1,v2,spaces);
						}
					}
				} else if (v2.isSinalizado() == false) {
					if (v2.haveDecimais()) {
						if (v1.getInteiro() == v2.getInteiro()) {
							lista = (ArrayList<String>) XTo9V9(v1,v2,spaces);
						} else if (v1.getInteiro() < v2.getInteiro()) {
							lista = (ArrayList<String>) XTo9V9(v1,v2,spaces);
						} else if (v1.getInteiro() > v2.getInteiro()) {
							lista = (ArrayList<String>) XXToS9(v1,v2,spaces);
						}
					} else {
						if (v1.getInteiro() == v2.getInteiro()) {
							lista = (ArrayList<String>) XToS9(v1,v2,spaces);
						} else if (v1.getInteiro() < v2.getInteiro()) {
							lista = (ArrayList<String>) XToS9(v1,v2,spaces);
						} else if (v1.getInteiro() > v2.getInteiro()) {
							lista = (ArrayList<String>) XXToS9(v1,v2,spaces);
						}
					}

				}

			} else if (v1.isAlfaNumerica()&& v2.isAlfaNumerica()) {
				if (v1.getInteiro() > v2.getInteiro()) {
					lista = (ArrayList<String>) XXToX(v1,v2,spaces);
				} else {
					lista = (ArrayList<String>) VARIguais(v1,v2,spaces);
				}
			}
		return lista;
	}

	/**
	 * @AUTHOR Lucas 
	 * Método para redefinir pois ambas as variáveis são
	 *         sinalizadas, inteiro origem é maior que inteiro destino,(obs -
	 *         decimais iguais), ex: S99V9 para S9V9
	 */
	public List<String> S99V9ToS9V9(VariavelTO varOrigem,
			VariavelTO varDestino, Integer space) {
		StringBuffer aux = new StringBuffer();
		String pic;
		Integer dif;
		List<String> retorno = new ArrayList<String>();
		if (varOrigem.getInteiro().toString().length() == 1) {
			pic = "PIC +9(00" + varOrigem.getInteiro() + ")";
		} else if (varOrigem.getInteiro().toString().length() == 2) {
			pic = "PIC +9(0" + varOrigem.getInteiro() + ")";
		} else {
			pic = "PIC +9(" + varOrigem.getInteiro() + ")";
		}
		if (varOrigem.getDecimais().toString().length() == 1) {
			pic = pic.concat("V9(00" + varOrigem.getDecimais() + ")");
		} else if (varOrigem.getDecimais().toString().length() == 2) {
			pic = pic.concat("V9(0" + varOrigem.getDecimais() + ")");
		} else {
			pic = pic.concat("V9(" + varOrigem.getDecimais() + ")");
		}
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "WRK-S9-"
				+ varOrigem.getInteiro() + "-V" + varOrigem.getDecimais(), pic,
				"", "VALUE ZEROS.", "\n"));
		retorno.add(aux.toString());
		// fim da parte 1
		aux = new StringBuffer();
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "FILLER",
				"REDEFINES", "WRK-S9-" + varOrigem.getInteiro() + "-V"
						+ varOrigem.getDecimais() + ".\n", "", ""));

		pic = "";
		dif = varOrigem.getInteiro() - varDestino.getInteiro();
		dif = dif + 1;
		if (dif.toString().length() == 1) {
			pic = "PIC  X(00" + dif + ").";
		} else if (dif.toString().length() == 2) {
			pic = "PIC  X(0" + dif + ").";
		} else {
			pic = "PIC  X(" + dif + ").";
		}
		aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "FILLER",
				pic, "\n", null, null));

		pic = "";
		if (varDestino.getInteiro().toString().length() == 1) {
			pic = "PIC  9(00" + varDestino.getInteiro() + ")";
		} else if (varDestino.getInteiro().toString().length() == 2) {
			pic = "PIC  9(0" + varDestino.getInteiro() + ")";
		} else {
			pic = "PIC  9(" + varDestino.getInteiro() + ")";
		}
		if (varDestino.getDecimais().toString().length() == 1) {
			pic = pic.concat("V9(00" + varDestino.getDecimais() + ").");
		} else if (varDestino.getDecimais().toString().length() == 2) {
			pic = pic.concat("V9(0" + varDestino.getDecimais() + ").");
		} else {
			pic = pic.concat("V9(" + varDestino.getDecimais() + ").");
		}
		aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "WRK-S9-"
				+ varOrigem.getInteiro() + "-V" + varOrigem.getDecimais()
				+ "-TO-9-" + varDestino.getInteiro() + "-V"
				+ varDestino.getDecimais(), pic, "\n", null, null));
		retorno.add(aux.toString());
		// fim da parte 2
		aux = new StringBuffer();
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "MOVE", varOrigem
				.getNome(), "TO", "WRK-S9-" + varOrigem.getInteiro() + "-V"
				+ varOrigem.getDecimais() + ".\n", null, null));

		aux.append((UtilProjeto.geraMovimentacoes(space - 1, "MOVE", "WRK-S9-"
				+ varOrigem.getInteiro() + "-V" + varOrigem.getDecimais()
				+ "-TO-9-" + varDestino.getInteiro() + "-V"
				+ varDestino.getDecimais(), "TO", varDestino.getNome() + ".\n",
				null, null)));
		retorno.add(aux.toString());
		// fim da parte 3
		return retorno;

	}

	/**
	 * @AUTHOR Lucas 
	 * Método para retirar decimal da origem, pois o destino não
	 *         tem decimal, ex: S9V9 para S9
	 */
	public List<String> S9V9ToS9(VariavelTO varOrigem, VariavelTO varDestino,
			Integer space) {
		StringBuffer aux = new StringBuffer();
		String pic;
		Integer dif;
		List<String> retorno = new ArrayList<String>();
		if (varOrigem.getInteiro().toString().length() == 1) {
			pic = "PIC +9(00" + varOrigem.getInteiro() + ")";
		} else if (varOrigem.getInteiro().toString().length() == 2) {
			pic = "PIC +9(0" + varOrigem.getInteiro() + ")";
		} else {
			pic = "PIC +9(" + varOrigem.getInteiro() + ")";
		}
		if (varOrigem.getDecimais().toString().length() == 1) {
			pic = pic.concat("V9(00" + varOrigem.getDecimais() + ")");
		} else if (varOrigem.getDecimais().toString().length() == 2) {
			pic = pic.concat("V9(0" + varOrigem.getDecimais() + ")");
		} else {
			pic = pic.concat("V9(" + varOrigem.getDecimais() + ")");
		}
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "WRK-S9-"
				+ varOrigem.getInteiro() + "-V" + varOrigem.getDecimais(), pic,
				"", "VALUE ZEROS.", "\n"));
		retorno.add(aux.toString());
		// fim da parte 1
		aux = new StringBuffer();
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "FILLER",
				"REDEFINES", "WRK-S9-" + varOrigem.getInteiro() + "-V"
						+ varOrigem.getDecimais() + ".\n", null, null));

		pic = "PIC  X(001).";
		aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "FILLER",
				pic, "\n", null, null));

		pic = "";
		if (varDestino.getInteiro().toString().length() == 1) {
			pic = "PIC  9(00" + varDestino.getInteiro() + ").";
		} else if (varDestino.getInteiro().toString().length() == 2) {
			pic = "PIC  9(0" + varDestino.getInteiro() + ").";
		} else {
			pic = "PIC  9(" + varDestino.getInteiro() + ").";
		}
		aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "WRK-S9-"
				+ varOrigem.getInteiro() + "-V" + varOrigem.getDecimais()
				+ "-TO-9-" + varDestino.getInteiro(), pic, "\n", null, null));

		pic = "";
		dif = varOrigem.getDecimais();
		if (dif.toString().length() == 1) {
			pic = "PIC  X(00" + dif + ").";
		} else if (dif.toString().length() == 2) {
			pic = "PIC  X(0" + dif + ").";
		} else {
			pic = "PIC  X(" + dif + ").";
		}
		aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "FILLER",
				pic, "\n", null, null));
		retorno.add(aux.toString());
		// fim da parte 2
		aux = new StringBuffer();
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "MOVE", varOrigem
				.getNome(), "TO", "WRK-S9-" + varOrigem.getInteiro() + "-V"
				+ varOrigem.getDecimais() + ".\n", null, null));

		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "MOVE", "WRK-S9-"
				+ varOrigem.getInteiro() + "-V" + varOrigem.getDecimais()
				+ "-TO-9-" + varDestino.getInteiro(), "TO", varDestino
				.getNome()
				+ ".\n", null, null));
		retorno.add(aux.toString());
		// fim da parte 3
		return retorno;

	}

	/**
	 * @AUTHOR Lucas Método para retirar decimal da origem, pois o destino não
	 *         tem decimal e redefinir, pois tamanho inteiro da origem é maior
	 *         que destino, ex: S99V9 para S9
	 */
	public List<String> S99V9ToS9(VariavelTO varOrigem, VariavelTO varDestino,
			Integer space) {
		StringBuffer aux = new StringBuffer();
		String pic;
		Integer dif;
		List<String> retorno = new ArrayList<String>();
		if (varOrigem.getInteiro().toString().length() == 1) {
			pic = "PIC +9(00" + varOrigem.getInteiro() + ")";
		} else if (varOrigem.getInteiro().toString().length() == 2) {
			pic = "PIC +9(0" + varOrigem.getInteiro() + ")";
		} else {
			pic = "PIC +9(" + varOrigem.getInteiro() + ")";
		}
		if (varOrigem.getDecimais().toString().length() == 1) {
			pic = pic.concat("V9(00" + varOrigem.getDecimais() + ")");
		} else if (varOrigem.getDecimais().toString().length() == 2) {
			pic = pic.concat("V9(0" + varOrigem.getDecimais() + ")");
		} else {
			pic = pic.concat("V9(" + varOrigem.getDecimais() + ")");
		}
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "WRK-S9-"
				+ varOrigem.getInteiro() + "-V" + varOrigem.getDecimais(), pic,
				"", "VALUE ZEROS.", "\n"));
		retorno.add(aux.toString());
		// fim da parte 1
		aux = new StringBuffer();
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "FILLER",
				"REDEFINES", "WRK-S9-" + varOrigem.getInteiro() + "-V"
						+ varOrigem.getDecimais() + ".\n", "", ""));

		pic = "";
		dif = varOrigem.getInteiro() - varDestino.getInteiro();
		dif = dif + 1;
		if (dif.toString().length() == 1) {
			pic = "PIC  X(00" + dif + ").";
		} else if (dif.toString().length() == 2) {
			pic = "PIC  X(0" + dif + ").";
		} else {
			pic = "PIC  X(" + dif + ").";
		}
		aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "FILLER",
				pic, "\n", null, null));

		pic = "";
		if (varDestino.getInteiro().toString().length() == 1) {
			pic = "PIC  9(00" + varDestino.getInteiro() + ").";
		} else if (varDestino.getInteiro().toString().length() == 2) {
			pic = "PIC  9(0" + varDestino.getInteiro() + ").";
		} else {
			pic = "PIC  9(" + varDestino.getInteiro() + ").";
		}
		aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "WRK-S9-"
				+ varOrigem.getInteiro() + "-V" + varOrigem.getDecimais()
				+ "-TO-9-" + varDestino.getInteiro(), pic, "\n", "", ""));

		pic = "";
		dif = varOrigem.getDecimais();
		if (dif.toString().length() == 1) {
			pic = "PIC  X(00" + dif + ").";
		} else if (dif.toString().length() == 2) {
			pic = "PIC  X(0" + dif + ").";
		} else {
			pic = "PIC  X(" + dif + ").";
		}
		aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "FILLER",
				pic, "\n", null, null));
		retorno.add(aux.toString());
		// fim da parte 2
		aux = new StringBuffer();
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "MOVE", varOrigem
				.getNome(), "TO", "WRK-S9-" + varOrigem.getInteiro() + "-V"
				+ varOrigem.getDecimais() + ".\n", null, null));

		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "MOVE", "WRK-S9-"
				+ varOrigem.getInteiro() + "-V" + varOrigem.getDecimais()
				+ "-TO-9-" + varDestino.getInteiro(), "TO", varDestino
				.getNome()
				+ ".\n", null, null));
		retorno.add(aux.toString());
		// fim da parte 3
		return retorno;

	}

	/**
	 * @AUTHOR Lucas Método para redefinir a origem que é numérica sinalizada
	 *         sem decimais para destino com decimais e sem sinal.
	 */
	public List<String> S99To99V99(VariavelTO varOrigem, VariavelTO varDestino,
			Integer space) {
		StringBuffer aux = new StringBuffer();
		String pic;
		List<String> retorno = new ArrayList<String>();
		if (varOrigem.getInteiro().toString().length() == 1) {
			pic = "PIC +9(00" + varOrigem.getInteiro() + ")";
		} else if (varOrigem.getInteiro().toString().length() == 2) {
			pic = "PIC +9(0" + varOrigem.getInteiro() + ")";
		} else {
			pic = "PIC +9(" + varOrigem.getInteiro() + ")";
		}

		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "WRK-S9-"
				+ varOrigem.getInteiro(), pic, "", "VALUE ZEROS.", "\n"));
		retorno.add(aux.toString());
		// fim da parte 1
		aux = new StringBuffer();
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "FILLER",
				"REDEFINES", "WRK-S9-" + varOrigem.getInteiro() + ".\n", null,
				null));

		pic = "";
		pic = "PIC  X(001).";
		aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "FILLER",
				pic, "\n", null, null));

		pic = "";
		if (varDestino.getInteiro().toString().length() == 1) {
			pic = "PIC  9(00" + varDestino.getInteiro() + ").";
		} else if (varDestino.getInteiro().toString().length() == 2) {
			pic = "PIC  9(0" + varDestino.getInteiro() + ").";
		} else {
			pic = "PIC  9(" + varDestino.getInteiro() + ").";
		}

		aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "WRK-S9-"
				+ varOrigem.getInteiro() + "-TO-9-" + varDestino.getInteiro(),
				pic, "\n", null, null));
		retorno.add(aux.toString());
		// fim da parte 2
		aux = new StringBuffer();
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "MOVE", varOrigem
				.getNome(), "TO", "WRK-S9-" + varOrigem.getInteiro() + ".\n",
				null, null));

		aux.append((UtilProjeto.geraMovimentacoes(space - 1, "MOVE", "WRK-S9-"
				+ varOrigem.getInteiro() + "-TO-9-" + varDestino.getInteiro(),
				"TO", varDestino.getNome() + ".\n", null, null)));
		retorno.add(aux.toString());
		// fim da parte 3
		return retorno;

	}

	/**
	 * @AUTHOR Lucas Método para redefinir a origem, pois a origem é maior que o
	 *         destino(não possuem decimais, ambos são sinalizadas), ex: S99
	 *         para S9
	 */
	public List<String> S99ToS9(VariavelTO varOrigem, VariavelTO varDestino,
			Integer space) {
		StringBuffer aux = new StringBuffer();
		String pic;
		Integer dif;
		List<String> retorno = new ArrayList<String>();
		if (varOrigem.getInteiro().toString().length() == 1) {
			pic = "PIC +9(00" + varOrigem.getInteiro() + ")";
		} else if (varOrigem.getInteiro().toString().length() == 2) {
			pic = "PIC +9(0" + varOrigem.getInteiro() + ")";
		} else {
			pic = "PIC +9(" + varOrigem.getInteiro() + ")";
		}
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "WRK-S9-"
				+ varOrigem.getInteiro(), pic, "", "VALUE ZEROS.", "\n"));
		retorno.add(aux.toString());
		// fim da parte 1
		aux = new StringBuffer();
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "FILLER",
				"REDEFINES", "WRK-S9-" + varOrigem.getInteiro() + ".\n", null,
				null));

		pic = "";
		dif = varOrigem.getInteiro() - varDestino.getInteiro();
		dif = dif + 1;
		if (dif.toString().length() == 1) {
			pic = "PIC  X(00" + dif + ").";
		} else if (dif.toString().length() == 2) {
			pic = "PIC  X(0" + dif + ").";
		} else {
			pic = "PIC  X(" + dif + ").";
		}
		aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "FILLER",
				pic, "\n", null, null));

		pic = "";
		if (varDestino.getInteiro().toString().length() == 1) {
			pic = "PIC  9(00" + varDestino.getInteiro() + ").";
		} else if (varDestino.getInteiro().toString().length() == 2) {
			pic = "PIC  9(0" + varDestino.getInteiro() + ").";
		} else {
			pic = "PIC  9(" + varDestino.getInteiro() + ").";
		}
		aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "WRK-S9-"
				+ varOrigem.getInteiro() + "-TO-9-" + varDestino.getInteiro(),
				pic, "\n", null, null));
		retorno.add(aux.toString());
		// fim da parte 2
		aux = new StringBuffer();
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "MOVE", varOrigem
				.getNome(), "TO", "WRK-S9-" + varOrigem.getInteiro() + ".\n",
				null, null));

		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "MOVE", "WRK-S9-"
				+ varOrigem.getInteiro() + "-TO-9-" + varDestino.getInteiro(),
				"TO", varDestino.getNome() + ".\n", null, null));
		retorno.add(aux.toString());
		// fim da parte 3
		return retorno;

	}

	/**
	 * @AUTHOR Bruno Método para redefinir a origem, numerica maior que destino
	 */
	public List<String> _99To9(VariavelTO v1, VariavelTO v2, int space) {
		List<StringBuffer> listaStringBuffer = new ArrayList<StringBuffer>();
		StringBuffer cabecalho = new StringBuffer();
		StringBuffer redefines = new StringBuffer();
		StringBuffer movimentacoes = new StringBuffer();
		int x = v1.getInteiro() - v2.getInteiro();

		cabecalho.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "WRK-"
				+ "9" + "-" + v1.getInteiro(), "PIC ", v1.getPic(), "VALUE",
				"ZEROS" + ".\n"));
		redefines
				.append("           05  FILLER                  REDEFINES WRK-"
						+ "9" + "-" + v1.getInteiro() + ".\n");
		if (x < 10) {
			redefines.append(UtilProjeto.geraMovimentacoes(15, "10 ", "FILLER",
					"PIC ", "9" + "(00" + x + ")" + ".", "", "")
					+ "\n");
		} else {
			redefines.append(UtilProjeto.geraMovimentacoes(15, "10 ", "FILLER",
					"PIC ", "9" + "(0" + x + ")" + ".", "", "")
					+ "\n");
		}
		if (v2.getInteiro() < 10) {
			redefines.append(UtilProjeto.geraMovimentacoes(15, "10 ", "WRK-"
					+ "9" + "-" + v1.getInteiro() + "-TO-" + "9" + "-"
					+ v2.getInteiro(), "PIC ", "9" + "(00" + v2.getInteiro()
					+ ")." + "", "", "")
					+ "\n");
		} else {
			redefines.append(UtilProjeto.geraMovimentacoes(15, "10 ", "WRK-"
					+ "9" + "-" + v1.getInteiro() + "-TO-" + "9" + "-"
					+ v2.getInteiro(), "PIC ", "9" + "(0" + v2.getInteiro()
					+ ")." + ".", "", "")
					+ "\n");
		}

		// MOVIMENTACOES
		movimentacoes.append(UtilProjeto.geraMovimentacoes(11, "MOVE", v1
				.getNome(), "TO", "WRK-" + "9" + "-" + v1.getInteiro() + ".\n",
				"", ""));
		movimentacoes.append(UtilProjeto.geraMovimentacoes(11, "MOVE", "WRK-"
				+ "9" + "-" + v1.getInteiro() + "-TO-" + "9" + "-"
				+ v2.getInteiro(), "TO", v2.getNome() + ".\n", "", ""));
		listaStringBuffer.add(cabecalho);
		listaStringBuffer.add(redefines);
		listaStringBuffer.add(movimentacoes);
		ArrayList<String> listaString = new ArrayList<String>();

		for (StringBuffer b : listaStringBuffer) {
			listaString.add(b.toString());
		}

		return listaString;
	}

	/**
	 * @AUTHOR Bruno Método para redefinir a origem, pois o inteiro da origem é
	 *         maior que o inteiro do destino, ex: 99V9 to 9V9
	 */
	public List<String> _99V9To9V9(VariavelTO v1, VariavelTO v2, Integer space) {
		List<StringBuffer> listaStringBuffer = new ArrayList<StringBuffer>();
		StringBuffer cabecalho = new StringBuffer();
		StringBuffer redefines = new StringBuffer();
		StringBuffer movimentacoes = new StringBuffer();

		int x = v1.getInteiro() - v2.getInteiro();
		String d = "";
		if (v1.getDecimais() < 10) {
			d = ("9(00" + v1.getDecimais() + ").");
		} else {
			d = ("9(0" + v1.getDecimais() + ").");
		}

		cabecalho.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "WRK-"
				+ "9" + "-" + v1.getInteiro() + "-V" + v1.getDecimais(),
				"PIC ", v1.getPic().replaceAll("s", "+"), "VALUE", "ZEROS"
						+ ".\n"));
		redefines
				.append("           05  FILLER                  REDEFINES WRK-"
						+ "9" + "-" + v1.getInteiro() + "-V" + v1.getDecimais()
						+ ".\n");
		if (x < 10) {
			redefines.append(UtilProjeto.geraMovimentacoes(15, "10 ", "FILLER",
					"PIC ", "X" + "(00" + x + ")" + ".", "", "")
					+ "\n");
		} else {
			redefines.append(UtilProjeto.geraMovimentacoes(15, "10 ", "FILLER",
					"PIC ", "X" + "(0" + x + ")" + ".", "", "")
					+ "\n");
		}
		if (v2.getInteiro() < 10) {
			redefines.append(UtilProjeto.geraMovimentacoes(15, "10 ", "WRK-"
					+ "9" + "-" + v1.getInteiro() + "-TO-" + "9" + "-"
					+ v2.getInteiro(), "PIC ", "9" + "(00" + v2.getInteiro()
					+ ")V" + d + "", "", "")
					+ "\n");
		} else {
			redefines.append(UtilProjeto.geraMovimentacoes(15, "10 ", "WRK-"
					+ "9" + "-" + v1.getInteiro() + "-TO-" + "9" + "-"
					+ v2.getInteiro(), "PIC ", "9" + "(0" + v2.getInteiro()
					+ ")V" + d + ".", "", "")
					+ "\n");
		}

		// MOVIMENTACOES
		movimentacoes.append(UtilProjeto.geraMovimentacoes(11, "MOVE", v1
				.getNome(), "TO", "WRK-" + "9" + "-" + v1.getInteiro() + "-V"
				+ v1.getDecimais() + ".\n", "", ""));
		movimentacoes.append(UtilProjeto.geraMovimentacoes(11, "MOVE", "WRK-"
				+ "9" + "-" + v1.getInteiro() + "-TO-" + "9" + "-"
				+ v2.getInteiro(), "TO", v2.getNome() + ".\n", "", ""));
		listaStringBuffer.add(cabecalho);
		listaStringBuffer.add(redefines);
		listaStringBuffer.add(movimentacoes);

		ArrayList<String> listaString = new ArrayList<String>();

		for (StringBuffer b : listaStringBuffer) {
			listaString.add(b.toString());
		}

		return listaString;
	}

	/**
	 * @AUTHOR Bruno Método para redefinir a origem, para tirar sinalizada,
	 *         retirar decimais, ex: S9V9 to X
	 */
	public List<String> S9V9ToX(VariavelTO v1, VariavelTO v2, Integer space) {
		List<StringBuffer> listaStringBuffer = new ArrayList<StringBuffer>();
		StringBuffer cabecalho = new StringBuffer();
		StringBuffer redefines = new StringBuffer();
		StringBuffer movimentacoes = new StringBuffer();

		int r = 0;
		r = 1 + (v1.getInteiro() - v2.getInteiro());

		cabecalho.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ",
				"WRK-9-" + v1.getInteiro() + "-V" + v1.getDecimais(), "PIC", v1
						.getPic().replace("S", "+"), "VALUE", "ZEROS" + ".\n"));
		redefines
				.append("           05  FILLER                  REDEFINES WRK-9-"
						+ v1.getInteiro() + "-V" + v1.getDecimais() + ".\n");

		if (r < 10)
			redefines.append("               10  FILLER              PIC  X(00"
					+ r + ").\n");
		else {
			redefines.append("               10  FILLER              PIC  X(0"
					+ r + ").\n");
		}

		if (v2.getInteiro() < 10) {
			redefines.append(UtilProjeto.geraMovimentacoes(14, " 10", " WRK-9-"
					+ v1.getInteiro() + "-TO-X-" + v2.getInteiro(), "PIC",
					" X(00" + v2.getInteiro() + ").", "", "")
					+ "\n");
		} else {
			redefines.append(UtilProjeto.geraMovimentacoes(14, " 10", " WRK-9-"
					+ v1.getInteiro() + "-TO-X-" + v2.getInteiro(), "PIC",
					" X(0" + v2.getInteiro() + ").", "", "")
					+ "\n");
		}
		if (v1.getDecimais() < 10) {
			redefines.append("               10  FILLER              PIC  X(00"
					+ v1.getDecimais() + ").\n");
		} else {
			redefines.append("               10  FILLER              PIC  X(0"
					+ v1.getDecimais() + ").\n");
		}

		// MOVIMENTACOES
		movimentacoes.append(UtilProjeto.geraMovimentacoes(11, "MOVE", v1
				.getNome(), "TO", "WRK-9-" + v1.getInteiro() + "-V"
				+ v1.getDecimais() + ".\n", "", ""));
		movimentacoes.append(UtilProjeto.geraMovimentacoes(11, "MOVE", "WRK-9-"
				+ v1.getInteiro() + "-TO-X-" + v2.getInteiro(), "TO", v2
				.getNome().toUpperCase()
				+ ".\n", "", ""));
		listaStringBuffer.add(cabecalho);
		listaStringBuffer.add(redefines);
		listaStringBuffer.add(movimentacoes);

		ArrayList<String> listaString = new ArrayList<String>();

		for (StringBuffer b : listaStringBuffer) {
			listaString.add(b.toString());
		}

		return listaString;
	}

	/**
	 * @AUTHOR Bruno Método para redefinir a origem que é numérica com decimais
	 *         maior que o destino, e destino alfanumérica, ex: 99V9 to X
	 */
	public List<String> _99V9ToX(VariavelTO v1, VariavelTO v2, int space) {
		List<StringBuffer> listaStringBuffer = new ArrayList<StringBuffer>();
		StringBuffer cabecalho = new StringBuffer();
		StringBuffer redefines = new StringBuffer();
		StringBuffer movimentacoes = new StringBuffer();

		int r = 0;
		r = (v1.getInteiro() - v2.getInteiro());

		cabecalho.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ",
				"WRK-9-" + v1.getInteiro() + "-V" + v1.getDecimais(), "PIC ",
				v1.getPic().replace("S", "+"), "VALUE", "ZEROS" + ".\n"));
		redefines
				.append("           05  FILLER                  REDEFINES WRK-9-"
						+ v1.getInteiro() + "-V" + v1.getDecimais() + ".\n");

		if (r < 10)
			redefines.append("               10  FILLER              PIC  X(00"
					+ r + ").\n");
		else {
			redefines.append("               10  FILLER              PIC  X(0"
					+ r + ").\n");
		}

		if (v2.getInteiro() < 10) {
			redefines.append(UtilProjeto.geraMovimentacoes(14, " 10", " WRK-9-"
					+ v1.getInteiro() + "-TO-X-" + v2.getInteiro(), "PIC",
					" X(00" + v2.getInteiro() + ").", "", "")
					+ "\n");
		} else {
			redefines.append(UtilProjeto.geraMovimentacoes(14, " 10", " WRK-9-"
					+ v1.getInteiro() + "-TO-X-" + v2.getInteiro(), "PIC",
					" X(0" + v2.getInteiro() + ").", "", "")
					+ "\n");
		}
		if (v1.getDecimais() < 10) {
			redefines.append("               10  FILLER              PIC  X(00"
					+ v1.getDecimais() + ").\n");
		} else {
			redefines.append("               10  FILLER              PIC  X(0"
					+ v1.getDecimais() + ").\n");
		}

		// MOVIMENTACOES
		movimentacoes.append(UtilProjeto.geraMovimentacoes(11, "MOVE", v1
				.getNome(), "TO", "WRK-9-" + v1.getInteiro() + "-V"
				+ v1.getDecimais() + ".\n", "", ""));
		movimentacoes.append(UtilProjeto.geraMovimentacoes(11, "MOVE", "WRK-9-"
				+ v1.getInteiro() + "-TO-X-" + v2.getInteiro(), "TO", v2
				.getNome().toUpperCase()
				+ ".\n", "", ""));
		listaStringBuffer.add(cabecalho);
		listaStringBuffer.add(redefines);
		listaStringBuffer.add(movimentacoes);

		ArrayList<String> listaString = new ArrayList<String>();

		for (StringBuffer b : listaStringBuffer) {
			listaString.add(b.toString());
		}

		return listaString;

	}

	/**
	 * @AUTHOR Fausto 
	 *         Método para redefinir a origem que é alfanumérica, para
	 *         uma numérica sinalizada, ex: X to S9
	 */
	public List<String> XToS9(VariavelTO v1, VariavelTO v2, Integer space) {
		List<StringBuffer> listaStringBuffer = new ArrayList<StringBuffer>();
		StringBuffer cabecalho = new StringBuffer();
		StringBuffer redefines = new StringBuffer();
		StringBuffer movimentacoes = new StringBuffer();

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

		ArrayList<String> listaString = new ArrayList<String>();

		for (StringBuffer b : listaStringBuffer) {
			listaString.add(b.toString());
		}

		return listaString;
	}

	/**
	 * @AUTHOR Fausto 
	 * 		   Método para redefinir a origem que é uma alfanumérica
	 *         maior que o destino, o destino é uma numérica sinalizada, ex: XX
	 *         to S9
	 */
	public List<String> XXToS9(VariavelTO v1, VariavelTO v2, Integer space) {
		List<StringBuffer> listaStringBuffer = new ArrayList<StringBuffer>();
		StringBuffer cabecalho = new StringBuffer();
		StringBuffer redefines = new StringBuffer();
		StringBuffer movimentacoes = new StringBuffer();

		int x = (v1.getInteiro() - v2.getInteiro());

		cabecalho.append(UtilProjeto.geraMovimentacoes(space-1, "05", " WRK-"
				+ "X" + "-" + v1.getInteiro(), "PIC ", v1.getPic(), "VALUE",
				"SPACES" + ".\n"));
		redefines
				.append("           05  FILLER                  REDEFINES WRK-"
						+ "X" + "-" + v1.getInteiro() + ".\n");
		if (v2.getInteiro() < 10) {
			redefines.append(UtilProjeto.geraMovimentacoes(15, "10 ", "WRK-"
					+ "X" + "-" + v1.getInteiro() + "-TO-" + "9" + "-"
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
					+ "X" + "-" + v1.getInteiro() + "-TO-" + "9" + "-"
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
				+ "X" + "-" + v1.getInteiro() + "-TO-" + "9" + "-"
				+ v2.getInteiro(), "TO", v2.getNome() + ".\n", "", ""));
		listaStringBuffer.add(cabecalho);
		listaStringBuffer.add(redefines);
		listaStringBuffer.add(movimentacoes);

		ArrayList<String> listaString = new ArrayList<String>();

		for (StringBuffer b : listaStringBuffer) {
			listaString.add(b.toString());
		}

		return listaString;
	}

	/**
	 * @AUTHOR Fausto 
	 *         Método para redefinir a origem alfanumérica, para tirar
	 *         uma numérica de tamanho igual, com decimais, ex: X to 9V9
	 */
	public List<String> XTo9V9(VariavelTO v1, VariavelTO v2, Integer space) {
		List<StringBuffer> listaStringBuffer = new ArrayList<StringBuffer>();
		StringBuffer cabecalho = new StringBuffer();
		StringBuffer redefines = new StringBuffer();
		StringBuffer movimentacoes = new StringBuffer();

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

		ArrayList<String> listaString = new ArrayList<String>();

		for (StringBuffer b : listaStringBuffer) {
			listaString.add(b.toString());
		}

		return listaString;
	}

	/**
	 * @AUTHOR Fausto 
	 *         Método para redefinir a origem alfanumérica, para uma
	 *         alfanumérica de tamanho menor, ex: XX to X
	 */
	public List<String> XXToX(VariavelTO v1, VariavelTO v2, Integer space) {
		List<StringBuffer> listaStringBuffer = new ArrayList<StringBuffer>();
		StringBuffer cabecalho = new StringBuffer();
		StringBuffer redefines = new StringBuffer();
		StringBuffer movimentacoes = new StringBuffer();

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

		ArrayList<String> listaString = new ArrayList<String>();

		for (StringBuffer b : listaStringBuffer) {
			listaString.add(b.toString());
		}

		return listaString;
	}

	/**
	 * @AUTHOR Fausto 
	 * Método para redefinir a origem numérica sinalizada, para
	 * uma numérica de tamanho igual e decimais iguais, ex: S9V9 to 9V9
	 */
	public List<String> S9V9To9V9(VariavelTO v1, VariavelTO v2, int space) {
		List<StringBuffer> listaStringBuffer = new ArrayList<StringBuffer>();
		StringBuffer cabecalho = new StringBuffer();
		StringBuffer redefines = new StringBuffer();
		StringBuffer movimentacoes = new StringBuffer();

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

		ArrayList<String> listaString = new ArrayList<String>();

		for (StringBuffer b : listaStringBuffer) {
			listaString.add(b.toString());
		}

		return listaString;
	}

	/**
	 * @AUTHOR Andre 
	 * Método para redefinir a origem, para tirar sinalizada, a
	 * origem é maior que o destino, ex: S99V9 to 9V9
	 */
	public List<String> S99V9To9V9(VariavelTO v1, VariavelTO varDestino,
			Integer space) {
        StringBuffer aux = new StringBuffer();
        StringBuffer pic = new StringBuffer();
        List<String> retorno = new ArrayList<String>();

        if (v1.getInteiro().toString().length() == 1) {
               pic.append("PIC +9(00" + v1.getInteiro() + ")");
        } else if (v1.getInteiro().toString().length() == 2) {
               pic.append("PIC +9(0" + v1.getInteiro() + ")");
        } else {
               pic.append("PIC +9(" + v1.getInteiro() + ")");
        }

        if (v1.getDecimais().toString().length() == 1) {
               pic.append("V9(00" + v1.getDecimais() + ")");
        } else if (v1.getDecimais().toString().length() == 2) {
               pic.append("V9(0" + v1.getDecimais() + ")");
        } else {
               pic.append("V9(" + v1.getDecimais() + ")");
        }

        aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "WRK-S9-"
                      + v1.getInteiro() + "-V" + v1.getDecimais(),
                      String.valueOf(pic), "", "VALUE ZEROS.", ""));
        aux.append("\n");
        retorno.add(String.valueOf(aux));
        aux = new StringBuffer();
        pic = new StringBuffer();
        Integer filler = v1.getInteiro() - varDestino.getInteiro() + 1;
        if (filler.toString().length() == 1) {
               pic.append("PIC  X(00" + filler + ")");
        } else if (filler.toString().length() == 2) {
               pic.append("PIC  X(0" + filler + ")");
        } else {
               pic.append("PIC  X(" + filler + ")");
        }
        aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "FILLER",
                      "REDEFINES",
                      "WRK-S9-" + v1.getInteiro() + "-V" + v1.getDecimais() + ".\n",
                      "", ""));
        aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "FILLER",
                      pic + ".", "\n", null, null));
        pic = new StringBuffer();
        if (varDestino.getInteiro().toString().length() == 1) {
               pic.append("PIC  9(00" + varDestino.getInteiro() + ")");
        } else if (varDestino.getInteiro().toString().length() == 2) {
               pic.append("PIC  9(0" + varDestino.getInteiro() + ")");
        } else {
               pic.append("PIC  9(" + varDestino.getInteiro() + ")");
        }

        if (varDestino.getDecimais().toString().length() == 1) {
               pic.append("V9(00" + varDestino.getDecimais() + ")");
        } else if (varDestino.getDecimais().toString().length() == 2) {
               pic.append("V9(0" + varDestino.getDecimais() + ")");
        } else {
               pic.append("V9(" + varDestino.getDecimais() + ")");
        }
        aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "WRK-S9-"
                      + v1.getInteiro() + "-V" + v1.getDecimais() + "-TO" + "-9-"
                      + varDestino.getInteiro() + "-V" + varDestino.getDecimais(),
                      String.valueOf(pic) + ".", "", "", ""));
        aux.append("\n");
        retorno.add(String.valueOf(aux));
        aux = new StringBuffer();
        pic = new StringBuffer();
        aux.append(UtilProjeto.geraMovimentacoes(space - 1, "MOVE",
                      v1.getNome(), "TO",
                      "WRK-S9-" + v1.getInteiro() + "-V" + v1.getDecimais() + ".\n",
                      null, null));

        aux.append(UtilProjeto.geraMovimentacoes(space - 1, "MOVE", "WRK-S9-"
                      + v1.getInteiro() + "-V" + v1.getDecimais() + "-TO" + "-9-"
                      + varDestino.getInteiro() + "-V" + varDestino.getDecimais(),
                      "TO", varDestino.getNome() + ".\n", null, null));
        retorno.add(String.valueOf(aux));
        return retorno;
	}

	/**
	 * @AUTHOR Andre 
	 * Método para redefinir a origem, sua origem é maior que o
	 * destino, ex: 99V9 to S9V9
	 */
	public List<String> _99V9ToS9V9(VariavelTO varOrigem, VariavelTO varDestino,
			Integer space) {
        StringBuffer aux = new StringBuffer();
        StringBuffer pic = new StringBuffer();
        List<String> retorno = new ArrayList<String>();

        if (varOrigem.getInteiro().toString().length() == 1) {
               pic.append("PIC  9(00" + varOrigem.getInteiro() + ")");
        } else if (varOrigem.getInteiro().toString().length() == 2) {
               pic.append("PIC  9(0" + varOrigem.getInteiro() + ")");
        } else {
               pic.append("PIC  9(" + varOrigem.getInteiro() + ")");
        }

        if (varOrigem.getDecimais().toString().length() == 1) {
               pic.append("V9(00" + varOrigem.getDecimais() + ")");
        } else if (varOrigem.getDecimais().toString().length() == 2) {
               pic.append("V9(0" + varOrigem.getDecimais() + ")");
        } else {
               pic.append("V9(" + varOrigem.getDecimais() + ")");
        }

        aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "WRK-9-"
                      + varOrigem.getInteiro() + "-V" + varOrigem.getDecimais(),
                      String.valueOf(pic), "", "VALUE ZEROS.", ""));
        aux.append("\n");
        retorno.add(String.valueOf(aux));

        aux = new StringBuffer();
        pic = new StringBuffer();
        Integer filler = varOrigem.getInteiro() - varDestino.getInteiro();
        if (filler.toString().length() == 1) {
               pic.append("PIC  X(00" + filler + ")");
        } else if (filler.toString().length() == 2) {
               pic.append("PIC  X(0" + filler + ")");
        } else {
               pic.append("PIC  X(" + filler + ")");
        }
        aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "FILLER",
                      "REDEFINES", "WRK-9-" + varOrigem.getInteiro() + "-V"
                                   + varOrigem.getDecimais() + ".\n", "", ""));
        aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "FILLER",
                      pic + ".", "\n", null, null));
        pic = new StringBuffer();
        if (varDestino.getInteiro().toString().length() == 1) {
               pic.append("PIC  9(00" + varDestino.getInteiro() + ")");
        } else if (varDestino.getInteiro().toString().length() == 2) {
               pic.append("PIC  9(0" + varDestino.getInteiro() + ")");
        } else {
               pic.append("PIC  9(" + varDestino.getInteiro() + ")");
        }

        if (varDestino.getDecimais().toString().length() == 1) {
               pic.append("V9(00" + varDestino.getDecimais() + ")");
        } else if (varDestino.getDecimais().toString().length() == 2) {
               pic.append("V9(0" + varDestino.getDecimais() + ")");
        } else {
               pic.append("V9(" + varDestino.getDecimais() + ")");
        }
        aux.append(UtilProjeto.geraMovimentacoes(
                      space + 3,
                      "10 ",
                      "WRK-9-" + varOrigem.getInteiro() + "-V"
                                   + varOrigem.getDecimais() + "-TO" + "-9-"
                                   + varDestino.getInteiro() + "-V"
                                   + varDestino.getDecimais(), String.valueOf(pic) + ".",
                      "", "", ""));
        aux.append("\n");
        retorno.add(String.valueOf(aux));

        aux = new StringBuffer();
        pic = new StringBuffer();
        aux.append(UtilProjeto.geraMovimentacoes(space - 1, "MOVE",
                      varOrigem.getNome(), "TO", "WRK-9-" + varOrigem.getInteiro()
                                   + "-V" + varOrigem.getDecimais() + ".\n", null, null));
        aux.append(UtilProjeto.geraMovimentacoes(
                      space - 1,
                      "MOVE",
                      "WRK-9-" + varOrigem.getInteiro() + "-V"
                                   + varOrigem.getDecimais() + "-TO" + "-9-"
                                   + varDestino.getInteiro() + "-V"
                                   + varDestino.getDecimais(), "TO", varDestino.getNome()
                                   + ".\n", null, null));
        retorno.add(String.valueOf(aux));

        return retorno;
	}

	/**
	 * @AUTHOR Andre 
	 * Método para mover origem para destino (variaveis são iguais)
	 */
	public List<String> VARIguais(VariavelTO varOrigem, VariavelTO varDestino,
			Integer space) {
		List<String> retorno = new ArrayList<String>();
		retorno.add("      *----------------------------------------------------------------*\n");
		retorno.add("");
		retorno.add(UtilProjeto.geraMovimentacoes(space - 1, "MOVE", varOrigem
				.getNome(), "TO", varDestino.getNome() + ".\n", null, null));
		return retorno;

	}

	/**
	 * @AUTHOR Andre 
	 * Redefinir numérica maior para alfanumérica menor
	 */
	public List<String> _99ToX(VariavelTO varOrigem, VariavelTO varDestino,
			Integer space) {
		StringBuffer aux = new StringBuffer();
		StringBuffer pic = new StringBuffer();
		List<String> retorno = new ArrayList<String>();
		if (varOrigem.getInteiro().toString().length() == 1) {
			pic.append("PIC  9(00" + varOrigem.getInteiro() + ")");
		} else if (varOrigem.getInteiro().toString().length() == 2) {
			pic.append("PIC  9(0" + varOrigem.getInteiro() + ")");
		} else {
			pic.append("PIC  9(" + varOrigem.getInteiro() + ")");
		}
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "WRK-9-"
				+ varOrigem.getInteiro(), String.valueOf(pic), "", "VALUE",
				"ZEROS."));
		aux.append("\n");
		retorno.add(String.valueOf(aux));
		aux = new StringBuffer();
		pic = new StringBuffer();
		Integer filler = varOrigem.getInteiro() - varDestino.getInteiro();
		if (filler.toString().length() == 1) {
			pic.append("PIC  X(00" + filler + ")");
		} else if (filler.toString().length() == 2) {
			pic.append("PIC  X(0" + filler + ")");
		} else {
			pic.append("PIC  X(" + filler + ")");
		}
		aux
				.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ",
						"FILLER", "REDEFINES", "WRK-9-"
								+ varOrigem.getInteiro() + ".\n", "", ""));
		aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "FILLER",
				pic + ".", "\n", null, null));
		pic = new StringBuffer();
		if (varDestino.getInteiro().toString().length() == 1) {
			pic.append("PIC  X(00" + varDestino.getInteiro() + ")");
		} else if (varDestino.getInteiro().toString().length() == 2) {
			pic.append("PIC  X(0" + varDestino.getInteiro() + ")");
		} else {
			pic.append("PIC  X(" + varDestino.getInteiro() + ")");
		}
		aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "WRK-9-"
				+ varOrigem.getInteiro() + "-TO" + "-X-"
				+ varDestino.getInteiro(), String.valueOf(pic) + ".", "", "",
				""));
		aux.append("\n");
		retorno.add(String.valueOf(aux));
		aux = new StringBuffer();
		pic = new StringBuffer();
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "MOVE", varOrigem
				.getNome(), "TO", "WRK-9-" + varOrigem.getInteiro() + ".",
				null, null));
		aux.append("\n");
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "MOVE", "WRK-9-"
				+ varOrigem.getInteiro() + "-TO" + "-X-"
				+ varDestino.getInteiro(), "TO", varDestino.getNome() + ".\n",
				null, null));
		retorno.add(String.valueOf(aux));

		return retorno;

	}

	/**
	 * @AUTHOR Andre 
	 * Redefinir numérica sinalizada para numérica não sinalizada.
	 */
	public List<String> S99To99(VariavelTO varOrigem, VariavelTO varDestino,
			Integer space) {
        StringBuffer aux = new StringBuffer();
        StringBuffer pic = new StringBuffer();
        List<String> retorno = new ArrayList<String>();
        if (varOrigem.getInteiro().toString().length() == 1) {
               pic.append("PIC +9(00" + varOrigem.getInteiro() + ")");
        } else if (varOrigem.getInteiro().toString().length() == 2) {
               pic.append("PIC +9(0" + varOrigem.getInteiro() + ")");
        } else {
               pic.append("PIC +9(" + varOrigem.getInteiro() + ")");
        }
        aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "WRK-S9-"
                      + varOrigem.getInteiro(), String.valueOf(pic), "",
                      "VALUE ZEROS.", ""));
        aux.append("\n");
        retorno.add(String.valueOf(aux));
        aux = new StringBuffer();
        aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "FILLER",
                      "REDEFINES", "WRK-S9-" + varOrigem.getInteiro() + ".\n", "", ""));
        aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "FILLER",
                      "PIC  X(001).", "\n", null, null));
        aux.append(UtilProjeto.geraMovimentacoes(
                      space + 3,
                      "10 ",
                      "WRK-S9-" + varOrigem.getInteiro() + "-TO" + "-9-"
                                   + varOrigem.getInteiro(), String.valueOf(pic)
                                   .replaceAll("\\+", " ") + ".", "", "", ""));
        aux.append("\n");
        retorno.add(String.valueOf(aux));
        aux = new StringBuffer();
        pic = new StringBuffer();
        aux.append(UtilProjeto.geraMovimentacoes(space - 1, "MOVE",
                      varOrigem.getNome(), "TO", "WRK-S9-" + varOrigem.getInteiro()
                                   + ".\n", null, null));
        aux.append(UtilProjeto.geraMovimentacoes(
                      space - 1,
                      "MOVE",
                      "WRK-S9-" + varOrigem.getInteiro() + "-TO" + "-9-"
                                   + varOrigem.getInteiro(), "TO", varDestino.getNome()
                                   + ".", String.valueOf(pic), "\n"));
        aux.append("\n");
        retorno.add(String.valueOf(aux));
        return retorno;


	}

	/**
	 * @AUTHOR Ed 
	 * Método para redefinir a origem, retirar sinal e mover parar
	 * alfanumérica sua origem é maior que o destino, ex: S99 to X
	 */
	public List<String> S99ToX(VariavelTO varOrigem, VariavelTO varDestino,
			Integer space) {
		StringBuffer aux = new StringBuffer();
		String pic;
		Integer dif;
		List<String> retorno = new ArrayList<String>();
		if (varOrigem.getInteiro().toString().length() == 1) {
			pic = "PIC +9(00" + varOrigem.getInteiro() + ")";
		} else if (varOrigem.getInteiro().toString().length() == 2) {
			pic = "PIC +9(0" + varOrigem.getInteiro() + ")";
		} else {
			pic = "PIC +9(" + varOrigem.getInteiro() + ")";
		}
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "WRK-S9-"
				+ varOrigem.getInteiro(), pic, "", "VALUE ZEROS.", "\n"));
		retorno.add(aux.toString());
		// fim da parte 1
		aux = new StringBuffer();
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "FILLER",
				"REDEFINES", "WRK-S9-" + varOrigem.getInteiro() + ".\n", null,
				null));

		pic = "";
		dif = varOrigem.getInteiro() - varDestino.getInteiro() + 1;
		if (dif.toString().length() == 1) {
			pic = "PIC  X(00" + dif + ").";
		} else if (dif.toString().length() == 2) {
			pic = "PIC  X(0" + dif + ").";
		} else {
			pic = "PIC  X(" + dif + ").";
		}

		aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "FILLER",
				pic, "\n", null, null));
		pic = "";
		if (varDestino.getInteiro().toString().length() == 1) {
			pic = "PIC  X(00" + varDestino.getInteiro() + ").";
		} else if (varDestino.getInteiro().toString().length() == 2) {
			pic = "PIC  X(0" + varDestino.getInteiro() + ").";
		} else {
			pic = "PIC  X(" + varDestino.getInteiro() + ").";
		}
		aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "WRK-S9-"
				+ varOrigem.getInteiro() + "-TO-X-" + varDestino.getInteiro(),
				pic, "", "", ""));
		aux.append("\n");
		retorno.add(aux.toString());
		// fim da parte 2
		aux = new StringBuffer();
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "MOVE", varOrigem
				.getNome(), "TO", "WRK-S9-" + varOrigem.getInteiro() + ".\n",
				null, null));

		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "MOVE", "WRK-S9-"
				+ varOrigem.getInteiro() + "-TO-X-" + varDestino.getInteiro(),
				"TO", varDestino.getNome() + ".", "", ""));
		aux.append("\n");
		retorno.add(aux.toString());
		// fim da parte 3
		return retorno;

	}

	/**
	 * @AUTHOR Ed 
	 * Método para redefinir a origem, sua origem tem o mesmo tamanho
	 * que o destino, ex: 9V9 to X
	 */
	public List<String> _9V9ToX(VariavelTO varOrigem, VariavelTO varDestino, Integer space) {
		StringBuffer aux = new StringBuffer();
		String pic;
		Integer dif;
		List<String> retorno = new ArrayList<String>();
		if (varOrigem.getInteiro().toString().length() == 1) {
			pic = "PIC  9(00" + varOrigem.getInteiro() + ")";
		} else if (varOrigem.getInteiro().toString().length() == 2) {
			pic = "PIC  9(0" + varOrigem.getInteiro() + ")";
		} else {
			pic = "PIC  9(" + varOrigem.getInteiro() + ")";
		}
		if (varOrigem.getDecimais().toString().length() == 1) {
			pic = pic.concat("V9(00" + varOrigem.getDecimais() + ")");
		} else if (varOrigem.getDecimais().toString().length() == 2) {
			pic = pic.concat("V9(0" + varOrigem.getDecimais() + ")");
		} else {
			pic = pic.concat("V9(" + varOrigem.getDecimais() + ")");
		}
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "WRK-9-"
				+ varOrigem.getInteiro() + "-V" + varOrigem.getDecimais(), pic,
				"", "VALUE ZEROS.", "\n"));
		retorno.add(aux.toString());
		// fim da parte 1
		aux = new StringBuffer();
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "FILLER",
				"REDEFINES", "WRK-9-" + varOrigem.getInteiro() + "-V"
						+ varOrigem.getDecimais() + ".\n", null, null));

		pic = "";
		if (varDestino.getInteiro().toString().length() == 1) {
			pic = "PIC  X(00" + varOrigem.getInteiro() + ").";
		} else if (varDestino.getInteiro().toString().length() == 2) {
			pic = "PIC  X(0" + varOrigem.getInteiro() + ").";
		} else {
			pic = "PIC  X(" + varOrigem.getInteiro() + ").";
		}
		aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "WRK-9-"
				+ varOrigem.getInteiro() + "-V" + varOrigem.getDecimais()
				+ "-TO-X-" + varOrigem.getInteiro(), pic, "\n", null, null));

		pic = "";
		dif = varOrigem.getDecimais();
		if (dif.toString().length() == 1) {
			pic = "PIC  X(00" + dif + ").";
		} else if (dif.toString().length() == 2) {
			pic = "PIC  X(0" + dif + ").";
		} else {
			pic = "PIC  X(" + dif + ").";
		}
		aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "FILLER",
				pic, "", "", ""));
		aux.append("\n");
		retorno.add(aux.toString());
		// fim da parte 2
		aux = new StringBuffer();
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "MOVE", varOrigem
				.getNome(), "TO", "WRK-9-" + varOrigem.getInteiro() + "-V"
				+ varOrigem.getDecimais() + ".\n", null, null));

		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "MOVE", "WRK-9-"
				+ varOrigem.getInteiro() + "-V" + varOrigem.getDecimais()
				+ "-TO-X-" + varOrigem.getInteiro(), "TO", varDestino.getNome()
				+ ".", null, null));
		aux.append("\n");
		retorno.add(aux.toString());
		// fim da parte 3
		return retorno;
	}

	/**
	 * @AUTHOR Ed 
	 * Método para redefinir a origem, sua origem é menor que o
	 * destino, ex: 9V9 to XX
	 */
	public List<String> _9V9ToXX(VariavelTO varOrigem, VariavelTO varDestino, Integer space) {
		StringBuffer aux = new StringBuffer();
		String pic;
		Integer dif;
		List<String> retorno = new ArrayList<String>();
		if (varOrigem.getInteiro().toString().length() == 1) {
			pic = "PIC  9(00" + varOrigem.getInteiro() + ")";
		} else if (varOrigem.getInteiro().toString().length() == 2) {
			pic = "PIC  9(0" + varOrigem.getInteiro() + ")";
		} else {
			pic = "PIC  9(" + varOrigem.getInteiro() + ")";
		}
		if (varOrigem.getDecimais().toString().length() == 1) {
			pic = pic.concat("V9(00" + varOrigem.getDecimais() + ")");
		} else if (varOrigem.getDecimais().toString().length() == 2) {
			pic = pic.concat("V9(0" + varOrigem.getDecimais() + ")");
		} else {
			pic = pic.concat("V9(" + varOrigem.getDecimais() + ")");
		}
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "WRK-9-"
				+ varOrigem.getInteiro() + "-V" + varOrigem.getDecimais(), pic,
				"", "VALUE ZEROS.", "\n"));
		retorno.add(aux.toString());
		// fim da parte 1
		aux = new StringBuffer();
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "FILLER",
				"REDEFINES", "WRK-9-" + varOrigem.getInteiro() + "-V"
						+ varOrigem.getDecimais() + ".\n", null, null));

		pic = "";
		if (varOrigem.getInteiro().toString().length() == 1) {
			pic = "PIC  X(00" + varOrigem.getInteiro() + ").";
		} else if (varDestino.getInteiro().toString().length() == 2) {
			pic = "PIC  X(0" + varOrigem.getInteiro() + ").";
		} else {
			pic = "PIC  X(" + varOrigem.getInteiro() + ").";
		}
		aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "WRK-9-"
				+ varOrigem.getInteiro() + "-V" + varOrigem.getDecimais()
				+ "-TO-X-" + varOrigem.getInteiro(), pic, "\n", null, null));

		pic = "";
		dif = varOrigem.getDecimais();
		if (dif.toString().length() == 1) {
			pic = "PIC  X(00" + dif + ").";
		} else if (dif.toString().length() == 2) {
			pic = "PIC  X(0" + dif + ").";
		} else {
			pic = "PIC  X(" + dif + ").";
		}
		aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "FILLER",
				pic, "", "", ""));
		aux.append("\n");
		retorno.add(aux.toString());
		// fim da parte 2
		aux = new StringBuffer();
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "MOVE", varOrigem
				.getNome(), "TO", "WRK-9-" + varOrigem.getInteiro() + "-V"
				+ varOrigem.getDecimais() + ".\n", null, null));

		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "MOVE", "WRK-9-"
				+ varOrigem.getInteiro() + "-V" + varOrigem.getDecimais()
				+ "-TO-X-" + varOrigem.getInteiro(), "TO", varDestino.getNome()
				+ ".", null, null));
		aux.append("\n");
		retorno.add(aux.toString());
		// fim da parte 3
		return retorno;
	}

	/**
	 * @AUTHOR Ed 
	 * Método para redefinir a origem, sua origem é maior que o
	 * destino e sinalizada, ex: S99V9 to X
	 */
	public List<String> S99V9ToX(VariavelTO varOrigem, VariavelTO varDestino, Integer space) {
		StringBuffer aux = new StringBuffer();
		String pic;
		Integer dif;
		List<String> retorno = new ArrayList<String>();
		if (varOrigem.getInteiro().toString().length() == 1) {
			pic = "PIC +9(00" + varOrigem.getInteiro() + ")";
		} else if (varOrigem.getInteiro().toString().length() == 2) {
			pic = "PIC +9(0" + varOrigem.getInteiro() + ")";
		} else {
			pic = "PIC +9(" + varOrigem.getInteiro() + ")";
		}
		if (varOrigem.getDecimais().toString().length() == 1) {
			pic = pic.concat("V9(00" + varOrigem.getDecimais() + ")");
		} else if (varOrigem.getDecimais().toString().length() == 2) {
			pic = pic.concat("V9(0" + varOrigem.getDecimais() + ")");
		} else {
			pic = pic.concat("V9(" + varOrigem.getDecimais() + ")");
		}
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "WRK-S9-"
				+ varOrigem.getInteiro() + "-V" + varOrigem.getDecimais(), pic,
				"", "VALUE ZEROS.", "\n"));
		retorno.add(aux.toString());
		// fim da parte 1
		aux = new StringBuffer();
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "FILLER",
				"REDEFINES", "WRK-S9-" + varOrigem.getInteiro() + "-V"
						+ varOrigem.getDecimais() + ".\n", "", ""));

		pic = "";
		dif = varOrigem.getInteiro() - varDestino.getInteiro();
		if (dif.toString().length() == 1) {
			pic = "PIC  X(00" + dif + ").";
		} else if (dif.toString().length() == 2) {
			pic = "PIC  X(0" + dif + ").";
		} else {
			pic = "PIC  X(" + dif + ").";
		}
		aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "FILLER",
				pic, "\n", null, null));

		pic = "";
		if (varDestino.getInteiro().toString().length() == 1) {
			pic = "PIC  X(00" + varDestino.getInteiro() + ").";
		} else if (varDestino.getInteiro().toString().length() == 2) {
			pic = "PIC  X(0" + varDestino.getInteiro() + ").";
		} else {
			pic = "PIC  X(" + varDestino.getInteiro() + ").";
		}

		aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "WRK-S9-"
				+ varOrigem.getInteiro() + "-V" + varOrigem.getDecimais()
				+ "-TO-X-" + varDestino.getInteiro(), pic, "", null, null));
		aux.append("\n");
		retorno.add(aux.toString());
		// fim da parte 2
		aux = new StringBuffer();
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "MOVE", varOrigem
				.getNome(), "TO", "WRK-S9-" + varOrigem.getInteiro() + "-V"
				+ varOrigem.getDecimais() + ".\n", null, null));

		aux.append((UtilProjeto.geraMovimentacoes(space - 1, "MOVE", "WRK-S9-"
				+ varOrigem.getInteiro() + "-V" + varOrigem.getDecimais()
				+ "-TO-X-" + varDestino.getInteiro(), "TO", varDestino
				.getNome()
				+ ".", null, null)));
		aux.append("\n");
		retorno.add(aux.toString());
		// fim da parte 3
		return retorno;
	}

	/**
	 * @AUTHOR Ed 
	 * Método para redefinir a origem, sua origem é numérica e o
	 * destino alfanumérico de mesmo tamanho, ex: 9 to X
	 */
	public List<String> _9ToX(VariavelTO varOrigem, VariavelTO varDestino, Integer space) {
		StringBuffer aux = new StringBuffer();
		String pic;
		List<String> retorno = new ArrayList<String>();
		if (varOrigem.getInteiro().toString().length() == 1) {
			pic = "PIC  9(00" + varOrigem.getInteiro() + ")";
		} else if (varOrigem.getInteiro().toString().length() == 2) {
			pic = "PIC  9(0" + varOrigem.getInteiro() + ")";
		} else {
			pic = "PIC  9(" + varOrigem.getInteiro() + ")";
		}
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ", "WRK-9-"
				+ varOrigem.getInteiro(), pic, "", "VALUE ZEROS.", "\n"));
		retorno.add(aux.toString());
		// fim da parte 1
		aux = new StringBuffer();
		aux
				.append(UtilProjeto.geraMovimentacoes(space - 1, "05 ",
						"FILLER", "REDEFINES", "WRK-9-"
								+ varOrigem.getInteiro() + ".\n", "", ""));

		pic = "";
		if (varDestino.getInteiro().toString().length() == 1) {
			pic = "PIC  X(00" + varOrigem.getInteiro() + ").";
		} else if (varDestino.getInteiro().toString().length() == 2) {
			pic = "PIC  X(0" + varOrigem.getInteiro() + ").";
		} else {
			pic = "PIC  X(" + varOrigem.getInteiro() + ").";
		}
		aux.append(UtilProjeto.geraMovimentacoes(space + 3, "10 ", "WRK-9-"
				+ varOrigem.getInteiro() + "-TO-X-" + varOrigem.getInteiro(),
				pic, "", "", ""));
		aux.append("\n");
		retorno.add(aux.toString());
		// fim da parte 2
		aux = new StringBuffer();
		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "MOVE", varOrigem
				.getNome(), "TO", "WRK-9-" + varOrigem.getInteiro() + ".\n",
				null, null));

		aux.append(UtilProjeto.geraMovimentacoes(space - 1, "MOVE", "WRK-9-"
				+ varOrigem.getInteiro() + "-TO-X-" + varOrigem.getInteiro(),
				"TO", varDestino.getNome() + ".", null, null));
		aux.append("\n");
		retorno.add(aux.toString());
		// fim da parte 3
		return retorno;
	}

}