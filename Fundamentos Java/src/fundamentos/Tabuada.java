/**
 * Fundamentos do java
 * La�os de repeti��es
 * 
 */
package fundamentos;
import java.util.Scanner;
/**
 * @author Pedro Guedes
 */
public class Tabuada {

	/**
	 * 
	 * Construtor
	 */
	public Tabuada() {
		
	}

	/**
	 * M�todo principal
	 * @param args
	 */
	public static void main(String[] args) {
		//vari�vel
		int valor;
		Scanner teclado = new Scanner (System.in);
		System.out.println("-------------TABUADA----------------");
		System.out.print("Digite o valor da tabuada: ");
		// entrada
		valor = teclado.nextInt();
		System.out.print("Tabuada do " + valor);
		System.out.print("");
       // processamento/saida
		for (int i = 1; i < 11; i++) {
			System.out.println(valor + "x" + i + " = " + (valor * i));
		}
		teclado.close();
	}
	

}