package Lobby_Screen;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import AddFriends_screen.AddFriends_Background;
import Create_screen.Create_Background;
import Create_screen.FriendsList_Button;
import Create_screen.PlayList_Button;
import Create_screen.User_List;
import Default.Default_Frame;
import Default.Default_ScrollBar_UI;
import Main_Screen.Main_Background;

public class Lobby_Background extends JPanel {
	// 로비 화면을 그려주는 패널 
	public static boolean Select = false;
	public static boolean Select1 = false;
	private Image Lob_Background = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_SCREEN.png")).getImage();
	private ImageIcon LOBBY_BACK = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_BACK.png"));
	private ImageIcon LOBBY_IN = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_SETTING.png"));
	private ImageIcon ADDFREIDNS = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_ADDFRIENDS.png"));
	private ImageIcon REFRESH_IN = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_REFRESH_BUTTON.png"));
	private ImageIcon CREATE = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_CREATE_BUTTON.png"));
	
	private Default_Frame DF;
	private Lobby_Back_Button LBB;  
	private Lobby_Setting_Button LSB;
	private Lobby_Chat LC;
	private Lobby_AddFriends_Button LAB;
	private static AddFriends_Background AB;
	public static Play_List PL;
	private Lobby_Refresh_Button LRB;
	private Lobby_Create_Buttonn LCB;
	private static Create_Background CB;
	public static PlayerList_screen PLS;
	public Lobby_FriendsList_Button LFB;
	public Lobby_UserList_Button LUB;
	public Lobby_PlayList_Scroll LPS;
	public static PlayerList_Scroll PS;
	public static FriendsList_Screen FLS;
	public static FriendsList_Scroll FS;
	private static JTextField JT;
	public Lobby_Background(Default_Frame DF) {

		this.DF = DF;
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);
		setLayout(null); 
		LBB = new Lobby_Back_Button(LOBBY_BACK, DF);
		LSB = new Lobby_Setting_Button(LOBBY_IN, DF);
		LAB = new Lobby_AddFriends_Button(ADDFREIDNS, this);
		LRB = new Lobby_Refresh_Button(REFRESH_IN, DF);
		LCB = new Lobby_Create_Buttonn(CREATE, this);
		AB = new AddFriends_Background(DF);
		CB = new Create_Background(DF);
		LC = new Lobby_Chat();	
		PL = new Play_List();
		PLS = new PlayerList_screen();
		LFB = new Lobby_FriendsList_Button(DF);
		LUB = new Lobby_UserList_Button(DF);
		LPS = new Lobby_PlayList_Scroll();
		PS = new PlayerList_Scroll();
		FLS = new FriendsList_Screen();
		FS = new FriendsList_Scroll();
		JT = LC.getChat_TextField();
		
		add(LFB);
		add(LSB);
		add(LUB);
		add(LBB);		
		add(LAB);
		add(AB);
		add(CB);
		add(LRB);
		add(LCB);
		add(FS);
		add(LPS);
		add(PS);
		add(LC);
		
		CB.setVisible(false);
		AB.setVisible(false);
		thread.UserInfo.getUserInfo();
		
	}
	public static JTextField getJT () {
		return JT;
	}
	public static void AddfriendsSetvisible() {
		// 친구추가 화면의 출력 상태를 바꿔주는 메소드
		Select = !Select;
		AB.setVisible(Select);
	}
	public static void CreateSetvisible() {
		// 방생성 화면의 출력 상태를 바꿔주는 메소드 
		Select1 = !Select1;
		CB.setVisible(Select1);
	}

	public static void AddUserlistButton(String userName) {
		PLS.add(new User_List(userName));
		PLS.revalidate();
		PLS.repaint();
		
	}
	
	public static void AddFriendlistButton(String userName, int state) {
		FLS.add(new FriendsList_Button(userName, state));
		FLS.revalidate();
		FLS.repaint();
	}
	
	public static void AddPlaylistButton(String roomName, int roomNum, Default_Frame DF) {
		// 방 목록을 만들어 주는 메소드 
		PL.add(new PlayList_Button(roomName,roomNum,DF));
		PL.revalidate();
		PL.repaint();
	}
	public void paintComponent(Graphics g) {
		g.drawImage(Lob_Background, 0, 0, this.getWidth(), this.getHeight(), this);
	}

}
