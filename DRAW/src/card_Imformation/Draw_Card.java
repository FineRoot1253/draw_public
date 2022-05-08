package card_Imformation;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Default.Default_Button_Event;
import Gameboard_Screen.GameBaord_Background;

public abstract class Draw_Card extends Default_Button_Event{
	String name;
	static String enemyname = "";
	boolean enterCheck=false;
	static String cardname;
	public  Draw_Card(String name) {
		this.name = name;
	}
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	public String getName() {
		return name;
	}
	public void enterCheckOn() {
		enterCheck = true;
	}
	public void enterCheckOff() {
		enterCheck = false;
	}
	public boolean can(Draw_Card card) {
		if(GameBaord_Background.isFightingmood()) {
			if(card.getName().equals("Bang"))
				return true;
		}
		else if(GameBaord_Background.isBangmood()) {
			if(card.getName().equals("Avoid") || card.getName().equals("Beer") && GameBaord_Background.getHP().equals("1"))
				return true;
		}
		else if(GameBaord_Background.getMyTurn() && !card.getName().equals("Avoid"))
			return true;
		
		return false;
			
	}
	public static void setEnemyName(String name) {
		enemyname = name;
	}
	public String EnemyName() {
		return enemyname;
	}
	public static void setCardName(String name) {
		cardname = name;
	}
	public static String getCardName() {
		return cardname;
	}
}
