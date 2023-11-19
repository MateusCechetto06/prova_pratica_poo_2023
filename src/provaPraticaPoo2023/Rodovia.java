package provaPraticaPoo2023;

import javax.swing.JOptionPane;

public class Rodovia {
	private String sigla;
	private String grauPericulosidade;
	private int qtdAcidentesVitimasFatais;
	private int qtdAcidentesBicicletas;
	
	public Rodovia() {
	}
	
	public Rodovia(String sigla, String grau) {
		this.sigla = sigla;
		this.grauPericulosidade = grau;
	}
	
	public boolean cadastrarRodovia() {
		this.sigla = JOptionPane.showInputDialog("Digite a sigla da rodovia:").toUpperCase();
		
		do {
			int grau = Integer.parseInt(JOptionPane.showInputDialog("Digite o grau de periculosidade da via:\n"
					                                              + "1 - Alto\n"
					                                              + "2 - Médio\n"
					                                              + "3 - Baixo"));
			
			if(grau == 1) {
				this.grauPericulosidade = "Alto";
			}else if(grau == 2) {
				this.grauPericulosidade = "Médio";
			}else if(grau== 3) {
				this.grauPericulosidade = "Baixo";
			}else {
				this.grauPericulosidade = "";
				JOptionPane.showMessageDialog(null, "Grau inválido!");
			}
		}while(this.grauPericulosidade.equals(""));
		
		return true;
	}
	
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getGrauPericulosidade() {
		return grauPericulosidade;
	}
	public void setGrauPericulosidade(String grauPericulosidade) {
		this.grauPericulosidade = grauPericulosidade;
	}

	public int getQtdAcidentesVitimasFatais() {
		return qtdAcidentesVitimasFatais;
	}

	public void setQtdAcidentesVitimasFatais(int qtdAcidentesVitimasFatais) {
		this.qtdAcidentesVitimasFatais = qtdAcidentesVitimasFatais;
	}

	public int getQtdAcidentesBicicletas() {
		return qtdAcidentesBicicletas;
	}

	public void setQtdAcidentesBicicletas(int qtdAcidentesBicicletas) {
		this.qtdAcidentesBicicletas = qtdAcidentesBicicletas;
	}

	@Override
	public String toString() {
		return sigla + " [Grau de periculosidade:"+grauPericulosidade+"]";
	}
	
}
