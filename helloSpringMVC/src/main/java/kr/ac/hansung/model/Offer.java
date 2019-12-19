package kr.ac.hansung.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Offer {
	
	private String id;
	
	@Size(min=2, max=100, message="Name mush be between 2 and 100 chars")
	private String name;
	@Email(message="Please privide a valid eamil address")
	@NotEmpty(message="The email address cannot be empty")
	private String email;
	@Size(min=5, max=100, message="Text must be between 5 and 100 chars")
	private String text;
 
}
