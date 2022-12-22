package cs.dit.service;

import org.springframework.stereotype.Service;

import cs.dit.domain.MemberVO;
import cs.dit.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberMapper mapper;
	
	@Override
	public String checkUser(String id, String pwd) {
		return mapper.checkUser(id, pwd);
	}
	
	@Override
	public String checkId(String id) {
		return mapper.checkId(id);
	}
	
	@Override
	public MemberVO get(String id) {
		return mapper.selectOne(id);
	}
	
	@Override
	public int register(MemberVO member) {
		return mapper.insert(member);
	}
	
	@Override
	public int remove(String id) {
		return mapper.delete(id);
	}
	
	

	

}
