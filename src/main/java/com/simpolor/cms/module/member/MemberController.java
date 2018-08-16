package com.simpolor.cms.module.member;

import com.simpolor.cms.module.member.model.Member;
import com.simpolor.cms.module.member.service.MemberService;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MemberController {

	final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public ModelAndView memberLogin(ModelAndView mav, HttpServletRequest request) {
		
		String referer = request.getHeader("Referer");
		logger.info("-- referer : {}", referer);
		
		// 저장할때 부터 "/member/login" 과 동일한지 비교가 필요
		if(request.getSession().getAttribute("refererUrl") == null) {
			  request.getSession().setAttribute("refererUrl", referer);
		}
		
		mav.setViewName("module/member/memberLogin");
		
		return mav;
	}
	
	@RequestMapping( value="/member/register", method=RequestMethod.GET)
	public ModelAndView memberRegisterForm(ModelAndView mav) {

		logger.info("[M] memberRegisterForm");

		mav.setViewName("module/member/memberRegister");
		
		return mav;
	}
	
	@RequestMapping( value="/member/register", method=RequestMethod.POST)
	public ModelAndView memberRegister(ModelAndView mav, Member member) {

		logger.info("[M] memberRegister");

		String memberId = member.getMember_id();
		String memberPw = member.getMember_pw();
		String memberPwConfirm = member.getMember_pw_confirm();
		String memberName = member.getMember_name();
		String memberEmail = member.getMember_email();

		logger.info("- memberId :"+memberId);
		logger.info("- memberPw :"+memberPw);
		logger.info("- memberPwConfirm :"+memberPwConfirm);
		logger.info("- memberName :"+memberName);
		logger.info("- memberEmail :"+memberEmail);
		
		if(StringUtils.isEmpty(memberId) || StringUtils.isEmpty(memberPw) || StringUtils.isEmpty(memberPwConfirm) || StringUtils.isEmpty(memberName) || StringUtils.isEmpty(memberEmail)) {
			mav.setViewName("module/member/memberRegister");
			return mav;
		}
		
		if(StringUtils.equals(memberPw, memberPwConfirm)) {
			if(memberService.isMemberId(memberId) == 0) {
				member.setMember_roles("USER");
				int result = memberService.registerMember(member);
				if(result > 0) {
					mav.setViewName("redirect:/member/registerComplete");
					return mav;
				}
			}
		}
		
		mav.setViewName("module/member/memberRegister");
		
		return mav;
	}
	
	@RequestMapping( value="/member/registerComplete", method=RequestMethod.GET)
	public ModelAndView memberRegisterComplete(ModelAndView mav) {

		logger.info("[M] memberRegisterComplete");

		mav.setViewName("module/member/memberRegisterComplete");
		
		return mav;
	}
	
	@RequestMapping("/member/list")
	public ModelAndView memberList() {

		logger.info("[M] memberList");
		
		List<Member> list = memberService.getMemberList();

		ModelAndView mav = new ModelAndView();
		mav.addObject("memberList", list);
		mav.setViewName("module/member/memberList");
		
		return mav;
	}
	
	@RequestMapping( value="/member/info/{member_id}", method=RequestMethod.GET)
	public ModelAndView memberInfo(ModelAndView mav, @PathVariable String member_id) {

		logger.info("[M] memberInfo");

		Member member = memberService.getMember(member_id);
		
		mav.addObject("member", member);
		mav.setViewName("module/member/memberInfo");
		
		return mav;
	}
	
	@RequestMapping( value="/member/modify/{member_id}", method=RequestMethod.GET)
	public ModelAndView memberModifyForm(ModelAndView mav, @PathVariable String member_id) {

		logger.info("[M] memberModifyForm");

		Member member = memberService.getMember(member_id);

		mav.addObject("member", member);
		mav.setViewName("module/member/memberModify");
		
		return mav;
	}
	
	@RequestMapping( value="/member/modify/{member_id}", method=RequestMethod.POST)
	public ModelAndView memberModify(ModelAndView mav, @PathVariable String member_id, Member member) {

		logger.info("[M] memberModify");
		
		logger.info("- member_id : "+member_id);
		logger.info("- member_name : "+member.getMember_name());
		logger.info("- member_email : "+member.getMember_email());
		
		member.setMember_id(member_id);
		if(memberService.modifyMember( member) > 0){
			mav.setViewName("redirect:/member/list");
		}else{
			mav.setViewName("module/member/memberModify");
		}
		
		return mav;
	}
	
	@RequestMapping( value="/member/delete/{member_id}", method=RequestMethod.GET)
	public ModelAndView memberDelete(ModelAndView mav, @PathVariable String member_id) {

		logger.info("[M] memberDelete");
		
		if(memberService.deleteMember(member_id) > 0) mav.setViewName("redirect:/member/list");
		else mav.setViewName("module/member/memberModify");
		
		return mav;
	}
	
	
	
}
