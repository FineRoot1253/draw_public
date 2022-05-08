package Login_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.ImageIcon;
import Default.Default_Button_Event;
import Default.Default_Frame;
import Default.Default_Socket;
import Lobby_Screen.Lobby_Background;
import Main_Screen.Main_Background;
import Util.AccessServer;
import Util.Check;
import Util.ReceiveServer;
import Util.SendServer;
import thread.ChatThread;
import thread.RoomInfo;
import thread.UserInfo;

public class Login_Button extends Default_Button_Event {
	// 로그인을 인식하고 로그인이 된다면 로비로 보내는 버튼 
	private ImageIcon LOGIN_IN = new ImageIcon(Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_IN.png"));
	private ImageIcon LOGIN_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_ENTER.png"));
	private Default_Frame DF;
	private Login_Background LB;
	
	public Login_Button(ImageIcon icon, Default_Frame DF, Login_Background LB) {
		this.LB = LB;
		this.DF = DF;
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);

		setBounds(1158,710, icon.getIconWidth(), icon.getIconHeight());
		addMouseListener(this);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(LOGIN_ENTER);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(LOGIN_IN);
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	
		String[] value = LB.getInfo();
	
		if(Check.CheckValue(value)) 
			SendServer.SendData(Default_Socket.getOutData(), value[0] + ":" + value[1]);
		
		LB.setTextField();
		System.out.println("ID PASS 일치");
		String awnser = ReceiveServer.ReceiveData(Default_Socket.getInData()); //Default_Socket.getInData().readUTF();
		System.out.println(awnser);
		if (awnser.equals("LoginAccept")) { // 로그인 성공
			AccessServer.AccessRoomChat();
			DF.getContentPane().removeAll();
			DF.add(new Lobby_Background(DF));
			DF.revalidate();
			
			ChatThread CT = new thread.ChatThread();
			RoomInfo LR = new RoomInfo(DF);
			UserInfo UI = new UserInfo();
		} else
			// 로그인 실패
			System.out.println("로그인 실패");
		
	}
}
