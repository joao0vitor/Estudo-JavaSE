/**
 * Seguros
 */
package seguros;

import contas.Conta;

/**
 * @author joao vitor
 *
 */
public class SeguroPessoaFisica extends Conta {

	/**
	 * M�todo principal
	 * @param args
	 */
	public static void main(String[] args) {
		// Cliente 3
		// Usando o modificador protected devemos usar a 
		// proproia heran�a (SeguroPessoaFisica) para criar o objeto
	
		SeguroPessoaFisica cc3 = new SeguroPessoaFisica();
		cc3.setCliente("Robson Vaamonde");
		cc3.setSaldo(9000);
		System.out.println("Cliente: " + cc3.getCliente());
		cc3.exibirSaldo();
	}

}
