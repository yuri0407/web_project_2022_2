package cs.dit.domain;

import java.util.Date;

import lombok.Data;

@Data
public class RequestVO {

	private int rno;
	private String rname, rcontent;
	private Date rdate;
}
