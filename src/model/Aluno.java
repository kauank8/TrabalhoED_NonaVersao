package model;

public class Aluno {

	private String nome;
	private String RA;
	
	@Override
	public String toString() {
		return  nome + ";" + RA+"\r\n";
	}

	
	//Get e set
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRA() {
		return RA;
	}

	public void setRA(String rA) {
		RA = rA;
	}
	
}
