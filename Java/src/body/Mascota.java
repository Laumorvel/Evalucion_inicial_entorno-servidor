package body;

import enumerado.EEspecie;
import exception.NoCorrespondeConEspecieException;

public class Mascota {

	String pasaporteMascota;
	String nombre;
	int edad;
	EEspecie tipo;

	/**
	 * 
	 * @param pasaporteMascota
	 * @param nombre
	 * @param edad
	 * 
	 * @param especie          --> Se introduce la especie como String para evitar
	 *                         problemas, no como enumerado EEspecie.
	 * @throws NoCorrespondeConEspecieException --> Se ha creado esta excepción para
	 *                                          que salte en caso de que la especie
	 *                                          no corresponda con las especies
	 *                                          registradas en el enumerado que se
	 *                                          corresponden con las especies que
	 *                                          trata la clínica.
	 */
	public Mascota(String pasaporteMascota, String nombre, int edad, Cliente cliente, String especie)
			throws NoCorrespondeConEspecieException {
		this.pasaporteMascota = pasaporteMascota;
		this.nombre = nombre;
		this.edad = edad;

		try {
			this.tipo = EEspecie.valueOf(especie);
		} catch (Exception e) {
			throw new NoCorrespondeConEspecieException();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pasaporteMascota == null) ? 0 : pasaporteMascota.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Mascota))
			return false;
		Mascota other = (Mascota) obj;
		if (pasaporteMascota == null) {
			if (other.pasaporteMascota != null)
				return false;
		} else if (!pasaporteMascota.equals(other.pasaporteMascota))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mascota [pasaporteMascota=" + pasaporteMascota + ", nombre=" + nombre + ", edad=" + edad + "]";
	}

	public String getPasaporteMascota() {
		return pasaporteMascota;
	}

	public void setPasaporteMascota(String pasaporteMascota) {
		this.pasaporteMascota = pasaporteMascota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public EEspecie getTipo() {
		return tipo;
	}

	public void setTipo(EEspecie tipo) {
		this.tipo = tipo;
	}

}
