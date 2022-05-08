package Gameboard_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Create_screen.Create_Background;
import Default.Default_Button_Event;
import Default.Default_Frame;
import Default.Default_Socket;
import Main_Screen.Main_Background;
import Room_Screen.Room_Background;
import Util.SendServer;
import thread.Gameboard_RoomInfo;

public class Finishi_Button extends Default_Button_Event{
	// 끝내기 버튼을 나타내는 클래스 
	private ImageIcon FINISHI = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/FINISHI.png"));
	private ImageIcon FINISHI_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/FINISHI_ENTER.png"));
	public Finishi_Button() {
		setIcon(FINISHI);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setEnabled(false);
		setBounds(625,255, FINISHI.getIconWidth(), FINISHI.getIconHeight());
		//addMouseListener(this);
		
	}
	public void mouseEntered(MouseEvent e) {
		setIcon(FINISHI_ENTER);//흰색으로 바뀜
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(FINISHI);// 다시 원상태로
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(Gameboard_Screen.GameBaord_Background.getPhase3())
			SendServer.SendData(Default_Socket.getOutData(), "END");
		else if(!GameBaord_Background.getMyTurn())
			SendServer.SendData(Default_Socket.getOutData(), "0:0");
		//else if(GameBaord_Background.getPhase2())
		//	SendServer.SendData(Default_Socket.getOutData(), "LEFT");
	}
}
