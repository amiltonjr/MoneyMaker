package Model.Gerencia;

public class ContaCorrente implements ContaBancaria {

    private double saldo;
    private String cpfCliente;
    private String numeroConta;
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
    
    @Override
    public String getTipo() {
        return this.tipo;
    }
    
}
