	package gameCharacter_Screen;
//!
import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Socket;
import Main_Screen.Main_Background;
import Util.SendServer;

public class Position extends Default_Button_Event {
	private boolean SET = true ;
	private ImageIcon B1;
	private int position;

	
	public Position(int x, int y,int num) {
		B1 = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/TILE/B" + num + ".png"));
		position = num;
	
		setIcon(null);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(x,y, B1.getIconWidth(), B1.getIconHeight());
		//483 55
		//addMouseListener(this);
		
	}

	public void mouseEntered(MouseEvent e) {
		setIcon(B1);// 흰색으로 바뀜
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(null);// 다시 원상태로
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {
				
		setIcon(null);
		removeMouseListener(this);
		System.out.println(position);
		SendServer.SendData(Default_Socket.getOutData(), position + "");
		System.out.println(position+"를 보냈음");
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		Position_Screen.NoPosition();
		
	}
	public void use() {
		SET = false ;
	}
	public boolean getSET() {
		return SET;
	}
}
