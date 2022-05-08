package DB;

import java.util.HashMap;

public class BFDAO extends DAO{
	private BFDAO() {
		super();
	}
	public static class Singleton {
		// 인스턴스를 하나만 만들겠다는 생각에 추가됨 덕분에 static를 도배 안해도됨
		private static final BFDAO instance = new BFDAO();
	}

	public static BFDAO getInstance() {
		return Singleton.instance;
	}
	public boolean insert(String id, String nickName) {
		// 친구 추가
		boolean ok = false;

		try {
			// System.out.println(id + name); 콘솔확인용
			
			String sql = "SELECT m.nickName, b.bf_nickName FROM (SELECT nickName FROM TB_MEMBER WHERE nickName =?) m left join (SELECT bf_nickName FROM TB_BF WHERE bf_id=?) b ON m.nickName=b.bf_nickName";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nickName);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("nickName").equals(nickName)) {
					if(rs.getString("bf_nickname")!=null) {
						System.out.println("This User is already your friend");
					}else {
						sql = "insert into TB_BF (" + "bf_id,bf_nickName) " + "values(?,?)";
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, id);
						pstmt.setString(2, nickName);
						int r = pstmt.executeUpdate();
						if (r > 0) {
							System.out.println("추가 성공");
							ok = true;
						} else {
							System.out.println("추가 실패");
						}
					}
					
				}
					System.out.println("login succeeded");
					ok = true;
				
			} else {
				System.out.println("This nickname is not exist, Please checkout nickname");
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}

	public boolean delete(String id, String nickName) {
		// 행삭제 메서드 ,친구 목록 삭제가 디폴트, 오버라이딩으로 사용 가능
		boolean ok = false;

		try {
			// System.out.println(id + pwd + name); 테스트콘솔확인용
		
			String sql = "delete from TB_BF where bf_id=? and bf_nickName=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, nickName);
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

	public HashMap<String, Integer> selectBF(String id) {
		// 접속 현황 테이블의 접속 여부를 조인하여 친구 목록 불러오기
		HashMap<String, Integer> bf_map = new HashMap<>();
		try {
		
			String sql = "select b.bf_nickName, s.member_state from TB_BF b join (SELECT s.st_id, s.member_state, m.nickName FROM TB_MEMBER m join TB_STATE s on m.id=s.st_id) s on bf_id=? and b.bf_nickName=s.nickName";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bf_map.put(rs.getString("b.bf_nickName"), rs.getInt("s.member_state"));
			}
		} catch (Exception e) {
			System.out.println(e + "예외발생");
		}
		
		System.out.println(bf_map.toString());
		return bf_map;
	}
}
