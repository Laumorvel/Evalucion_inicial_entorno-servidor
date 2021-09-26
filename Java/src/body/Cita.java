package body;

import java.time.LocalDateTime;

public class Cita {

	Cliente cliente;
	ATrabajador trabajador;
	LocalDateTime appointment;

	public Cita(Cliente cliente, ATrabajador trabajador, LocalDateTime appointment) {
		this.cliente = cliente;
		this.trabajador = trabajador;
		this.appointment = appointment;
	}

	/**
	 * he usado al trabajador y la hora-día de la cita para diferenciar las citas
	 * entre sí porque puede haber 2 citas a la misma hora pero no con el mismo
	 * trabajador
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appointment == null) ? 0 : appointment.hashCode());
		result = prime * result + ((trabajador == null) ? 0 : trabajador.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cita))
			return false;
		Cita other = (Cita) obj;
		if (appointment == null) {
			if (other.appointment != null)
				return false;
		} else if (!appointment.equals(other.appointment))
			return false;
		if (trabajador == null) {
			if (other.trabajador != null)
				return false;
		} else if (!trabajador.equals(other.trabajador))
			return false;
		return true;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ATrabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(ATrabajador trabajador) {
		this.trabajador = trabajador;
	}

	public LocalDateTime getAppointment() {
		return appointment;
	}

	public void setAppointment(LocalDateTime appointment) {
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "Cita [cliente=" + cliente.nombre + ", trabajador=" + trabajador.nombre + ", appointment=" + appointment + "]";
	}

}
