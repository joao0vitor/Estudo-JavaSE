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
			System.out.println("Avi�o aterrizado");
		}
		
		void acelerar() {
			System.out.println("Avi�o decolado");
		}
		void desligar() {
			System.out.println("Avi�o desligado");
		}
		
		void ligar() {
			System.out.println("Avi�o ligado");
		}
}

