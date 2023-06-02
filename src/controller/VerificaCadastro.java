package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Usuarios;
import view.TelaLogin;

public class VerificaCadastro implements ActionListener {

	private JTextField usuario;
	private JTextField senha;
	private JTextField confirma;
	private JFrame frame;
	private Usuarios us;

	public VerificaCadastro(JTextField usuario, JTextField senha, JTextField tfCConfirmaSenha, JFrame frame) {
		super();
		this.usuario = usuario;
		this.senha = senha;
		this.confirma = tfCConfirmaSenha;
		this.frame = frame;
		us = new Usuarios();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			FazCadastro();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void FazCadastro() throws IOException {

		String path = System.getProperty("user.home") + File.separator + "SistemaTCC";
		File dir = new File(path);
		us.setSenha(senha.getText());
		us.setUsuario(usuario.getText());
		if (!dir.exists()) {
			dir.mkdir();
		}
		boolean status = true;
		File arqgrupos = new File(path, "BancoUsuarios.csv");
		boolean existe = false;

		if (!us.getUsuario().equals("") && !us.getSenha().equals("") && !confirma.getText().equals("")) {
			if (us.getSenha().equals(confirma.getText())) {
				if (arqgrupos.exists()) {
					existe = true;
				}

				if (!VerificaExistencia()) {
					FileWriter filewrite = new FileWriter(arqgrupos, existe);
					PrintWriter print = new PrintWriter(filewrite);
					print.write(us.toString());
					print.flush();
					print.close();
					filewrite.close();

					JOptionPane.showMessageDialog(null, "Usuarios " + us.getUsuario() + " Foi Registrado", "Sucesso!",
							JOptionPane.INFORMATION_MESSAGE);
					TelaLogin tl = new TelaLogin();
					tl.setVisible(true);
					frame.dispose();
					usuario.setText("");
					senha.setText("");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Senhas Diferentes", "Erro", JOptionPane.ERROR_MESSAGE);
				confirma.setText("");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Por favor, Preencha Todos os Campos", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
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
					TelaLogin tl = new TelaLogin();
					tl.setVisible(true);
					status = true;
					break;
				}
				linha = buffer.readLine();
			}
		}
		return status;
	}

}
