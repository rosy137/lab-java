package edu.java.mvc.model;

	//데이터 설계
public class Post {
	//field
    private int pid;
    private String title;
    private String content;
    private String author;
    private String createdTime;
    private String modifiedTime;
    
    //constructor
	public Post() {}
	public Post(int pid, String title, String content, String author, String createdTime,
			String modifiedTime) {
		this.pid = pid;
		this.title = title;
		this.content = content;
		this.author = author;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
	}
    // getters&setters
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public int getPid() {
		return pid;
	} // pid는 set 불가
	public String getCreatedTime() {
		return createdTime;
	} // 최초 생성일은 set 불가
	
	@Override
		public String toString() {
			return "Post (pid: " + this.pid
					+ ", title: " + this.title
					+ ", content: " + this.content
					+ ", author: " + this.author
					+ ", createdtime: " + this.createdTime
					+ ", modifiedtime: " + this.modifiedTime
					+ ")";
	}

}