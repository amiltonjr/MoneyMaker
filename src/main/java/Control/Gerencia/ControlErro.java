package Control.Gerencia;

import View.Gerencia.FrameBemVindo;
import View.Gerencia.FrameErroAbertura;

public class ControlErro {
    
    public static void retornar(FrameErroAbertura currentFrame, FrameBemVindo parentFrame) {
        currentFrame.setVisible(false);
        parentFrame.setVisible(true);
    }
    
}
