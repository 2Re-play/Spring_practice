package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/* lombok annotation */
@Getter
@Setter
@AllArgsConstructor 
public class Customer {
	
	private String id;
	private String password;

}
