package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.MyClass;
import kr.ac.hansung.model.Semester;
import kr.ac.hansung.service.MyClassService;

@Controller
public class MyClassController {

	@Autowired
	private MyClassService myClassService;
	
	// 학기별 이수 학점 조회
	@RequestMapping("/myclass/semester")
	public String showClassSemester (Model model) {
		List<Semester> semesters = myClassService.getMyClassSemester();
		model.addAttribute("semesters", semesters); // model에 저장
		return "semester";
	}
	
	// 학기별 이수 교과목 조회
	@RequestMapping("/myclass/semester/list")
	public String showClassSemesterList (@RequestParam(value="year", required=true) int year,
										 @RequestParam(value="semester", required=true) int semester, Model model) {
		
		List<MyClass> myClass = myClassService.getMyClassSemesterList(year, semester);
		model.addAttribute("myClass", myClass); // model에 저장
		return "semesterClassList";
	}
	
	// 2020년 예상 수강신청 입력하기 
	@RequestMapping("/createclass")
	public String createoffer(Model model) {
		
		// 해당 코드를 넣지 않고 실행시키면 model에 offer 객체가 할당되지 않기 때문에 data buffering, data banding이 이루어지지 않음.
		model.addAttribute("myClass", new MyClass()); // model에 저장 
		
		return "createclass";
	}
	
	@RequestMapping("/docreate")
	public String docreate(Model model, @Valid MyClass myClass, BindingResult result) { //data binding @Valid annotation to validation check!!
		
		if(result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors(); // 발생한 error 전부 list에 저장
			for(ObjectError error: errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "createclass";
		} 
		
		myClassService.insert(myClass); 

		return "classcreated";
	}
	
	// 2020년 수강신청 내역 조회하기 
		@RequestMapping("/myclass/future")
		public String showClassSemesterFutrue (Model model) {
			List<MyClass> myClass = myClassService.getMyClassSemesterFuture();
			model.addAttribute("myClass", myClass); // model에 저장
			return "semesterClassList";
		}
}
