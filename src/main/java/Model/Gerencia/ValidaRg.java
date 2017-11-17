/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Gerencia;

/*
 Classe que valida o RG
 */
public class ValidaRg {
    
    public static boolean RG(String rg) {
        // Remove os pontos
        rg = rg.replace(" ", "").replace(".", "").replace("-", "");
        
        return (rg.length()>= 7 && ValidaNumero.isNumeric(rg));
    }
    
}
