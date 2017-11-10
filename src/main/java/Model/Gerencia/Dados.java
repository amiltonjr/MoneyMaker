package Model.Gerencia;

import Entity.Gerencia.Cliente;
import java.util.ArrayList;

public class Dados {
    
    private final ArrayList<Cliente> clientes;
    
    public Dados() {
        clientes = new ArrayList<>();
    }
    
    // Sets
    
    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
    
    // Método que define um cliente com base em seu ID
    public void setClientePorId(Cliente cliente, int id) {
        this.clientes.set(id, cliente);
    }
    
    // Gets
    
    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }
    
    // Método que obtém um cliente pelo CPF
    public Cliente getClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf))
                return cliente;
        }
        
        return null;
    }
    
    // Método que obtém um cliente com base em seu ID
    public Cliente getClientePorId(int id) {
        return this.clientes.get(id);
        /*
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id)
                return cliente;
        }
        
        return null;
        */
    }
    
}
