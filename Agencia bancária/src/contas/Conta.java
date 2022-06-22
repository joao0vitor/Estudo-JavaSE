/**
 * POO - Encapsulamento e m�todos especiais
 */
package contas;

/**
 * @author joao vitor
 *
 */
public class Conta {

	// Atributos
	// Para encapsular(proteger) uma vari�vel devemos usar
	// o modificador private e criar m�todos especificos (get e set)
	// para outras classes e pacotes terem acesso as vari�veis
	
	// Encapsulamento Passo 1: Modificador private
	private String cliente;
	private double saldo;
	
	/**
	 * Construtor 
	 */
	public Conta() {
		System.out.println("---------------------------------");
		System.out.println("Ag�ncia 0261");
	}
	
	
	// Encapsulamento Passo 2: Criar os m�todos especificos (get e set) | Eclipse - bot�o direito do mouse
	// - source -> Generate Getters and Setters - selecionar as variaveis encapsuladas
	/**
	 * Ler o conte�do da variavel cliente
	 * @return cliente
	 */
	public String getCliente() {
		return cliente;
	}
	
	/**
	 * Setar(atribuir) um nome a variavel cliente
	 * @param cliente
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	/**
	 * Obter o saldo do cliente
	 * @return saldo
	 */
	public double getSaldo() {
		return saldo;
	}
	
	/**
	 * Setar (atribuir) um valor a conta corrente
	 * @param saldo
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	

	// m�todos
	/**
	 * M�todo simples que exibe o valor do saldo
	 */
	protected void exibirSaldo() {
		System.out.println("Saldo: R$ " + saldo);
	}

}
