package provaPraticaPoo2023;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {
		ArrayList<Rodovia> rodovias = new ArrayList<Rodovia>();
		ArrayList<Acidente> acidentes = new ArrayList<Acidente>();
		
		String menu = "1 - Cadastrar Rodovia\n"
				    + "2 - Cadastrar Acidentes\n"
				    + "3 - Listar todos os acidentes cujo algum condutor estava embriagado\n"
				    + "4 - Listar a quantidade de acidentes por nível de periculosidade\n"
				    + "5 - Listar todos os veículos de carga que se envolveram em acidentes\n"
				    + "6 - Listar a rodovia com mais acidentes com bicicletas\n"
				    + "7 - Listar o acidente com mais vitimas fatais\n"
				    + "8 - Retornar a quantidade de acidentes que possuem veículos novos\n"
				    + "9 - Listar rodovias que registraram acidentes no carnaval\n"
				    + "10 - Sair\n\n";
	
		int op = 0;
		
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			if(op == 1) {
				Rodovia r = new Rodovia();
				r.cadastrarRodovia();
				rodovias.add(r);
			}else if(op == 2) {
				Acidente a = new Acidente();
				a.cadastrarAcidente(rodovias);
				acidentes.add(a);
			}else if(op == 3) {
				JOptionPane.showMessageDialog(null, Util.listaAcidentesCondutorEmbriagado(acidentes));
			}else if(op == 4) {
				JOptionPane.showMessageDialog(null,Util.listarQuantidadeAcidenteporGrauPericulosidade(acidentes));
			}else if(op == 5) {
				JOptionPane.showMessageDialog(null,Util.listarVeiculosCargasAcidentes(acidentes));
			}else if(op == 6) {
				JOptionPane.showMessageDialog(null,Util.listarRodoviaAcidentesBicicleta(acidentes));
			}else if(op == 7) {
				JOptionPane.showMessageDialog(null,Util.listaAcidentesVitimasFatais(acidentes));
			}else if(op == 8){
				JOptionPane.showMessageDialog(null,Util.quantidadeAcidentesVeiculosNovos(acidentes));
			}else if(op == 9){
				JOptionPane.showMessageDialog(null,Util.listaRodoviasAcidentesCarnaval(acidentes));
			}
			
		}while(op != 10);
		
	}
}
