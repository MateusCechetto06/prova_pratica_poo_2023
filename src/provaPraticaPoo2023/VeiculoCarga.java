package provaPraticaPoo2023;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class VeiculoCarga extends Veiculo{
	private double qtdCarga;
	
	public VeiculoCarga() {
		
	}
	
	public VeiculoCarga(String nome, int ano, ArrayList<Pessoa> pessoas, double qtdCarga) {
		super(nome, ano, pessoas);
		this.qtdCarga = qtdCarga;
		
	}
	
	@Override
	public void cadastrarVeiculo() {		
		this.qtdCarga = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de carga do veiculo"));
		super.cadastrarVeiculo();
	}

	public double getQtdCarga() {
		return qtdCarga;
	}

	public void setQtdCarga(double qtdCarga) {
		this.qtdCarga = qtdCarga;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Quantidade da carga:" + this.qtdCarga ;
	}
}
