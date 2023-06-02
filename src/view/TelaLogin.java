package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.VerificaLogin;


public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField tfLUsuario;
	private JTextField tfLSenha;
//	public static boolean Status = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbLTitleLogin = new JLabel("Login");
		lbLTitleLogin.setFont(new Font("Arial", Font.BOLD, 24));
		lbLTitleLogin.setBounds(183, 11, 91, 46);
		panel.add(lbLTitleLogin);
		
		JLabel lbLLogin = new JLabel("Usuário");
		lbLLogin.setFont(new Font("Arial", Font.PLAIN, 20));
		lbLLogin.setBounds(117, 51, 100, 37);
		panel.add(lbLLogin);
		
		JLabel lbLSenha = new JLabel("Senha");
		lbLSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		lbLSenha.setBounds(117, 115, 100, 37);
		panel.add(lbLSenha);
		
		tfLUsuario = new JTextField();
		tfLUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
		tfLUsuario.setBounds(117, 89, 202, 26);
		panel.add(tfLUsuario);
		tfLUsuario.setColumns(10);
		
		tfLSenha = new JTextField();
		tfLSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		tfLSenha.setColumns(10);
		tfLSenha.setBounds(117, 153, 202, 26);
		panel.add(tfLSenha);
		
		JButton btnLEntrar = new JButton("Entrar");
		btnLEntrar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnLEntrar.setBounds(117, 190, 89, 23);
		panel.add(btnLEntrar);
		
		JButton btnLCadastrar = new JButton("Cadastro");
		btnLCadastrar.setForeground(new Color(128, 128, 128));
		btnLCadastrar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLCadastrar.setBackground(new Color(192, 192, 192));
		btnLCadastrar.setBounds(333, 227, 91, 23);
		panel.add(btnLCadastrar);
		
		VerificaLogin login = new VerificaLogin(tfLUsuario, tfLSenha, this);
		btnLEntrar.addActionListener(login);
		btnLCadastrar.addActionListener(login);
	}
}
