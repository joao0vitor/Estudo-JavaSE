/**
 * 
 */
package carros;

/**
 * @author joao vitor
 *
 */
public class Aviao extends Carro {

	/**
	 *
	 */
	public Aviao() {
		System.out.println("=================================");
	}
		// Atributos
		double envergadura;
		
		void aterrizar() {
			System.out.println("Avião aterrizado");
		}
		
		void acelerar() {
			System.out.println("Avião decolado");
		}
		void desligar() {
			System.out.println("Avião desligado");
		}
		
		void ligar() {
			System.out.println("Avião ligado");
		}
}

