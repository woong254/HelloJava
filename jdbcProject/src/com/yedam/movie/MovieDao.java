package com.yedam.movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieDao {
	Connection con = DBUtil.getConnect();
	//1번 영화 조회
	public ArrayList<Movie> findAll() {
		ArrayList<Movie> list = new ArrayList<Movie>();
		String query = "select * from movie order by moNo";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery("select * from movie order by moNo");
			
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
	//수정
	public boolean update(String field1, String value1, String field2, String value2) {
		String query = "update movie "
				+ "set "
				+ field1 
				+ " = ? where " 
				+ field2
				+" = ?";
				
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			
			if(field1.equals("moNo")) {
				stmt.setInt(1, Integer.parseInt(value1));
			} else if(field1.equals("raiting")) {
				stmt.setDouble(1,Double.parseDouble(value1));
			} else {
				stmt.setString(1, value1);
			}	
			if(field2.equals("moNo")) {
				stmt.setInt(2, Integer.parseInt(value2));
			} else if(field2.equals("raiting")) {
				stmt.setDouble(1,Double.parseDouble(value2));
			} else {
				stmt.setString(2, value2);
			}		
			
			int r = stmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//컬럼별 검색
	public ArrayList<Movie> find(String field,String value){
		ArrayList<Movie> list = new ArrayList<>();
		String query = "select * "
				     + "from movie "
				     + "where "
				     + field
				     + " like ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, "%"+value+"%");
			if(field == "moNO") {
				stmt.setInt(1, Integer.parseInt(value));
			} else if(field == "raiting") {
				stmt.setDouble(1, Double.parseDouble(value));
			}
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
	//감독 검색용
	public ArrayList<Movie> avgDirector(){
		ArrayList<Movie> list = new ArrayList<>();
		String query = "select director, AVG(raiting) as avg_raiting "
				     + "from movie "
				     + "where director is not null "
				     + "group by director";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Movie m = new Movie();
				m.setDirector(rs.getString("director"));
				m.setRaiting(rs.getDouble("avg_raiting"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	} 
	//평점 검색
	public ArrayList<Movie> minmax(Double min,Double max){
		ArrayList<Movie> list = new ArrayList<>();
		String query = "select * "
				     + "from movie "
				     + "where raiting >= ? "
				     + "and   raiting <= ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setDouble(1, min);
			stmt.setDouble(2, max);
			
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
	//삭제
	public boolean deleteMovie(String field, String value) {
		String query = "DELETE FROM movie WHERE " 
					 + field 
					 + " = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			
			if(field.equals("title")) {
				stmt.setString(1, value);
				} else if(field.equals("moNo"))stmt.setInt(1, Integer.parseInt(value));
			
			int r = stmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}
