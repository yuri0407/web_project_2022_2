package cs.dit.mapper;

import java.util.List;

import cs.dit.domain.BookVO;
import cs.dit.domain.Criteria;

public interface BookMapper {
	
	public List<BookVO> getListPage(Criteria cri);
	
	public List<BookVO> getList();		//list
	
	public BookVO selectOne(int bno);	//selectOne
	
	public int getTotal(Criteria cri);
	

}
