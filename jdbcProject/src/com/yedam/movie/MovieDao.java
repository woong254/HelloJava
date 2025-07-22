package com.yedam.movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MovieDao {
	Connection con = DBUtil.getConnect();
	//1번 영화 조회
	public ArrayList<Movie> findAll() {
		ArrayList<Movie> list = new ArrayList<Movie>();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from movie");
			
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setMoNo(rs.getInt("moNo"));
				movie.setTitle(rs.getString("title"));
				movie.setDirector(rs.getString("director"));
				movie.setGenre(rs.getString("genre"));
				movie.setRaiting(rs.getDouble("raiting"));
				list.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//2번 영화 등록
	public boolean insert(Movie movie) {
		String query = "insert into movie(moNo,title,director,genre,raiting)"
					 + "values(?,?,?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setInt(1, movie.getMoNo());
			stmt.setString(2, movie.getTitle());
			stmt.setString(3, movie.getDirector());
			stmt.setString(4, movie.getGenre());
			stmt.setDouble(5, movie.getRaiting());
			
			int r = stmt.executeUpdate();
			
			if(r>0) {
				return true;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	//영화 제목으로 검색
	public ArrayList<Movie> findTitle(String title){
		ArrayList<Movie> list = new ArrayList<>();
		String query = "select *"
				     + "from movie"
				     + "where title = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, title);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Movie m = new Movie();
				m.setMoNo(rs.getInt("moNo"));
				m.setTitle(rs.getString("title"));
				m.setDirector(rs.getString("director"));
				m.setGenre(rs.getString("genre"));
				m.setRaiting(rs.getDouble("raiting"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean update(String title, int moNo) {
		String query = "update movie"
					 + "set moNo = ?"
					 + "where title = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setInt(1, moNo);
			stmt.setString(2, title);			
			int r = stmt.executeUpdate();
			
			if(r==1) {
				return true;
			} else if(r>=2) {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
}
