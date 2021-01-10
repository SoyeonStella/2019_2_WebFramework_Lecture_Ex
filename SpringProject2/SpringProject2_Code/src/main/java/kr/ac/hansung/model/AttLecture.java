package kr.ac.hansung.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString //객체 출력시 사용하는 메서드
public class AttLecture {
	
	// input 수정 못하게 막아둠 
	private int att_year;
	private int att_term;
	
	@NotEmpty(message="The sub_code cannot be empty")
	private String sub_code;
	
	@NotEmpty(message="The sub_title cannot be empty")
	private String sub_title;
	
	@NotEmpty(message="The sub_part cannot be empty")
	private String sub_part;
	
	@NotNull(message="The sub_credit cannot be empty")
	private int sub_credit;
	
	
	
}
