package Gameboard_Screen;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Main_Screen.Main_Background;

public class Use_Card_Screen extends JPanel{
	// 카드 눌렀을때 쓸지 안쓸지 선택하는 화면 
		private Image UCS = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/USE_CARD_SCREEN.png")).getImage();
		private Use_Card_Yes_Button UCYB;
		private Use_Card_No_Button UCNB;
		public Use_Card_Screen() {
			UCYB = new Use_Card_Yes_Button();
			UCNB = new Use_Card_No_Button();
			setLayout(null); 
			setVisible(false);
			setBounds(443,314,721,266);
			setOpaque(false);
			add(UCYB);
			add(UCNB);
				
		}
		
		public void paintComponent(Graphics g) {
			g.drawImage(UCS, 0, 0, this.getWidth(), this.getHeight(), this);

		}
}
