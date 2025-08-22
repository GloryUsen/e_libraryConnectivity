package com.glory.elibraryapp.beans;

import java.util.Date;

public class IssueBookBean {
    private String callNo, studentId, studentName ;
    private long studentMobile;
    private Date issuedDate;
    private String returnsStatus;

    public IssueBookBean(){
        super();
    }

    public IssueBookBean(String callNo, String studentId, String studentName, long studentMobile) {
        this.callNo = callNo;
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentMobile = studentMobile;

    }

    public String getCallNo() {
        return callNo;
    }

    public void setCallNo(String callNo) {
        this.callNo = callNo;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public long getStudentMobile() {
        return studentMobile;
    }

    public void setStudentMobile(long studentMobile) {
        this.studentMobile = studentMobile;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getReturnsStatus() {
        return returnsStatus;
    }

    public void setReturnsStatus(String returnsStatus) {
        this.returnsStatus = returnsStatus;
    }


}
