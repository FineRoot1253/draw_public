package Lobby_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Main_Screen.Main_Background;
import Room_Screen.Room_Background;

public class Lobby_Join_Button extends Default_Button_Event{
	// 로비에서 방목록을 눌러 들어가는 버튼 
	private ImageIcon LOBBY_IN = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_JOIN.png"));
	private ImageIcon LOBBY_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_JOIN_ENTER.png"));
	private Default_Frame DF;
	
	public Lobby_Join_Button(ImageIcon icon, Default_Frame DF) {
		this.DF = DF;
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(1225,790, icon.getIconWidth(), icon.getIconHeight());
		addMouseListener(this);
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(LOBBY_ENTER);//흰색으로 바뀜
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(LOBBY_IN);// 다시 원상태로
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {
		DF.getContentPane().removeAll();
		DF.add(new Room_Background(DF));//Select_Background 패널 불러옴 
		DF.revalidate();
	}
}
