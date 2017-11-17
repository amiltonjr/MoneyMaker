package Control.Gerencia;

import Model.Gerencia.ValidaData;
import Model.Gerencia.ValidaNumero;
import Entity.Gerencia.Cliente;
import Model.Gerencia.AbrirConta;
import Model.Gerencia.CadastrarCliente;
import Model.Gerencia.ValidaCpf;
import Model.Gerencia.ValidaRg;
import View.Gerencia.FrameAberturaConta;
import View.Gerencia.FrameBemVindo;
import View.Gerencia.FrameConfirmAbertura;
import View.Gerencia.FrameErroAbertura;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControlAberturaConta {
    
    public static void cancelar(FrameAberturaConta currentFrame, FrameBemVindo nextFrame) {
        currentFrame.setVisible(false);
        nextFrame.setVisible(true);
    }
    
    public static void sucesso(FrameAberturaConta currentFrame, FrameConfirmAbertura sucessFrame) {
        currentFrame.setVisible(false);
        sucessFrame.setVisible(true);
    }
    
    public static void erro(FrameAberturaConta currentFrame, FrameErroAbertura errorFrame) {
        currentFrame.setVisible(false);
        errorFrame.setVisible(true);
    }
    
    public static void sucessoCliente() {
        JOptionPane.showMessageDialog(new JFrame(), "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void erroCliente() {
        JOptionPane.showMessageDialog(new JFrame(), "Erro ao cadastrar o cliente!\nVerifique os dados preenchidos, se o cliente já não foi cadastrado e tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void erroFormulario(String campo) {
        JOptionPane.showMessageDialog(new JFrame(), "Campo " + campo + " inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void limparCampos(FrameAberturaConta currentFrame) {
        currentFrame.resetCPF();
        currentFrame.resetRG();
        currentFrame.resetSexo();
        currentFrame.resetNome();
        currentFrame.resetEndereco();
        currentFrame.resetNascimento();
        currentFrame.resetVip();
        currentFrame.resetLimiteNumeroConta();
        currentFrame.resetLimiteAgencia();
        currentFrame.resetLimiteNomeCorrentista();
        currentFrame.resetLimiteSaldoInicial();
        currentFrame.resetLimiteLimite();
        currentFrame.resetLimiteDataAbertura();
        currentFrame.resetPoupancaNumeroConta();
        currentFrame.resetPoupancaAgencia();
        currentFrame.resetPoupancaNomeCorrentista();
        currentFrame.resetPoupancaSaldoInicial();
        currentFrame.resetLimiteAniversario();
        currentFrame.resetCorrenteNumeroConta();
        currentFrame.resetCorrenteAgencia();
        currentFrame.resetCorrenteNomeCorrentista();
        currentFrame.resetCorrenteSaldoInicial();
        currentFrame.resetCorrenteDataAbertura();
        currentFrame.resetCheckboxes();
        currentFrame.resetTabs();
    }
    
    public static void cadastrarCliente(FrameAberturaConta currentFrame, FrameConfirmAbertura frameSucess, FrameErroAbertura frameError, String cpf, String rg, String sexo, String nome, String endereco, String nascimento, boolean vip) {
        
        // Valida os dados
        if (!ValidaCpf.CPF(cpf)) {
            erroFormulario("CPF");
            currentFrame.focoCPF();
        } else if (!ValidaRg.RG(rg)) {
            erroFormulario("RG");
            currentFrame.focoRG();
        } else if (sexo.equalsIgnoreCase("- Selecione -")) {
            erroFormulario("Sexo");
            currentFrame.focoSexo();
        } else if (nome.length() < 3) {
            erroFormulario("Nome");
            currentFrame.focoNome();
        } else if (endereco.length() < 3) {
            erroFormulario("Endereço");
            currentFrame.focoEndereco();
        } else if (!ValidaData.validarData(nascimento)) {
            erroFormulario("Nascimento");
            currentFrame.focoNascimento();
        } else {
            // Envia para o pacote Model
            if (CadastrarCliente.cadastrarCliente(cpf, rg, sexo, nome, endereco, nascimento, vip)) {
                sucessoCliente();
                cancelar(currentFrame, currentFrame.getParentFrame());
            } else
                erroCliente();
        }
    }
    
    public static void abrirContaCorrenteLimite(FrameAberturaConta currentFrame, FrameConfirmAbertura frameSucess, FrameErroAbertura frameError, String conta, String agencia, Cliente correntista, String saldoInicial, String limite, String dataAbertura, boolean contrato, boolean necessidades, boolean outroBanco) {
        // Valida os dados
        
        if (!ValidaNumero.isNumeric(conta)) {
            erroFormulario("Conta");
            currentFrame.focoLimiteNumeroConta();
        } else if (!ValidaNumero.isNumeric(agencia)) {
            erroFormulario("Agência");
            currentFrame.focoLimiteAgencia();
        } else if (correntista == null) {
            erroFormulario("Correntista");
            currentFrame.focoLimiteNomeCorrentista();
        } else if (!ValidaNumero.isNumeric(saldoInicial)) {
            erroFormulario("Saldo inicial");
            currentFrame.focoLimiteSaldoInicial();
        } else if (!ValidaNumero.isNumeric(limite)) {
            erroFormulario("Limite");
            currentFrame.focoLimiteLimite();
        } else if (!ValidaData.validarData(dataAbertura)) {
            erroFormulario("Data de abertura");
            currentFrame.focoLimiteDataAbertura();
        } else {
            // Corrige os floats
            saldoInicial = saldoInicial.replace(",", ".");
            limite = limite.replace(",", ".");
            // Envia para o pacote Model
            if (AbrirConta.abrirContaCorrenteLimite(conta, agencia, correntista, saldoInicial, limite, dataAbertura, contrato, necessidades, outroBanco))
                sucesso(currentFrame, frameSucess);
            else
                erro(currentFrame, frameError);
        }
    }
    
    public static void abrirContaCorrente(FrameAberturaConta currentFrame, FrameConfirmAbertura frameSucess, FrameErroAbertura frameError, String conta, String agencia, Cliente correntista, String saldoInicial, String dataAbertura, boolean contrato, boolean necessidades, boolean outroBanco) {
        // Valida os dados
        if (!ValidaNumero.isNumeric(conta)) {
            erroFormulario("Conta");
            currentFrame.focoCorrenteNumeroConta();
        } else if (!ValidaNumero.isNumeric(agencia)) {
            erroFormulario("Agência");
            currentFrame.focoCorrenteAgencia();
        } else if (correntista == null) {
            erroFormulario("Correntista");
            currentFrame.focoCorrenteNomeCorrentista();
        } else if (!ValidaNumero.isNumeric(saldoInicial)) {
            erroFormulario("Saldo inicial");
            currentFrame.focoCorrenteSaldoInicial();
        } else if (!ValidaData.validarData(dataAbertura)) {
            erroFormulario("Data de abertura");
            currentFrame.focoCorrenteDataAbertura();
        } else {
            // Corrige os floats
            saldoInicial = saldoInicial.replace(",", ".");
            // Envia para o pacote Model
            if (AbrirConta.abrirContaCorrente(conta, agencia, correntista, saldoInicial, dataAbertura, contrato, necessidades, outroBanco))
                sucesso(currentFrame, frameSucess);
            else
                erro(currentFrame, frameError);
        }
    }
    
    public static void abrirContaPoupanca(FrameAberturaConta currentFrame, FrameConfirmAbertura frameSucess, FrameErroAbertura frameError, String conta, String agencia, Cliente correntista, String saldoInicial, String aniversario, boolean contrato, boolean necessidades, boolean outroBanco) {
        // Valida os dados
        if (!ValidaNumero.isNumeric(conta)) {
            erroFormulario("Conta");
            currentFrame.focoPoupancaNumeroConta();
        } else if (!ValidaNumero.isNumeric(agencia)) {
            erroFormulario("Agência");
            currentFrame.focoPoupancaAgencia();
        } else if (correntista == null) {
            erroFormulario("Correntista");
            currentFrame.focoPoupancaNomeCorrentista();
        } else if (!ValidaNumero.isNumeric(saldoInicial)) {
            erroFormulario("Saldo inicial");
            currentFrame.focoPoupancaSaldoInicial();
        } else if (!ValidaData.validarData(aniversario)) {
            erroFormulario("Aniversário");
            currentFrame.focoPoupancaAniversario();
        } else {
            // Corrige os floats
            saldoInicial = saldoInicial.replace(",", ".");
            // Envia para o pacote Model
            if (AbrirConta.abrirContaPoupanca(conta, agencia, correntista, saldoInicial, aniversario, contrato, necessidades, outroBanco))
                sucesso(currentFrame, frameSucess);
            else
                erro(currentFrame, frameError);
        }
    }
    
}
