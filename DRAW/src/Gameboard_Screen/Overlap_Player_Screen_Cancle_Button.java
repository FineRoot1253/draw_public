package Gameboard_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Socket;
import Main_Screen.Main_Background;
import Util.SendServer;

public class Overlap_Player_Screen_Cancle_Button extends Default_Button_Event {
	// 왼쪽 으로 간다고 하는 버튼 클래스 
			private ImageIcon RIGHT = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/MOVE_RIGHT.png"));
			private ImageIcon RIGHT_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/MOVE_RIGHT_ENTER.png"));
			
			public Overlap_Player_Screen_Cancle_Button() {
				//setIcon(RIGHT);
				//setBorderPainted(false);
				//setFocusable(false);
				//setContentAreaFilled(false);
				setBounds(180,550,100,80);
				setText("나 가 라");
				addMouseListener(this);
			}
			public void mouseEntered(MouseEvent e) {
				//setIcon(RIGHT_ENTER);//흰색으로 바뀜
				setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
			}

			@Override
			public void mouseExited(MouseEvent e) {
				//setIcon(RIGHT);// 다시 원상태로
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
			}

			@Override
			public void mousePressed(MouseEvent e) {
				GameBaord_Background.RemoveOverlapScreen();
			}
}
