package br.edu.unoesc.vboot;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TesteLambda {

	public static void main(String[] args) {
	
		List<String> nomes = Arrays.asList("André Luiz","Gabriel", "Joaquim Pedro", "Paulo");
		//Imprime todos os nomes da lista utilizando Method references
		nomes.forEach(System.out::println);
		
		Venda venda1 = new Venda(LocalDate.of(2014, 03, 20), 1500.0);
		Venda venda2 = new Venda(LocalDate.of(2014, 04, 27), 1800.0);
		Venda venda3 = new Venda(LocalDate.of(2014, 05, 10), 500.0);
		List<Venda> vendas = Arrays.asList(venda1, venda2, venda3);
		
		//Utilizando lambda em uma classe desenvolvida. Filtra as vendas com valor maior que 1000.0 e gera uma nova lista
		List<Venda> vendasFiltrado = FiltroUtil.filtrar(vendas, vend->vend.getValorTotal() > 1000.0);
		//Utilizando lambda para imprimir os valores da nova lista
		vendasFiltrado.forEach(venda-> System.out.println(venda.getValorTotal()));
		
		//Mesmo exemplo de filtro só que utilizando agora o Stream e filter do próprio java. Muito melhor.
		List<Venda> vendas1000 = vendas.stream()
				.filter(u->u.getValorTotal() > 1000.0)
				.collect(Collectors.toList());
		vendas1000.forEach(venda-> System.out.println(venda.getValorTotal()));
		
		//Reduce do stream
		double valorMaximo = vendas.stream().mapToDouble(Venda::getValorTotal).max().orElse(0);
		
		System.out.println(valorMaximo);
		
		//Map do stream. Todas as vendas por data.
		Map<LocalDate, List<Venda>> vendasPorData = vendas.stream()
				.collect(Collectors.groupingBy(v -> v.getDataVenda()));
		
		System.out.println(vendasPorData);
		
		//Exemplo de outros coletores da classe Collectors
		String nomesVirgula = nomes.stream().collect(Collectors.joining(","));
		
		System.out.println(nomesVirgula);
		
		//Exemplo da utilização da classe Optional, para diminuir os erros de NPE.
		Optional<String> nome = getNome();
		
		System.out.println(nome.orElse("Vazio"));
		
	}
	
	public static Optional<String> getNome(){
		return Optional.of("Valor");
	}
	
}
