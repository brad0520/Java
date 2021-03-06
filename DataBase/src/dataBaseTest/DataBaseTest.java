package dataBaseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// // =======================================DB 세팅=========================================
		
		// 드라이버 정보
		String driver = "com.mysql.cj.jdbc.Driver";
		// dbms 주소
		String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC"; // mysql에 작성해둔 데이터 베이스가 미리 준비되야함
		// 사용자 계정
		String user = "root";
		// 사용자 비밀번호
		String pass = "";
		Class.forName(driver); // Driver 세팅
		Connection conn = DriverManager.getConnection(url, user, pass); // DBMS 선택 -> 담당자(Connection) 부여받음

		// =========================================조회===========================================
		String sql = "SELECT * FROM article";
		
		PreparedStatement pstmt = conn.prepareStatement(sql); // PreparedStatment 통해서 sql 세팅
		
		ResultSet rs = pstmt.executeQuery(); // 조회 결과가 있는 경우
		//pstmt.executeUpdate(); // 조회 결과가 없는 경우
		
		while(rs.next()) {
			
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String body = rs.getString("body");
			String nickname = rs.getString("nickname");
			int hit = rs.getInt("hit");
			
			System.out.println(id + " " + title + " " + body + " " + nickname + " " + hit);			
		}
		
		// =========================================삽입===========================================
		String sql2 = " INSERT INTO article SET title = ?, `body` = ?, nickname = 'Brad', hit = 100";
		PreparedStatement pstmt2 = conn.prepareStatement(sql2);
		
		pstmt2.setString(1, "제목7");
		pstmt2.setString(2, "내용7");		
		
		pstmt2.executeUpdate();
		
	}

}
