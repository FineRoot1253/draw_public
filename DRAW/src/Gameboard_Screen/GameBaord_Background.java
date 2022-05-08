package Gameboard_Screen;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Default.Default_Frame;
import Default.Default_Socket;
import Main_Screen.Main_Background;
import Room_Screen.Room_Background;
import Util.Commend;
import Util.SendServer;
import gameCharacter_Screen.Position_Screen;
import thread.InRoom_UserInfo;
import thread.RoomInfo;


public class GameBaord_Background extends JPanel{
	// 게임 화면을 나타내는 패널 
	private static boolean Fightingmood = false;
	private static boolean VarietyStoremood =false;
	private static boolean Bangmood = false;
	private static GameBaord_Background GBB;
	private static boolean myTurn;
	private static boolean phase2;
	private static ArrayList<String> AttackList = new ArrayList<String>();
	private static boolean phase3;
	private static boolean ChooseEnemy = false;
	private static int UserNum;
	private Image GameBaord_Background = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/GAMEBOARD_SCREEN.png")).getImage();
	private Default_Frame DF;
	private Game_Chat GC;
	private Finishi_Button FB;
	private static Weather_Screen WS;
	private static Score_Screen SS;
	private static Imformation_Screen IS;
	private static ExpansionCard_Screen ECS;
	private Card_Screen CS;
	private static Finishi_Button FinishB;
	private static Card_Screen CardS;
	private Position_Screen PoS;
	private static Rolling_Button RB;
	private PlayerTurn_Screen PTS;
	private static MoveLeft_Button MLB;
	private static MoveRight_Button MRB;
	private static Use_Card_Screen UCS;
	private static String player_name=""; //  수정했음
	private static String player_hp=""; //  
	private static boolean use = false;
	private static Overlap_Player_Imformation OPI;
	private static Overlap_Player_Screen OPS;
	private static Result_Screen RS;
	private Use_VarietyStore_Screen UVS;
	
	public GameBaord_Background(Default_Frame DF) {
		this.DF = DF;
		GBB = this;
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// Å©±â °íÁ¤
		setLayout(null); 
		GC = new Game_Chat();
		FB = new Finishi_Button();
		WS = new Weather_Screen();
		SS = new Score_Screen();
		IS = new Imformation_Screen();
		CS = new Card_Screen();
		PoS = new Position_Screen();
		RB = new Rolling_Button(this);
		PTS = new  PlayerTurn_Screen();
		MLB = new MoveLeft_Button();
		MRB = new MoveRight_Button();
		UCS = new Use_Card_Screen();
		FinishB = FB;
		CardS = CS;

		add(IS);
		add(GC);
		add(FB);
		add(WS);
		add(SS);
		add(CS);
		add(PoS);
		add(RB);
		add(PTS);
		add(MLB);
		add(MRB);
		add(UCS);
		
	}
	public void paintComponent(Graphics g) {
		g.drawImage(GameBaord_Background, 0, 0, this.getWidth(), this.getHeight(), this);

	}
	static public void MoveLR() {
		MLB.setVisible(true);
		MRB.setVisible(true);
	}
	static public void RemoveLR() {
		MLB.setVisible(false);
		MRB.setVisible(false);
	}
	
	static public void ExpansionCard(String card) {
		ECS = new ExpansionCard_Screen(card);
		GBB.add(ECS);
		GBB.revalidate();
		GBB.repaint();
		IS.setVisible(false);
	}
	static public void ExpansionCardRemove() {
		GBB.remove(ECS);
		GBB.revalidate();
		GBB.repaint();
		IS.setVisible(true);
	}
	static public void OverlapImformation(ArrayList<JLabel> names) {
		OPI = new Overlap_Player_Imformation(names);
		GBB.add(OPI);
		GBB.revalidate();
		GBB.repaint();
		IS.setVisible(false);
	}
	
	static public void RemoveOverlapImformation() {
		GBB.remove(OPI);
		GBB.revalidate();
		GBB.repaint();
		IS.setVisible(true);
	}
	static public void OverlapScreen(ArrayList<JLabel> names) {
		OPS = new Overlap_Player_Screen(names);
		GBB.add(OPS);
		GBB.revalidate();
		GBB.repaint();
	}
	static public void RemoveOverlapScreen() {
		GBB.remove(OPS);
		GBB.revalidate();
		GBB.repaint();
	}
	static public void myTurnStart() {
		myTurn = true;
		RB.setEnabled(true);
		RB.addMouseListener(RB);
		FinishB.setEnabled(true);
		FinishB.addMouseListener(FinishB);
		
	}
	static public void myTurnEnd() {
		FinishB.setEnabled(false);
		FinishB.removeMouseListener(FinishB);
		if(Position_Screen.getmany())
			OPS.removeMouseListener(OPS);
		myTurn = false;
		phase2 = false;
		phase3 = false;
	}
	static public void onPhase2() {
		phase2 = true;
	}
	static public void onPhase3() {
		phase2 = false;
		phase3 = true;
		if(Position_Screen.getmany())
			OPS.addMouseListener(OPS);
		
	}
	static public void SemiTurnStart() {
		FinishB.setEnabled(true);
		FinishB.addMouseListener(FinishB);
		setBangmood();
	}
	static public void SemiFightStart() {
		FinishB.setEnabled(true);
		FinishB.addMouseListener(FinishB);
		setFightingmood();
	}
	static public void SemiDraw() {
		FinishB.setEnabled(true);
		FinishB.addMouseListener(FinishB);
		setVarietyStoremood();
	}
	
