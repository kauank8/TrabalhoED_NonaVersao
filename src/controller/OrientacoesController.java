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

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OrientacoesController implements ActionListener {
	private JTextArea ta;
	private JTextField codigo;

	public OrientacoesController(JTextArea ta, JTextField codigo) {
		this.ta = ta;
		this.codigo = codigo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			boolean status = LeraqrGp();
			InsereOrientacao(status);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private boolean LeraqrGp() throws IOException {
		String path = System.getProperty("user.home") + File.separator + "SistemaTCC";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		boolean status = true;
		File arqgrupos = new File(path, "BancoGrupos.csv");
		if (arqgrupos.exists() && arqgrupos.isFile()) {
			FileInputStream fluxo = new FileInputStream(arqgrupos);
			InputStreamReader leitorfluxo = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitorfluxo);
			String linha = buffer.readLine();
			while (linha != null) {
				String vtlinha[] = linha.split(";");
				if (codigo.getText().equals(vtlinha[0])) {
					status = false;
					break;
				}
				linha = buffer.readLine();
			}
		}
		return status;
	}

	private void InsereOrientacao(boolean status) throws IOException {
		
		if (!status && !ta.getText().equals("")) {

			String txt = codigo.getText() + ";" + ta.getText() + "\n";
			String path = System.getProperty("user.home") + File.separator + "SistemaTCC";
			File dir = new File(path);
			if (!dir.exists()) {
				dir.mkdir();
			}
			File arq = new File(path, "BancoOrientacoes.csv");
			boolean existe = false;

			if (arq.exists()) {
				existe = true;
			}
				FileWriter filewrite = new FileWriter(arq, existe);
				PrintWriter print = new PrintWriter(filewrite);
				print.write(txt);
				print.flush();
				print.close();
				filewrite.close();
				JOptionPane.showMessageDialog(null, "A orientação Foi Registrada", "Sucesso!",
						JOptionPane.INFORMATION_MESSAGE);
				ta.setText("");
				codigo.setText("");
			} 
		else {

			JOptionPane.showMessageDialog(null, "Codigo Invalido ou Orientação em branco", "Erro",
					JOptionPane.ERROR_MESSAGE);
			codigo.setText("");
		}
	}

	
}
