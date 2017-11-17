package Model.Gerencia;

import DAO.Gerencia.ContaDAO;
import Entity.Gerencia.Cliente;
import Entity.Gerencia.Conta;

public class AbrirConta {

    private static final String separadorChaves = "|";

    public static boolean abrirContaCorrente(String numero, String agencia, Cliente correntista, String saldoInicial, String dataAbertura, boolean contrato, boolean necessidades, boolean outroBanco) {
        // Valida os dados
        if (!ValidaNumero.isNumeric(numero) || !ValidaNumero.isNumeric(agencia) || correntista == null || !ValidaNumero.isNumeric(saldoInicial) || !ValidaData.validarData(dataAbertura)) {
            return false;
        }

        Conta conta = new Conta();

        conta.setNumeroConta(numero);
        conta.setAgencia(agencia);
        conta.setCliente(correntista);
        conta.setSaldo(Double.parseDouble(saldoInicial));
        conta.setDataAbertura(dataAbertura);
        conta.setContrato(contrato);
        conta.setNecessidades(necessidades);
        conta.setOutroBanco(outroBanco);
        conta.setStatus("ativo");

        // Verifica se a conta já está cadastrada para este cliente
        Conta existe = ContaDAO.getInstance().getByNumber(numero);

        if (existe != null) {
            return false;
        }

        // Grava no banco
        return ContaDAO.getInstance().persist(conta);
    }

    public static boolean abrirContaCorrenteLimite(String numero, String agencia, Cliente correntista, String saldoInicial, String limite, String dataAbertura, boolean contrato, boolean necessidades, boolean outroBanco) {
        // Valida os dados
        if (!ValidaNumero.isNumeric(numero) || !ValidaNumero.isNumeric(agencia) || correntista == null || !ValidaNumero.isNumeric(saldoInicial) || !ValidaNumero.isNumeric(limite) || !ValidaData.validarData(dataAbertura)) {
            return false;
        }

        Conta conta = new Conta();

        conta.setTipo("limite");
        conta.setNumeroConta(numero);
        conta.setAgencia(agencia);
        conta.setLimite(Double.parseDouble(limite));
        conta.setCliente(correntista);
        conta.setCpfCliente(correntista.getCpf());
        conta.setSaldo(Double.parseDouble(saldoInicial));
        conta.setDataAbertura(dataAbertura);
        conta.setContrato(contrato);
        conta.setNecessidades(necessidades);
        conta.setOutroBanco(outroBanco);
        conta.setStatus("ativo");

        // Verifica se a conta já está cadastrada para este cliente
        Conta existe = ContaDAO.getInstance().getByNumber(numero);
        
        if(existe != null){
            return false;
        }
        
        // Grava no banco
        return ContaDAO.getInstance().persist(conta);

    }

    public static boolean abrirContaPoupanca(String numero, String agencia, Cliente correntista, String saldoInicial, String aniversario, boolean contrato, boolean necessidades, boolean outroBanco) {
        // Valida os dados
        if (!ValidaNumero.isNumeric(numero) || !ValidaNumero.isNumeric(agencia) || correntista == null || !ValidaNumero.isNumeric(saldoInicial) || !ValidaData.validarData(aniversario)) {
            return false;
        }
        
        // Verifica se a conta já está cadastrada para este cliente
        Conta existe = ContaDAO.getInstance().getByNumber(numero);
        
        if(existe != null){
            return false;
        }

        
        Conta conta = new Conta();

        conta.setTipo("poupanca");
        conta.setNumeroConta(numero);
        conta.setAgencia(agencia);
        conta.setCliente(correntista);
        conta.setCpfCliente(correntista.getCpf());
        conta.setSaldo(Double.parseDouble(saldoInicial));
        conta.setDataAbertura(aniversario);
        conta.setContrato(contrato);
        conta.setNecessidades(necessidades);
        conta.setOutroBanco(outroBanco);
        conta.setStatus("ativo");
        
        // Grava no banco
        return ContaDAO.getInstance().persist(conta);
        
    }

}
