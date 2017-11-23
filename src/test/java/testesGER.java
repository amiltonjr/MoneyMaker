/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entity.Gerencia.Cliente;
import Model.Gerencia.AbrirConta;
import Model.Gerencia.CadastrarCliente;
import Model.Gerencia.ValidaData;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author amiltonjunior
 */
public class testesGER {
    
    public testesGER() {}
    
    @Test
    public void teste_validaData() {
        // Simula a entrada de uma data inválida do tipo 010203
        assertFalse(ValidaData.validarData("010203"));
    }
    
    @Test
    public void teste_validaNome() {
        // Simula a entrada de um nome vazio
        assertFalse(CadastrarCliente.cadastrarCliente("443.857.851-55", "107652345", "masculino", "", "Rua Alberto Carazzai 1234", "30/08/1993", false));
    }
    
    @Test
    public void teste_validaAgencia() {
        // Simula a adição de uma agência com valor zero
        assertFalse(AbrirConta.abrirContaPoupanca("1234", "0", new Cliente(), "1.00", "12/12/2017", true, false, false));
    }
}
