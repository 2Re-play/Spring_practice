package kr.ac.hansung.csemall;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("kr/ac/hansung/conf/beans.xml");
		
		OfferDao offerDao = (OfferDao)context.getBean("offerDao");
		System.out.println("the record count is " + offerDao.getRowCount()); 
		
		List<Offer> offerList = offerDao.getOffers();
		
		for(Offer offer: offerList) {
			System.out.println(offer); //lombok의 toString 함수가 불린
		}
		Offer offer = new Offer();
		offer.setName("test2");
		offer.setEmail("test2@test.com");
		offer.setId("id003");
		offer.setText("0103333332");
		/* CREATE  METHOD */
//		System.out.println("insert is : " + offerDao.insert(offer)); 
		/* UPDATE METHOD */
//		System.out.println("update is : " + offerDao.update(offer)); 
		/* DELETE METHOD */
		System.out.println("delete is : " + offerDao.delete("id003")); 
		context.close();
	}

}
