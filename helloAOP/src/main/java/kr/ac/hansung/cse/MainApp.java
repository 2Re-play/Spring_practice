package kr.ac.hansung.cse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		// 컨테이너 생성, 인자로 xml config파일을 넘겨
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("/kr/ac/hansung/cse/conf/animal.xml");

		PetOwner person = (PetOwner) context.getBean("id_petOwner"); // bean 가져오기
		
		person.play();
		
		context.close(); 
	}

}
