package Gameboard_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Main_Screen.Main_Background;
import gameCharacter_Screen.Position_Screen;

public class Use_Card_No_Button extends Default_Button_Event{
	// 카드 사용 no 버튼 
	private ImageIcon NO = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/USE_CARD_NO.png"));
	private ImageIcon NO_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/USE_CARD_NO_ENTER.png"));
	public Use_Card_No_Button() {
		setIcon(NO);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(440,128, NO.getIconWidth(), NO.getIconHeight());
		addMouseListener(this);
		
	}
	public void mouseEntered(MouseEvent e) {
		setIcon(NO_ENTER);//흰색으로 바뀜
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(NO);// 다시 원상태로
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GameBaord_Background.no();
		GameBaord_Background.offUcs();
		Position_Screen.removeListener();
	}
}