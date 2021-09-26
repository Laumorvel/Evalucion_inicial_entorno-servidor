package body;

import java.time.LocalDate;

import interfaz.IPagable;

public abstract class ATrabajador extends APersona implements IPagable {

	// hashCode e Equal --> los diferencio por el dni de la clase APersona de la que
	// extiende

	String horario;
	double salario;

	public ATrabajador(String nombre, String dni, String direccion, LocalDate fechaNacimiento, String tlf,
			String horario) {
		super(nombre, dni, direccion, fechaNacimiento, tlf);
		this.horario = horario;
	}

	@Override
	public String toString() {
		return super.toString() + "ATrabajador [horario=" + horario + ", salario=" + salario + "]";
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public double getSueldo() {
		return salario;
	}

	public void setSueldo(double sueldo) {
		this.salario = sueldo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
