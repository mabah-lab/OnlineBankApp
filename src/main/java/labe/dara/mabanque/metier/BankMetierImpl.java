package labe.dara.mabanque.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import labe.dara.mabanque.dao.CompteRepository;
import labe.dara.mabanque.dao.OperationRepository;
import labe.dara.mabanque.entities.Compte;
import labe.dara.mabanque.entities.CompteCourant;
import labe.dara.mabanque.entities.Operation;
import labe.dara.mabanque.entities.Retrait;
import labe.dara.mabanque.entities.Versement;

@Service
@Transactional
public class BankMetierImpl implements IBankMetier {
	@Autowired
	private CompteRepository cpteRep;
	@Autowired
	OperationRepository opeRep;
	@Override
	public Compte consulterCompte(String codeCompte) {
		// TODO Auto-generated method stub
		Compte cp= cpteRep.findById(codeCompte).orElse(null);
		if(cp==null) throw new RuntimeException("Compte introuvable");
		return cp;
	}

	@Override
	public void retirer(String codeCompte, double montant) {
		// TODO Auto-generated method stub
		double disponibilite=0;
		Compte cp= consulterCompte( codeCompte);
		if(cp instanceof CompteCourant)
			disponibilite=((CompteCourant) cp).getDecouvert();
		if(cp.getSolde()+disponibilite<montant) 
			throw new RuntimeException("Solde insuffisant");
		Retrait r= new Retrait(new Date(), montant, cp);
		opeRep.save(r);
		cp.setSolde(cp.getSolde()-montant);
		cpteRep.save(cp);
	}

	@Override
	public void verser(String codeCompte, double montant) {
		// TODO Auto-generated method stub
		Compte cp= consulterCompte(codeCompte);
		Versement v= new Versement(new Date(), montant, cp);
		opeRep.save(v);
		cp.setSolde(cp.getSolde()+montant);
		cpteRep.save(cp);	
	}

	@Override
	public void virer(String codeCompte1,String codeCompte2, double montant) {
		// TODO Auto-generated method stub
		if(codeCompte1.equals(codeCompte2))
			throw new RuntimeException("Virement sur le même compte non autorisé");
		retirer(codeCompte1, montant);
		verser(codeCompte2, montant);	
	}

	@Override
	public Page<Operation> listOperation(String codeCompte, int page, int size) {
		// TODO Auto-generated method stub
		return opeRep.listOperation(codeCompte, PageRequest.of(page, size));							
	}

	
}
