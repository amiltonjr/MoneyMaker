package Control.Gerencia;

import DAO.Gerencia.ContaDAO;
import Entity.Gerencia.Conta;
import View.Gerencia.FrameBemVindo;
import View.Gerencia.FrameDeletarConta;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControlDeletarConta {
    
    public static void limparCampos(FrameDeletarConta currentFrame) {
        currentFrame.resetCliente();
        currentFrame.resetConta();
        currentFrame.resetStatus();
    }
    
    public static boolean deletar(Conta conta, String botao) {
        
        if (conta == null){
            return false;
        }
        
        try {

            // Salva o resultado no banco
            ContaDAO.getInstance().remove(conta);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static void sucesso() {
        JOptionPane.showMessageDialog(new JFrame(), "Conta deletada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void erro() {
        JOptionPane.showMessageDialog(new JFrame(), "Erro ao deletar a conta!\nVerifique os dados e tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void cancelar(FrameDeletarConta currentFrame, FrameBemVindo nextFrame) {
        currentFrame.setVisible(false); // Oculta o FrameDeletarConta
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
