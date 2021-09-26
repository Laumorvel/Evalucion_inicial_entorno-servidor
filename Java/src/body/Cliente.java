package body;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Cliente extends APersona {

	// Se añade aquí la lista mascotas porque el cliente puede terner +1 mascota
	// aunque en la mayoría de los casos la lista estará compuesta por 1 elemento
	// porque lo habitual es tener solo una mascota.

	// No se ha hecho al revés (añadir Cliente en la clase Mascota) porque en la
	// clase ClínicaVeterinaria se añadirán clientes a su lista de clientes. Habrá,
	// por tanto, clientes con sus mascotas asociadas y no una lista de mascotas con
	// sus dueños asociados, lo cual no sería lo lógico.

	// Tampoco he añadido equal y hashcode porque se diferenciarán por el dni de la
	// clase padre
	Set<Mascota> mascotas;

	public Cliente(String nombre, String dni, String direccion, LocalDate fechaNacimiento, String tlf) {
		super(nombre, dni, direccion, fechaNacimiento, tlf);
		this.mascotas = new HashSet<Mascota>();// no se repetirán mascotas (se diferencian por su pasaporte animal)
	}

	@Override
	public String toString() {
		return super.toString() + "Cliente [mascotas=" + mascotas + "]";
	}

	public Set<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(Set<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public void addMascota(Mascota mascota) {
		this.mascotas.add(mascota);
	}

}
