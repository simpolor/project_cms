package com.simpolor.cms.component;

import lombok.Data;

@Data
public class Pagination {

    int recordsPerPage;       // 페이지당 레코드 수

    int firstPageNo;          // 첫번째 페이지 번호

    int prevPageNo;           // 이전 페이지 번호

    int startPageNo;          // 시작 페이지 (페이징 너비 기준)

    int currentPageNo;        // 페이지 번호

    int endPageNo;            // 끝 페이지 (페이징 너비 기준)

    int nextPageNo;           // 다음 페이지 번호

    int finalPageNo;          // 마지막 페이지 번호

    int numberOfRecords;      // 전체 레코드 수

    int sizeOfPage;           // 보여지는 페이지 갯수 (1,2,3,4,5 갯수)

}
