/**
 * Jogo Minecraft (Exemplo POO)
 */
package minecraft;

/**
 * @author joao vitor
 * Classe responsável pela craiação dos objetos
 */
public class Mundo {

	/** 
	 * Método principal
	 * @param args
	 */
	public static void main(String[] args) {
		// Objeto 1
		Bloco blocoTerra = new Bloco();
		blocoTerra.resistencia = 1;
		blocoTerra.textura = "Terra";
		System.out.println("Bloco: " + blocoTerra.textura);
		System.out.println("Resistencia: " + blocoTerra.resistencia);
		blocoTerra.construir();
		blocoTerra.minerar();
		// Objeto 2
		Bloco blocoMadeira = new Bloco();
		blocoMadeira.resistencia = 2;
		blocoMadeira.textura = "Madeira";
		System.out.println("Bloco: " + blocoMadeira.textura);
		System.out.println("Resistencia: " + blocoMadeira.resistencia);
		blocoMadeira.minerar();
		blocoMadeira.craftar();
	}

}
