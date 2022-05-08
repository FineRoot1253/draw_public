package card_Imformation;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Gameboard_Screen.Card_Screen;
import Gameboard_Screen.GameBaord_Background;
import Main_Screen.Main_Background;

public class IndianAmbush_Card  extends Draw_Card{
	// 원주민 습격 카드 버튼을 나타내는 클래스 
	private ImageIcon IndianAmbush_Cards = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/CARD/원주민습격1.png"));
	public IndianAmbush_Card() {
		super("IndianAmbush");
		setIcon(IndianAmbush_Cards);
		setBorderPainted(false);
		setFocusable(false);
		setBounds(0, 50,  IndianAmbush_Cards.getIconWidth(), IndianAmbush_Cards.getIconHeight());
		setContentAreaFilled(false);
		addMouseListener(this);
	}
	public void mouseEntered(MouseEvent e) {
		GameBaord_Background.ExpansionCard("원주민습격");
		setIcon(IndianAmbush_Cards);//흰색으로 바뀜
		setBounds(this.getX(), this.getY()-40, IndianAmbush_Cards.getIconWidth(), IndianAmbush_Cards.getIconHeight());
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
		enterCheckOn();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		GameBaord_Background.ExpansionCardRemove();
		setIcon(IndianAmbush_Cards);// 다시 원상태로
		setBounds(this.getX(), this.getY()+40, IndianAmbush_Cards.getIconWidth(), IndianAmbush_Cards.getIconHeight());
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
		enterCheckOff();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(enterCheck) {
			if(this.can(this)) {
				Card_Screen.useCard(this);
			}
		GameBaord_Background.ExpansionCardRemove();
		
		}
	}

}