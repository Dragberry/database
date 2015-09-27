package by.bsuir.drahun.database.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.util.JSONPObject;

import by.bsuir.drahun.database.business.OfferService;
import by.bsuir.drahun.database.domain.ProductOffer;
import by.bsuir.drahun.database.json.AddConditionEntity;
import by.bsuir.drahun.database.query.ProductOfferQuery;

@Controller
@Scope("session")
@SessionAttributes("query")
public class DatabaseController implements Serializable {
	
	private static final long serialVersionUID = 7372736988583245713L;
	
	@Autowired
	private OfferService offerServise;
	
	@RequestMapping("/")
	public String getDatabasePage() {
		
		return "index";
	}
	@RequestMapping(value = "/search-offers", method = RequestMethod.GET, params = {"query"})
	public ModelAndView getOfferList(@RequestParam("query") String query, ModelAndView model, HttpServletRequest request) {
		List<ProductOffer> offerList = offerServise.fetchOffers(query);
	    model.addObject("offerList", offerList);
	    model.setViewName("offer-list");
	    request.getSession().setAttribute("query", query);
		return model;
	}
	
	@RequestMapping("/offer-list")
	public ModelAndView getOfferList(ModelAndView model) {
		List<ProductOffer> offerList = offerServise.fetchOffers(new ProductOfferQuery());
	    model.addObject("offerList", offerList);
	    model.setViewName("offer-list");
		return model;
	}
	
	@RequestMapping(value = "/add-condition", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<AddConditionEntity> addCondition() {
		AddConditionEntity entity = new AddConditionEntity();
		entity.setResultQuery("gddhd");
		return new ResponseEntity<AddConditionEntity>(entity, HttpStatus.OK);
	}
	
}
