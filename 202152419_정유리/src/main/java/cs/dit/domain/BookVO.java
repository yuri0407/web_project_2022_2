package cs.dit.domain;

import lombok.Data;

@Data
public class BookVO {

	private int bno;
	private String bname, writer, publisher, pdate;
	private String category, bcontent, bimage;
}
