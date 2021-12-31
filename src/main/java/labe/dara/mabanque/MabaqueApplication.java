package labe.dara.mabanque;

import java.util.Date;


import labe.dara.mabanque.metier.IBankInitialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import labe.dara.mabanque.dao.ClientRepository;
import labe.dara.mabanque.dao.CompteRepository;
import labe.dara.mabanque.dao.OperationRepository;
import labe.dara.mabanque.entities.Client;
import labe.dara.mabanque.entities.Compte;
import labe.dara.mabanque.entities.CompteCourant;
import labe.dara.mabanque.entities.CompteEpargne;
import labe.dara.mabanque.entities.Operation;
import labe.dara.mabanque.entities.Retrait;
import labe.dara.mabanque.entities.Versement;
import labe.dara.mabanque.metier.IBankMetier;

@SpringBootApplication
public class MabaqueApplication  implements CommandLineRunner {
	@Autowired
	private IBankInitialize iBankInitialize;
	public static void main(String[] args) {
		SpringApplication.run(MabaqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		iBankInitialize.initUsersProfils();
		iBankInitialize.initBankData();


	}

}
