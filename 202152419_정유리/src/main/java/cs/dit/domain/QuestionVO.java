package cs.dit.domain;

import java.util.Date;

import lombok.Data;

@Data
public class QuestionVO {

	private int qno;
	private String qtitle, qcontent, manswer;
	private Date qdate;
	
}
