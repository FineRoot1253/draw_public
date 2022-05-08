package DB;

public class ROOMDAO extends DAO{
	private ROOMDAO() {
		super();
	}
	public static class Singleton {
		// 인스턴스를 하나만 만들겠다는 생각에 추가됨 덕분에 static를 도배 안해도됨
		private static final ROOMDAO instance = new ROOMDAO();
	}
	public static ROOMDAO getInstance() {
		return Singleton.instance;
	}
	public boolean insert(String id, String nickName,int manNum) {
		//  룸테이블 추가 메소드 , 사용후 접속 현황 테이블 업데이트 해야함
		boolean ok = false;
		
		try {
			// System.out.println(id + name); 콘솔확인용
			String sql = "insert into TB_ROOM (" + "ro_ch,ro_num,ro_people) " + "values(?,?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, nickName);
			pstmt.setInt(3, manNum);
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

	public boolean update(String id, int op1, int op2) {
		// 인게임내 회원 룸입장, 룸퇴장을 위해 존재함, 인원수 업데이트가 주로 쓰일거라 생각함
		boolean ok = false;

		try {
			// System.out.println(id + pwd + name); 테스트콘솔확인용
			String sql = "update TB_ROOM set ro_people =?" + " where ro_ch=? and ro_num=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, op1); // 변경된 사람수
			pstmt.setInt(2, op2); //  찾는 방의 채널
			pstmt.setString(3, id); //  찾는 방의 번호
			int r = pstmt.executeUpdate();
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
