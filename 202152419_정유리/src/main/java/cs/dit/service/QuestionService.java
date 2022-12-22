package cs.dit.service;

import java.util.List;

import cs.dit.domain.Criteria;
import cs.dit.domain.QuestionVO;

public interface QuestionService {
	
	public List<QuestionVO> getList(Criteria cri);

	public List<QuestionVO> getList();		//list
	
	public int register(QuestionVO question);	//insert
	
	public QuestionVO get(int qno);	//selectOne
	
	public int getTotal(Criteria cri);
}
