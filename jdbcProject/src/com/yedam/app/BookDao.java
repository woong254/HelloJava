package com.yedam.app;

import java.sql.Connection;        // DB와 연결할 때 사용하는 클래스
import java.sql.PreparedStatement; // SQL문(쿼리)을 DB에 보낼 때 사용하는 객체
import java.sql.ResultSet;         // SELECT 결과(데이터)를 받을 때 사용하는 객체
import java.sql.SQLException;      // DB 작업 중 에러가 나면 이 예외가 발생
import java.sql.Statement;         // SQL문을 DB로 보낼 때 사용 (PreparedStatement보다 단순)
import java.util.ArrayList;        // 여러 Book 객체를 담기 위한 리스트

// Book 테이블에 있는 데이터를 다루는 DAO (Data Access Object)
// - 등록, 수정, 삭제, 조회를 DB와 연결해서 처리
public class BookDao {

    // 책 가격 수정 메서드
    // 매개변수: 책 번호(bno), 바꿀 가격(price)
    // 반환값: 수정 성공하면 true, 실패하면 false
    public boolean update(int bno, int price) {
        // DB 연결을 가져옴 (전화선 연결 느낌)
        Connection conn = DBUtil.getConnect();

        // SQL 문장 작성 (id가 bno인 책의 가격을 price로 바꿔라)
        String query = "update book"
                     + "     set price = ? "
                     + "     where id = ?";

        try {
            // SQL 문장을 DB로 보낼 준비 (PreparedStatement는 ? 자리에 값을 채워줄 수 있음)
            PreparedStatement stmt = conn.prepareStatement(query);

            // 첫 번째 ? 자리에 price 값을 넣음
            stmt.setInt(1, price);
            // 두 번째 ? 자리에 bno 값을 넣음
            stmt.setInt(2, bno);

            // SQL 실행 (DB에 실제로 업데이트 시도)
            // executeUpdate()는 영향을 준 행(row)의 개수를 반환 (성공 시 1 이상)
            int r = stmt.executeUpdate();

            // r이 1 이상이면(=실제로 수정된 데이터가 있다면) true 반환
            if (r > 0) {
                return true;
            }
        } catch (SQLException e) { // DB 연결 문제나 SQL 문법 에러가 나면 여기로 넘어옴
            e.printStackTrace();   // 에러 내용을 콘솔에 출력
        }

        // 수정이 안 되면 false 반환
        return false;
    }

    // 책 등록 메서드
    // 매개변수: Book 객체 (id, title, author, price 정보를 가진 책)
    // 반환값: 등록 성공하면 true, 실패하면 false
    public boolean insert(Book book) {
        Connection conn = DBUtil.getConnect();

        // book 테이블에 새로운 책 정보를 넣는 SQL문
        String query = "insert into book (id, title, author, price)"
                     + "     values(?,?,?,?)";
        System.out.println(query); // SQL 문장 출력 (디버깅용)

        try {
            // SQL 실행 준비
            PreparedStatement stmt = conn.prepareStatement(query);

            // ? 자리에 Book 객체의 값들 채워 넣음
            stmt.setInt(1, book.getId());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            stmt.setInt(4, book.getPrice());

            // 실행해서 DB에 insert (추가)
            int r = stmt.executeUpdate();

            // r이 1 이상이면(=1건 이상 등록) 성공
            if (r > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 오류 출력
        }
        return false; // 실패 시 false
    }

    // 책 목록 전체 조회 메서드
    // 반환값: Book 객체들이 들어있는 ArrayList
    public ArrayList<Book> findAll() {
        Connection conn = DBUtil.getConnect(); // DB 연결
        ArrayList<Book> list = new ArrayList<Book>(); // 결과를 담을 리스트 준비

        try {
            // 단순 SQL 실행용 Statement (PreparedStatement와 다르게 ? 같은 변수가 없음)
            Statement stmt = conn.createStatement();

            // "book" 테이블의 모든 데이터를 가져오는 쿼리 실행
            ResultSet rs = stmt.executeQuery("select * from book");

            // ResultSet(rs)에는 DB에서 가져온 결과가 들어 있음
            // rs.next()는 다음 행(row)으로 이동하면서 데이터가 있는지 확인
            while (rs.next()) {
                // 한 행(row)을 Book 객체로 변환
                Book book = new Book();
                book.setId(rs.getInt("id"));       // "id" 컬럼 값을 book.id에 저장
                book.setTitle(rs.getString("title"));   // "title" 컬럼 값을 book.title에 저장
                book.setAuthor(rs.getString("author")); // "author" 컬럼 값을 book.author에 저장
                book.setPrice(rs.getInt("price"));      // "price" 컬럼 값을 book.price에 저장

                // 리스트에 이 Book 객체를 추가
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 실행 중 문제 발생 시 출력
        }

        // 최종적으로 Book 객체들이 담긴 리스트 반환
        return list;
    } // end of findAll
}