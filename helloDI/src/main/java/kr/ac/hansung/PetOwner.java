package kr.ac.hansung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class PetOwner {

	@Autowired // wired by type (AnimalType에 의해서 의존성이 주입된다.) 
	@Qualifier(value="qf_dog") // 의존성 주입 (singleton이 아닐경우 지정해줘야함)
	private AnimalType animal;
	
	public void play() {
		animal.sound();
	}
	
}
