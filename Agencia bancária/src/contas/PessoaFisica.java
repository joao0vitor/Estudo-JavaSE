/**
 * Conta corrente
 */
package contas;

/**
 * @author joao vitor
 *
 */
public class PessoaFisica {

	/**]
	 * Método principal
	 * @param args
	 */
	public static void main(String[] args) {
		// Cliente 1
		Conta cc1 = new Conta();
		cc1.setCliente("Leandro Ramos");
		cc1.setSaldo(10000);
		System.out.println("Cliente: " + cc1.getCliente());
		cc1.exibirSaldo();
		
		// Cliente 2
		Conta cc2 = new Conta();
		cc2.setCliente("Kelly Cristina");
		cc2.setSaldo(8500);
		System.out.println("Cliente: " + cc2.getSaldo());
		cc2.exibirSaldo();
	}

}
