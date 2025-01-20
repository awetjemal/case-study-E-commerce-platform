package com.casestudy.webapp.formBeans;



public class Greeting {

    private long id = 0;
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long doubleId(){
        return (id*2) + 5;
    }
}