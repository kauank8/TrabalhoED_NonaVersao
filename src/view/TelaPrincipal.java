package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.AlunoController;
import controller.ConsultaCodigoController;
import controller.ConsultaOrientacaoController;
import controller.ConsultarAreaController;
import controller.GruposController;
import controller.OrientacoesController;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField tfAlunoNome;
	private JTextField tfAlunoRa;
	private JTextField tfGruposRA;
	private JTextField tfCGrupoCodigo;
	private JTextField tfCAArea;
	private JTextField tfCOrientacao;
	private JTextField tfOCodigoGrupo;
	private JTextArea taGruposAdiciona;	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
//	public TelaPrincipal(boolean status) throws HeadlessException {
//		super();
//		this.status = status;
//	}


	public TelaPrincipal() {
		setTitle("Sistema de Controle de TCC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 480);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(192, 192, 192));
		tabbedPane.setFont(new Font("Arial", Font.PLAIN, 12));
		tabbedPane.setBounds(0, 0, 710, 477);
		contentPane.add(tabbedPane);
		
		//Tela Alunos
		JPanel TelaAluno = new JPanel();
		TelaAluno.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Registrar Aluno", null, TelaAluno, null);
		TelaAluno.setLayout(null);
		
		JLabel lblAlunoNome = new JLabel("Nome:");
		lblAlunoNome.setForeground(Color.BLACK);
		lblAlunoNome.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAlunoNome.setBounds(100, 130, 65, 22);
		TelaAluno.add(lblAlunoNome);
		
		JLabel lblTituloPag = new JLabel("Registrar Aluno");
		lblTituloPag.setFont(new Font("Arial", Font.BOLD, 24));
		lblTituloPag.setBounds(202, 53, 212, 36);
		TelaAluno.add(lblTituloPag);
		
		tfAlunoNome = new JTextField();
		tfAlunoNome.setFont(new Font("Arial", Font.PLAIN, 12));
		tfAlunoNome.setBounds(175, 130, 320, 22);
		TelaAluno.add(tfAlunoNome);
		tfAlunoNome.setColumns(10);
		
		JLabel lblAlunoRa = new JLabel("RA:");
		lblAlunoRa.setForeground(Color.BLACK);
		lblAlunoRa.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAlunoRa.setBounds(100, 189, 65, 22);
		TelaAluno.add(lblAlunoRa);
		
		tfAlunoRa = new JTextField();
		tfAlunoRa.setFont(new Font("Arial", Font.PLAIN, 12));
		tfAlunoRa.setColumns(10);
		tfAlunoRa.setBounds(175, 189, 320, 22);
		TelaAluno.add(tfAlunoRa);
		
		JButton btnAlunoGrava = new JButton("Gravar Aluno");
		btnAlunoGrava.setFont(new Font("Arial", Font.PLAIN, 20));
		btnAlunoGrava.setBounds(200, 250, 179, 30);
		TelaAluno.add(btnAlunoGrava);
		
		AlunoController aluno = new AlunoController(tfAlunoNome, tfAlunoRa);
		btnAlunoGrava.addActionListener(aluno);
		
		//-----------------------------------------------------------------------------------------------------------
		//Tela Grupos
		JPanel TelaGrupos = new JPanel();
		TelaGrupos.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Registrar Grupos", null, TelaGrupos, null);
		TelaGrupos.setLayout(null);
		
		JLabel lblTituloGrupos = new JLabel("Registrar Grupos");
		lblTituloGrupos.setBounds(200, 35, 212, 36);
		lblTituloGrupos.setFont(new Font("Arial", Font.BOLD, 24));
		TelaGrupos.add(lblTituloGrupos);
		
		JLabel lblGruposRa = new JLabel("RA:");
		lblGruposRa.setForeground(Color.BLACK);
		lblGruposRa.setFont(new Font("Arial", Font.PLAIN, 20));
		lblGruposRa.setBounds(55, 105, 65, 22);
		TelaGrupos.add(lblGruposRa);
		
		tfGruposRA = new JTextField();
		tfGruposRA.setFont(new Font("Arial", Font.PLAIN, 12));
		tfGruposRA.setBounds(104, 108, 219, 22);
		TelaGrupos.add(tfGruposRA);
		tfGruposRA.setColumns(10);
		
		JButton btnGruposGravar = new JButton("Gravar Grupo");
		btnGruposGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGruposGravar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnGruposGravar.setBounds(55, 288, 179, 30);
		TelaGrupos.add(btnGruposGravar);
		
		JButton btnGruposAdicionar = new JButton("Adicionar Aluno ao Grupo");
		btnGruposAdicionar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnGruposAdicionar.setBounds(57, 158, 267, 30);
		TelaGrupos.add(btnGruposAdicionar);
		
		taGruposAdiciona = new JTextArea();
		taGruposAdiciona.setBounds(402, 107, 267, 274);
		TelaGrupos.add(taGruposAdiciona);
		

		
		
		
		JButton btnGruposLimpar = new JButton("Limpar Lista");
		btnGruposLimpar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnGruposLimpar.setBounds(55, 222, 179, 30);
		TelaGrupos.add(btnGruposLimpar);
		
		JLabel lblNewLabel = new JLabel("Lista Alunos");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(473, 84, 116, 13);
		TelaGrupos.add(lblNewLabel);
		
		GruposController gp = new GruposController(tfGruposRA,null,null,null,taGruposAdiciona);
		
		btnGruposGravar.addActionListener(gp);
		btnGruposAdicionar.addActionListener(gp);
		btnGruposLimpar.addActionListener(gp);
		
		//---------------------------------------------------------------------------------------------
		//Tela Consulta Codigo
		
		JPanel Colsulta_Codigo = new JPanel();
        Colsulta_Codigo.setBackground(new Color(192, 192, 192));
        tabbedPane.addTab("Consulta por Código", null, Colsulta_Codigo, null);
        Colsulta_Codigo.setLayout(null);

        JLabel lblInserirCod = new JLabel("Insira o Código:");
        lblInserirCod.setFont(new Font("Arial", Font.PLAIN, 20));
        lblInserirCod.setBounds(109, 90, 144, 22);
        Colsulta_Codigo.add(lblInserirCod);

        JLabel lblTitulo = new JLabel("Consulta por Código");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setBounds(212, 26, 250, 36);
        Colsulta_Codigo.add(lblTitulo);

        tfCGrupoCodigo = new JTextField();
        tfCGrupoCodigo.setFont(new Font("Arial", Font.PLAIN, 15));
        tfCGrupoCodigo.setColumns(10);
        tfCGrupoCodigo.setBounds(287, 89, 175, 28);
        Colsulta_Codigo.add(tfCGrupoCodigo);

        JButton btnCGrupoCodigo = new JButton("Buscar");
        btnCGrupoCodigo.setFont(new Font("Arial", Font.PLAIN, 20));
        btnCGrupoCodigo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnCGrupoCodigo.setBounds(484, 87, 101, 28);
        Colsulta_Codigo.add(btnCGrupoCodigo);

        JLabel lblCGruposGp = new JLabel("Grupo");
        lblCGruposGp.setFont(new Font("Arial", Font.BOLD, 24));
        lblCGruposGp.setBounds(270, 152, 117, 36);
        Colsulta_Codigo.add(lblCGruposGp);

        JTextArea taCGrupoTexto = new JTextArea();
        taCGrupoTexto.setText("\r\n");
        taCGrupoTexto.setFont(new Font("Arial", Font.PLAIN, 20));
        taCGrupoTexto.setBounds(10, 198, 671, 206);
        Colsulta_Codigo.add(taCGrupoTexto);
        
        ConsultaCodigoController codigo = new ConsultaCodigoController(tfCGrupoCodigo,taCGrupoTexto);
        btnCGrupoCodigo.addActionListener(codigo);
        
        //---------------------------------------------------------------------------------------------------
        //Tela COnsulta Area
        
        JPanel ConsultaArea = new JPanel();
        ConsultaArea.setBackground(new Color(192, 192, 192));
        tabbedPane.addTab("Consulta por Área", null, ConsultaArea, null);
        tabbedPane.setBackgroundAt(3, new Color(192, 192, 192));
        tabbedPane.setBackgroundAt(1, new Color(192, 192, 192));
        ConsultaArea.setLayout(null);

        JLabel lblCAGruposConsultar = new JLabel("Consulta por Área");
        lblCAGruposConsultar.setFont(new Font("Arial", Font.BOLD, 24));
        lblCAGruposConsultar.setBounds(231, 27, 227, 36);
        ConsultaArea.add(lblCAGruposConsultar);

        JLabel lblCAGruposArea = new JLabel("Digite a Área: ");
        lblCAGruposArea.setFont(new Font("Arial", Font.PLAIN, 20));
        lblCAGruposArea.setBounds(103, 90, 144, 22);
        ConsultaArea.add(lblCAGruposArea);

        JLabel lblCAGruposGp = new JLabel("Grupos");
        lblCAGruposGp.setFont(new Font("Arial", Font.BOLD, 24));
        lblCAGruposGp.setBounds(280, 152, 117, 36);
        ConsultaArea.add(lblCAGruposGp);

        tfCAArea = new JTextField();
        tfCAArea.setFont(new Font("Arial", Font.PLAIN, 15));
        tfCAArea.setBounds(257, 89, 175, 28);
        ConsultaArea.add(tfCAArea);
        tfCAArea.setColumns(10);

        JTextArea taCAGrupos = new JTextArea();
        taCAGrupos.setFont(new Font("Arial", Font.PLAIN, 20));
        taCAGrupos.setBounds(10, 198, 671, 206);
        ConsultaArea.add(taCAGrupos);

        JButton btnCABuscarArea = new JButton("Buscar");
        btnCABuscarArea.setFont(new Font("Arial", Font.PLAIN, 20));
        btnCABuscarArea.setBounds(460, 89, 101, 28);
        ConsultaArea.add(btnCABuscarArea);
        
        ConsultarAreaController CA = new ConsultarAreaController(tfCAArea, taCAGrupos);
        btnCABuscarArea.addActionListener(CA);
		
        //----------------------------------------------------------------------------------------------->
		//Tela Inserir Orientacoes
		JPanel Orientacoes = new JPanel();
		Orientacoes.setBackground(new Color(192, 192, 192));
		tabbedPane.addTab("Orientações", null, Orientacoes, null);
		Orientacoes.setLayout(null);

        JLabel lblProfessorOrient = new JLabel("Coloque Abaixo Suas Orientações!!");
        lblProfessorOrient.setFont(new Font("Arial", Font.BOLD, 20));
        lblProfessorOrient.setBounds(130, 36, 343, 48);
        Orientacoes.add(lblProfessorOrient);

        JButton btRegistrarOrien = new JButton("Registrar Orientações");
        btRegistrarOrien.setFont(new Font("Arial", Font.PLAIN, 20));
        btRegistrarOrien.setBounds(397, 331, 239, 33);
        Orientacoes.add(btRegistrarOrien);
        

        JLabel lbODigiteOCod = new JLabel("Digite o Código do Grupo");
        lbODigiteOCod.setFont(new Font("Arial", Font.PLAIN, 20));
        lbODigiteOCod.setBounds(10, 323, 227, 48);
        Orientacoes.add(lbODigiteOCod);

        tfOCodigoGrupo = new JTextField();
        tfOCodigoGrupo.setFont(new Font("Arial", Font.PLAIN, 20));
        tfOCodigoGrupo.setBounds(244, 336, 111, 28);
        Orientacoes.add(tfOCodigoGrupo);
        tfOCodigoGrupo.setColumns(10);
        
        JTextArea taOrientacaoTxt = new JTextArea();
        taOrientacaoTxt.setFont(new Font("Arial", Font.PLAIN, 20));
        taOrientacaoTxt.setBounds(74, 95, 551, 208);
        Orientacoes.add(taOrientacaoTxt);
        
        OrientacoesController or = new OrientacoesController(taOrientacaoTxt, tfOCodigoGrupo);
        btRegistrarOrien.addActionListener(or);
        
        //-----------------------------------------------------------
        //Consultar Orientacao
		
        JPanel ConsultarOrientacao = new JPanel();
        ConsultarOrientacao.setBackground(new Color(192, 192, 192));
        tabbedPane.addTab("Consulta Orientaçoes", null, ConsultarOrientacao, null);
        ConsultarOrientacao.setLayout(null);

        JLabel lblOrientacaoInserirCod = new JLabel("Insira o Código do Grupo:");
        lblOrientacaoInserirCod.setFont(new Font("Arial", Font.PLAIN, 20));
        lblOrientacaoInserirCod.setBounds(37, 90, 242, 22);
        ConsultarOrientacao.add(lblOrientacaoInserirCod);
        
        tfCOrientacao = new JTextField();
        tfCOrientacao.setFont(new Font("Arial", Font.PLAIN, 15));
        tfCOrientacao.setBounds(289, 89, 175, 28);
        ConsultarOrientacao.add(tfCOrientacao);
        tfCOrientacao.setColumns(10);

        JTextArea taCOrientacoes = new JTextArea();
        taCOrientacoes.setFont(new Font("Arial", Font.PLAIN, 20));
        taCOrientacoes.setBounds(10, 198, 671, 206);
        ConsultarOrientacao.add(taCOrientacoes);

        JButton btnCOBuscarOrientacao = new JButton("Ultima Orientação");
        btnCOBuscarOrientacao.setFont(new Font("Arial", Font.PLAIN, 16));
        btnCOBuscarOrientacao.setBounds(497, 87, 175, 28);
        ConsultarOrientacao.add(btnCOBuscarOrientacao);
        
        JLabel lblCOOrientacaoGP = new JLabel("Ultima Orientação");
        lblCOOrientacaoGP.setFont(new Font("Arial", Font.BOLD, 24));
        lblCOOrientacaoGP.setBounds(215, 152, 253, 36);
        ConsultarOrientacao.add(lblCOOrientacaoGP);
        
        JLabel lblCOrientacaoTi = new JLabel("Consulta Ultima Orientacao");
        lblCOrientacaoTi.setFont(new Font("Arial", Font.BOLD, 24));
        lblCOrientacaoTi.setBounds(163, 29, 332, 36);
        ConsultarOrientacao.add(lblCOrientacaoTi);
        
        JButton btnCOrientacoesTodas = new JButton("Todas Orientações");
        btnCOrientacoesTodas.setFont(new Font("Arial", Font.PLAIN, 16));
        btnCOrientacoesTodas.setBounds(497, 138, 175, 28);
        ConsultarOrientacao.add(btnCOrientacoesTodas);
        
        ConsultaOrientacaoController CO = new ConsultaOrientacaoController(taCOrientacoes, tfCOrientacao);
        btnCOBuscarOrientacao.addActionListener(CO);
        btnCOrientacoesTodas.addActionListener(CO);
        
	}
}

