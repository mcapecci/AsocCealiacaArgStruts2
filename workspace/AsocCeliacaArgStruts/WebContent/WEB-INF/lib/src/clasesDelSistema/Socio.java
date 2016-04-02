package clasesDelSistema;

import java.util.List;
import java.util.Date;

import javax.persistence.*;

@Entity @DiscriminatorValue("socio")
public abstract class Socio extends Usuario {
	
	private String dni;
	private String ocupacion;
	private Date fechaIngreso;
	private Date fechaNacimiento;
	private Date fechaDiagnostico;
	private String presentadoPor;
	@OneToMany(mappedBy="socio", cascade = CascadeType.ALL)
	private List<Pago> pagos;
	
	
	/* Constructor sin argumentos */

	public Socio() {
		super();
	}
	
	/* Metodos Getters y Setters */
	
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Date getFechaDiagnostico() {
		return fechaDiagnostico;
	}
	public void setFechaDiagnostico(Date fechaDiagnostico) {
		this.fechaDiagnostico = fechaDiagnostico;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}
	public List<Pago> getPagos() {
		return pagos;
	}
	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public String getPresentadoPor() {
		return presentadoPor;
	}

	public void setPresentadoPor(String presentadoPor) {
		this.presentadoPor = presentadoPor;
	}
	
	
}
