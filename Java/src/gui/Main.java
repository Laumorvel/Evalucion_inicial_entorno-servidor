package gui;

import body.APersona;
import body.ATrabajador;
import body.Cita;
import body.Cliente;
import body.ClinicaVeterinaria;
import body.Mascota;
import body.PeluqueroCanino;
import body.Veterinario;
import exception.NoCorrespondeConEspecieException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {

	public static void main(String[] args) {
		APersona vet1 = new Veterinario("Pepe Villanueva León", "30256987L", "Calle Bonita, 23",
				LocalDate.of(1999, 10, 30), "689758425", "L - V (8:00 - 15:00)");

		ATrabajador pelu1 = new PeluqueroCanino("Loli Montes Salero", "58415789K", "Calle Preciosa, 7",
				LocalDate.of(1992, 12, 02), "689568956", "L - S (8:00 - 15:00)");

		Cliente cliente1 = new Cliente("Javier Tomares", "541258965L", "Calle Artesanos, 41", LocalDate.of(1999, 03, 12),
				"658985698");

		Mascota boby = null;
		try {
			boby = new Mascota("7845f", "Boby", 3, cliente1, "PERRO");
		} catch (NoCorrespondeConEspecieException e) {
			System.out.println(e.getMessage());
		}
		cliente1.addMascota(boby);
		
		ATrabajador vet2 = new Veterinario("Pepe Villanueva León", "30256987L", "Calle Bonita, 23",
				LocalDate.of(1999, 10, 30), "689758425", "L - V (8:00 - 15:00)");

		Cita cita1 = new Cita(cliente1, vet2, LocalDateTime.of(LocalDate.of(2021, 04, 12), LocalTime.of(9, 30)));
		
		ClinicaVeterinaria clinicaMoreno = new ClinicaVeterinaria();
		clinicaMoreno.addCitas(cita1);
		clinicaMoreno.addClientes(cliente1);
		clinicaMoreno.addTrabajadores(vet2);
		clinicaMoreno.addTrabajadores(pelu1);
		
		System.out.println(clinicaMoreno);
//		System.out.println(vet1);
//		System.out.println(boby);
//		System.out.println(cliente1);
	}

}
