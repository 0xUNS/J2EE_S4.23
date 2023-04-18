package com.example.jpaap;

import com.example.jpaap.entities.Patient;
import com.example.jpaap.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaApApplication implements CommandLineRunner {
	@Autowired
	private PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(JpaApApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println( " .d8888b.           888     888\nd88    88b          888     888      2023\n888    888          888     888\n888    888 888  888 888     888 88888b.  .d88888\n888    888  88..88  888     888 888 \"88b 880\n888    888   X88X   888     888 888  888 '88888b.\nY88    88P  d8''8b  '88.   .88' 888  888      888\n 'Y8888P'  888  888   '88888'   888  888  88888P\n");

		SimpleDateFormat simpleFormatter=new SimpleDateFormat("dd/MM/yyyy");
		patientRepository.save(new Patient(null, "Mohamed",simpleFormatter.parse("12/12/2005"), true, 56));
		patientRepository.save(new Patient(null, "Walid", simpleFormatter.parse("12/12/2012"), false, 94));
		patientRepository.save(new Patient(null, "Younes", simpleFormatter.parse("12/12/2006"), true, 30));
		patientRepository.save( new Patient(null, "Youssfi", simpleFormatter.parse("12/12/1974"), false, 91));
		for (int i=1; i<100 ; i++)
			patientRepository.save(new Patient(null, "Patient_"+i,new Date(), Math.random()<0.5, (int) (Math.random()*100)));

		Page<Patient> patients = patientRepository.findAll(PageRequest.of(0, 5));
		System.out.println(" - - - - - - - - - - - - - - - - ");
		System.out.println("Total Elements: " + patients.getTotalElements() + "Total Pages: " + patients.getTotalPages() + "Page Number: " + patients.getNumber());


		Page<Patient> byMalade = patientRepository.findByMalade(true, PageRequest.of(0,5));
		Page<Patient> byMaladeIsTrueAndScoreLessThan50 = patientRepository.findByMaladeIsTrueAndScoreLessThan(50, PageRequest.of(0,5));
		List<Patient> content = byMaladeIsTrueAndScoreLessThan50.getContent();

		content.forEach(System.out::println);

		System.out.println("===== Patients : nom commence par 'You' =====");
		List<Patient> patientList = patientRepository.chercherPatients("You%");
		patientList.forEach(System.out::println);

		System.out.println("===== Patient : Id = 4 =====");
		Patient patient = patientRepository.findById(4L).orElse(null);
		if (patient != null )
			System.out.println("Le patient " + patient.getNom() + (patient.isMalade() ? " est" : " n'est pas") + " malade.");

//		patient.setScore(84);
//		patientRepository.save(patient);
//		patientRepository.deleteById(2L);


	}
}
