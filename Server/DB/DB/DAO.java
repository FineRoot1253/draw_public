package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DAO {
	String driver = "org.mariadb.jdbc.Driver";// 드라이버
	Connection con = null;// 커넥션 객체
	PreparedStatement pstmt = null;// sql 명령에 사용되는 객체
	ResultSet rs = null;// 명령문세팅에 사용되는 객체
	String name;
	public DAO() {
		con=getConn();
	}
	public Connection getConn() {
		// db연결시도메서드
		try {
			Class.forName(driver);// 보통 드라이버의 종류를 적게된다
		} catch (ClassNotFoundException e) {// 주로 이것은 오타가 나거나 라이브러리 미설치시 발생함
			System.out.println("드라이버 접속 실패");
		}
		try {// 순서대로 db종류, 아이피, 포트, db이름, db유저아이디, db유저패스워드이다
			con = DriverManager.getConnection("jdbc:mariadb://???.???.???.???:????/????", "????", "????");
			if (con != null) {
				System.out.println("DB 접속 성공");
			}
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
			e.printStackTrace();
		}

		return con;
	}


	public void dbclose() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}









