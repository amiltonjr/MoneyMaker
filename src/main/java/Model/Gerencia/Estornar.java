package Model.Gerencia;

import DAO.Gerencia.ContaDAO;
import DAO.Gerencia.MovimentacaoDAO;
import Entity.Gerencia.Conta;
import Entity.Gerencia.Movimentacao;

public class Estornar {

    public static boolean estornar(Movimentacao mov) {

        try {
            // Obtém o valor da transação
            double valor = Double.parseDouble(mov.getValor().replace(",", "."));
            Conta conta = mov.getConta();

            // Estorna o valor do Saque
            if (mov.getOperacao().equals("SAQUE")) {
                conta.setSaldo(conta.getSaldo() + valor);
                // Estorna o valor do Depósito
            } else {
                conta.setSaldo(conta.getSaldo() - valor);
            }

            // Remove a movimentação
            MovimentacaoDAO.getInstance().remove(mov);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
