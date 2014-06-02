package br.edu.unoesc.vboot;

/**
 * Interface funcional para construir exemplo de filtro de listas dinâmicos.
 * @author forchesatto
 *
 * @param <T>
 */
@FunctionalInterface
public interface Criterio<T> {

	boolean teste(T objeto);
}
