package labe.dara.mabanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import labe.dara.mabanque.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String>{
	

}
