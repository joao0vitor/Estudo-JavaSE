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
		//Transferencia
			System.out.println("--------------------------------");
			System.out.println("----------Transferencia---------");
			System.out.println("Cliente: " + cc1.getCliente());
			System.out.println("Favorecido: " + cc2.getCliente());
			cc1.transferencia(cc2, 2000);
			System.out.println("--------------------------------");
			System.out.println("Cliente: " + cc1.getCliente());
			cc1.exibirSaldo();
			System.out.println("Favorecido: " + cc2.getCliente());
			cc2.exibirSaldo();
			
			//Relatorio gerencial
			Conta gerente = new Conta();
			double relatorio = gerente.soma(cc1.getSaldo(),cc2.getSaldo());
			System.out.println("Saldo total das contas: " + relatorio);
		}
}
