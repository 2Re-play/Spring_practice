package kr.ac.hansung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.model.MySemester;
import kr.ac.hansung.service.MyClassService;


@Controller
public class MyClassController {
	
	@Autowired
	private MyClassService myClassService;

	@RequestMapping("/myclass/semester")
	public String myClassSemester (Model model) {
		List<MySemester> mySemester = myClassService.getClassSemester();
		model.addAttribute("mySemester", mySemester); // model에 저장 
		
		return "semester";
	}
}
