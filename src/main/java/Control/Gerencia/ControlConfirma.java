package Control.Gerencia;

import View.Gerencia.FrameBemVindo;
import View.Gerencia.FrameConfirmAbertura;

public class ControlConfirma {
    
    public static void retornar(FrameConfirmAbertura currentFrame, FrameBemVindo parentFrame) {
        currentFrame.setVisible(false);
        parentFrame.setVisible(true);
    }
    
}
