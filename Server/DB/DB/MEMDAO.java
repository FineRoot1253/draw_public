package DB;

import java.sql.SQLException;

public class MEMDAO extends DAO {
	private MEMDAO() {
		super();
	}
	public static class Singleton {
		// 인스턴스를 하나만 만들겠다는 생각에 추가됨 덕분에 static를 도배 안해도됨
		private static final MEMDAO instance = new MEMDAO();
	}

	public static MEMDAO getInstance() {
		return Singleton.instance;
	}
	public boolean delete(String id, String name) {
	// 행삭제 메서드 ,친구 목록 삭제가 디폴트, 오버라이딩으로 사용 가능
	boolean ok = false;

	try {
		// System.out.println(id + pwd + name); 테스트콘솔확인용
		String sql = "delete from TB_MEMBER where bf_id=? and bf_nickName=?";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, name);
		int r = pstmt.executeUpdate();
		if (r > 0) {
			System.out.println("삭제 성공");
			ok = true;
		} else {
			System.out.println("삭제 실패");
		}
		

	} catch (Exception e) {
		e.printStackTrace();
	}

	return ok;
}
	public boolean selectMEM(String id, String pwd) {
	// select와 같은 메서드 , 로그인기능이 디폴트임 , 오버라이딩 사용가능
	boolean ok = false;
	try {

		String sql = "select pwd, name from TB_MEMBER where id=?";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery(); // ���� -> ����
		if (rs.next()) {
			if (pwd.equals(rs.getString("pwd"))) {
				System.out.println("login succeeded");
				name = rs.getString("name");
				ok = true;
			} else {
				System.out.println("Wrong password, Login Failed");
			}
		} else {
			System.out.println("UserName does not exist, Login Failed");
		}
	} catch (Exception e) {
		System.out.println(e + "예외발생");
	}
	
	return ok;
}
	public boolean insertMEM(String id, String pwd, String name, String nickName, String birth) {
	// 삽입 메서드 , 친구 추가가 디폴트 , 이후 방테이블추가 메서드등등으로 오버라이딩 해서 사용 가능
	boolean ok = false;

	try { 
		//  birth는 '년도-월-일' 이 형식을 유지해야함
		//  System.out.println(id + name); 콘솔확인용
		String sql = "select nickName from TB_MEMBER WHERE nickName = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,nickName);
		rs = pstmt.executeQuery();
		if(rs.next())  {
			if(rs.getString("nickName").equals(nickName))
				System.out.println(nickName + " is already exist, try again");
				return ok;
		} else {
			System.out.println("NickName can be use, you can use this id");
			ok = true;
		}
		
		sql = "insert into TB_MEMBER (id,pwd,name,nickName,birth) values(?,?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		pstmt.setString(3, name);
		pstmt.setString(4, nickName);
		pstmt.setDate(5, java.sql.Date.valueOf(birth));
		try {
		int r = pstmt.executeUpdate();
			System.out.println("가입 성공");
			ok = true;
		}catch(SQLException e) {
			if(e.getErrorCode()==1062) {
				System.out.println("this " + id + " is already exist, try another one please");
				ok = false;
				return ok;
			}else {
				System.out.println("원인을 알 수 없는 이유로 가입 실패...");
				ok = false;
				return ok;
			}
		}

	} catch (Exception e) {
		e.printStackTrace();
	}

	return ok;
}
	public boolean deleteMEM(String id, String nickName) {
		// 회원탈퇴시 필수
		boolean ok = false;

		try {
			// System.out.println(id + pwd + name); 테스트콘솔확인용
			String sql = "delete from TB_MEMBER where st_id=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			int r = pstmt.executeUpdate();
			if (r > 0) {
				System.out.println("삭제 성공");
				ok = true;
			} else {
				System.out.println("삭제 실패");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}
	public boolean selectAge() {
		// 나이 계산 메소드
		boolean ok = false;
	

		try {
		
			String sql = "select floor(datediff (now(), birth)/365) as age";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getInt("age") > 20) {
					System.out.println("login succeeded");
					ok = true;
				} else {
					System.out.println("Your age is not allowed , Please checkout our Policy");
				}
			}
			

		} catch (Exception e) {
			System.out.println(e + "-> 예외발생");
		}
		return ok;

	}
	public String selectNick(String id) {
		// select와 같은 메서드 , 로그인기능이 디폴트임 , 오버라이딩 사용가능
		try {
		// 내부 조인 사용함

			String sql = "select nickName, name from TB_MEMBER where id=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); // ���� -> ����
			if (rs.next()) {
					return rs.getString("nickName");
	
			} else {
				System.out.println("UserName does not exist");
			}
		} catch (Exception e) {
			System.out.println(e + "예외발생");
		}
		
		return "null";
	}
	public boolean selectRed(String id) {
		// 중복 검사 메소드
		boolean ok = false;
	

		try {
		
			String sql = "select id from TB_MEMBER where id=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getString("id") + " is already exist, try again");
			} else {
				System.out.println("UserName does not exist, you can use this id");
				ok = true;
			}
			

		} catch (Exception e) {
			System.out.println(e + "-> 예외발생");
		}
		return ok;
	}
}
