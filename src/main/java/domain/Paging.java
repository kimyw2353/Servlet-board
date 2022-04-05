package domain;

import java.util.IdentityHashMap;

public class Paging {
    private int page;
    private int totalCount;
    private int beginPage;
    private int endPage;
    private int displayRow = 5;
    private int displayPage = 5;
    boolean prev;
    boolean next;

    /*
    private int firstPageNum; //첫번째 페이지 번호
    private int prevPageNum; //이전 페이지 번호
    private int startPageNum; //시작페이지(페이징네비)
    private int pageNum; //페이지번호
    private int endPageNum; //끝페이지(페이징네비)
    private int nextPageNum; //다음 페이지 번호
    private int finalPageNum; // 마지막 페이지 번호
    private int totalCount; // 전체 게시글 수
    private int pageSize; //게시글 수
    private int startSeq;//게시글 시작 시퀀스
    private int endSeq; //게시글 끝 시퀀스

    public int getFirstPageNum() {
        return firstPageNum;
    }

    public void setFirstPageNum(int firstPageNum) {
        this.firstPageNum = firstPageNum;
    }

    public int getPrevPageNum() {
        return prevPageNum;
    }

    public void setPrevPageNum(int prevPageNum) {
        this.prevPageNum = prevPageNum;
    }

    public int getStartPageNum() {
        return startPageNum;
    }

    public void setStartPageNum(int startPageNum) {
        this.startPageNum = startPageNum;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getEndPageNum() {
        return endPageNum;
    }

    public void setEndPageNum(int endPageNum) {
        this.endPageNum = endPageNum;
    }

    public int getNextPageNum() {
        return nextPageNum;
    }

    public void setNextPageNum(int nextPageNum) {
        this.nextPageNum = nextPageNum;
    }

    public int getFinalPageNum() {
        return finalPageNum;
    }

    public void setFinalPageNum(int finalPageNum) {
        this.finalPageNum = finalPageNum;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        this.makePaging();
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartSeq() {
        return startSeq;
    }

    public void setStartSeq(int startSeq) {
        this.startSeq = startSeq;
    }

    public int getEndSeq() {
        return endSeq;
    }

    public void setEndSeq(int endSeq) {
        this.endSeq = endSeq;
    }*/

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        paging();
    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getDisplayRow() {
        return displayRow;
    }

    public void setDisplayRow(int displayRow) {
        this.displayRow = displayRow;
    }

    public int getDisplayPage() {
        return displayPage;
    }

    public void setDisplayPage(int displayPage) {
        this.displayPage = displayPage;
    }

    public boolean isPrev() {
        return prev;
    }

    public void setPrev(boolean prev) {
        this.prev = prev;
    }

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    private void paging() {
        endPage = ((int) Math.ceil(page / (double) displayPage)) * displayPage;
        System.out.println("endPage : " + endPage);
        beginPage = endPage - (displayPage - 1);
        System.out.println("beginPage : " + beginPage);
        int totalPage = (int) Math.ceil(totalCount / (double) displayRow);
        if (totalPage < endPage) {
            endPage = totalPage;
            next = false;
        } else {
            next = true;
        }
        prev = (beginPage == 1) ? false : true;
        System.out.println("endPage : " + endPage);
        System.out.println("totalPage : " + totalPage);
    }

}/*
    private void makePaging(){
        if(this.totalCount==0) return; //카운트 지정 안됐을 때
        if(this.pageNum==0) this.setPageNum(1); //첫페이지 기본값
        if(this.pageSize==0) this.setPageSize(5); //페이지에 보여줄 갯수

        int finalPage = (totalCount +(pageSize - 1)) / pageSize; //마지막 페이징 번호 구하기
        if(this.pageNum > finalPage) this.setPageNum(finalPage); //마지막 페이지를 넘으면

        if(this.pageNum < 0) this.pageNum = 1;

        boolean isNowFirst = pageNum == 1? true:false; //전체에서 시작페이지인지
        boolean isNowFinal = pageNum == finalPage? true:false; //전체에서 마지막페이지인지

        int startPage = ((pageNum - 1) / 10) * 10 + 1; //시작페이지 (페이징네비 기준)
        int endPage = startPage + 10 - 1; //끝페이지 (페이징네비 기준)

        if(endPage > finalPage){ //페이징 네비에서의 마지막 페이지가 실제 마지막 페이지보다 큰 경우
            endPage = finalPage;
        }

        this.setFinalPageNum(1);

        if(isNowFirst){
            this.setPrevPageNum(1);
        }else {
            this.setPrevPageNum(((pageNum - 1) < 1 ? 1 : (pageNum - 1))); //이전페이지 번호
        }

        this.setStartPageNum(startPage); //시작페이지 (페이징네비 기준)
        this.setEndPageNum(endPage); //끝페이지 (페이징네비 기준)

        if(isNowFinal){
            this.setNextPageNum(finalPage); //다음페이지 번호
        }else{
            this.setNextPageNum(((pageNum + 1) > finalPage ? finalPage : (pageNum + 1))); //다음페이지 번호
        }

        int startSeq = (pageNum - 1) * pageSize;
        int endSeq = (pageNum * pageSize);
        this.setStartSeq(startSeq); // 게시글 시작시퀀스
        this.setEndSeq(endSeq); // 게시글 끝 시퀀스

        this.setFinalPageNum(finalPage); //마지막 페이지 번호
    }
}*/