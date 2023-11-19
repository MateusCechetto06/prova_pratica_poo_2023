package provaPraticaPoo2023;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Acidente {
	private Rodovia rodovia = new Rodovia();
	private int qtdVitimasFatais;
	private int qtdVitimasFeridas;
	private int mes;
	private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
	
	public Acidente() {
	}
	
	public Acidente(Rodovia rodovia, int qtdVitimasFatais, int qtdVitimasFeridas, int mes, ArrayList<Veiculo>veiculos) {
		this.rodovia = rodovia;
		this.qtdVitimasFatais = qtdVitimasFatais;
		this.qtdVitimasFeridas = qtdVitimasFeridas;
		this.mes = mes;
		this.veiculos = veiculos;
	}
	
	public boolean cadastrarAcidente(ArrayList<Rodovia> rodovias) {	
		this.rodovia = selecionaRodovia(rodovias);
		this.qtdVitimasFatais = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de vitimas fatais causada pelo acidente:"));
		if(this.qtdVitimasFatais > 0) {
			this.rodovia.setQtdAcidentesVitimasFatais(+1);
		}
		this.qtdVitimasFeridas = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de vitimas feridas causada pelo acidente:"));
		do {
			this.mes = Integer.parseInt(JOptionPane.showInputDialog("Digite o mês do acidente:\n" + retornaMeses()));
		}while(this.mes <= 0 || this.mes > 12);
		
		JOptionPane.showMessageDialog(null, "Iremos agora cadastrar o(s) veículo(s) do acidente");
		do {
			Veiculo v;
			if (JOptionPane.showInputDialog("O veículo era de carga?(S/N)").substring(0).equalsIgnoreCase("S")) {
				v = new VeiculoCarga();
			}else if(JOptionPane.showInputDialog("O veículo era uma bicicleta?(S/N)").substring(0).equalsIgnoreCase("S")) {
				v = new Bicicleta();
				this.rodovia.setQtdAcidentesBicicletas(+1);
			}else {
				v = new Veiculo();
			}
			v.cadastrarVeiculo();
			veiculos.add(v);
		}while(JOptionPane.showInputDialog("Existe mais algum veículo no acidente?(S/N)").substring(0).equalsIgnoreCase("S"));
		return true;
	}
	
	private Rodovia selecionaRodovia(ArrayList<Rodovia> rodovias) {
		String menu = "Seleciona a Rodovia onde ocorreu o acidente:\n";
		int cont = 1;
		for(Rodovia r : rodovias) {
			menu += cont + " - " + r + "\n";
			cont++;
		}
		
		int escolha = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return rodovias.get(escolha-1);
	}
	
	private String retornaMeses() {
		return "1 - Janeiro\n"
			 + "2 - Fevereiro\n"
			 + "3 - Março\n"
			 + "4 - Abril\n"
			 + "5 - Maio\n"
			 + "6 - Junho\n"
			 + "7 - Julho\n"
			 + "8 - Agosto\n"
			 + "9 - Setembro\n"
			 + "10 - Outubro\n"
			 + "11 - Novembro\n"
			 + "12 - Dezembro";	
	}
	
	private String retornaMes(int mes) {
		String mesretornado = "";
		if( mes == 1) {
			mesretornado = "Janeiro";
		}else if(mes == 2) {
			mesretornado = "Fevereiro";
		}else if(mes == 3) {
			mesretornado = "Março";
		}else if(mes == 4) {
			mesretornado = "Abril";
		}else if(mes == 5) {
			mesretornado = "Maio";
		}else if(mes == 6) {
			mesretornado = "Junho";
		}else if(mes == 7) {
			mesretornado = "Julho";
		}else if(mes == 8) {
			mesretornado = "Agosto";
		}else if(mes == 9) {
			mesretornado = "Setembro";
		}else if(mes == 10) {
			mesretornado = "Outubro";
		}else if(mes == 11) {
			mesretornado = "Novembro";
		}else if(mes == 12) {
			mesretornado = "Dezembro";
		}
		
		return mesretornado;
		
	}
	
	private String retornaVeiculos(ArrayList<Veiculo> veiculos) {
		String texto = "";
		
		for(Veiculo v: veiculos) {
	    	 texto += v + "\n";
	     }
		
		return texto;
	}

	public Rodovia getRodovia() {
		return rodovia;
	}

	public void setRodovia(Rodovia rodovia) {
		this.rodovia = rodovia;
	}

	public int getQtdVitimasFatais() {
		return qtdVitimasFatais;
	}

	public void setQtdVitimasFatais(int qtdVitimasFatais) {
		this.qtdVitimasFatais = qtdVitimasFatais;
	}

	public int getQtdVitimasFeridas() {
		return qtdVitimasFeridas;
	}

	public void setQtdVitimasFeridas(int qtdVitimasFeridas) {
		this.qtdVitimasFeridas = qtdVitimasFeridas;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public ArrayList<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(ArrayList<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	@Override
	public String toString() {
		return "Acidente:\n"
			 + rodovia + "\n"
		     + "Quantidade de vitimas fatais: " + this.qtdVitimasFatais + "\n" 
		     + "Quantidade de vitimas feridas: " + this.qtdVitimasFeridas + "\n"
		     + "Mês do acidente: " + retornaMes(this.mes) + "\n"
		     + retornaVeiculos(veiculos);
	}
}
