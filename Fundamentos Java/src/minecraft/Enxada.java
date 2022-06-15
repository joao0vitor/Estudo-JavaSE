/**
 * POO - Fundamentos
 */
package minecraft;

/**
 * @author joao vitor
 * Classe modelo com heran�a (extends)
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
	    
	    // m�todo
	    /**
	     * M�todo usado para arar a terra
	     */
	    void arar() {
	    	System.out.println("Terra preparada o plantio");
	    		// Aten��o
	    		conquista = true;
	    }
}
