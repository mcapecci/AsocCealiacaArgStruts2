package clasesDelSistema;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Pago {
	
	@Id @GeneratedValue
	private Long id;
	private Date periodo;
	private float importe;
	private Date fechaPago;	
	@ManyToOne(optional=false)@JoinColumn(name="socioId")
	private Socio socio;
	 
	/* Constructor sin argumentos */	

	public Pago() {
		super();
	}
		 
	/* Metodos Getters y Setters */
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
 
	
	public Date getFechaPago() {
		return fechaPago;
	}
	
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	
		
	public float getImporte() {
		return importe;
	}
	
	public void setImporte(float importe) {
		this.importe = importe;
	}
	
	
	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Date getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Date periodo) {
		this.periodo = periodo;
	}
 
}
