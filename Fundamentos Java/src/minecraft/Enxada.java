/**
 * POO - Fundamentos
 */
package minecraft;

/**
 * @author joao vitor
 * Classe modelo com herança (extends)
 */
public class Enxada extends Bloco {
	/**
	 * Construtor
	 */
	public Enxada() {
		System.out.println("___ CAMPO ___");
	}
		// Atributos
	    boolean conquista;
	    
	    // método
	    /**
	     * Método usado para arar a terra
	     */
	    void arar() {
	    	System.out.println("Terra preparada o plantio");
	    		// Atenção
	    		conquista = true;
	    }
}
