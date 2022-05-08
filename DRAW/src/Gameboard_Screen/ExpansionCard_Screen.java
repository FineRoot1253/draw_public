package Gameboard_Screen;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Main_Screen.Main_Background;

public class ExpansionCard_Screen extends JPanel{
	// 카드 확대해서 보여주는 패널 
	private Image Card_Background;
	
	public ExpansionCard_Screen(String Card) {
		Card_Background = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/CARD/"+Card+".png")).getImage();
		setLayout(null); 
		setVisible(true);
		setBounds(1400,330,280,375);
		setOpaque(false);
			
	}
	public void paintComponent(Graphics g) {
		g.drawImage(Card_Background, 0, 0, this.getWidth(), this.getHeight(), this);

	}
}
