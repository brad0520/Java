package boardDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BoardDB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		// 데이터베이스 연결
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/BoardDB?serverTimezone=UTC";
		String user = "root";
		String pass = "";
		Class.forName(driver); 
		Connection conn = DriverManager.getConnection(url, user, pass); 

		// BoardDB 기능 구현
		while (true) {
			System.out.print("명령어를 입력해주세요 : ");
			String cmd = sc.nextLine();

			if (cmd.equals("list")) {

				String sql = "SELECT * FROM article";
				// 조회한 데이터를 rs에 저장
				PreparedStatement pstmt = conn.prepareStatement(sql); 
				ResultSet rs = pstmt.executeQuery(); 

				while (rs.next()) {

					int id = rs.getInt("id");
					String title = rs.getString("title");
					String writer = rs.getString("writer");
					String regDate = rs.getString("regDate");
					int hit = rs.getInt("hit");

					System.out.println(id + " " + title + " " + writer + " " + regDate + " " + hit);

				}
			} else if (cmd.equals("add")) {

				System.out.print("제목 : ");
				String title = sc.nextLine();
				System.out.print("내용 : ");
				String body = sc.nextLine();
				String regDate = Util.getCurrentDate();

				String sql = "INSERT INTO article SET title = ?, `body` = ?, writer = '홍길동', regDate = ?, hit = 10";
				PreparedStatement pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, title);
				pstmt.setString(2, body);
				pstmt.setString(3, regDate);
				
				// 추가된 데이터를 데이터베이스에 저장 실행
				pstmt.executeUpdate();

			} else if (cmd.equals("update")) {
				System.out.print("번호 : ");
				int id = Integer.parseInt(sc.nextLine());

				String sql = "select * from article where id = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);

				pstmt.setInt(1, id);
				// 요청된 데이터를 rs에 저장
				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					// 게시물 번호가 있는 경우 실행
					System.out.print("제목 : ");
					String title = sc.nextLine();
					System.out.print("내용 : ");
					String body = sc.nextLine();

					String sql2 = "UPDATE article SET title = ?, `body` = ? WHERE id = ?";
					PreparedStatement pstmt2 = conn.prepareStatement(sql2);

					pstmt2.setString(1, title);
					pstmt2.setString(2, body);
					pstmt2.setInt(3, id);
					// 변경된 데이터를 데이터베이스에 업데이트
					pstmt2.executeUpdate();

				} else { // 게시물 번호가 있는 경우 실행 
					System.out.println("없는 게시물입니다.");

				}
			} else if (cmd.equals("delete")) {
				System.out.print("번호 : ");
				int id = Integer.parseInt(sc.nextLine());

				String sql = "select * from article where id = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);

				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					String sql2 = "delete from article WHERE id = ?";
					PreparedStatement pstmt2 = conn.prepareStatement(sql2);

					pstmt2.setInt(1, id);

					// 데이터 삭제 실행
					pstmt2.executeUpdate();

				} else {
					System.out.println("없는 게시물입니다.");
				}
			}
			else if(cmd.equals("read")){
				System.out.print("번호 : ");
				int id = Integer.parseInt(sc.nextLine());

				String sql = "select * from article where id = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);

				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					int id2 = rs.getInt("id");
					String title = rs.getString("title");
					String body = rs.getString("body");
					String writer = rs.getString("writer");
					String regDate = rs.getString("regDate");
					String hit = rs.getString("hit");

					System.out.println("번호 : " + id2);
					System.out.println("제목 : " + title);
					System.out.println("내용 : " + body);
					System.out.println("작성자 : " + writer);
					System.out.println("등록날짜 : " + regDate);
					System.out.println("조회수 : " + hit);

				} else {
					System.out.println("없는 게시물입니다.");
				}
			}
		}
	}
}
