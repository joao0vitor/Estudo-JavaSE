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
	
	/*
	 * M�todo simples com uma variavel local
	 * @param valor
	 */
	protected void sacar(double valor) {
		saldo -= valor;
		System.out.println("D�bito: R$" + valor);
	}
	/*
	 * M�todo simples com uma variavel local
	 * @param valor
	 */
	protected void depositar(double valor) {
		saldo += valor;
		System.out.println("Cr�dito: R$" + valor);
	}
	/**
	 * Metodo simples com uma variavel local e um objeto que sera criado para indicar a conta de destino da transferencia
	 * @param destino
	 * @param valor
	 */
	protected void transferencia(Conta destino, double valor) {
		this.sacar(valor);
		destino.depositar(valor);
		System.out.println("Transferencia: R$" + valor);
	}
	
/**
 * M�todo com retorno obrigatorio 
 * @param cc1
 * @param cc2
 * @return
 */
		double soma (double cc1, double cc2) {
		double total = cc1 + cc2; 
		return total;
	}
}
