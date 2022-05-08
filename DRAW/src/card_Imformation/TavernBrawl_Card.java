package card_Imformation;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Gameboard_Screen.Card_Screen;
import Gameboard_Screen.GameBaord_Background;
import Main_Screen.Main_Background;

public class TavernBrawl_Card extends Draw_Card {
	// 난투 카드 버튼을 나타내는 클래스
	private ImageIcon TavernBrawl_Cards = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/CARD/난투1.png"));

	public TavernBrawl_Card() {
		super("TavernBrawl");
		setIcon(TavernBrawl_Cards);
		setBorderPainted(false);
		setFocusable(false);
		setBounds(0, 50, TavernBrawl_Cards.getIconWidth(), TavernBrawl_Cards.getIconHeight());
		setContentAreaFilled(false);
		addMouseListener(this);
	}

	public void mouseEntered(MouseEvent e) {
		GameBaord_Background.ExpansionCard("난투");
		setIcon(TavernBrawl_Cards);// 흰색으로 바뀜
		setBounds(this.getX(), this.getY()-40, TavernBrawl_Cards.getIconWidth(), TavernBrawl_Cards.getIconHeight());
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
		enterCheckOn();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		GameBaord_Background.ExpansionCardRemove();
		setIcon(TavernBrawl_Cards);// 다시 원상태로
		setBounds(this.getX(), this.getY()+40, TavernBrawl_Cards.getIconWidth(), TavernBrawl_Cards.getIconHeight());
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
