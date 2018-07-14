package com.simpolor.cms.module.member.dao;


import com.simpolor.cms.module.member.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberRepository {

	List<Member> selectMemberList();
	Member selectMember(String member_id);
	int selecMemberIdCheck(String member_id);
	int insertMember(Member member);
	int updateMember(Member member);
	int deleteMember(String member_id);

}
