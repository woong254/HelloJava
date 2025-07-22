package com.yedam.movie;

public class Movie {
	//필드
	private int moNo; //영화번호
	private String title; //영화제목
	private String director; //감독
	private String genre; //장르
	private double raiting; //평점
	//생성자
	public Movie() {
	}
	public Movie(int moNo, String title, String director, String genre, double raiting) {
//		super();
		this.moNo = moNo;
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.raiting = raiting;
	}
	//메소드 (getter, setter 생성)
	public int getMoNo() {
		return moNo;
	}
	public void setMoNo(int moNo) {
		this.moNo = moNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getRaiting() {
		return raiting;
	}
	public void setRaiting(double raiting) {
		this.raiting = raiting;
	}
	
	
	
}
