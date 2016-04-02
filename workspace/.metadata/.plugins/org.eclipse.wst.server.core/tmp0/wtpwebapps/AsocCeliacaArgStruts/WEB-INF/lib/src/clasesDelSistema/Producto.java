package clasesDelSistema;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Producto extends Elemento {
	
	private String rnpa;
	private String empresa;
	private String rne;
	private Date fecha;
	private Date fechaCertLdg;
	private String comentario;
	
	
	/* Constructor sin argumentos */	

	public Producto() {
		super();
	}

	/* Metodos Getters y Setters */
	
	public Date getFechaCertLdg() {
		return fechaCertLdg;
	}
	
	public void setFechaCertLdg(Date fechaCertLdg) {
		this.fechaCertLdg = fechaCertLdg;
	}
	
	public String getRnpa() {
		return rnpa;
	}
	
	public void setRnpa(String rnpa) {
		this.rnpa = rnpa;
	}
	
	public String getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	public String getRne() {
		return rne;
	}
	
	public void setRne(String rne) {
		this.rne = rne;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
}
