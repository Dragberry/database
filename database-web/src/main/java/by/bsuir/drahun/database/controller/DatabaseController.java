package by.bsuir.drahun.database.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DatabaseController {
	
	@RequestMapping("/")
	public String getDatabasePage() {
		return "index";
	}
	@RequestMapping("/offer-list")
	public String getOfferList() {
		return "offer-list";
	}

}
