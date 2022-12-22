package cs.dit.service;


import cs.dit.domain.MemberVO;

public interface MemberService {
	
	public String checkUser(String id, String pwd);	//checkUser
	
	public String checkId(String id);		//checkId
	
	public MemberVO get(String id);		//list
	
	public int register(MemberVO member);	//insert
	
	public int remove(String id);		//delete
}
