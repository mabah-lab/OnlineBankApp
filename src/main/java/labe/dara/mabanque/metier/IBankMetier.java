package labe.dara.mabanque.metier;

import org.springframework.data.domain.Page;

import labe.dara.mabanque.entities.Compte;
import labe.dara.mabanque.entities.Operation;

public interface IBankMetier {
	
	public Compte consulterCompte(String codeCompte);
	public void retirer(String codeCompte, double montant);
	public void verser(String codeCompte, double montant);
	public void virer(String codeCompte1, String codeCompte2, double montant);
	public Page<Operation> listOperation (String codeCompte, int page, int size);



}
