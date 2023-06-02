package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Usuarios;
import view.TelaCadastro;
import view.TelaPrincipal;

public class VerificaLogin implements ActionListener {
	private JTextField usuario;
	private JTextField senha;
	private Usuarios us;
	private JFrame frame1;

	public VerificaLogin(JTextField usuario, JTextField senha, JFrame frame) {
		super();
		this.usuario = usuario;
		this.senha = senha;
		us = new Usuarios();
		frame1 = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Entrar")) {
			try {
				FazLogin();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (cmd.equals("Cadastro")) {
			try {
				FazCadastro();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public VerificaLogin(JTextField usuario, JTextField senha, Usuarios us) {
		super();
		this.usuario = usuario;
		this.senha = senha;
		this.us = us;
	}

	private void FazCadastro() throws IOException {
		TelaCadastro frame2 = new TelaCadastro();
		frame2.setVisible(true);
		frame1.dispose();
	}

	private boolean VerificaExistencia() throws IOException {
		String path = System.getProperty("user.home") + File.separator + "SistemaTCC";
		File dir = new File(path);
		us.setSenha(senha.getText());
		us.setUsuario(usuario.getText());
		if (!dir.exists()) {
			dir.mkdir();
		}
		boolean status = false;
		File arqgrupos = new File(path, "BancoUsuarios.csv");
		if (arqgrupos.exists() && arqgrupos.isFile()) {
			FileInputStream fluxo = new FileInputStream(arqgrupos);
			InputStreamReader leitorfluxo = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitorfluxo);
			String linha = buffer.readLine();
			while (linha != null) {
				String vtlinha[] = linha.split(";");
				if (usuario.getText().equals(vtlinha[0]) || senha.getText().equals(vtlinha[1])) {
					JOptionPane.showMessageDialog(null, "Usuario ou senha já existentes", "ERRO",
							JOptionPane.WARNING_MESSAGE);
					status = true;
					break;
				}
				linha = buffer.readLine();
			}
		}
		return status;
	}

	private void FazLogin() throws IOException {
		String path = System.getProperty("user.home") + File.separator + "SistemaTCC";
		File dir = new File(path);
		us.setSenha(senha.getText());
		us.setUsuario(usuario.getText());
		if (!dir.exists()) {
			dir.mkdir();
		}
		boolean status = true;
		File arqgrupos = new File(path, "BancoUsuarios.csv");
		if (!us.getUsuario().equals("") || !us.getSenha().equals("")) {
			if (arqgrupos.exists() && arqgrupos.isFile()) {
				FileInputStream fluxo = new FileInputStream(arqgrupos);
				InputStreamReader leitorfluxo = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitorfluxo);
				String linha = buffer.readLine();
				while (linha != null) {
					String vtlinha[] = linha.split(";");
					if (usuario.getText().equals(vtlinha[0]) && senha.getText().equals(vtlinha[1])) {
						JOptionPane.showMessageDialog(null,
								"Seja Bem Vindo " + us.getUsuario() + " ao Sistema de Controle de TCC", "Bem Vindo",
								JOptionPane.INFORMATION_MESSAGE);
						TelaPrincipal frame = new TelaPrincipal();
						frame.setVisible(true);
						frame1.dispose();
						status = true;
						break;
					}
					linha = buffer.readLine();
					status = false;
				}
				if (!status) {
					JOptionPane.showMessageDialog(null, "Usuario ou Senha Incorretos", "Erro",
							JOptionPane.ERROR_MESSAGE);
					usuario.setText("");
					senha.setText("");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Usuario ou Senha Incorretos", "Erro",
						JOptionPane.ERROR_MESSAGE);
				usuario.setText("");
				senha.setText("");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Por favor, Preencha Todos os Campos", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

	}
}