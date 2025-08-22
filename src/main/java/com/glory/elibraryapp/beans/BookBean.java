package com.glory.elibraryapp.beans;

public class BookBean {

    private String callno;
    private String name;
    private String author;
    private String publish;
    private int quantity ;
    private int issued;

    public BookBean(){
        super();
    }

    public BookBean(String callno, String name, String author, String publish, int quantity, int issued) {
        this.callno = callno;
        this.name = name;
        this.author = author;
        this.publish = publish;
        this.quantity = quantity;
        this.issued = issued;
    }

    public String getCallno() {
        return callno;
    }

    public void setCallno(String callno) {
        this.callno = callno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIssued() {
        return issued;
    }

    public void setIssued(int issued) {
        this.issued = issued;
    }
}
