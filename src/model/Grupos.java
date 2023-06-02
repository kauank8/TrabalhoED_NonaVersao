package model;

public class Grupos {
	
	private String area;
	private String codigo;
	private String tema;
	private String ra;

	//get e set
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}

	//
	@Override
	public String toString() {
		return  codigo + ";" + codigo + ", tema=" + tema + "]";
	}
}
