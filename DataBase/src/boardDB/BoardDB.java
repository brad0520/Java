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

		// �뜲�씠�꽣踰좎씠�뒪 �뿰寃�
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/BoardDB?serverTimezone=UTC";
		String user = "root";
		String pass = "";
		Class.forName(driver); 
		Connection conn = DriverManager.getConnection(url, user, pass); 

		// BoardDB 湲곕뒫 援ы쁽
		while (true) {
			System.out.print("紐낅졊�뼱瑜� �엯�젰�빐二쇱꽭�슂 : ");
			String cmd = sc.nextLine();

			if (cmd.equals("list")) {

				String sql = "SELECT * FROM article";
				// 議고쉶�븳 �뜲�씠�꽣瑜� rs�뿉 ���옣
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

				System.out.print("�젣紐� : ");
				String title = sc.nextLine();
				System.out.print("�궡�슜 : ");
				String body = sc.nextLine();
				String regDate = Util.getCurrentDate();

				String sql = "INSERT INTO article SET title = ?, `body` = ?, writer = '�솉湲몃룞', regDate = ?, hit = 10";
				PreparedStatement pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, title);
				pstmt.setString(2, body);
				pstmt.setString(3, regDate);
				
				// 異붽��맂 �뜲�씠�꽣瑜� �뜲�씠�꽣踰좎씠�뒪�뿉 ���옣 �떎�뻾
				pstmt.executeUpdate();

			} else if (cmd.equals("update")) {
				System.out.print("踰덊샇 : ");
				int id = Integer.parseInt(sc.nextLine());

				String sql = "select * from article where id = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);

				pstmt.setInt(1, id);
				// �슂泥��맂 �뜲�씠�꽣瑜� rs�뿉 ���옣
				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					// 寃뚯떆臾� 踰덊샇媛� �엳�뒗 寃쎌슦 �떎�뻾
					System.out.print("�젣紐� : ");
					String title = sc.nextLine();
					System.out.print("�궡�슜 : ");
					String body = sc.nextLine();

					String sql2 = "UPDATE article SET title = ?, `body` = ? WHERE id = ?";
					PreparedStatement pstmt2 = conn.prepareStatement(sql2);

					pstmt2.setString(1, title);
					pstmt2.setString(2, body);
					pstmt2.setInt(3, id);
					// 蹂�寃쎈맂 �뜲�씠�꽣瑜� �뜲�씠�꽣踰좎씠�뒪�뿉 �뾽�뜲�씠�듃
					pstmt2.executeUpdate();

				} else { // 寃뚯떆臾� 踰덊샇媛� �엳�뒗 寃쎌슦 �떎�뻾 
					System.out.println("�뾾�뒗 寃뚯떆臾쇱엯�땲�떎.");

				}
			} else if (cmd.equals("delete")) {
				System.out.print("踰덊샇 : ");
				int id = Integer.parseInt(sc.nextLine());

				String sql = "select * from article where id = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);

				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					String sql2 = "delete from article WHERE id = ?";
					PreparedStatement pstmt2 = conn.prepareStatement(sql2);

					pstmt2.setInt(1, id);

					// �뜲�씠�꽣 �궘�젣 �떎�뻾
					pstmt2.executeUpdate();

				} else {
					System.out.println("�뾾�뒗 寃뚯떆臾쇱엯�땲�떎.");
				}
			}
			else if(cmd.equals("read")){
				System.out.print("踰덊샇 : ");
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

					System.out.println("踰덊샇 : " + id2);
					System.out.println("�젣紐� : " + title);
					System.out.println("�궡�슜 : " + body);
					System.out.println("�옉�꽦�옄 : " + writer);
					System.out.println("�벑濡앸궇吏� : " + regDate);
					System.out.println("議고쉶�닔 : " + hit);

				} else {
					System.out.println("�뾾�뒗 寃뚯떆臾쇱엯�땲�떎.");
				}
			}
		}
	}
}
