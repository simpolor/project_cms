package com.simpolor.cms.component;

public class PaginationBuilder {

    private final int DEFAULT_FIRST_NO = 1;
    private final int DEFAULT_CURRENT_PAGE_NO = 1;
    private final int DEFAULT_RECORDS_PER_PAGE = 10;
    private final int DEFAULT_SIZE_OF_PAGE = 10;

    private int numberOfRecords;      // 전체 레코드 수
    private int recordsPerPage;       // 페이지당 레코드 수
    private int sizeOfPage;           // 보여지는 페이지 갯수 (1,2,3,4,5 갯수)
    private int currentPageNo;        // 페이지 번호

    public PaginationBuilder setNumberOfRecords(int numberOfRecords) {
        this.numberOfRecords = numberOfRecords;
        return this;
    }

    public PaginationBuilder setRecordsPerPage(int recordsPerPage) {
        this.recordsPerPage = recordsPerPage;
        return this;
    }

    public PaginationBuilder setSizeOfPage(int sizeOfPage) {
        this.sizeOfPage = sizeOfPage;
        return this;
    }

    public PaginationBuilder setCurrentPageNo(int currentPageNo) {
        this.currentPageNo = currentPageNo;
        return this;
    }

    public Pagination build(){

        int prevPageNo; // 이전 페이지 번호
        int nextPageNo; // 다음 페이지 번호

        if (numberOfRecords == 0) { // 게시글 전체 수가 없는 경우
            return new Pagination();
        }

        if (currentPageNo == 0) {
            currentPageNo = DEFAULT_CURRENT_PAGE_NO; // 기본 값 설정
        }

        if (recordsPerPage == 0) {
            recordsPerPage = DEFAULT_RECORDS_PER_PAGE; // 기본 값 설정
        }

        if (sizeOfPage == 0) {
            sizeOfPage = DEFAULT_SIZE_OF_PAGE; // 기본 값 설정
        }

        System.out.println("-- numberOfRecords : "+numberOfRecords);
        System.out.println("-- recordsPerPage : "+recordsPerPage);
        System.out.println("-- finalPage : "+((numberOfRecords + (recordsPerPage - 1)) / recordsPerPage));
        int finalPage = (numberOfRecords + (recordsPerPage - 1)) / recordsPerPage; // 마지막 페이지

        if (currentPageNo > finalPage){
            currentPageNo = finalPage;	// 기본 값 설정
        }

        if (currentPageNo < 0 || currentPageNo > finalPage){ // 현재 페이지 유효성 체크
            currentPageNo = DEFAULT_CURRENT_PAGE_NO; // 시작 페이지 (전체)
        }

        boolean isNowFirst = currentPageNo == 1 ? true : false;
        boolean isNowFinal = currentPageNo == finalPage ? true : false;

        int startPage = ((currentPageNo - 1) / sizeOfPage) * sizeOfPage + 1;
        int endPage = startPage + sizeOfPage - 1;

        if (endPage > finalPage) {
            endPage = finalPage;
        }

        if (isNowFirst){
            prevPageNo = 1; // 이전 페이지 번호
        }else{
            prevPageNo = (currentPageNo - 1) < 1 ? 1 : (currentPageNo - 1);
        }

        if (isNowFinal) {
            nextPageNo = finalPage; // 다음 페이지 번호
        } else{
            nextPageNo = (currentPageNo + 1) > finalPage ? finalPage : (currentPageNo + 1);
        }

        Pagination pagination = new Pagination();
        pagination.setRecordsPerPage(recordsPerPage);
        pagination.setFirstPageNo(DEFAULT_FIRST_NO);
        pagination.setStartPageNo(startPage);
        pagination.setPrevPageNo(prevPageNo);
        pagination.setCurrentPageNo(currentPageNo);
        pagination.setNextPageNo(nextPageNo);
        pagination.setEndPageNo(endPage);
        pagination.setFinalPageNo(finalPage);
        pagination.setNumberOfRecords(numberOfRecords);
        pagination.setSizeOfPage(sizeOfPage);

        return pagination;
    }
}
