package provaPraticaPoo2023;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Veiculo {
	private String nome;
	private int anoFabricacao;
	private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	public Veiculo() {
	}
	
	public Veiculo(String nome, int ano, ArrayList<Pessoa> pessoas) {
		this.nome = nome;
		this.anoFabricacao = ano;
		this.pessoas = pessoas; 
	}
	
	public void cadastrarVeiculo() {
		this.nome = JOptionPane.showInputDialog("Digite o nome do veículo:");
		this.anoFabricacao = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de fabricação do veículo:"));
		JOptionPane.showMessageDialog(null, "Iremos agora cadastrar a(s) pessoa(s) do veículo");
		do {
			Pessoa p = new Pessoa();
			p.cadastrarPessoa();
			pessoas.add(p);
		}while (JOptionPane.showInputDialog("Deseja incluir novas pessoas no veículo?(S/N)").substring(0).equalsIgnoreCase("S"));
		
		selecionaCondutor(pessoas);
		
	}
	
	private String retornaPessoas(ArrayList<Pessoa> pessoas) {
		String texto = "";
		for(Pessoa p: pessoas) {
			texto += p + "\n";
		}
		
		return texto;
	}
	
	private void selecionaCondutor(ArrayList<Pessoa> pessoas) {
		String menu = "Qual das pessoas cadastradas era o condutor do veículo?\n";
		int cont = 1;
		for(Pessoa p: pessoas) {
			menu += cont + " - " + p + "\n";
			cont++;
		}
		
		int escolha = Integer.parseInt(JOptionPane.showInputDialog(menu));
		
		pessoas.get(escolha-1).setCondutor(true);
		
		if (JOptionPane.showInputDialog("O condutor estava embriagado(a)(S/N)?").substring(0).equalsIgnoreCase("S")) {
			pessoas.get(escolha-1).setCondutorEmbriagado(true);
		}
	}
	
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoas(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	@Override
	public String toString() {
		return this.nome+ ": " + this.anoFabricacao + "\n" + retornaPessoas(pessoas);
	}
	
}
