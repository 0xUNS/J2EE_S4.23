package com.example.jpaap.repositories;

import com.example.jpaap.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	List<Patient> findByMalade(boolean b);

	Page<Patient> findByMalade(boolean b, Pageable pageable);

	//	List<Patient> findByMaladeAndScoreLessThan(boolean b, int i);
	Page<Patient> findByMaladeIsTrueAndScoreLessThan(int i, Pageable pageable);

	@Query("select p from Patient p where p.nom like :x")
	List<Patient> chercherPatients(@Param("x") String s);

}
