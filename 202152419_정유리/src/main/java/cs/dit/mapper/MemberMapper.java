package cs.dit.mapper;


import org.apache.ibatis.annotations.Param;

import cs.dit.domain.MemberVO;

public interface MemberMapper {
	
	public String checkUser(@Param("id") String id, @Param("pwd") String pwd);	//checkUser
	
	public String checkId(String id);		//checkId
	
	public MemberVO selectOne(String id);		//selectOne
	
	public int insert(MemberVO member);	//insert
	
	public int delete(String id);		//delete


}
