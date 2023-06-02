package model;

public class Usuarios {
	private String usuario;
	private String senha;
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return usuario + ";" + senha + "\r\n";
	}
}
