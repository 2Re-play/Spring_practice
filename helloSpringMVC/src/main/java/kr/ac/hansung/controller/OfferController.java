package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.Offer;
import kr.ac.hansung.service.OfferService;

@Controller
public class OfferController {

	@Autowired
	private OfferService offerService;
	
	@RequestMapping("/offers")
	public String showOffers(Model model) {
		List<Offer> offers = offerService.getCurrent();
		model.addAttribute("offers", offers); // model에 저장 
		
		return "offers";
	}

	@RequestMapping("/createoffer")
	public String createoffer(Model model) {
		
		// 해당 코드를 넣지 않고 실행시키면 model에 offer 객체가 할당되지 않기 때문에 data buffering, data banding이 이루어지지 않음.
		model.addAttribute("offer", new Offer()); // model에 저장 
		
		return "createoffer";
	}
	
	@RequestMapping("/docreate")
	public String docreate(Model model, @Valid Offer offer, BindingResult result) { //data binding @Valid annotation to validation check!!
		
		if(result.hasErrors()) {
			System.out.println("=== Web Form data does not validated ===");
			List<ObjectError> errors = result.getAllErrors(); // 발생한 error 전부 list에 저장
			for(ObjectError error: errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "createoffer";
		} 
		offerService.insert(offer); 

		return "offercreated";
	}
	
}
