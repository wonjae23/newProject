package com.won.project.domain;

public class Board {
	
	private String rn;
	private String id;
    private String subject;
    private String content;
    private String writer;
    private String register_datetime;
     
    
    public String getRn() {
		return rn;
	}
	public void setRn(String rn) {
		this.rn = rn;
	}
	public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public String getRegister_datetime() {
        return register_datetime;
    }
    public void setRegister_datetime(String register_datetime) {
        this.register_datetime = register_datetime;
    }
}
