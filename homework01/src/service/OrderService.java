package service;

public class OrderService {
	
	public boolean checkCreditCardNumebr(String cardNumber, String repeatCardNumber) {
			if(cardNumber != "" || repeatCardNumber != "") {
				if(cardNumber.equals(repeatCardNumber))
					return true;
				else 
					return false;
			} else {
				return false;
			}
		}

}
