package Lobby_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Default.Default_Socket;
import Main_Screen.Main_Background;
import Util.SendServer;

public class Lobby_FriendsList_Button extends Default_Button_Event{
	// 친구 목록을 보여주는 버튼이다. 
	private ImageIcon FriendsList_Button = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_FRIENDSLIST_BUTTON.png"));
	private ImageIcon FriendsList_Button_Enter = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_FRIENDSLIST_BUTTON_ENTER.png"));
	private Lobby_Background LB;
	private Default_Frame DF;
	public Lobby_FriendsList_Button(Default_Frame DF) {
		this.DF = DF;
		setIcon(FriendsList_Button);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(1235,162, FriendsList_Button.getIconWidth(), FriendsList_Button.getIconHeight());
		addMouseListener(this);
		setVisible(true);		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(FriendsList_Button_Enter);//흰색으로 바뀜
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(FriendsList_Button);// 다시 원상태로
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Lobby_Background.FS.setVisible(true);
		Lobby_Background.PS.setVisible(false);
		
		SendServer.SendData(Default_Socket.getOutData(),"Friend");
	}
}
