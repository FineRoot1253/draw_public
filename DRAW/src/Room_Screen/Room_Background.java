package Room_Screen;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import Default.Default_Frame;
import Default.Default_Socket;
import Gameboard_Screen.GameBaord_Background;
import Main_Screen.Main_Background;
import Util.SendServer;

public class Room_Background extends JPanel{
	private Image Rom_Background = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/ROOM_SCREEN.png")).getImage();
	private ImageIcon ROOM_BACK = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/ROOM_BACK.png"));
	private ImageIcon ROOM_IN = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/ROOM_START.png"));
	private static ImageIcon USER_LIST_BUTTON_READY = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/ROOM_PLAYER_READY.png"));
	private static ImageIcon USER_LIST_BUTTON = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/ROOM_PLAYER.png"));
	private Room_Chat RC;
	private Default_Frame DF;
	private Room_Back_Button RBB;
	private static Room_Start_Button RSB;
	private static Room_UserList RUL;
	private static boolean CanStart = false; 
	private static Room_Ready_Button RRB;
	public Room_Background(Default_Frame DF) {
		this.DF = DF;
		RC = new Room_Chat();
		RUL = new Room_UserList();
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// ũ�� ����
		setLayout(null); 
		RBB= new Room_Back_Button(ROOM_BACK, DF);
		RSB= new Room_Start_Button(ROOM_IN, DF);
		RRB = new Room_Ready_Button();
		add(RC);
		add(RSB);	
		add(RBB);	
		add(RRB);
		add(RUL);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(Rom_Background, 0, 0, this.getWidth(), this.getHeight(), this);

	}
	public static void ClearUser() {
		for (int i = 0; i < 5; i++) {
			Room_UserList.getButton(i).setIcon(USER_LIST_BUTTON);
			Room_UserList.getButton(i).setText("");
			Room_UserList.getButton(i).setHorizontalTextPosition(JButton.CENTER);
			Room_UserList.getButton(i).setFont(new Font("굴림체", Font.BOLD, 45));
		}
		RUL.revalidate();
		RUL.repaint();
	}
	public static void SetUser(int Num, String Name, String Ready){
		
		
		if(Ready.equals("true")) {
			Room_UserList.getButton(Num).setIcon(USER_LIST_BUTTON_READY);
			Room_UserList.getButton(Num).setText(Name);
			Room_UserList.getButton(Num).setHorizontalTextPosition(JButton.CENTER);
			Room_UserList.getButton(Num).setFont(new Font("굴림체", Font.BOLD, 45));
			
		}
		else {
		Room_UserList.getButton(Num).setIcon(USER_LIST_BUTTON);
		Room_UserList.getButton(Num).setText(Name);
		Room_UserList.getButton(Num).setHorizontalTextPosition(JButton.CENTER);
		Room_UserList.getButton(Num).setFont(new Font("굴림체", Font.BOLD, 45));
		}
		RUL.revalidate();
		RUL.repaint();
	}
	public static void OnReady(int Num) {
		Room_UserList.getButton(Num).setIcon(USER_LIST_BUTTON_READY);
		RUL.revalidate();
		RUL.repaint();
	}
	public static void OffReady(int Num) {
		Room_UserList.getButton(Num).setIcon(USER_LIST_BUTTON);
		RUL.revalidate();
		RUL.repaint();
	}

	public static void setCanStart() {
		CanStart = true;
		RSB.setVisible(true);
		RRB.setVisible(false);
	}
	public static void setCantStart() {
		CanStart = false;
		RSB.setVisible(false);
		RRB.setVisible(true);
	}
	public static boolean getCanStart() {
		return CanStart;
	}
	public static void gameStart() {
		Default_Frame.getDF().getContentPane().removeAll();
		Default_Frame.getDF().add(new GameBaord_Background(Default_Frame.getDF()));//Select_Background
		Default_Frame.getDF().revalidate();
		SendServer.SendData(Default_Socket.getOutData(),"InGame");
		SendServer.SendData(Default_Socket.getOutRoomInfo(),"InGame");
	}
}
