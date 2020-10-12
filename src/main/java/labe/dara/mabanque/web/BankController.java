package labe.dara.mabanque.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import labe.dara.mabanque.metier.IBankMetier;

@Controller
public class BankController {
	@Autowired
	private IBankMetier bankMetier;
	
	@RequestMapping("/operations")
	public String index() {
		
		return "comptes";
	}
}
