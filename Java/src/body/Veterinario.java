package body;

import java.time.LocalDate;

public class Veterinario extends ATrabajador {

	// ¿Tengo que añadirle el toString para que imprima el sueldo con el suplemento
	// o se va a añadir teniendo ese método?

	final double SUPLEMENTO_VET = 1000;

	public Veterinario(String nombre, String dni, String direccion, LocalDate fechaNacimiento, String tlf,
			String horario) {
		super(nombre, dni, direccion, fechaNacimiento, tlf, horario);
		this.salario = getSalario();
	}

	@Override
	public double getSalario() {
		return SALARIO_BASE + SUPLEMENTO_VET;
	}


}
