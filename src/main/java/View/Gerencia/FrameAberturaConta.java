/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Gerencia;

import Control.Gerencia.ControlAberturaConta;
import DAO.Gerencia.ClienteDAO;
import Entity.Gerencia.Cliente;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author amiltonjunior
 */
public class FrameAberturaConta extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private FrameBemVindo parentFrame;
    private FrameConfirmAbertura sucessFrame;
    private FrameErroAbertura errorFrame;
    private Map<Integer, Map<String, ArrayList<String>>> bdClientes;

    private List<Cliente> correntistas;

    /**
     * Creates new form FrameEfetuarDeposito
     */
    public FrameAberturaConta() {
        initComponents();

        // Adiciona as máscaras aos campos
        try {
            MaskFormatter formataCPF = new MaskFormatter("###.###.###-##");
            formataCPF.install(numeroCPF);

            MaskFormatter formataRG = new MaskFormatter("##.###.###-#");
            formataRG.install(numeroRG);

            MaskFormatter formataData1 = new MaskFormatter("##/##/####");
            formataData1.install(dataNascimento);
            MaskFormatter formataData2 = new MaskFormatter("##/##/####");
            formataData2.install(dataAberturaLimite);
            MaskFormatter formataData3 = new MaskFormatter("##/##/####");
            formataData3.install(aniversarioConta);
            MaskFormatter formataData4 = new MaskFormatter("##/##/####");
            formataData4.install(dataAberturaCorrente);
        } catch (ParseException e) {
        }

        this.correntistas = ClienteDAO.getInstance().findAll();
    }
    
    public void Recarregar() {
        correntistas = ClienteDAO.getInstance().findAll();
    }

    // Método que armazena o JFrame pai
    public void setParentFrame(FrameBemVindo parentFrame) {
        this.parentFrame = parentFrame;
    }

    public void setSucessFrame(FrameConfirmAbertura frame) {
        this.sucessFrame = frame;
    }

    public void setErrorFrame(FrameErroAbertura frame) {
        this.errorFrame = frame;
    }

    public void setBdClientes(Map<Integer, Map<String, ArrayList<String>>> array) {
        this.bdClientes = array;
    }

    public void preencherNomesClientes() {
        // Recarrega do BD
        Recarregar();
        
        // Limpa os campos
        ControlAberturaConta.limparCampos(this);

        for (Cliente cliente : this.correntistas) {
            nomeCorrentistaLimite.addItem(cliente.getNome());
            nomeCorrentistaCorrente.addItem(cliente.getNome());
            nomeCorrentistaPoupanca.addItem(cliente.getNome());
        }
    }

    public Map<Integer, Map<String, ArrayList<String>>> getBdClientes() {
        return this.bdClientes;
    }

    // Método que retorna o JFrame pai
    public FrameBemVindo getParentFrame() {
        return this.parentFrame;
    }

    public FrameConfirmAbertura getSucessFrame() {
        return this.sucessFrame;
    }

    public FrameErroAbertura getErrorFrame() {
        return this.errorFrame;
    }

    public void focoCPF() {
        numeroCPF.requestFocus();
    }

    public void focoRG() {
        numeroRG.requestFocus();
    }

    public void focoSexo() {
        Sexo.requestFocus();
    }

    public void focoNome() {
        nomeCorrentista.requestFocus();
    }

    public void focoEndereco() {
        endereco.requestFocus();
    }

    public void focoNascimento() {
        dataNascimento.requestFocus();
    }

    public void focoLimiteNumeroConta() {
        numeroContaLimite.requestFocus();
    }

    public void focoLimiteAgencia() {
        agenciaCorrenteLimite.requestFocus();
    }

    public void focoLimiteNomeCorrentista() {
        nomeCorrentistaLimite.requestFocus();
    }

    public void focoLimiteSaldoInicial() {
        saldoInicialLimite.requestFocus();
    }

    public void focoLimiteLimite() {
        limite.requestFocus();
    }

    public void focoLimiteDataAbertura() {
        dataAberturaLimite.requestFocus();
    }

    public void focoPoupancaNumeroConta() {
        numeroContaPoupanca.requestFocus();
    }

    public void focoPoupancaAgencia() {
        agenciaPoupanca.requestFocus();
    }

    public void focoPoupancaNomeCorrentista() {
        nomeCorrentistaPoupanca.requestFocus();
    }

    public void focoPoupancaSaldoInicial() {
        saldoInicialPoupanca.requestFocus();
    }

    public void focoPoupancaAniversario() {
        aniversarioConta.requestFocus();
    }

    public void focoCorrenteNumeroConta() {
        numeroCorrente.requestFocus();
    }

    public void focoCorrenteAgencia() {
        agenciaCorrente.requestFocus();
    }

    public void focoCorrenteNomeCorrentista() {
        nomeCorrentistaCorrente.requestFocus();
    }

    public void focoCorrenteSaldoInicial() {
        saldoInicialCorrente.requestFocus();
    }

    public void focoCorrenteDataAbertura() {
        dataAberturaCorrente.requestFocus();
    }

    public void resetCPF() {
        numeroCPF.setText("");
    }

    public void resetRG() {
        numeroRG.setText("");
    }

    public void resetSexo() {
        Sexo.setSelectedIndex(0);
    }

    public void resetNome() {
        nomeCorrentista.setText("");
    }

    public void resetEndereco() {
        endereco.setText("");
    }

    public void resetNascimento() {
        dataNascimento.setText("");
    }

    public void resetVip() {
        clienteVIP.setSelected(false);
    }

    public void resetLimiteNumeroConta() {
        numeroContaLimite.setText("");
    }

    public void resetLimiteAgencia() {
        agenciaCorrenteLimite.setText("");
    }

    public void resetLimiteNomeCorrentista() {
        nomeCorrentistaLimite.removeAllItems();
        nomeCorrentistaLimite.addItem("- Selecione -");
        nomeCorrentistaLimite.setSelectedIndex(0);
    }

    public void resetLimiteSaldoInicial() {
        saldoInicialLimite.setText("");
    }

    public void resetLimiteLimite() {
        limite.setText("");
    }

    public void resetLimiteDataAbertura() {
        dataAberturaLimite.setText("");
    }

    public void resetPoupancaNumeroConta() {
        numeroContaPoupanca.setText("");
    }

    public void resetPoupancaAgencia() {
        agenciaPoupanca.setText("");
    }

    public void resetPoupancaNomeCorrentista() {
        nomeCorrentistaPoupanca.removeAllItems();
        nomeCorrentistaPoupanca.addItem("- Selecione -");
        nomeCorrentistaPoupanca.setSelectedIndex(0);
    }

    public void resetPoupancaSaldoInicial() {
        saldoInicialPoupanca.setText("");
    }

    public void resetLimiteAniversario() {
        aniversarioConta.setText("");
    }

    public void resetCorrenteNumeroConta() {
        numeroCorrente.setText("");
    }

    public void resetCorrenteAgencia() {
        agenciaCorrente.setText("");
    }

    public void resetCorrenteNomeCorrentista() {
        nomeCorrentistaCorrente.removeAllItems();
        nomeCorrentistaCorrente.addItem("- Selecione -");
        nomeCorrentistaCorrente.setSelectedIndex(0);
    }

    public void resetCorrenteSaldoInicial() {
        saldoInicialCorrente.setText("");
    }

    public void resetCorrenteDataAbertura() {
        dataAberturaCorrente.setText("");
    }

    public void resetTabs() {
        menu.setSelectedIndex(0);
    }

    public void resetCheckboxes() {
        contratoLimite.setSelected(false);
        contratoPoupanca.setSelected(false);
        contratoCorrente.setSelected(false);
        necessidadesLimite.setSelected(false);
        necessidadesPoupanca.setSelected(false);
        necessidadesCorrente.setSelected(false);
        outroBancoLimite.setSelected(false);
        outroBancoPoupanca.setSelected(false);
        outroBancoCorrente.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        PainelPrincipal6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        menu = new javax.swing.JTabbedPane();
        jPanelCliente = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        numeroCL1 = new javax.swing.JLabel();
        agenciaCL1 = new javax.swing.JLabel();
        tipoCL1 = new javax.swing.JLabel();
        nomeCL1 = new javax.swing.JLabel();
        nomeCorrentista = new javax.swing.JTextField();
        saldoCL1 = new javax.swing.JLabel();
        endereco = new javax.swing.JTextField();
        dataCL1 = new javax.swing.JLabel();
        outrobancoCL1 = new javax.swing.JLabel();
        clienteVIP = new javax.swing.JCheckBox();
        cancelarCL1 = new javax.swing.JButton();
        cadastrarCliente = new javax.swing.JButton();
        Sexo = new javax.swing.JComboBox<>();
        numeroCPF = new javax.swing.JFormattedTextField();
        numeroRG = new javax.swing.JFormattedTextField();
        dataNascimento = new javax.swing.JFormattedTextField();
        jPanelCorrenteLimite = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        numeroCL = new javax.swing.JLabel();
        numeroContaLimite = new javax.swing.JTextField();
        agenciaCL = new javax.swing.JLabel();
        agenciaCorrenteLimite = new javax.swing.JTextField();
        nomeCL = new javax.swing.JLabel();
        saldoCL = new javax.swing.JLabel();
        saldoInicialLimite = new javax.swing.JTextField();
        dataCL = new javax.swing.JLabel();
        dataHojeLimite = new javax.swing.JLabel();
        contratoCL = new javax.swing.JLabel();
        necessidadesLimite = new javax.swing.JCheckBox();
        necessidadeCL = new javax.swing.JLabel();
        contratoLimite = new javax.swing.JCheckBox();
        outrobancoCL = new javax.swing.JLabel();
        outroBancoLimite = new javax.swing.JCheckBox();
        cancelarCL = new javax.swing.JButton();
        abrirCL = new javax.swing.JButton();
        limiteCL = new javax.swing.JLabel();
        limite = new javax.swing.JTextField();
        nomeCorrentistaLimite = new javax.swing.JComboBox<>();
        dataAberturaLimite = new javax.swing.JFormattedTextField();
        jPanelPoupanca = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLnumeroCP = new javax.swing.JLabel();
        numeroContaPoupanca = new javax.swing.JTextField();
        jLagenciaCP = new javax.swing.JLabel();
        agenciaPoupanca = new javax.swing.JTextField();
        jLnomeCP = new javax.swing.JLabel();
        jLsaldoCP = new javax.swing.JLabel();
        saldoInicialPoupanca = new javax.swing.JTextField();
        jLaniverCP = new javax.swing.JLabel();
        dataHojePoupanca = new javax.swing.JLabel();
        jLcontratoCP = new javax.swing.JLabel();
        necessidadesPoupanca = new javax.swing.JCheckBox();
        jLnecessiCP = new javax.swing.JLabel();
        contratoPoupanca = new javax.swing.JCheckBox();
        jLoutroCP = new javax.swing.JLabel();
        outroBancoPoupanca = new javax.swing.JCheckBox();
        cancelarCP = new javax.swing.JButton();
        abrirCP = new javax.swing.JButton();
        nomeCorrentistaPoupanca = new javax.swing.JComboBox<>();
        aniversarioConta = new javax.swing.JFormattedTextField();
        jPanelCorrente = new javax.swing.JPanel();
        numerocontaCC = new javax.swing.JLabel();
        numeroCorrente = new javax.swing.JTextField();
        agenciaCC = new javax.swing.JLabel();
        agenciaCorrente = new javax.swing.JTextField();
        nomecorrentCC = new javax.swing.JLabel();
        saldoCC = new javax.swing.JLabel();
        saldoInicialCorrente = new javax.swing.JTextField();
        dataabertCC = new javax.swing.JLabel();
        dataHojeCorrente = new javax.swing.JLabel();
        contratoCC = new javax.swing.JLabel();
        necessidadesCorrente = new javax.swing.JCheckBox();
        necessidadeCC = new javax.swing.JLabel();
        contratoCorrente = new javax.swing.JCheckBox();
        outrobancoCC = new javax.swing.JLabel();
        outroBancoCorrente = new javax.swing.JCheckBox();
        cancelarCC = new javax.swing.JButton();
        abrirCC = new javax.swing.JButton();
        nomeCorrentistaCorrente = new javax.swing.JComboBox<>();
        dataAberturaCorrente = new javax.swing.JFormattedTextField();

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        PainelPrincipal6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Novo Cadastro - Banco MM - MoneyMaker");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icones/logo_banco.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(176, 176, 176))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Selecione o tipo:");

        jPanelCliente.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        numeroCL1.setText("Número do CPF:");

        agenciaCL1.setText("RG:");

        tipoCL1.setText("Sexo:");

        nomeCL1.setText("Nome do Correntista: ");

        saldoCL1.setText("Endereço:");

        dataCL1.setText("Data de nascimento:");

        outrobancoCL1.setText("É cliente VIP?");

        cancelarCL1.setBackground(new java.awt.Color(255, 255, 255));
        cancelarCL1.setText("Cancelar");
        cancelarCL1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarCL1btnCancelarCCclick(evt);
            }
        });
        cancelarCL1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarCL1ActionPerformed(evt);
            }
        });

        cadastrarCliente.setBackground(new java.awt.Color(255, 255, 255));
        cadastrarCliente.setText("Cadastrar Cliente");
        cadastrarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cadastrarClientebtnAbrirContaCLclick(evt);
            }
        });
        cadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarClienteActionPerformed(evt);
            }
        });

        Sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Selecione -", "Masculino", "Feminino" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(saldoCL1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(endereco))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(numeroCL1)
                        .addGap(3, 3, 3)
                        .addComponent(numeroCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(agenciaCL1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numeroRG, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tipoCL1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(nomeCL1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeCorrentista, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(outrobancoCL1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(clienteVIP))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addComponent(cancelarCL1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(dataCL1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroCL1)
                    .addComponent(agenciaCL1)
                    .addComponent(tipoCL1)
                    .addComponent(Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeCL1)
                    .addComponent(nomeCorrentista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saldoCL1)
                    .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataCL1)
                    .addComponent(dataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outrobancoCL1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(clienteVIP, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(57, 57, 57)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarCL1)
                    .addComponent(cadastrarCliente)))
        );

        javax.swing.GroupLayout jPanelClienteLayout = new javax.swing.GroupLayout(jPanelCliente);
        jPanelCliente.setLayout(jPanelClienteLayout);
        jPanelClienteLayout.setHorizontalGroup(
            jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelClienteLayout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanelClienteLayout.setVerticalGroup(
            jPanelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelClienteLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        menu.addTab("Novo Cliente", jPanelCliente);

        jPanelCorrenteLimite.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        numeroCL.setText("Número da Conta:");

        agenciaCL.setText("Agência:");

        nomeCL.setText("Nome do Correntista: ");

        saldoCL.setText("Saldo inicial: ");

        dataCL.setText("Data de abertura:");

        dataHojeLimite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icones/calendario.jpg"))); // NOI18N
        dataHojeLimite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataHojeLimiteMouseClicked(evt);
            }
        });

        contratoCL.setText("O cliente assinou o contrato?");

        necessidadeCL.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        necessidadeCL.setText("O cliente possui necessidades especiais de atendimento?");

        outrobancoCL.setText("O cliente já foi correntista em outro banco?");

        cancelarCL.setBackground(new java.awt.Color(255, 255, 255));
        cancelarCL.setText("Cancelar");
        cancelarCL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarCCclick(evt);
            }
        });
        cancelarCL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarCLActionPerformed(evt);
            }
        });

        abrirCL.setBackground(new java.awt.Color(255, 255, 255));
        abrirCL.setText("Abrir conta");
        abrirCL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAbrirContaCLclick(evt);
            }
        });
        abrirCL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirCLActionPerformed(evt);
            }
        });

        limiteCL.setText("Limite:");

        nomeCorrentistaLimite.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Selecione -" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(numeroCL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numeroContaLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(agenciaCL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agenciaCorrenteLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(nomeCL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeCorrentistaLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(saldoCL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saldoInicialLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(limiteCL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(limite, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(necessidadeCL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(necessidadesLimite))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(outrobancoCL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(cancelarCL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(abrirCL)
                                .addGap(28, 28, 28)))
                        .addComponent(outroBancoLimite))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(contratoCL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contratoLimite))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(dataCL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataAberturaLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addComponent(dataHojeLimite)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroCL)
                    .addComponent(numeroContaLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agenciaCL)
                    .addComponent(agenciaCorrenteLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeCL)
                    .addComponent(nomeCorrentistaLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saldoCL)
                    .addComponent(saldoInicialLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limiteCL)
                    .addComponent(limite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dataCL)
                            .addComponent(dataAberturaLimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(contratoCL)
                            .addComponent(contratoLimite)))
                    .addComponent(dataHojeLimite))
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(necessidadeCL)
                            .addComponent(necessidadesLimite))
                        .addGap(27, 27, 27)
                        .addComponent(outrobancoCL))
                    .addComponent(outroBancoLimite, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarCL)
                    .addComponent(abrirCL)))
        );

        javax.swing.GroupLayout jPanelCorrenteLimiteLayout = new javax.swing.GroupLayout(jPanelCorrenteLimite);
        jPanelCorrenteLimite.setLayout(jPanelCorrenteLimiteLayout);
        jPanelCorrenteLimiteLayout.setHorizontalGroup(
            jPanelCorrenteLimiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
            .addGroup(jPanelCorrenteLimiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCorrenteLimiteLayout.createSequentialGroup()
                    .addContainerGap(44, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(44, Short.MAX_VALUE)))
        );
        jPanelCorrenteLimiteLayout.setVerticalGroup(
            jPanelCorrenteLimiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
            .addGroup(jPanelCorrenteLimiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCorrenteLimiteLayout.createSequentialGroup()
                    .addContainerGap(27, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(56, Short.MAX_VALUE)))
        );

        menu.addTab("Conta Corrente c/Limite", jPanelCorrenteLimite);

        jPanelPoupanca.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLnumeroCP.setText("Número da Conta:");

        jLagenciaCP.setText("Agência:");

        jLnomeCP.setText("Nome do Correntista: ");

        jLsaldoCP.setText("Saldo inicial: ");

        jLaniverCP.setText("Aniversário da conta:");

        dataHojePoupanca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icones/calendario.jpg"))); // NOI18N
        dataHojePoupanca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataHojePoupancaMouseClicked(evt);
            }
        });

        jLcontratoCP.setText("O cliente assinou o contrato?");

        jLnecessiCP.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLnecessiCP.setText("O cliente possui necessidades especiais de atendimento?");

        jLoutroCP.setText("O cliente já foi correntista em outro banco?");

        cancelarCP.setBackground(new java.awt.Color(255, 255, 255));
        cancelarCP.setText("Cancelar");
        cancelarCP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarCPclick(evt);
            }
        });
        cancelarCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarCPActionPerformed(evt);
            }
        });

        abrirCP.setBackground(new java.awt.Color(255, 255, 255));
        abrirCP.setText("Abrir conta");
        abrirCP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAbrirContaCPclick(evt);
            }
        });
        abrirCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirCPActionPerformed(evt);
            }
        });

        nomeCorrentistaPoupanca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Selecione -" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLnumeroCP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numeroContaPoupanca, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jLagenciaCP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(agenciaPoupanca, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLnomeCP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nomeCorrentistaPoupanca, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLsaldoCP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saldoInicialPoupanca, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLoutroCP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(outroBancoPoupanca))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLnecessiCP)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLcontratoCP)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(contratoPoupanca))
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLaniverCP)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(aniversarioConta, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dataHojePoupanca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(necessidadesPoupanca))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(cancelarCP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(abrirCP)))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLnumeroCP)
                    .addComponent(numeroContaPoupanca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLagenciaCP)
                    .addComponent(agenciaPoupanca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLnomeCP)
                    .addComponent(nomeCorrentistaPoupanca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLsaldoCP)
                    .addComponent(saldoInicialPoupanca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLaniverCP)
                                    .addComponent(aniversarioConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLcontratoCP)
                                    .addComponent(contratoPoupanca)))
                            .addComponent(dataHojePoupanca))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLnecessiCP)
                            .addComponent(necessidadesPoupanca))
                        .addGap(27, 27, 27)
                        .addComponent(jLoutroCP))
                    .addComponent(outroBancoPoupanca))
                .addGap(38, 38, 38)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarCP)
                    .addComponent(abrirCP))
                .addContainerGap(128, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelPoupancaLayout = new javax.swing.GroupLayout(jPanelPoupanca);
        jPanelPoupanca.setLayout(jPanelPoupancaLayout);
        jPanelPoupancaLayout.setHorizontalGroup(
            jPanelPoupancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPoupancaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelPoupancaLayout.setVerticalGroup(
            jPanelPoupancaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPoupancaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        menu.addTab("Conta Poupança", jPanelPoupanca);

        jPanelCorrente.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCorrente.setPreferredSize(new java.awt.Dimension(780, 495));

        numerocontaCC.setText("Número da Conta:");

        agenciaCC.setText("Agência:");

        nomecorrentCC.setText("Nome do Correntista: ");

        saldoCC.setText("Saldo inicial: ");

        dataabertCC.setText("Data de abertura:");

        dataHojeCorrente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icones/calendario.jpg"))); // NOI18N
        dataHojeCorrente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataHojeCorrenteMouseClicked(evt);
            }
        });

        contratoCC.setText("O cliente assinou o contrato?");

        necessidadeCC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        necessidadeCC.setText("O cliente possui necessidades especiais de atendimento?");

        outrobancoCC.setText("O cliente já foi correntista em outro banco?");

        cancelarCC.setBackground(new java.awt.Color(255, 255, 255));
        cancelarCC.setText("Cancelar");
        cancelarCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncancelarCCclick(evt);
            }
        });
        cancelarCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarCCActionPerformed(evt);
            }
        });

        abrirCC.setBackground(new java.awt.Color(255, 255, 255));
        abrirCC.setText("Abrir conta");
        abrirCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAbrirContaCCclick(evt);
            }
        });
        abrirCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirCCActionPerformed(evt);
            }
        });

        nomeCorrentistaCorrente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Selecione -" }));

        dataAberturaCorrente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataAberturaCorrenteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelCorrenteLayout = new javax.swing.GroupLayout(jPanelCorrente);
        jPanelCorrente.setLayout(jPanelCorrenteLayout);
        jPanelCorrenteLayout.setHorizontalGroup(
            jPanelCorrenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCorrenteLayout.createSequentialGroup()
                .addGroup(jPanelCorrenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCorrenteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelCorrenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelCorrenteLayout.createSequentialGroup()
                                .addComponent(numerocontaCC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numeroCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(agenciaCC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(agenciaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelCorrenteLayout.createSequentialGroup()
                                .addComponent(nomecorrentCC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nomeCorrentistaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelCorrenteLayout.createSequentialGroup()
                                .addComponent(saldoCC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saldoInicialCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelCorrenteLayout.createSequentialGroup()
                                .addComponent(necessidadeCC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(necessidadesCorrente))
                            .addGroup(jPanelCorrenteLayout.createSequentialGroup()
                                .addComponent(outrobancoCC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(outroBancoCorrente))
                            .addGroup(jPanelCorrenteLayout.createSequentialGroup()
                                .addGroup(jPanelCorrenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelCorrenteLayout.createSequentialGroup()
                                        .addComponent(contratoCC)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(contratoCorrente))
                                    .addGroup(jPanelCorrenteLayout.createSequentialGroup()
                                        .addComponent(dataabertCC)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dataAberturaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(19, 19, 19)
                                .addComponent(dataHojeCorrente))))
                    .addGroup(jPanelCorrenteLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(cancelarCC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(abrirCC)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanelCorrenteLayout.setVerticalGroup(
            jPanelCorrenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCorrenteLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelCorrenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numerocontaCC)
                    .addComponent(numeroCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agenciaCC)
                    .addComponent(agenciaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCorrenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomecorrentCC)
                    .addComponent(nomeCorrentistaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCorrenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saldoCC)
                    .addComponent(saldoInicialCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCorrenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCorrenteLayout.createSequentialGroup()
                        .addGroup(jPanelCorrenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dataabertCC)
                            .addComponent(dataAberturaCorrente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelCorrenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(contratoCC)
                            .addComponent(contratoCorrente)))
                    .addComponent(dataHojeCorrente))
                .addGap(10, 10, 10)
                .addGroup(jPanelCorrenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCorrenteLayout.createSequentialGroup()
                        .addGroup(jPanelCorrenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(necessidadeCC)
                            .addComponent(necessidadesCorrente))
                        .addGap(27, 27, 27)
                        .addComponent(outrobancoCC))
                    .addComponent(outroBancoCorrente, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(38, 38, 38)
                .addGroup(jPanelCorrenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarCC)
                    .addComponent(abrirCC))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        menu.addTab("Conta Corrente Comum", jPanelCorrente);

        javax.swing.GroupLayout PainelPrincipal6Layout = new javax.swing.GroupLayout(PainelPrincipal6);
        PainelPrincipal6.setLayout(PainelPrincipal6Layout);
        PainelPrincipal6Layout.setHorizontalGroup(
            PainelPrincipal6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PainelPrincipal6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelPrincipal6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelPrincipal6Layout.createSequentialGroup()
                        .addGap(924, 924, 924)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelPrincipal6Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PainelPrincipal6Layout.createSequentialGroup()
                        .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        PainelPrincipal6Layout.setVerticalGroup(
            PainelPrincipal6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelPrincipal6Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PainelPrincipal6, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PainelPrincipal6, javax.swing.GroupLayout.PREFERRED_SIZE, 519, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarCCActionPerformed
        ControlAberturaConta.cancelar(this, getParentFrame());
    }//GEN-LAST:event_cancelarCCActionPerformed

    private void cancelarCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarCLActionPerformed
        ControlAberturaConta.cancelar(this, getParentFrame());
    }//GEN-LAST:event_cancelarCLActionPerformed

    private void cancelarCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarCPActionPerformed
        ControlAberturaConta.cancelar(this, getParentFrame());
    }//GEN-LAST:event_cancelarCPActionPerformed

    private void btncancelarCCclick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelarCCclick
        // TODO add your handling code here:
    }//GEN-LAST:event_btncancelarCCclick

    private void btnAbrirContaCCclick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbrirContaCCclick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAbrirContaCCclick

    private void btnCancelarCCclick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarCCclick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarCCclick

    private void btnAbrirContaCLclick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbrirContaCLclick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAbrirContaCLclick

    private void btnCancelarCPclick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarCPclick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarCPclick

    private void btnAbrirContaCPclick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbrirContaCPclick
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAbrirContaCPclick

    private void cancelarCL1btnCancelarCCclick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarCL1btnCancelarCCclick
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarCL1btnCancelarCCclick

    private void cancelarCL1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarCL1ActionPerformed
        ControlAberturaConta.cancelar(this, getParentFrame());
    }//GEN-LAST:event_cancelarCL1ActionPerformed

    private void cadastrarClientebtnAbrirContaCLclick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadastrarClientebtnAbrirContaCLclick
        // TODO add your handling code here:
    }//GEN-LAST:event_cadastrarClientebtnAbrirContaCLclick

    private void cadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarClienteActionPerformed
        ControlAberturaConta.cadastrarCliente(this, getSucessFrame(), getErrorFrame(), numeroCPF.getText(), numeroRG.getText(), Sexo.getSelectedItem().toString(), nomeCorrentista.getText(), endereco.getText(), dataNascimento.getText(), clienteVIP.isSelected());
    }//GEN-LAST:event_cadastrarClienteActionPerformed

    private void abrirCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirCLActionPerformed
        int index = nomeCorrentistaLimite.getSelectedIndex();
        Cliente correntista = index == 0 ? null : this.correntistas.get(index - 1);

        ControlAberturaConta.abrirContaCorrenteLimite(this, getSucessFrame(), getErrorFrame(), numeroContaLimite.getText(), agenciaCorrenteLimite.getText(), correntista, saldoInicialLimite.getText(), limite.getText(), dataAberturaLimite.getText(), contratoLimite.isSelected(), necessidadesLimite.isSelected(), outroBancoLimite.isSelected());
    }//GEN-LAST:event_abrirCLActionPerformed

    private void abrirCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirCPActionPerformed
        int index = nomeCorrentistaPoupanca.getSelectedIndex();
        Cliente correntista = index == 0 ? null : this.correntistas.get(index - 1);

        ControlAberturaConta.abrirContaPoupanca(this, getSucessFrame(), getErrorFrame(), numeroContaPoupanca.getText(), agenciaPoupanca.getText(), correntista, saldoInicialPoupanca.getText(), aniversarioConta.getText(), contratoPoupanca.isSelected(), necessidadesPoupanca.isSelected(), outroBancoPoupanca.isSelected());
    }//GEN-LAST:event_abrirCPActionPerformed

    private void abrirCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirCCActionPerformed
        int index = nomeCorrentistaCorrente.getSelectedIndex();
        Cliente correntista = index == 0 ? null : this.correntistas.get(index - 1);

        ControlAberturaConta.abrirContaCorrente(this, getSucessFrame(), getErrorFrame(), numeroCorrente.getText(), agenciaCorrente.getText(), correntista, saldoInicialCorrente.getText(), dataAberturaCorrente.getText(), contratoCorrente.isSelected(), necessidadesCorrente.isSelected(), outroBancoCorrente.isSelected());
    }//GEN-LAST:event_abrirCCActionPerformed

    private void dataHojeLimiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataHojeLimiteMouseClicked
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        dataAberturaLimite.setText(dateFormat.format(date));
    }//GEN-LAST:event_dataHojeLimiteMouseClicked

    private void dataHojePoupancaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataHojePoupancaMouseClicked
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        aniversarioConta.setText(dateFormat.format(date));
    }//GEN-LAST:event_dataHojePoupancaMouseClicked

    private void dataAberturaCorrenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataAberturaCorrenteMouseClicked

    }//GEN-LAST:event_dataAberturaCorrenteMouseClicked

    private void dataHojeCorrenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataHojeCorrenteMouseClicked
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        dataAberturaCorrente.setText(dateFormat.format(date));
    }//GEN-LAST:event_dataHojeCorrenteMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameAberturaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameAberturaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameAberturaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameAberturaConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameAberturaConta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelPrincipal6;
    private javax.swing.JComboBox<String> Sexo;
    private javax.swing.JButton abrirCC;
    private javax.swing.JButton abrirCL;
    private javax.swing.JButton abrirCP;
    private javax.swing.JLabel agenciaCC;
    private javax.swing.JLabel agenciaCL;
    private javax.swing.JLabel agenciaCL1;
    private javax.swing.JTextField agenciaCorrente;
    private javax.swing.JTextField agenciaCorrenteLimite;
    private javax.swing.JTextField agenciaPoupanca;
    private javax.swing.JFormattedTextField aniversarioConta;
    private javax.swing.JButton cadastrarCliente;
    private javax.swing.JButton cancelarCC;
    private javax.swing.JButton cancelarCL;
    private javax.swing.JButton cancelarCL1;
    private javax.swing.JButton cancelarCP;
    private javax.swing.JCheckBox clienteVIP;
    private javax.swing.JLabel contratoCC;
    private javax.swing.JLabel contratoCL;
    private javax.swing.JCheckBox contratoCorrente;
    private javax.swing.JCheckBox contratoLimite;
    private javax.swing.JCheckBox contratoPoupanca;
    private javax.swing.JFormattedTextField dataAberturaCorrente;
    private javax.swing.JFormattedTextField dataAberturaLimite;
    private javax.swing.JLabel dataCL;
    private javax.swing.JLabel dataCL1;
    private javax.swing.JLabel dataHojeCorrente;
    private javax.swing.JLabel dataHojeLimite;
    private javax.swing.JLabel dataHojePoupanca;
    private javax.swing.JFormattedTextField dataNascimento;
    private javax.swing.JLabel dataabertCC;
    private javax.swing.JTextField endereco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLagenciaCP;
    private javax.swing.JLabel jLaniverCP;
    private javax.swing.JLabel jLcontratoCP;
    private javax.swing.JLabel jLnecessiCP;
    private javax.swing.JLabel jLnomeCP;
    private javax.swing.JLabel jLnumeroCP;
    private javax.swing.JLabel jLoutroCP;
    private javax.swing.JLabel jLsaldoCP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelCliente;
    private javax.swing.JPanel jPanelCorrente;
    private javax.swing.JPanel jPanelCorrenteLimite;
    private javax.swing.JPanel jPanelPoupanca;
    private javax.swing.JTextField limite;
    private javax.swing.JLabel limiteCL;
    private javax.swing.JTabbedPane menu;
    private javax.swing.JLabel necessidadeCC;
    private javax.swing.JLabel necessidadeCL;
    private javax.swing.JCheckBox necessidadesCorrente;
    private javax.swing.JCheckBox necessidadesLimite;
    private javax.swing.JCheckBox necessidadesPoupanca;
    private javax.swing.JLabel nomeCL;
    private javax.swing.JLabel nomeCL1;
    private javax.swing.JTextField nomeCorrentista;
    private javax.swing.JComboBox<String> nomeCorrentistaCorrente;
    private javax.swing.JComboBox<String> nomeCorrentistaLimite;
    private javax.swing.JComboBox<String> nomeCorrentistaPoupanca;
    private javax.swing.JLabel nomecorrentCC;
    private javax.swing.JLabel numeroCL;
    private javax.swing.JLabel numeroCL1;
    private javax.swing.JFormattedTextField numeroCPF;
    private javax.swing.JTextField numeroContaLimite;
    private javax.swing.JTextField numeroContaPoupanca;
    private javax.swing.JTextField numeroCorrente;
    private javax.swing.JFormattedTextField numeroRG;
    private javax.swing.JLabel numerocontaCC;
    private javax.swing.JCheckBox outroBancoCorrente;
    private javax.swing.JCheckBox outroBancoLimite;
    private javax.swing.JCheckBox outroBancoPoupanca;
    private javax.swing.JLabel outrobancoCC;
    private javax.swing.JLabel outrobancoCL;
    private javax.swing.JLabel outrobancoCL1;
    private javax.swing.JLabel saldoCC;
    private javax.swing.JLabel saldoCL;
    private javax.swing.JLabel saldoCL1;
    private javax.swing.JTextField saldoInicialCorrente;
    private javax.swing.JTextField saldoInicialLimite;
    private javax.swing.JTextField saldoInicialPoupanca;
    private javax.swing.JLabel tipoCL1;
    // End of variables declaration//GEN-END:variables
}
