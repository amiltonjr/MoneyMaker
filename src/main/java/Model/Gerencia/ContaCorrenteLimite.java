package Model.Gerencia;

public class ContaCorrenteLimite implements ContaBancaria {
    
    private double saldo;
    private String cpfCliente;
    private String numeroConta;
    private double limite;
    private String tipo;
    
    @Override
    public boolean sacar(double valor) {
        // TODO
        
        return true;
    }

    @Override
    public boolean depositar(double valor) {
        // TODO
        
        return true;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void setCpfCliente(String nome) {
        this.cpfCliente = nome;
    }
    
    public void setNumeroConta(String numero) {
        this.numeroConta = numero;
    }
    
    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public double getSaldo() {
        return this.saldo;
    }
    
    public String getCpfCliente() {
        return this.cpfCliente;
    }
    
    public String getNumeroConta() {
        return this.numeroConta;
    }
    
    public double getLimite() {
        return this.limite;
    }
    
    @Override
    public String getTipo() {
        return this.tipo;
    }
    
}
