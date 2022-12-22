package cs.dit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cs.dit.domain.BookVO;
import cs.dit.domain.Criteria;
import cs.dit.domain.ReviewVO;
import cs.dit.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

	private final BookMapper mapper;
	
	@Override
	public List<BookVO> getList() {
		return mapper.getList();
	}
	
	@Override
	public List<BookVO> getList(Criteria cri) {
		
		log.info("get List with Criteria : " + cri);
		
		return mapper.getListPage(cri);
	}

	@Override
	public BookVO get(int bno) {
		return mapper.selectOne(bno);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		
		return mapper.getTotal(cri);
	}
	
}
