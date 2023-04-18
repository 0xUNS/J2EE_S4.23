package com.example.jpaap.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity     // Entity JPA
@Data   // Getters Setters
@NoArgsConstructor  // Constructeur sans parametre
@AllArgsConstructor     // Constructeur avec parametre
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50)
	private String nom;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private boolean malade;
	private int score;

	@Override
	public String toString() {
		return "+--------------- Id: "+ id +" ---------------+" +
				"\n Nom: " + nom  +
				"\n Date Naissance: " + dateNaissance +
				"\n Score: " + score +
				(malade ? ",  est" : ",  n'est pas") + " malade";
	}
}
