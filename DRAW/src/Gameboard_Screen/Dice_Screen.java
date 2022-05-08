package Gameboard_Screen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Default.Default_Frame;
import Main_Screen.Main_Background;

public class Dice_Screen extends JLabel{
	// 주사위 표시하는 패널
	private ImageIcon Dice1 = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/Dice/1.gif"));
	
	public Dice_Screen(int DiceResult) {
		
		Dice1 = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/Dice/"+DiceResult+".gif"));
		
		Dice1.getImage().flush();
		setIcon(Dice1);
		setFocusable(false);
		setBounds(620,350,400,300);
		
	}
}