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

import br.com.KauanPaulino.ListaObject.Lista_Object;
import model.Aluno;
import model.Grupos;

public class GruposController implements ActionListener {
	private JTextField ra;
	private JTextField area;
	private JTextField tema;
	private JTextField codigo;
	private Lista_Object lista;
	private Grupos gp;
	private JTextArea textArea;

	public GruposController(JTextField ra, JTextField area, JTextField tema, JTextField codigo, JTextArea textArea) {
		super();
		this.ra = ra;
		this.area = area;
		this.tema = tema;
		this.codigo = codigo;
		lista = new Lista_Object();
		gp = new Grupos();
		this.textArea=textArea;
	}

	// construtor

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Gravar Grupo")) {
			try {
				GravarGrupos();
				LimpaLista();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (cmd.equals("Adicionar Aluno ao Grupo")) {
			String ra;
			try {
				ra = ColetaRa();
				ExisteAluno(ra);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("Limpar Lista")) {
			try {
				LimpaLista();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	//---------------------------------------------------------------------->
	// Comeca Gravar Grupo
	private void GravarGrupos() throws Exception {
		if(lista.isEmpty()==false) {
		gp.setArea(JOptionPane.showInputDialog("Digite a area do grupo"));
		gp.setTema(JOptionPane.showInputDialog("Digite o tema do grupo"));
		gp.setCodigo(JOptionPane.showInputDialog("Digite o codigo do grupo"));

		boolean status = VerificaArquivoGrupos();

		if (gp.getArea().equals("") || gp.getCodigo().equals("") || gp.getTema().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente", "Erro",
					JOptionPane.ERROR_MESSAGE);
		} else if (status) {
			GravaGruposArq();
			JOptionPane.showMessageDialog(null, "O Grupo " + gp.getCodigo() + " Foi Registrado", "Sucesso!",
					JOptionPane.INFORMATION_MESSAGE);
			

		}
		}else {
			JOptionPane.showMessageDialog(null, "Lista Vazia", "Erro",
					JOptionPane.ERROR_MESSAGE);
			
		}

	}
	
	//---------------------------------------------------------------------->
	//Grava grupos em um arquivo  se o limite de tamanho de grupo for respeitado
	private void GravaGruposArq() throws Exception {
		int tamanho = lista.size();

		if (tamanho > 0 && tamanho <= 4) {
			String path = System.getProperty("user.home") + File.separator + "SistemaTCC";
			File dir = new File(path);
			if (!dir.exists()) {
				dir.mkdir();
			}
			File arqGp = new File(path, "BancoGrupos.csv");
			boolean existe = false;

			if (arqGp.exists()) {
				existe = true;
			}
			String txt = gp.getCodigo() + ";" + gp.getArea() + ";" + gp.getTema();
			// Gera String
			for (int i = 0; i < tamanho; i++) {
				Aluno aluno = new Aluno();
				aluno = (Aluno) lista.get(i);
				txt += ";" + aluno.getNome() + ";" + aluno.getRA();
			}
			txt += "\r\n";
			FileWriter filewrite = new FileWriter(arqGp, existe);
			PrintWriter print = new PrintWriter(filewrite);
			print.write(txt);
			print.flush();
			print.close();
			filewrite.close();

		} else {
			JOptionPane.showMessageDialog(null, "Grupo Invalido", "Erro", JOptionPane.ERROR_MESSAGE);
		}

	}

	//---------------------------------------------------------------------->
	// Verifica O arquivos grupos
	private boolean VerificaArquivoGrupos() throws IOException {
		boolean status;
		do {
			status = LeraqrGp();
			if (!status) {
				JOptionPane.showMessageDialog(null, "Codigo Invalido", "Erro", JOptionPane.ERROR_MESSAGE);
				gp.setCodigo(JOptionPane.showInputDialog("Digite o codigo novamente"));
				status = LeraqrGp();
			}
		} while (status != true);
		return status;
	}

	//------------------------------------------------------------------->
	//Ler O arquivo e verifica se o codigo ja existe
	
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
				if (gp.getCodigo().equals(vtlinha[0])) {
					status = false;
					break;
				}
				linha = buffer.readLine();
			}
		}
		return status;
	}
	
	//----------------------------------------------------------------->
	// Limpa Lista para proxima gravação
	private void LimpaLista() throws Exception {
		int tamanho = lista.size();
		for (int i = 0; i < tamanho; i++) {
			lista.remove(0);
		}
		JOptionPane.showMessageDialog(null, "A Lista De Alunos Foi limpa", "Limpar",
		JOptionPane.INFORMATION_MESSAGE);
		textArea.setText("");
		
	}
	
	//----------------------------------------------------------------->
	// Coleta Ra
	private String ColetaRa() throws IOException {
		Grupos gp = new Grupos();
		gp.setRa(ra.getText());
		return gp.getRa();
	}

	//----------------------------------------------------------------------->
	// Verifica Existencia do Aluno
	private boolean ExisteAluno(String Ra) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "SistemaTCC";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}

		File arqAlunos = new File(path, "BancoAlunos.csv");
		boolean status = false;
		if (arqAlunos.exists() && arqAlunos.isFile()) {
			FileInputStream fluxo = new FileInputStream(arqAlunos);
			InputStreamReader leitorfluxo = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitorfluxo);
			String linha = buffer.readLine();
			while (linha != null) {
				String vtlinha[] = linha.split(";");
				Aluno aluno = new Aluno();
				aluno.setNome(vtlinha[0]);
				aluno.setRA(vtlinha[1]);
				if (aluno.getRA().equals(Ra)) {
					AdicionarAluno(aluno);
					status = true;
					break;
				}
				linha = buffer.readLine();
			}
		}
		if (!status) {
			JOptionPane.showMessageDialog(null, "Ra Inexistente, Por favor Digite Novamenete", "Erro",
					JOptionPane.ERROR_MESSAGE);
			ra.setText("");
		}
		return status;
	}
	
	//------------------------------------------------>
	// Adiciona Aluno Grupos
	private void AdicionarAluno(Aluno aluno) {
		int tamanho = lista.size();
		if (tamanho < 4) {
			if (lista.isEmpty()) {
				lista.addFirst(aluno);
			} else {
				try {
					lista.addLast(aluno);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			JOptionPane.showMessageDialog(null, "Aluno(a) " + aluno.getNome() + " Foi Registrado no Grupo", "Sucesso!",
					JOptionPane.INFORMATION_MESSAGE);
			textArea.append(aluno.toString());
			ra.setText("");
		} else {
			JOptionPane.showMessageDialog(null, "O aluno não foi adicionado, Pois o grupo esta cheio", "Erro",
					JOptionPane.ERROR_MESSAGE);
			ra.setText("");
		}
	}

}
