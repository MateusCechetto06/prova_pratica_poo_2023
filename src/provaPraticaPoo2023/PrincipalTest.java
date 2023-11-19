package provaPraticaPoo2023;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PrincipalTest {
	
	@Test
	public void cadastrarRodoviaTest() {
		Rodovia rodovia1 = new Rodovia();
		assertTrue(rodovia1.cadastrarRodovia());
	}
	
	@Test
	public void cadastrarAcidenteTest() {
		ArrayList<Rodovia> rodovias = new ArrayList<Rodovia>();
		Rodovia rodovia1 = new Rodovia("SC", "Alto");
		rodovias.add(rodovia1);
		Acidente acidente1 = new Acidente();
		assertTrue(acidente1.cadastrarAcidente(rodovias));	
	}
	
	@Test
	public void listarEmbriagadosTest() {
		Rodovia rodovia1 = new Rodovia("SC", "Alto");
		Rodovia rodovia2 = new Rodovia("PR", "Médio");
		
		ArrayList<Rodovia> rodovias = new ArrayList<Rodovia>();
		rodovias.add(rodovia1);
		rodovias.add(rodovia2);
		
		Pessoa pessoa1 = new Pessoa("Mateus", 22, 'M', true, true);
		Pessoa pessoa2 = new Pessoa("Bianca", 19, 'F', false, false);
		
		ArrayList<Pessoa> pessoas1 = new ArrayList<Pessoa>();
		pessoas1.add(pessoa1);
		pessoas1.add(pessoa2);
		
		Veiculo veiculo1 = new Veiculo("GOL", 2022, pessoas1);
		
		Pessoa pessoa3 = new Pessoa("Maria", 50, 'M', true, false);
		
		ArrayList<Pessoa> pessoas2 = new ArrayList<Pessoa>();
		pessoas1.add(pessoa3);
		
		Veiculo veiculo2 = new Veiculo("Ford K", 2010, pessoas2);
		
		ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
		veiculos.add(veiculo1);
		veiculos.add(veiculo2);
		
		Acidente acidente1 = new Acidente(rodovia1, 0, 0, 2, veiculos);
		
		ArrayList<Acidente> acidentes = new ArrayList<Acidente>();
		acidentes.add(acidente1);
		
		assertEquals(Util.listaAcidentesCondutorEmbriagado(acidentes), acidente1.toString());
	}
	
	@Test
	public void listarQuantidadeAcidentePorGrauPericulosidadeTest() {
		Rodovia rodovia1 = new Rodovia("SC", "Alto");
		Rodovia rodovia2 = new Rodovia("PR", "Médio");
		Rodovia rodovia3 = new Rodovia("RJ", "Baixo");
				
		ArrayList<Rodovia> rodovias = new ArrayList<Rodovia>();
		rodovias.add(rodovia1);
		rodovias.add(rodovia2);
		rodovias.add(rodovia3);
		
		Acidente acidente1 = new Acidente(rodovia1, 0, 0, 0, null);
		Acidente acidente2 = new Acidente(rodovia1, 0, 0, 0, null);
		Acidente acidente3 = new Acidente(rodovia2, 0, 0, 0, null);
		Acidente acidente4 = new Acidente(rodovia3, 0, 0, 0, null);
		
		ArrayList<Acidente> acidentes = new ArrayList<Acidente>();
		
		acidentes.add(acidente1);
		acidentes.add(acidente2);
		acidentes.add(acidente3);
		acidentes.add(acidente4);
		
		
		assertEquals("Quantidade de acidentes por grau de periculosidade da rodovia:\n"
	              + "Grau Alto: " + 2 +"\n"
	              + "Grau Médio: " + 1 + "\n"
	              + "Grau Baixo: " + 1, Util.listarQuantidadeAcidenteporGrauPericulosidade(acidentes));
		
	}
	
	@Test
	public void listarVeiculosCargasAcidentesTest() {
		Rodovia rodovia1 = new Rodovia("SC", "Alto");
		
		ArrayList<Rodovia> rodovias = new ArrayList<Rodovia>();
		rodovias.add(rodovia1);
		
		Pessoa pessoa1 = new Pessoa("Mateus", 22, 'M', true, true);
		
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		
		Veiculo veiculo1 = new VeiculoCarga("Caminhao", 2022, pessoas, 250);
		
		ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
		veiculos.add(veiculo1);
		
		Acidente acidente1 = new Acidente(rodovia1, 0, 0, 2, veiculos);
		
		ArrayList<Acidente> acidentes = new ArrayList<Acidente>();
		acidentes.add(acidente1);
		
		assertEquals(Util.listarVeiculosCargasAcidentes(acidentes), veiculo1 + "\n");
		
	}
	
	@Test
	public void listarRodoviaAcidentesBicicletaTest() {
		Rodovia rodovia1 = new Rodovia("SC", "Alto");
		Rodovia rodovia2 = new Rodovia("PR", "Médio");
		
		ArrayList<Rodovia> rodovias = new ArrayList<Rodovia>();
		rodovias.add(rodovia1);
		rodovias.add(rodovia2);
		
		Pessoa pessoa1 = new Pessoa("Mateus", 22, 'M', true, true);
		
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		
		Veiculo veiculo1 = new Bicicleta("BMX", 2022, pessoas);
		rodovias.get(1).setQtdAcidentesBicicletas(+1);
		
		ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
		veiculos.add(veiculo1);
		
		Acidente acidente1 = new Acidente(rodovia2, 0, 0, 2, veiculos);
		
		ArrayList<Acidente> acidentes = new ArrayList<Acidente>();
		acidentes.add(acidente1);
		
		assertEquals(Util.listarRodoviaAcidentesBicicleta(acidentes), rodovia2.toString());
		
	}
	
	@Test
	public void listaAcidentesVitimasFataisTest() {
		Rodovia rodovia1 = new Rodovia("SC", "Alto");
		Rodovia rodovia2 = new Rodovia("PR", "Médio");
		Rodovia rodovia3 = new Rodovia("RJ", "Baixo");
		
		ArrayList<Rodovia> rodovias = new ArrayList<Rodovia>();
		rodovias.add(rodovia1);
		rodovias.add(rodovia2);
		rodovias.add(rodovia3);
		
		Pessoa pessoa1 = new Pessoa("Mateus", 22, 'M', true, true);
		
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		
		Veiculo veiculo1 = new Bicicleta("BMX", 2022, pessoas);
		
		ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
		veiculos.add(veiculo1);
		
		Acidente acidente1 = new Acidente(rodovia2, 1, 0, 2, veiculos);
		rodovias.get(1).setQtdAcidentesVitimasFatais(+1);
	
		
		ArrayList<Acidente> acidentes = new ArrayList<Acidente>();
		
		acidentes.add(acidente1);
		
		assertEquals(Util.listaAcidentesVitimasFatais(acidentes), rodovia2.toString());
	}
	
	@Test
	
	public void listaRodoviasAcidentesCarnavalTest() {
		Rodovia rodovia1 = new Rodovia("SC", "Alto");
		Rodovia rodovia2 = new Rodovia("PR", "Médio");
		Rodovia rodovia3 = new Rodovia("RJ", "Baixo");
		
		ArrayList<Rodovia> rodovias = new ArrayList<Rodovia>();
		rodovias.add(rodovia1);
		rodovias.add(rodovia2);
		rodovias.add(rodovia3);
		
		Pessoa pessoa1 = new Pessoa("Mateus", 22, 'M', true, true);
		
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		
		Veiculo veiculo1 = new Bicicleta("BMX", 2022, pessoas);
		
		ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
		veiculos.add(veiculo1);
		
		Acidente acidente1 = new Acidente(rodovia2, 1, 0, 2, veiculos);
		Acidente acidente2 = new Acidente(rodovia1, 0, 0, 3, veiculos);
		
		ArrayList<Acidente> acidentes = new ArrayList<Acidente>();
		
		acidentes.add(acidente1);
		acidentes.add(acidente2);
		
		assertEquals(Util.listaRodoviasAcidentesCarnaval(acidentes), rodovia2.toString() +"\n");
	}
	
	@Test
	
	public void quantidadeAcidentesVeiculosNovosTest() {
		Rodovia rodovia1 = new Rodovia("SC", "Alto");
		
		ArrayList<Rodovia> rodovias = new ArrayList<Rodovia>();
		rodovias.add(rodovia1);
		
		Pessoa pessoa1 = new Pessoa("Mateus", 22, 'M', true, true);
		
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		
		Veiculo veiculo1 = new Bicicleta("BMX", 2022, pessoas);
		
		ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
		veiculos.add(veiculo1);
		
		ArrayList<Veiculo> veiculos2 = new ArrayList<Veiculo>();
		
		Acidente acidente1 = new Acidente(rodovia1, 0, 0, 3, veiculos);
		Acidente acidente2 = new Acidente(rodovia1, 0, 0, 3, veiculos);
		Acidente acidente3 = new Acidente(rodovia1, 0, 0, 3, veiculos2);
		
		ArrayList<Acidente> acidentes = new ArrayList<Acidente>();
		
		acidentes.add(acidente1);
		acidentes.add(acidente2);
		acidentes.add(acidente3);
		
		assertEquals(Util.quantidadeAcidentesVeiculosNovos(acidentes), "Acidentes que possuem veículos novos: 2");
	}

}
