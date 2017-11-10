package Model.Gerencia;

public class ContaPoupanca implements ContaBancaria {

    private double saldo;
    private String cpfCliente;
    private String numeroConta;
    private String dataAniversario;
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
    
    public void setDataAniversario(String data) {
        this.dataAniversario = data;
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
    
    public String getDataAniversario() {
        return this.dataAniversario;
    }
    
    @Override
    public String getTipo() {
        return this.tipo;
    }
    
}
