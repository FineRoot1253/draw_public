package Gameboard_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Socket;
import Main_Screen.Main_Background;
import Util.SendServer;
import card_Imformation.Draw_Card;

public class Use_Card_Yes_Button extends Default_Button_Event{
	// 카드 사용 yes 버튼 
	private ImageIcon YES = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/USE_CARD_YES.png"));
	private ImageIcon YES_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/USE_CARD_YES_ENTER.png"));
	public Use_Card_Yes_Button() {
		setIcon(YES);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(144,124, YES.getIconWidth(), YES.getIconHeight());
		addMouseListener(this);
		
	}
	public void mouseEntered(MouseEvent e) {
		setIcon(YES_ENTER);//흰색으로 바뀜
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(YES);// 다시 원상태로
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GameBaord_Background.yes();
		
		GameBaord_Background.offUcs();
		SendServer.SendData(Default_Socket.getOutData(), "yes");
	}
}