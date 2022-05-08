package Lobby_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Main_Screen.Main_Background;

public class Lobby_UserList_Button extends Default_Button_Event{
	// 유저 리스트를 보여주게 하는 버튼이다. 
	private ImageIcon USERLIST = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_USERLIST_BUTTON.png"));
	private ImageIcon USERLIST_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_USERLIST_BUTTON_ENTER.png"));
	private Default_Frame DF;
	public Lobby_UserList_Button(Default_Frame DF) {
		this.DF = DF;
		setIcon(USERLIST);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(1235,85, USERLIST.getIconWidth(), USERLIST.getIconHeight());
		addMouseListener(this);
		setVisible(true);	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(USERLIST_ENTER);//흰색으로 바뀜
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(USERLIST);// 다시 원상태로
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Lobby_Background.PS.setVisible(true);
		Lobby_Background.FS.setVisible(false);
	}

}
