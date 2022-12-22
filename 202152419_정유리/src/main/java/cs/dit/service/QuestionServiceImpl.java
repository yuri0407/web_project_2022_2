package cs.dit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cs.dit.domain.Criteria;
import cs.dit.domain.QuestionVO;
import cs.dit.domain.ReviewVO;
import cs.dit.mapper.QuestionMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

	private final QuestionMapper mapper;
	
	@Override
	public List<QuestionVO> getList(){
		return mapper.getList();
	}
	
	@Override
	public List<QuestionVO> getList(Criteria cri) {
		
		return mapper.getListPage(cri);
	}
	
	@Override
	public int register(QuestionVO question) {
		return mapper.insert(question);
	}
	
	@Override
	public QuestionVO get(int qno) {
		return mapper.selectOne(qno);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		
		return mapper.getTotal(cri);
	}
}
