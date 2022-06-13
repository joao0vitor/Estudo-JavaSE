/**
 * POO - Fundamentos
 */
package minecraft;

/**
 * @author joao vitor
 *
 */
public class Bloco {
	/**
	 * Construtor
	 */
	public Bloco() {
		super();
		System.out.println("-------------------------------------");
	}
	// Atributos
	int resistencia;
	String textura;
	
	// Modelos
	// void -> Método simples sem retorno
	/**
	 * Método usado para construção
	 */
	void construir() {
		System.out.println("Bloco colocado");
	}
	/**
	 * Método usado para obter recursos de mineração
	 */
	void minerar() {
		System.out.println("Recursos Obtidos");
	}
	/**
	 * Método usado para criar ítens
	 */
	void craftar() {
		System.out.println("Ítem criado");
	}
}
