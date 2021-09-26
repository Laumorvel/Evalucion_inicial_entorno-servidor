package body;

import java.time.LocalDate;

public class PeluqueroCanino extends ATrabajador {

	final double SUPLEMENTO_PELUQ = 300;

	public PeluqueroCanino(String nombre, String dni, String direccion, LocalDate fechaNacimiento, String tlf,
			String horario) {
		super(nombre, dni, direccion, fechaNacimiento, tlf, horario);
		this.salario = getSalario();
	}

	@Override
	public double getSalario() {
		return SALARIO_BASE + SUPLEMENTO_PELUQ;
	}

}
