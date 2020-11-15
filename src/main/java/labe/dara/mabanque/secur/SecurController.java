package labe.dara.mabanque.secur;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurController {
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/")
	public String home() {
		return "redirect:/operations";
	}
	@RequestMapping(value="/403")
	public String accessDenied() {
		return "403";
	}
}
