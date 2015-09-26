package by.bsuir.drahun.database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import by.bsuir.drahun.database.business.OfferService;
import by.bsuir.drahun.database.domain.ProductOffer;
import by.bsuir.drahun.database.query.ProductOfferQuery;

@Controller
public class DatabaseController {
	
	@Autowired
	private OfferService offerServise;
	
	@RequestMapping("/")
	public String getDatabasePage() {
		return "index";
	}
	@RequestMapping("/offer-list")
	public ModelAndView getOfferList(ModelAndView model) {
		List<ProductOffer> offerList = offerServise.fetchOffers(new ProductOfferQuery());
	    model.addObject("offerList", offerList);
	    model.setViewName("offer-list");
		return model;
	}
	
}
