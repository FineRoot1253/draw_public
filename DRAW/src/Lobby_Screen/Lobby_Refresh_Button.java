package Lobby_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Default.Default_Socket;
import Main_Screen.Main_Background;
import Room_Screen.Room_Background;
import Util.ReceiveServer;
import Util.SendServer;

public class Lobby_Refresh_Button extends Default_Button_Event{
	// 로비의 방목록을 새로고침 해주는 버튼 
	private ImageIcon REFRESH_IN = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_REFRESH_BUTTON.png"));
	private ImageIcon REFRESH_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_REFRESH_BUTTON_ENTER.png"));
	private Default_Frame DF;
	
	public Lobby_Refresh_Button(ImageIcon icon, Default_Frame DF) {
		this.DF = DF;
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(1147,250, icon.getIconWidth(), icon.getIconHeight());
		addMouseListener(this);
		
	}
	
	public void mouseEntered(MouseEvent e) {
		setIcon(REFRESH_ENTER);//흰색으로 바뀜
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(REFRESH_IN);// 다시 원상태로
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {
		SendServer.SendData(Default_Socket.getOutRoomInfo(), "reload");
	}
}
