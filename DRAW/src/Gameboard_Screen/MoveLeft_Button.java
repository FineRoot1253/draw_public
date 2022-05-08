package Gameboard_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Socket;
import Main_Screen.Main_Background;
import Util.SendServer;

public class MoveLeft_Button extends Default_Button_Event{
	// 왼쪽 으로 간다고 하는 버튼 클래스 
	private ImageIcon LEFT = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/MOVE_LEFT.png"));
	private ImageIcon LEFT_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/MOVE_LEFT_ENTER.png"));
	
	public MoveLeft_Button() {
		setIcon(LEFT);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(418,612, LEFT.getIconWidth(), LEFT.getIconHeight());
		setVisible(false);
		addMouseListener(this);
	}
	public void mouseEntered(MouseEvent e) {
		setIcon(LEFT_ENTER);//흰색으로 바뀜
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(LEFT);// 다시 원상태로
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GameBaord_Background.RemoveLR();
		if(GameBaord_Background.getPhase2())
			SendServer.SendData(Default_Socket.getOutData(), "LEFT");
	}
}
