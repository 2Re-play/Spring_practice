package kr.ac.hansung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class PetOwner {

	@Autowired // 어노테이션을 통해 생성자 생
	@Qualifier(value="qf_dog") // 의존성 주입 
	private AnimalType animal;
	
	public void play() {
		animal.sound();
	}
	
}
