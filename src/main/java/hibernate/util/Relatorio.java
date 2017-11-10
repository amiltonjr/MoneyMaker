package hibernate.util;

import DAO.Gerencia.ClienteDAO;
import DAO.Gerencia.ContaDAO;
import DAO.Gerencia.MovimentacaoDAO;
import Entity.Gerencia.Cliente;
import Entity.Gerencia.Conta;
import Entity.Gerencia.Movimentacao;
import java.io.File;
import java.io.IOException;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Relatorio {
    
    public static void main(String[] args) {
        
        Relatorio r = new Relatorio();
        
        r.gerarRelatorioClientes();
        r.gerarRelatorioContas();
        r.gerarRelatorioMovimentacoes();
        
        System.exit(0);
    }
    
    public void gerarRelatorioClientes() {
        try {
            List<Cliente> clientes = ClienteDAO.getInstance().findAll();

            // Trabalhando com o iReport
            System.out.println("Gerando relatório…");         
            JasperReport pathjrxml = JasperCompileManager.compileReport("src/main/resources/relatorios/clientes.jrxml");
            JasperPrint printReport = JasperFillManager.fillReport(pathjrxml, null, new JRBeanCollectionDataSource(clientes));
            JasperExportManager.exportReportToPdfFile(printReport, "src/main/resources/relatorios/clientes.pdf");
            System.out.println("Relatorio gerado");
            java.awt.Desktop.getDesktop().open(new File("src/main/resources/relatorios/clientes.pdf"));
        } catch(JRException e) {
            System.out.println("Erro ao gerar Relatório " + e.getMessage());
            System.exit(1);
        } catch(IOException o) {
            System.out.println("Erro ao gerar PDF " + o.getMessage());
            System.exit(1);
        }    
    }
    
    public void gerarRelatorioContas() {
        try {
            List<Conta> contas = ContaDAO.getInstance().findAll();
            
            // Trabalhando com o iReport
            System.out.println("Gerando relatório…");         
            JasperReport pathjrxml = JasperCompileManager.compileReport("src/main/resources/relatorios/contas.jrxml");
            JasperPrint printReport = JasperFillManager.fillReport(pathjrxml, null, new JRBeanCollectionDataSource(contas));
            JasperExportManager.exportReportToPdfFile(printReport, "src/main/resources/relatorios/contas.pdf");
            System.out.println("Relatorio gerado");
            java.awt.Desktop.getDesktop().open(new File("src/main/resources/relatorios/contas.pdf"));
        } catch(JRException e) {
            System.out.println("Erro ao gerar Relatório " + e.getMessage());
            System.exit(1);
        } catch(IOException o) {
            System.out.println("Erro ao gerar PDF " + o.getMessage());
            System.exit(1);
        }    
    }
    
    public void gerarRelatorioMovimentacoes() {
        try {
            List<Movimentacao> movs = MovimentacaoDAO.getInstance().findAll();
            
            // Trabalhando com o iReport
            System.out.println("Gerando relatório…");         
            JasperReport pathjrxml = JasperCompileManager.compileReport("src/main/resources/relatorios/movs.jrxml");
            JasperPrint printReport = JasperFillManager.fillReport(pathjrxml, null, new JRBeanCollectionDataSource(movs));
            JasperExportManager.exportReportToPdfFile(printReport, "src/main/resources/relatorios/movs.pdf");
            System.out.println("Relatorio gerado");
            java.awt.Desktop.getDesktop().open(new File("src/main/resources/relatorios/movs.pdf"));
        } catch(JRException e) {
            System.out.println("Erro ao gerar Relatório " + e.getMessage());
            System.exit(1);
        } catch(IOException o) {
            System.out.println("Erro ao gerar PDF " + o.getMessage());
            System.exit(1);
        }    
    }
    
}
