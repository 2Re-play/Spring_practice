package service;

import java.util.HashMap;
import java.util.Map;

import model.Customer;

public class CustomerService {

	private Map<String, Customer> customerMap;

	public CustomerService() {

		customerMap = new HashMap<String, Customer>();

		addCustomer(new Customer("id001", "pw001"));
		addCustomer(new Customer("id002", "pw002"));
	}

	private void addCustomer(Customer customer) {

		customerMap.put(customer.getId(), customer);

	}

	public Customer loginCheck(String id, String pw) {
		
		String findId = customerMap.get(id.toLowerCase()).getId();
		String findPw = customerMap.get(id.toLowerCase()).getPassword();
		
		if (id != null && pw != null) 
			if (findId.equals(id.toLowerCase()) && findPw.equals(pw.toLowerCase())) 
				return (customerMap.get(id.toLowerCase()));
			else 
				return null;
		 else 
			return null;
		
	}

}
