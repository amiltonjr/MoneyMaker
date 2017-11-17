/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Gerencia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 Classe que verifica se uma data é válida
 */
public class ValidaData {
    
    public static boolean validarData(String data) {
        // Validação inicial da data
        if (data.replace(" ", "").replace("/", "").length() != 8)
            return false;
        
        // Prepara para validar uma data
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        
        try {
            Date dt = sdf.parse(data);
            return true;
        } catch(ParseException e) {
            return false;
        }
    }
    
}
