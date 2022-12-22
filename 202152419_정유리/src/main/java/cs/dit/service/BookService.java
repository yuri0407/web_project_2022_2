package cs.dit.service;

import java.util.List;

import cs.dit.domain.BookVO;
import cs.dit.domain.Criteria;

public interface BookService {
	
	public List<BookVO> getList(Criteria cri);

	public List<BookVO> getList();
	
	public BookVO get(int bno);
	
	public int getTotal(Criteria cri);
	
}
