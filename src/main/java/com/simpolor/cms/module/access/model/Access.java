package com.simpolor.cms.module.access.model;

import lombok.Data;

@Data
public class Access {

	private long access_seq;

	private String access_url;

	private String access_roles;

	private String regi_id;

	private String regi_name;

	private String regi_date;

	private String modi_id;

	private String modi_name;

	private String modi_date;

	private String del_yn;

}
