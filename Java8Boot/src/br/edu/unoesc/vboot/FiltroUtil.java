package br.edu.unoesc.vboot;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe utilitaria para filtrar dados de uma lista, seguindo um critério.
 * @author forchesatto
 *
 */
public class FiltroUtil {

	/**
	 * Filtra os dados com base em um critério que pode ser um expressão lambda.
	 * @param dados
	 * @param criterio pode se um expressão lambda
	 * @return
	 */
	public static <T> List<T> filtrar(List<T> dados, Criterio<T> criterio){
		List<T> novaLista = new ArrayList<T>();
		//Exemplo de código lambda para um for.
		dados.forEach(dado->{
								if(criterio.teste(dado))
									novaLista.add(dado);
							});
		return novaLista;
	}
}
