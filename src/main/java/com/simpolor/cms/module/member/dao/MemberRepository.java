package com.simpolor.cms.module.member.dao;


import com.simpolor.cms.module.member.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

	@Autowired
	private SqlSession sqlSession;

	public List<Member> selectMemberList(){
		return sqlSession.selectList("selectMemberList");
	}

	public Member selectMember(String member_id){
		return  sqlSession.selectOne("selectMember", member_id);
	}

	public int selecMemberIdCheck(String member_id){
		return  sqlSession.selectOne("selecMemberIdCheck", member_id);
	}

	public int insertMember(Member member){
		return  sqlSession.insert("insertMember", member);
	}

	public int updateMember(Member member){
		return  sqlSession.update("updateMember", member);
	}

	public int deleteMember(String member_id){
		return  sqlSession.update("deleteMember", member_id);
	}

}
