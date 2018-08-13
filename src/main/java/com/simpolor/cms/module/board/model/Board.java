package com.simpolor.cms.module.board.model;

import lombok.Data;

@Data
public class Board {

    private int seq;
    private String title;
    private String content;
    private String regi_id;
    private String regi_name;
    private String regi_date;
    private String modi_id;
    private String modi_name;
    private String modi_date;
    private String del_yn;

    private int limit;
    private int offset;

}
