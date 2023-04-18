package com.example.patientsmvc;

import com.example.patientsmvc.entities.Patient;
import com.example.patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientsMvcApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PatientRepository patientRepository){
		return args -> {
			System.out.println( " .d8888b.           888     888\nd88    88b          888     888      2023\n888    888          888     888\n888    888 888  888 888     888 88888b.  .d88888\n888    888  88..88  888     888 888 \"88b 880\n888    888   X88X   888     888 888  888 '88888b.\nY88    88P  d8''8b  '88.   .88' 888  888      888\n 'Y8888P'  888  888   '88888'   888  888  88888P\n");

			patientRepository.save(new Patient(null, "Samir", new Date(), false, 75));
			patientRepository.save(new Patient(null, "Yassine", new Date(), false, 53));

			for(int i=0; i<5; i++)
				patientRepository.save(new Patient(null, "user_"+i, new Date(), false, (int) (Math.random()*100)));

//			patientRepository.findAll().forEach(patient -> {
//				System.out.println(patient.getNom() + " : " + patient.getScore());
//			});
		};
	}

}
