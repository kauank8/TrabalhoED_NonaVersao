package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Grupos;

public class ConsultaCodigoController implements ActionListener {
	private JTextField codigo;
	private JTextArea ta;
	private Grupos gp;

	public ConsultaCodigoController(JTextField codigo,JTextArea ta) {
		super();
		this.codigo = codigo;
		this.ta = ta;
		gp = new Grupos();
	}
	
	//Ação Do botão
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			ta.setText("");
			LerArq();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void LerArq() throws IOException {
		String path = System.getProperty("user.home") + File.separator + "SistemaTCC";
		File dir = new File(path);
		gp.setCodigo(codigo.getText());
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
			String txt="";
			String aux="";
			while (linha != null) {
				String vtlinha[] = linha.split(";");
				if (gp.getCodigo().equals(vtlinha[0])) {
					int tamanho = vtlinha.length;
					aux = vtlinha[0] + " || " + vtlinha[1] + " || " + vtlinha[2] + "\n" + "Integrantes || Ra\n";
					for (int i = 3; i < tamanho; i++) {
						txt += vtlinha[i] + " " + vtlinha[i + 1] +"\n";
						i++;
					}
					status=true;
					break;
				}
				linha=buffer.readLine();
				status=false;
			}
			if(!status) {
				JOptionPane.showMessageDialog(null, "Codigo Inexistente", "Erro",
						JOptionPane.ERROR_MESSAGE);
				codigo.setText("");
			}
			String txtpronto = aux + txt;
			ta.setText(txtpronto);
			codigo.setText("");
		}
		
	}
}