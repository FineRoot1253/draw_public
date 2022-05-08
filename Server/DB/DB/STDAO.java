package DB;

public class STDAO  extends DAO{
	private STDAO() {
		super();
	}
	public static class Singleton {
		// 인스턴스를 하나만 만들겠다는 생각에 추가됨 덕분에 static를 도배 안해도됨
		private static final STDAO instance = new STDAO();
	}

	public static STDAO getInstance() {
		return Singleton.instance;
	}
	public boolean insert(String id, int member_state, int roomNum) {
		// 접속인원테이블추가(회원가입시 필수)
		boolean ok = false;

		try {
			// System.out.println(id + name); 콘솔확인용
		
			String sql = "insert into TB_STATE (" + "st_id,member_state,roomNum) " + "values(?,?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, member_state);
			pstmt.setInt(3, roomNum);
			int r = pstmt.executeUpdate();
			if (r > 0) {
				System.out.println("추가 성공");
				ok = true;
			} else {
				System.out.println("추가 실패");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}

	public boolean select() {
		// 접속 인원 목록 불러오기
		boolean ok = false;
		try {
		
			String sql = "select * from TB_STATE";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
		} catch (Exception e) {
			System.out.println(e + "예외발생");
		}
		return ok;
	}
	public int getUserstate(String id) {
		// 접속 인원 접속상태 불러오기
		try {
		
			String sql = "select member_state from TB_STATE where st_id=?";
			int i;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				i=rs.getInt("member_state");
				
				return i;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 3;
	}
	public boolean delete(String id, String nickName) {
		// 회원탈퇴시 필수
		boolean ok = false;

		try {
			// System.out.println(id + pwd + name); 테스트콘솔확인용
		
			String sql = "delete from TB_STATE where st_id=?";

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

	public boolean update(String id, int op1, int op2) {
		// 인게임내 회원 로그아웃,로그인, 룸입장, 룸퇴장등등 기반으로 필수
		boolean ok = false;

		try {
			// System.out.println(id + pwd + name); 테스트콘솔확인용
		
			String sql = "update TB_STATE set member_state =? , roomNum=? where st_id=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, op1);
			pstmt.setInt(2, op2);
			pstmt.setString(3, id);
			int r = pstmt.executeUpdate();
			System.out.println(r);
			if (r > 0) {
				System.out.println("수정 성공");
				ok = true;
			} else {
				System.out.println("수정 실패");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}
}
