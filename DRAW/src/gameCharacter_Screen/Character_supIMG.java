package gameCharacter_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Default.Default_Button_Event;
import Gameboard_Screen.GameBaord_Background;
import Main_Screen.Main_Background;

public class Character_supIMG extends Default_Button_Event {
	// 여러명이 타일에 중첩 됬을때 캐릭터 나타내는 버튼
	private boolean SET = true;
	private ImageIcon Cs = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/CHARACTER/CHARACTER3.png"));
	private ImageIcon Cs_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/CHARACTER/CHARACTER3_ENTER.png"));
	private ArrayList<JLabel> names =null;
	
	public Character_supIMG() {
		
		setIcon(Cs);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(0, 37, Cs.getIconWidth(), Cs.getIconHeight());
		//addMouseListener(this);

	}
	//여기 건들임 
	public void set(int size,ArrayList<JLabel> names) {
		Cs = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/CHARACTER/CHARACTER" + size + ".png"));
		Cs_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/CHARACTER/CHARACTER" + size + "_ENTER.png"));
		
		this.names = names;
		
		setIcon(Cs);
	}
	
	public void mouseEntered(MouseEvent e) {
		setIcon(Cs_ENTER);// 흰색으로 바뀜
		GameBaord_Background.OverlapImformation(names);
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(Cs);// 다시 원상태로
		GameBaord_Background.RemoveOverlapImformation();
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		GameBaord_Background.RemoveOverlapImformation();
		GameBaord_Background.OverlapScreen(names);
	}
}
