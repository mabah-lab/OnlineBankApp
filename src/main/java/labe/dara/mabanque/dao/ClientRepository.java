package labe.dara.mabanque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import labe.dara.mabanque.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
