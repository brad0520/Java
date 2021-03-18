package dataBaseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BroadApp {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);

		// 데이터베이스 연결
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC"; 
		String user = "root";
		String pass = "";
		Class.forName(driver); 
		Connection conn = DriverManager.getConnection(url, user, pass); 

		// BoardApp 기능 구현
		while (true) {
			System.out.print("명령어를 입력해주세요 : ");
			String cmd = sc.nextLine();

			if (cmd.equals("list")) {
				String sql = "SELECT * FROM article";

				PreparedStatement pstmt = conn.prepareStatement(sql);

				ResultSet rs = pstmt.executeQuery(); 

				while (rs.next()) {
					
					int id = rs.getInt("id");
					String title = rs.getString("title");
					String body = rs.getString("body");
					String nickname = rs.getString("nickname");
					int hit = rs.getInt("hit");
					
					System.out.println(id + " " + title + " " + body + " " + nickname + " " + hit);
				}
			} else if (cmd.equals("add")) {
				System.out.print("제목 : ");
				String title = sc.nextLine();
				System.out.print("내용 : ");
				String body = sc.nextLine();
				
				String sql2 = " INSERT INTO article SET title = ?, `body` = ?, nickname = 'Brad', hit = 100";
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);

				pstmt2.setString(1, title);
				pstmt2.setString(2, body);
				
				pstmt2.executeUpdate();
			}

		}
	}
}