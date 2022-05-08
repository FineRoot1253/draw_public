package Create_screen;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JTextField;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Default.Default_Socket;
import Lobby_Screen.Lobby_Background;
import Login_Screen.Login_Background;
import Main_Screen.Main_Background;
import Room_Screen.Room_Background;
import Util.Check;
import Util.SendServer;

public class Create_Button extends Default_Button_Event{
	// 방생성 화면의 생성을 나타내는 버튼 
	private ImageIcon CREATE_IN = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/CREATE/CREATE_CREATE_BUTTON_IN.png"));
	private ImageIcon CREATE_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/CREATE/CREATE_CREATE_BUTTON_ENTER.png"));
	
	private Default_Frame DF;
	public Create_Button(ImageIcon icon, Default_Frame DF) {
		this.DF = DF;
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(25,575, icon.getIconWidth(), icon.getIconHeight());
		addMouseListener(this);
		
	}
	public void mouseEntered(MouseEvent e) {
		setIcon(CREATE_ENTER);//흰색으로 바뀜
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(CREATE_IN);// 다시 원상태로
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(!Check.CheckString(Create_Background.CREATE_TextField.getText())){
			SendServer.SendData(Default_Socket.getOutRoomInfo(), "Create");

			SendServer.SendData(Default_Socket.getOutRoomInfo(), Create_Background.CREATE_TextField.getText());
			Create_Background.CREATE_TextField.setText("");
			SendServer.SendData(Default_Socket.getOutData(), "InRoom");
			SendServer.SendData(Default_Socket.getOutData(), "InRoomInfo");
			DF.getContentPane().removeAll();
			DF.add(new Room_Background(DF));
			DF.revalidate();
		}
	}
}
