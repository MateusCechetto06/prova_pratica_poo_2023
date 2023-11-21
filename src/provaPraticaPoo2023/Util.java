package provaPraticaPoo2023;

import java.util.ArrayList;

public class Util {
	public static String listaAcidentesCondutorEmbriagado(ArrayList<Acidente> acidentes) {
		String texto = "";
		for(Acidente a: acidentes) {
			for(Veiculo v: a.getVeiculos()) {
				for(Pessoa p: v.getPessoas()) {
					if(p.isCondutorEmbriagado()) {
						texto += a;
						break;
					}
				}
			}
		}
		
		if (!texto.equals("")) {
			return texto;
			
		}else {
			return "Os acidentes registrados não possuem nenhum condutor embriagado";
		}
		
	}
	
	public static String listarQuantidadeAcidenteporGrauPericulosidade(ArrayList<Acidente> acidentes) {
		int qtdNivelBaixo = 0, qtdNivelMedio = 0, qtdNivelAlto = 0;
		
		for(Acidente a: acidentes) {
			if(a.getRodovia().getGrauPericulosidade().equalsIgnoreCase("Alto")){
				qtdNivelAlto++;
			}else if(a.getRodovia().getGrauPericulosidade().equalsIgnoreCase("Médio")){
				qtdNivelMedio++;
			}else if(a.getRodovia().getGrauPericulosidade().equalsIgnoreCase("Baixo")){
				qtdNivelBaixo++;
			}
		}
		
		return "Quantidade de acidentes por grau de periculosidade da rodovia:\n"
		      + "Grau Alto: " + qtdNivelAlto +"\n"
		      + "Grau Médio: " + qtdNivelMedio + "\n"
		      + "Grau Baixo: " + qtdNivelBaixo;
		
	}
	
	public static String listarVeiculosCargasAcidentes(ArrayList<Acidente> acidentes) {
		String texto = "";
		
		for(Acidente a: acidentes) {
			for(Veiculo v: a.getVeiculos()) {
				if(v instanceof VeiculoCarga) {
					texto += v.toString() + "\n";
				}
			}
		}
		
		if (!texto.equals("")) {
			return texto;
		}else {
			return "Não existem veículos de carga nos acidentes cadastrados";
		}
		
	}
	
	public static String listarRodoviaAcidentesBicicleta(ArrayList<Acidente> acidentes) {
		String texto = "";
		int qtdAcidente = 0;
		
		for(Acidente a: acidentes) {
			if(a.getRodovia().getQtdAcidentesBicicletas() > qtdAcidente) {
				qtdAcidente = a.getRodovia().getQtdAcidentesBicicletas();
				texto = a.getRodovia().toString();
			}
		}
		
		if (!texto.equals("")) {
			return texto;
		}else {
			return "Não existem veículos de carga nos acidentes cadastrados";
		}
		
	}
	
	public static String listaAcidentesVitimasFatais(ArrayList<Acidente> acidentes) {
		String texto = "";
		int qtdAcidente = 0;
		
		for(Acidente a: acidentes) {
			if(a.getRodovia().getQtdAcidentesVitimasFatais() > qtdAcidente) {
				qtdAcidente = a.getRodovia().getQtdAcidentesVitimasFatais();
				texto = a.getRodovia().toString();
			}
		}
		
		return texto;
	}
	
	public static String listaRodoviasAcidentesCarnaval(ArrayList<Acidente> acidentes) {
		String texto = "";
		
		for(Acidente a : acidentes) {
			if (a.getMes() == 2) {
				texto += a.getRodovia() + "\n";
			}
		}
		
		if (!texto.equals("")) {
			return texto;
		}else {
			return "As rodovias cadastradas não possuem acidentes no carnaval";
		}
		
		
	}
	
	public static String quantidadeAcidentesVeiculosNovos(ArrayList<Acidente> acidentes) {
		int cont = 0;
		
		for(Acidente a : acidentes) {
			for(Veiculo v: a.getVeiculos()) {
				if (v.getAnoFabricacao() >= 2013) {
					cont++;
					break;
				}
			}
		}
		
		return "Acidentes que possuem veículos novos: " + cont;
	}
}
