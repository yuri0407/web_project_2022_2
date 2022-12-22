package cs.dit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cs.dit.domain.Criteria;
import cs.dit.domain.ReviewVO;
import cs.dit.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

	private final ReviewMapper mapper;
	
	@Override
	public List<ReviewVO> getList() {
		return mapper.getList();
	}
	
	
	@Override
	public List<ReviewVO> getList(Criteria cri) {
		
		log.info("get List with Criteria : " + cri);
		
		return mapper.getListPage(cri);
	}
	
	
	

	@Override
	public int register(ReviewVO review) {
		return mapper.insert(review);
	}

	@Override
	public ReviewVO get(int rnum) {
		return mapper.selectOne(rnum);
	}
	
	
	
	@Override
	public int getTotal(Criteria cri) {
		
		return mapper.getTotal(cri);
	}
	

}
