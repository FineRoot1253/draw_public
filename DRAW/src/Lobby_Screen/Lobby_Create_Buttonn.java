package Lobby_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Main_Screen.Main_Background;

public class Lobby_Create_Buttonn extends Default_Button_Event{
	// 로비에서 방만드는 화면을 띄우는 버튼 
	private ImageIcon CREATE = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_CREATE_BUTTON.png"));
	private ImageIcon CREATE_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_CREATE_BUTTON_ENTER.png"));
	private Lobby_Background LB;
	private Default_Frame DF;
	
	public Lobby_Create_Buttonn(ImageIcon icon, Lobby_Background LB) {	
		this.LB = LB;
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(825,80, icon.getIconWidth(), icon.getIconHeight());
		addMouseListener(this);
		setVisible(true);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(CREATE_ENTER);//흰색으로 바뀜
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(CREATE);// 다시 원상태로
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Lobby_Background.CreateSetvisible();
	}
}
