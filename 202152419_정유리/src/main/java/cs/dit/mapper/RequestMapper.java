package cs.dit.mapper;

import java.util.List;

import cs.dit.domain.Criteria;
import cs.dit.domain.RequestVO;

public interface RequestMapper {
	
	public List<RequestVO> getListPage(Criteria cri);
	
	public List<RequestVO> getList();		//list

	public int insert(RequestVO request);	//insert
	
	public RequestVO selectOne(int rno);	//selectOne
	
	public int getTotal(Criteria cri);
}
