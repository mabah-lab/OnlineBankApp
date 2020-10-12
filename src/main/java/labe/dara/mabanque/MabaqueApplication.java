package labe.dara.mabanque;

import java.util.Date;


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
	private ClientRepository cltrRep;
	@Autowired
	private CompteRepository cpteRep;
	@Autowired
	private OperationRepository opeRep;
	@Autowired
	private IBankMetier bankrep;
	public static void main(String[] args) {
		SpringApplication.run(MabaqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * Client c1=cltrRep.save(new Client("BAH","Mamadou",new Date(),"Bruxelles"));
		 * Client c2=cltrRep.save(new Client("SY","Tanou",new Date(),"Dakar"));
		 * 
		 * Compte cp1= cpteRep.save(new CompteCourant("C1", new Date(), 1000, c1, 250));
		 * Compte cp2= cpteRep.save(new CompteEpargne("C2", new Date(), 8000, c1, 2.5));
		 * Compte cp3= cpteRep.save(new CompteEpargne("C3", new Date(), 4000, c2, 3.5));
		 * Compte cp4= cpteRep.save(new CompteCourant("C4", new Date(), 4000, c2, 0));
		 * 
		 * 
		 * Operation op1= opeRep.save(new Retrait(new Date(),500,cp2)); Operation op2=
		 * opeRep.save(new Versement(new Date(),500,cp1));
		 * 
		 * 
		 * bankrep.verser("C4", 3500); bankrep.verser("C1", 200); bankrep.verser("C2",
		 * 60); bankrep.verser("C3", 95); bankrep.retirer("C2", 50.0);
		 * bankrep.retirer("C1", 20.0); bankrep.retirer("C3", 15.0);
		 * bankrep.retirer("C4", 34.0); bankrep.virer("C3", "C1", 150);
		 */
		

	}

}
