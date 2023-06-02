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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.VerificaCadastro;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField tfCUsuario;
	private JTextField tfCConfirmaSenha;
	private JTextField tfCSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
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
		
		JLabel lblCTitle = new JLabel("Faça seu Cadastro");
		lblCTitle.setFont(new Font("Arial", Font.BOLD, 18));
		lblCTitle.setBounds(133, 25, 167, 28);
		panel.add(lblCTitle);
		
		JLabel lbCUsuario = new JLabel("Usuário");
		lbCUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
		lbCUsuario.setBounds(104, 78, 75, 37);
		panel.add(lbCUsuario);
		
		tfCUsuario = new JTextField();
		tfCUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
		tfCUsuario.setBounds(182, 83, 175, 26);
		panel.add(tfCUsuario);
		
		tfCConfirmaSenha = new JTextField();
		tfCConfirmaSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		tfCConfirmaSenha.setBounds(182, 157, 175, 26);
		panel.add(tfCConfirmaSenha);
		
		tfCSenha = new JTextField();
		tfCSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		tfCSenha.setBounds(182, 120, 175, 26);
		panel.add(tfCSenha);
		
		JLabel lbCSenha = new JLabel("Senha");
		lbCSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		lbCSenha.setBounds(104, 115, 75, 37);
		panel.add(lbCSenha);
		
		JLabel lbCConfirmasenha = new JLabel("Confirme a Senha");
		lbCConfirmasenha.setFont(new Font("Arial", Font.PLAIN, 18));
		lbCConfirmasenha.setBounds(22, 153, 152, 37);
		panel.add(lbCConfirmasenha);
		
		JButton btnCConfirma = new JButton("Cadastrar-se");
		btnCConfirma.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCConfirma.setBackground(new Color(0, 0, 0));
		btnCConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCConfirma.setBounds(215, 200, 100, 37);
		panel.add(btnCConfirma);
		
		VerificaCadastro vc = new VerificaCadastro(tfCUsuario, tfCSenha, tfCConfirmaSenha, this);
		btnCConfirma.addActionListener(vc);
		
	}
}