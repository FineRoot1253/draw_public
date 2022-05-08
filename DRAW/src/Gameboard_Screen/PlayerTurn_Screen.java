package Gameboard_Screen;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Main_Screen.Main_Background;

public class PlayerTurn_Screen extends JPanel{
	// 플레이어 턴을 나타내는 클래스 
	private Image Card_Background = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/CHANGETURN.png")).getImage();
	private JLabel Player_Turn;
	public PlayerTurn_Screen() {
		setLayout(null); 
		Player_Turn = new JLabel();
		Player_Turn.setFont(new Font("굴림", Font.BOLD, 50));
		Player_Turn.setText("누구의 턴~");
		Player_Turn.setBounds(314, 318, 460, 150);
		Player_Turn.setHorizontalAlignment(JLabel.CENTER);
		add(Player_Turn);
		setVisible(false);
		setBounds(284,191,1065,456);
		setOpaque(false);
	}
	
	
	public void paintComponent(Graphics g) {
		g.drawImage(Card_Background, 0, 0, this.getWidth(), this.getHeight(), this);

	}
}
