package com.example.hospital;

import com.example.hospital.entities.*;
import com.example.hospital.repositories.MedecinRepository;
import com.example.hospital.repositories.PatientRepository;
import com.example.hospital.repositories.RendezVousRepository;
import com.example.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Bean
	CommandLineRunner start(IHospitalService hospitalService,
	                        PatientRepository patientRepository,
	                        MedecinRepository medecinRepository,
	                        RendezVousRepository rendezVousRepository) {
		return args -> {
			System.out.println( " .d8888b.           888     888\nd88    88b          888     888      2023\n888    888          888     888\n888    888 888  888 888     888 88888b.  .d88888\n888    888  88..88  888     888 888 \"88b 880\n888    888   X88X   888     888 888  888 '88888b.\nY88    88P  d8''8b  '88.   .88' 888  888      888\n 'Y8888P'  888  888   '88888'   888  888  88888P\n");

			Stream.of("Houssam", "Amine", "Marwa", "Ayman", "Ghita")
							.forEach(name -> {
								hospitalService.savePatient(new Patient(null, name, new Date(), false, null));
							});
			Stream.of("Ahmed", "Ihssane", "Leila", "Sara", "Said")
					.forEach(name -> {
						hospitalService.saveMedecin(new Medecin(null, name, name+"@gmail.com", "Generaliste", null));
					});
			Patient patient = patientRepository.findById(1L).orElse(null);
			Patient patient1 = patientRepository.findByNom("Marwa");
			Medecin medecin = medecinRepository.findByNom("Said");
			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(statusRDV.PENDING);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient);
			RendezVous savedRDV = hospitalService.saveRendezVous(rendezVous);
			System.out.println("Id: " + savedRDV.getId());

			RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);
			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Rapport de la consultation ... blah blah ...");
			hospitalService.saveConsultation(consultation);


		};
	}
}
