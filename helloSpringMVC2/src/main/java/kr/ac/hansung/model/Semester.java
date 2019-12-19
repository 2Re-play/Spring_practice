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
public class Semester {

//	@NotEmpty(message="The class year cannot be empty")
	private int class_year;
//	@NotEmpty(message="The class semester cannot be empty")
	private int class_semester;
//	@NotEmpty(message="The class grade cannot be empty")
	private int class_grade;
}
