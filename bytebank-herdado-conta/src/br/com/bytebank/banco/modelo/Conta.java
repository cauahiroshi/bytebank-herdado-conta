package br.com.bytebank.banco.modelo;

/**
 * Essa classe representa a moldura de uma conta; 
 * @author Cauã Hiroshi
 *
 */

public abstract class Conta {
	
	protected double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total; 
	
	/**
	 * construtor para inicializar o objeto conta apartir da agencia e numero
	 * @param agencia
	 * @param numero
	 */
	public Conta(int agencia, int numero) {

		Conta.total++; 
		//System.out.println("o total de contas é " + Conta.total );
		this.agencia = agencia; 
		this.numero = numero; 
		//System.out.println("estou criando uma conta " + this.numero);
	}

	public abstract void deposita(double valor);
	
	/**
	 * valor precisa ser maior do que o saldo
	 * @param valor
	 * @return
	 */
	

	public boolean saca(double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			return true;
		}
		return false;
	}

	public boolean transfere(double valor, Conta destino) {
		if (this.saca (valor)) {
			destino.deposita(valor);
			return true;
		}
		return false;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public int getNumero() {
		return this.numero; 
	}
	
	public void setNumero(int numero) {
		if (numero <= 0 ) {
			System.out.println("nao pode valor menor ou igul a 0");
			return; 
		}
		this.numero = numero; 
	}
	
	public int getAgencia() {
		return this.agencia;
	}
	
	public void setAgencia(int agencia) {
		if(agencia <= 0) {
			System.out.println("nao pode valor menor ou igual a 0");
			return; 
		}
		this.agencia = agencia;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	public Cliente getTitular() {
		return titular;
	}
	
	public static int getTotal() {
		System.out.println();
		return Conta.total; 
	}
}
