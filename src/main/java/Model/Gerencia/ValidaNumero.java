/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Gerencia;

/**
 Classe que valida se a string fornecida é um número
 */
public class ValidaNumero {
    public static boolean isNumeric(String str) {
        try {
            str = str.replace(",", ".");
            double d = Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}
