/**
 * 
 */
package fundamentos;

import java.util.Random;
/**
 * Método principal
 * @author joao vitor
 *
 */
public class NumerosAleatorios {
	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		Random gerador = new Random();
		// Exemplo 1
		// Uso da classe Random para gerar números aleatórios
		//(100) Gerar número entre 0 e 99
		int numero = gerador.nextInt(100);
		System.out.println(numero);
		
		// Exemplo 2
		int dado = gerador.nextInt(6) + 1;
		System.out.println("Face do dado: " + dado);
		
		// Exemplo 3
		// A linha abaixo cria u m objeto que contém carateres
		String chassi = new String("0123456789ABCDEFGHIJKLMNOPQRSTUVYXWZ");
		System.out.print("Chassi: * ");
		for (int i = 0; i < 16; i++) {
		// A linha abaixo cria uma variavel do tipo char que usa o objeto
	    // gerador para gerar um número aleatório entre 0 e o tamanho máximo
		// de caracters do objeto chassi (.length() -> tamanho da String)
		// (char) converter o tipo int para o tipo char
		char numeracao = (char)gerador.nextInt(chassi.length());
		// a linha abaixo imprime o valor variavel numeracao
		// (.charAt() -> imprime apenas 1 caractere
		System.out.print(chassi.charAt(numeracao));
		}
		System.out.println(" *");
	}

}
