package labe.dara.mabanque.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import labe.dara.mabanque.entities.Compte;
import labe.dara.mabanque.entities.Operation;
import labe.dara.mabanque.metier.IBankMetier;

@Controller
public class BankController {
	@Autowired
	private IBankMetier bankMetier;
	
	@RequestMapping("/operations")
	public String index() {
		return "comptes";
	}
	@RequestMapping("/consulterCompte")
	public String consulter(Model model, String numCompte) {
		model.addAttribute("numCompte",numCompte);
		try {
			Compte cp = bankMetier.consulterCompte(numCompte);
			Page<Operation> listOperations= bankMetier.listOperation(numCompte, 0, 4);
			model.addAttribute("listOperations", listOperations.getContent());
			model.addAttribute("compte", cp);
		} catch (Exception e) {
			model.addAttribute("exception",e);
		}
		
		
		return "comptes";
	}
	
	@RequestMapping(value="/saveOperation", method = RequestMethod.POST)
	public String saveOperation(Model model,String numCompte, String typeOperation,double montant,String numCompte2) {
		try {
			if(typeOperation.equals("V")) {
				bankMetier.verser(numCompte, montant);
			}
			else if(typeOperation.contentEquals("R")) {
				bankMetier.retirer(numCompte, montant);
			}
			if(typeOperation.contentEquals("VIR")) {
				bankMetier.virer(numCompte, numCompte2, montant);
			}
		} catch (Exception e) {
			model.addAttribute("errorr",e);
			return "redirect:/consulterCompte?numCompte="+numCompte+"&error="+e.getMessage();
		}
		
			
		return "redirect:/consulterCompte?numCompte="+numCompte;
	}
}
