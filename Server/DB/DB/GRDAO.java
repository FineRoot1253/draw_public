package DB;

public class GRDAO  extends DAO{
	private GRDAO() {
		super();
	}
	public static class Singleton {
		// 인스턴스를 하나만 만들겠다는 생각에 추가됨 덕분에 static를 도배 안해도됨
		private static final GRDAO instance = new GRDAO();
	}

	public static GRDAO getInstance() {
		return Singleton.instance;
	}
	public boolean insertGR(String id, String nickName) {
		// 최초가입시 필수 추가
		boolean ok = false;

		try {
			// System.out.println(id + name); 콘솔확인용
		
			String sql = "insert into TB_GAMERECORD ("
					+ "gr_id,gr_traitor,gr_sheriff,gr_aide,gr_desperado,gr_roundsum) " + "values(?,?,?,?,?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, 0);
			pstmt.setInt(3, 0);
			pstmt.setInt(4, 0);
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);
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
}
