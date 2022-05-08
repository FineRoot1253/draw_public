package Gameboard_Screen;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Main_Screen.Main_Background;

public class Weather_Screen extends JPanel {
	// 날씨 카드를 나타내는 패널
	private String IMGstr="SUNNY";
	private String URL = "/Image/GAMEBOARD_SCREEN/WHEATHERCARD/";
	private ImageIcon Default_Sunny = new ImageIcon(
			Main_Background.class.getResource(URL+IMGstr+".png"));
	JButton Wheater_Button = new JButton(Default_Sunny);
	
	public Weather_Screen() {

		setLayout(null);
		setVisible(true);
		setBounds(10, 10, 130, 130);
		setOpaque(false);
		Wheater_Button.setToolTipText("시발련아");
		Wheater_Button.setBorderPainted(false);
		Wheater_Button.setFocusable(false);
		Wheater_Button.setContentAreaFilled(false);
		Wheater_Button.setEnabled(true);
		Wheater_Button.setSize(130, 130);
		add(Wheater_Button);
		
	}

	public void changeIcon(String str) {
		System.out.println(str);
		ImageIcon a = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/WHEATHERCARD/" + str + ".png"));
		Wheater_Button.setIcon(a);
		revalidate();
		repaint();
		
	}
}
