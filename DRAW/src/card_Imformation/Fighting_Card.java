package card_Imformation;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Socket;
import Gameboard_Screen.Card_Screen;
import Gameboard_Screen.GameBaord_Background;
import Main_Screen.Main_Background;
import Util.SendServer;
import gameCharacter_Screen.Position_Screen;

public class Fighting_Card extends Draw_Card{
	// 듀얼 카드 버튼을 나타내는 클래스 
	private ImageIcon Fighting_Cards = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/CARD/결투1.png"));
	public Fighting_Card() {
		super("Fighting");
		setIcon(Fighting_Cards);
		setBorderPainted(false);
		setBounds(0, 50, Fighting_Cards.getIconWidth(), Fighting_Cards.getIconHeight());
		setFocusable(false);
		setContentAreaFilled(false);
		addMouseListener(this);
	}
	public void mouseEntered(MouseEvent e) {
		GameBaord_Background.ExpansionCard("결투");
		setIcon(Fighting_Cards);//흰색으로 바뀜
		setBounds(this.getX(), this.getY()-40, Fighting_Cards.getIconWidth(), Fighting_Cards.getIconHeight());
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
		enterCheckOn();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		GameBaord_Background.ExpansionCardRemove();
		setIcon(Fighting_Cards);// 다시 원상태로
		setBounds(this.getX(), this.getY()+40, Fighting_Cards.getIconWidth(), Fighting_Cards.getIconHeight());
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
		enterCheckOff();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (enterCheck) {
			if (this.can(this)) {
			//	if (GameBaord_Background.isOverlap()) {
					Card_Screen.useCard(this);
					Position_Screen.addListener(2);
				//}
			}
			// GameBaord_Background.setBang();
			GameBaord_Background.ExpansionCardRemove();
			//

		}
	}

}