	static public void SemiTurnEnd() {
		FinishB.setEnabled(false);
		FinishB.removeMouseListener(FinishB);
		if(isBangmood())
			setBangmood();
		if(isFightingmood())
			setFightingmood();
		if(isVarietyStoremood())
			setVarietyStoremood();
	}
	static public void Resume() {
		FinishB.setEnabled(true);
		FinishB.addMouseListener(FinishB);
	}
	static public boolean getMyTurn() {
		return myTurn;
	}
	static public boolean getPhase2() {
		return phase2;
	}
	static public boolean getPhase3() {
		return phase3;
	}
	static public boolean getChooseEnemy() {
		return ChooseEnemy;
	}
	static public void setChooseEnemy() {
		ChooseEnemy = !ChooseEnemy;
	}
	static public void cardRepaint() {
		CardS.repaint();
		CardS.revalidate();
	}
	static public void setAttackList(String Messege) {
		String[] words = Messege.split(":");
		for (int i = 1; i < words.length; i++) {
			AttackList.add(words[i]);
			
		}
		for(int i = 0; i<AttackList.size();i++)
			System.out.print("공격가능 : "+AttackList.get(i)+" ");
		
	}
	static public ArrayList<String> getAttackList() {
		return AttackList;
	}
	static public void setUserNum(int Num) {
		UserNum = Num;
	}
	static public int getUserNum() {
		return UserNum;
	}
	static public void setInfo(String name, String hp, String job) {
		IS.setProfile(name, hp, job);
		player_name=name;
		player_hp=hp;
	}
	static public void setInfo(String hp) {
		IS.setHP(hp);
	}
	static public void setTable(String table) {
		Player_Score_Screen[] PSS=SS.getPSS() ;
		String[] words = table.split(":");
		for(int i = 0; i < words.length/3;i++ ) {
			if(words[(i*3+1)].equals(player_name)&&!words[(i*3+2)].equals(player_hp))
				setInfo(words[(i*3)+2]);
			
			PSS[i].setPIF(words[(i*3)+1],words[(i*3)+2],words[(i*3)+3]);
		}
	}
	
	public static void gameEnd(Default_Frame DF) {
		SendServer.SendData(Default_Socket.getOutRoomInfo(), "End");
		Commend.sleep(100);
		Card_Screen.resetCard();
		
		new InRoom_UserInfo();
		new RoomInfo(DF);
		
		DF.getContentPane().removeAll();
		DF.add(new Room_Background(DF));
		DF.revalidate();
	}
	public static void verify() {
		UCS.setVisible(true);
	}
	public static void yes() {
		use = true;
	}
	public static void no() {
		use = false;
	}
	public static boolean getUse() {
		return use;
	}
	public static boolean isFightingmood() {
		return Fightingmood;
	}
	public static void setFightingmood() {
		Fightingmood = !Fightingmood;
	}
	public static boolean isVarietyStoremood() {
		return VarietyStoremood;
	}
	public static void setVarietyStoremood() {
		VarietyStoremood = !VarietyStoremood;
	}
	public static boolean isBangmood() {
		return Bangmood;
	}
	public static void setBangmood() {
		Bangmood = !Bangmood;
	}
	public static String getHP() {
		return player_hp;
	}
	public static void onUcs() {
		
		UCS.setVisible(true);
	}
	public static void offUcs() {
		UCS.setVisible(false);
	}
	public static Use_Card_Screen getUCS() {
		return UCS;
	}
	public static void CutSceen(String act) {
		if(act.equals("Bang"))
			System.out.println();
			//System.out.println("뱅 여기 넣으면 돼 ");
		else if(act.equals("Beer"))
			System.out.println();
			//System.out.println("Beer 여기 넣으면 돼 ");
		else if(act.equals("Avoid"))
			System.out.println();
			//System.out.println("Avoid 여기 넣으면 돼");
			
	}
	public static Weather_Screen getWS() {
		return WS;
	}

}
