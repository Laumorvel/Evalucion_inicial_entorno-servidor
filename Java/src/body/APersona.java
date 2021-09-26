package body;

import java.time.LocalDate;

public abstract class APersona {

	String nombre;
	String dni;
	String direccion;
	LocalDate fechaNacimiento;
	String tlf;

	public APersona(String nombre, String dni, String direccion, LocalDate fechaNacimiento, String tlf) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.tlf = tlf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof APersona))
			return false;
		APersona other = (APersona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "APersona [nombre=" + nombre + ", dni=" + dni + ", direccion=" + direccion + ", fechaNacimiento="
				+ fechaNacimiento + ", tlf=" + tlf + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

}
