package cs.dit.mapper;

import java.util.List;

import cs.dit.domain.Criteria;
import cs.dit.domain.ReviewVO;


public interface ReviewMapper {

	public List<ReviewVO> getListPage(Criteria cri);
	
	
	
	public List<ReviewVO> getList();		//list
	
	public int insert(ReviewVO review);	//insert
	
	public ReviewVO selectOne(int rnum);	//selectOne
	
	
	
	public int getTotal(Criteria cri);
	
}
