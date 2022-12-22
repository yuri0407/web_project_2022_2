package cs.dit.mapper;

import java.util.List;

import cs.dit.domain.Criteria;
import cs.dit.domain.QuestionVO;

public interface QuestionMapper {
	
	public List<QuestionVO> getListPage(Criteria cri);

	public List<QuestionVO> getList();		//list
	
	public int insert(QuestionVO question);	//insert
	
	public QuestionVO selectOne(int qno);	//selectOne
	
	public int getTotal(Criteria cri);
}
