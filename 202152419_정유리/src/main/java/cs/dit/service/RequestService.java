package cs.dit.service;

import java.util.List;

import cs.dit.domain.Criteria;
import cs.dit.domain.RequestVO;

public interface RequestService {
	
	public List<RequestVO> getList(Criteria cri);

	public List<RequestVO> getList();		//list

	public int register(RequestVO request);	//insert
	
	public RequestVO get(int rno);	//selectOne
	
	public int getTotal(Criteria cri);
}
