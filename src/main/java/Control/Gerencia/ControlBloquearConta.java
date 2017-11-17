package Control.Gerencia;

import DAO.Gerencia.ContaDAO;
import Entity.Gerencia.Conta;
import View.Gerencia.FrameBemVindo;
import View.Gerencia.FrameBloquearConta;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControlBloquearConta {
    
    public static void limparCampos(FrameBloquearConta currentFrame) {
        currentFrame.resetCliente();
        currentFrame.resetConta();
        currentFrame.resetStatus();
    }
    
    public static boolean bloquear(Conta conta, String botao) {
        
        if (conta == null){
            return false;
        }
        
        try {

            // Se é para bloquear ou desbloquear
            if (botao.equals("Bloquear"))
                conta.setStatus("bloqueado");
            else
                conta.setStatus("ativo");
            
            // Salva o resultado no arquivo
            ContaDAO.getInstance().merge(conta);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static void sucessoBloq() {
        JOptionPane.showMessageDialog(new JFrame(), "Conta bloqueada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void sucessoDesbloq() {
        JOptionPane.showMessageDialog(new JFrame(), "Conta desbloqueada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void erro() {
        JOptionPane.showMessageDialog(new JFrame(), "Erro ao bloquear a conta!\nVerifique os dados e tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void cancelar(FrameBloquearConta currentFrame, FrameBemVindo nextFrame) {
        currentFrame.setVisible(false); // Oculta o FrameBloquearConta
        nextFrame.setVisible(true); // Exibe o FrameBemVindo
    }
    
    /*
    public static String getConta(String nome) {
        Cliente c = ClienteDAO.getInstance().getByNome(nome);
        return c.getNumeroConta();
    }
    
    public static String getStatusConta(String nome) {
        Cliente c = ClienteDAO.getInstance().getByNome(nome);
        return c.getConta().getStatus();
    }
    */
}
