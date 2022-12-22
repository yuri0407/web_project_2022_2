package cs.dit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cs.dit.domain.Criteria;
import cs.dit.domain.RequestVO;
import cs.dit.mapper.RequestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {

	private final RequestMapper mapper;
	
	@Override
	public List<RequestVO> getList() {
		return mapper.getList();
	}
	
	@Override
	public List<RequestVO> getList(Criteria cri) {
		
		log.info("get List with Criteria : " + cri);
		
		return mapper.getListPage(cri);
	}

	@Override
	public int register(RequestVO request) {
		return mapper.insert(request);
	}

	@Override
	public RequestVO get(int rno) {
		return mapper.selectOne(rno);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		
		return mapper.getTotal(cri);
	}

}
