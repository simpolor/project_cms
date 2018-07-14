package com.simpolor.cms.module.member.model;

import lombok.Data;

@Data
public class Member{

	private String member_id;

	private String member_pw;

	private String member_pw_confirm;

	private String member_name;

	private String member_email;

	private String member_roles;

	private String regi_date;

	private String modi_date;

	private String del_yn;

}
