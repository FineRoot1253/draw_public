package Login_Screen;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Default.Default_Frame;
import Default.Default_Socket;
import Lobby_Screen.Lobby_Background;
import Main_Screen.Main_Background;
import Util.AccessServer;
import Util.SendServer;
import thread.ChatThread;
import thread.RoomInfo;
import thread.UserInfo;

public class Login_Background extends JPanel{
	// 로그인 화면을 나타내는 클래스
	private Image Log_Background = new ImageIcon(Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_SCREEN.png")).getImage();
	private ImageIcon LOGIN_BACK = new ImageIcon(Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_BACK.png"));
	private ImageIcon LOGIN_BACK_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_BACK_ENTER.png"));
	private ImageIcon LOGIN_IN = new ImageIcon(Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_IN.png"));
	private ImageIcon LOGIN_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_ENTER.png"));
	private Default_Frame DF;
	private JTextField ID_TextField = new JTextField(); // 아이디 받아오기 위해 수정 private -> public static
	private JPasswordField PW_TextField = new JPasswordField(); // 패스워드 받아오기 위해 수정 private -> public static
	private Login_Back_Button LBB;
	private Login_Button LB;
	
	public Login_Background(Default_Frame DF) {
		this.DF = DF;
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);
		setLayout(null); 
		LBB = new Login_Back_Button(LOGIN_BACK, DF);
		LB = new Login_Button(LOGIN_IN,DF,this);
		add(LB);	
		add(LBB);
		add(ID_TextField);
		add(PW_TextField);
		ID_TextField.setBounds(880, 365, 400, 100); // 아이디적는 텍스트 필드 생성
		ID_TextField.setBorder(null); // 택스트 필드 투명화
		ID_TextField.setFont(new Font("Bernard MT",Font.HANGING_BASELINE,50)); // 폰트 지정 
		ID_TextField.setOpaque(false);
		PW_TextField.setBounds(880, 610, 400, 100);
		PW_TextField.setBorder(null);
		PW_TextField.setFont(new Font("Bernard MT",Font.HANGING_BASELINE,50));
		PW_TextField.setOpaque(false);
		setVisible(true);
		
		AccessServer.AccessUserInfo();
		
		SendServer.SendData(Default_Socket.getOutData(), "login");
	}
	
	public void paintComponent(Graphics g) {

		g.drawImage(Log_Background, 0, 0, this.getWidth(), this.getHeight(), this);

	}

	public void setTextField() {
		ID_TextField.setText("");
		PW_TextField.setText("");
	}

	public String[] getInfo() {
		String[] info = {ID_TextField.getText(),PW_TextField.getText()};
		
		return info;
	}
}
