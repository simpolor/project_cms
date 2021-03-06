package com.simpolor.cms.module.member.service;

import com.simpolor.cms.module.member.model.Member;
import com.simpolor.cms.module.member.dao.MemberRepository;
import com.simpolor.cms.security.PasswordEncrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService  {

	@Autowired
	private MemberRepository memberRepository;
	 
	@Autowired
	private PasswordEncrypt passwordEncrypt;
	
	public List<Member> getMemberList(){
		return memberRepository.selectMemberList();
	}
	
	public Member getMember(String member_id) {
		return memberRepository.selectMember(member_id); 
	} 

	public int isMemberId(String member_id) {
		return memberRepository.selecMemberIdCheck(member_id);
	}
	
	public int registerMember(Member member) {
		String memberPwEnc = member.getMember_pw(); 
		String encodedPassword = passwordEncrypt.encode(memberPwEnc); 
		member.setMember_pw(encodedPassword);
		
		return memberRepository.insertMember(member); 
	} 
	
	public int modifyMember(Member member){
		return memberRepository.updateMember(member);
	}
	
	public int deleteMember(String member_id) { 
		return memberRepository.deleteMember(member_id); 
	} 

}
