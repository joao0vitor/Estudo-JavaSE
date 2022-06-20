/**
 * 
 */
package carros;

import java.util.Random;

/**
 * @author joao vitor
 *
 */
public class Carro {

	/**
	 * 
	 */
	public Carro() {
		
		// Construtor
		
		Random gerador = new Random();
		String chassis = new String("0123456789ABCDEFGHIJKLMNOPQRSTUVYXWZ");
		System.out.print("Chassis: * ");
		for (int i = 0; i < 16; i++) {
			char numeracao = (char) gerador.nextInt(chassis.length());
		System.out.print(chassis.charAt(numeracao));
		}
		System.out.println(" *");
	}
	// Atributos
	int ano;
	int chassi;
	String cor;
	String nome;

	// Modelos
		// void -> M�todo simples sem retorno
		/**
		 * M�todo usado para ligar o carro
		 */
		void ligar() {
			System.out.println("Carro Ligado");
		}
		/**
		 * M�todo usado para desligar o carro
		 */
		void desligar() {
			System.out.println("Carro Desligado");
		}
		/**
		 * M�todo usado para acelerar o carro
		 */
		void acelerar() {
			System.out.println("Carro acelerado");
		}
	
}
