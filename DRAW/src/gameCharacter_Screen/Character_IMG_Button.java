package gameCharacter_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Socket;
import Gameboard_Screen.GameBaord_Background;
import Main_Screen.Main_Background;
import Util.SendServer;
import card_Imformation.Draw_Card;

public class Character_IMG_Button extends Default_Button_Event {
	private boolean SET = true ;
	private ImageIcon C1 = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/CHARACTER/CHARACTER.png"));
	private ImageIcon C1_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/CHARACTER/CHARACTER_ENTER.png"));
	private String name;
	public Character_IMG_Button() {
	
		setIcon(C1);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(0, 37,C1.getIconWidth(), C1.getIconHeight());
		
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void mouseEntered(MouseEvent e) {
		setIcon(C1_ENTER);// 흰색으로 바뀜
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(C1);// 다시 원상태로
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//if(GameBaord_Background.getChooseEnemy()) {
		//Draw_Card.setEnemyName(getName());		
		
		SendServer.SendData(Default_Socket.getOutData(), "Enemy:" + name);
		GameBaord_Background.onUcs();
		//}
		
	}
}