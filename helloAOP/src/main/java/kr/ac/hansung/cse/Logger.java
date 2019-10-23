package kr.ac.hansung.cse;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Logger {

	@Pointcut("execution(void kr.ac.hansung.cse.*.sound())") // target
	private void selectSound() { //signature 포인트컷의 아이디가 된다.
		
	}
	
	@After("selectSound()") // 참조할 포인트컷의 id
	public void aboutToSound() {
		System.out.println("advice: about to sound");
	}

}
