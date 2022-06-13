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
	// void -> M�todo simples sem retorno
	/**
	 * M�todo usado para constru��o
	 */
	void construir() {
		System.out.println("Bloco colocado");
	}
	/**
	 * M�todo usado para obter recursos de minera��o
	 */
	void minerar() {
		System.out.println("Recursos Obtidos");
	}
	/**
	 * M�todo usado para criar �tens
	 */
	void craftar() {
		System.out.println("�tem criado");
	}
}
