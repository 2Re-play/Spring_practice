package kr.ac.hansung.model;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MyClass {
	
//	@NotEmpty(message="The class year cannot be empty")
	private int class_year;
//	@NotEmpty(message="The class semester cannot be empty")
	private int class_semester;
	@NotEmpty(message="The class_code cannot be empty")
	private String class_code;
	@NotEmpty(message="The class name cannot be empty")
	private String class_name;
	@NotEmpty(message="The class category cannot be empty")
	private String class_category;
//	@NotEmpty(message="The class grade cannot be empty")
	private int class_grade;
	
}
