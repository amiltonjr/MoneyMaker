package Model.Gerencia;

import DAO.Gerencia.ClienteDAO;
import Entity.Gerencia.Cliente;

public class CadastrarCliente {
    
    
    public static boolean cadastrarCliente(String cpf, String rg, String sexo, String nome, String endereco, String nascimento, boolean vip) {
       // Valida os dados
       if (!ValidaCpf.CPF(cpf) || !ValidaRg.RG(rg) || sexo.length() < 8 || nome.length() < 3 || endereco.length() < 5 || !ValidaData.validarData(nascimento))
           return false;
       
       Cliente cliente = new Cliente();
       
       cliente.setCpf(cpf);
       cliente.setRg(rg);
       cliente.setSexo(sexo);
       cliente.setNome(nome);
       cliente.setEndereco(endereco);
       cliente.setNascimento(nascimento);
       cliente.setVip(vip);
       
       
       return ClienteDAO.getInstance().persist(cliente);
       
    }
    
}
