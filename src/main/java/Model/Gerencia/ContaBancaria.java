package Model.Gerencia;

public interface ContaBancaria {
    public String getTipo();
    public boolean sacar(double valor);
    public boolean depositar(double valor);
}
