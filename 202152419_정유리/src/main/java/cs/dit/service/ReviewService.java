package cs.dit.service;

import java.util.List;

import cs.dit.domain.Criteria;
import cs.dit.domain.ReviewVO;

public interface ReviewService {
	
	public List<ReviewVO> getList(Criteria cri);
	
	

	public List<ReviewVO> getList();		//list
	
	public int register(ReviewVO review);	//insert
	
	public ReviewVO get(int rnum);	//selectOne
	
	
	public int getTotal(Criteria cri);
	
}
