package Control.Gerencia;

import Entity.Gerencia.Movimentacao;
import Model.Gerencia.Estornar;
import View.Gerencia.FrameBemVindo;
import View.Gerencia.FrameEstornar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControlEstornar {

    public static void limparCampos(FrameEstornar currentFrame) {
        currentFrame.resetCliente();
        currentFrame.resetConta();
        currentFrame.resetLancamento();
    }

    public static void sucesso() {
        JOptionPane.showMessageDialog(new JFrame(), "Lançamento estornado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void erro() {
        JOptionPane.showMessageDialog(new JFrame(), "Erro ao estornar o lançamento!\nVerifique os dados e tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static boolean estornar(Movimentacao movimentacao) {
        // Valida os dados
        if (movimentacao != null) {
            // Envia para o pacote Model
            if (Estornar.estornar(movimentacao)) {
                sucesso();
                return true;
            } else {
                erro();
                return false;
            }
        } else {
            erro();
            return false;
        }
    }

    public static void erroFormulario() {
        JOptionPane.showMessageDialog(new JFrame(), "O formulário contém erros! Favor verificar.", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void cancelar(FrameEstornar currentFrame, FrameBemVindo nextFrame) {
        currentFrame.setVisible(false); // Oculta o FrameEstornar
        nextFrame.setVisible(true); // Exibe o FrameBemVindo
    }

//    public static String getConta(String nome) {
//
//        Cliente c = ClienteDAO.getInstance().getByNome(nome);
//        return c.getNumeroConta();
//    }
//
//    public static List<Movimentacao> getLancamentos(String conta) {
//
//        Conta c = ContaDAO.getInstance().getByNumber(conta);
//        return c.getMovimentacoes();
//    }

}
