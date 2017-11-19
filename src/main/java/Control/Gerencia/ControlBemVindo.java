package Control.Gerencia;

import View.Gerencia.FrameAberturaConta;
import View.Gerencia.FrameBemVindo;
import View.Gerencia.FrameBloquearConta;
import View.Gerencia.FrameDeletarConta;
import View.Gerencia.FrameEstornar;

public class ControlBemVindo {
    
    public static void abrirConta(FrameBemVindo currentFrame, FrameAberturaConta nextFrame) {
        currentFrame.setVisible(false); // Oculta o FrameBemVindo
        nextFrame.setVisible(true); // Exibe o FrameAberturaConta
        ControlAberturaConta.limparCampos(nextFrame); // Limpa os campos dos formulários
        nextFrame.preencherNomesClientes(); // Preenche os comboboxes
    }
    
    public static void estornar(FrameBemVindo currentFrame, FrameEstornar nextFrame) {
        currentFrame.setVisible(false); // Oculta o FrameBemVindo
        nextFrame.setVisible(true); // Exibe o FrameEstornar
        ControlEstornar.limparCampos(nextFrame); // Limpa os campos do formulário
        nextFrame.preencherNomesClientes(); // Preenche o combobox
    }
    
    public static void bloquear(FrameBemVindo currentFrame, FrameBloquearConta nextFrame) {
        currentFrame.setVisible(false); // Oculta o FrameBemVindo
        nextFrame.setVisible(true); // Exibe o FrameBloquearConta
        ControlBloquearConta.limparCampos(nextFrame); // Limpa os campos do formulário
        nextFrame.preencherNomesClientes(); // Preenche o combobox
    }
    
    public static void deletar(FrameBemVindo currentFrame, FrameDeletarConta nextFrame) {
        currentFrame.setVisible(false); // Oculta o FrameBemVindo
        nextFrame.setVisible(true); // Exibe o FrameBloquearConta
        ControlDeletarConta.limparCampos(nextFrame); // Limpa os campos do formulário
        nextFrame.preencherNomesClientes(); // Preenche o combobox
    }
    
}
