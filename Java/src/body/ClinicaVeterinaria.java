package body;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClinicaVeterinaria {

	Set<ATrabajador> trabajadores;
	Set<Cliente> clientes;
	List<Cita> citas;

	public ClinicaVeterinaria() {
		this.trabajadores = new HashSet<ATrabajador>();
		this.clientes = new HashSet<Cliente>();
		this.citas = new ArrayList<Cita>();
	}

	public ClinicaVeterinaria(Set<ATrabajador> trabajadores, Set<Cliente> clientes, List<Cita> citas) {
		this.trabajadores = new HashSet<ATrabajador>();
		this.clientes = new HashSet<Cliente>();
		this.citas = new ArrayList<Cita>();
	}

	public void addTrabajadores(ATrabajador e) {
		this.trabajadores.add(e);
	}

	public void addClientes(Cliente e) {
		this.clientes.add(e);
	}

	public void addCitas(Cita e) {
		this.citas.add(e);
	}

	public Set<ATrabajador> getTrabajadores() {
		return trabajadores;
	}

	public void setTrabajadores(Set<ATrabajador> trabajadores) {
		this.trabajadores = trabajadores;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	@Override
	public String toString() {
		return "ClinicaVeterinaria [trabajadores=" + trabajadores + "\n, clientes=" + clientes + "\n, citas=" + citas
				+ "]";
	}

}
