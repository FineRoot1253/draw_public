package Gameboard_Screen;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Main_Screen.Main_Background;

public class Result_Screen extends JPanel{
	// 게임결과 나타내는 패널 
		private Image RESULT = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/RESULT_SCREEN.png")).getImage();
		private ImageIcon OverlapIMG = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/CHARACTER/CHARACTER.png"));
		private JPanel layout;
		private JLabel[] IMF = new JLabel[5];
		private JPanel[] imformation = new JPanel[5];
		private JLabel[] IMG = new JLabel[5];
		public Result_Screen(Player_Score_Screen[] PSS) {
			
			setLayout(null); 
			setVisible(true);
			setBounds(100,0,1437,1050);
			setOpaque(false);
			layout = new JPanel();
			layout.setBounds(300,400,450,450);
			layout.setLayout(new GridLayout(0,1));
			layout.setOpaque(false);
			
			for(int i =0;i<PSS.length;i++) {
				imformation[i] = new JPanel();
				imformation[i].setBounds(30,100,410,90);
				imformation[i].setLayout(null);
				imformation[i].setOpaque(false);
				IMF[i] = new JLabel(PSS[i].getIMF()[0].getText());
				IMF[i].setHorizontalAlignment(JLabel.CENTER);
				IMF[i].setBounds(80, 0, 370, 90);
				IMF[i].setFont(new Font("굴림", Font.BOLD, 15));
				imformation[i].add(IMF[i]);
				IMG[i] = new JLabel();
				IMG[i].setBounds(0, 0, 80, 90);
				IMG[i].setIcon(OverlapIMG);
				imformation[i].add(IMG[i]);
				
				layout.add(imformation[i]);
			}
			add(layout);
				
		}
		
		public void paintComponent(Graphics g) {
			g.drawImage(RESULT, 0, 0, this.getWidth(), this.getHeight(), this);

		}
}
