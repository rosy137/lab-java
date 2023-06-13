package edu.java.file07;

import java.io.Serializable;

public class Score implements Serializable {
	private int java;
	private int web;
	private int python;
	public Score() {
	}
	public Score(int java, int web, int python) {
		this.java = java;
		this.web = web;
		this.python = python;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getWeb() {
		return web;
	}
	public void setWeb(int web) {
		this.web = web;
	}
	public int getPython() {
		return python;
	}
	public void setPython(int python) {
		this.python = python;
	}
	
	@Override
	public String toString() {
		return String.format("Score(java: %d, web: %d, python: %d)", java, web, python);
	}
	
//	파일에 쓰기 가능한 클래스로 만들것 
	
	
}
