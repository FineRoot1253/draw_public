package Gameboard_Screen;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Main_Screen.Main_Background;

public class Overlap_Player_Imformation extends JPanel{
	// 중복된 타일 사람들의 정보를 보여주는 스크린 
	private Image Overlap = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/Overlap_Player_Screen.png")).getImage();
	private ImageIcon OverlapIMG = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/CHARACTER/CHARACTER.png"));
	private JPanel layout;
	private JLabel[] IMF = new JLabel[5];
	private JPanel IMG_layout;
	private JLabel[] IMG = new JLabel[5];
	public Overlap_Player_Imformation(ArrayList<JLabel> names) {
		setLayout(null); 
		setVisible(true);
		setBounds(1398,315,280,420);
		setOpaque(false);
		layout = new JPanel();
		layout.setBounds(100,70,150,320);
		layout.setLayout(new GridLayout(0,1));
		layout.setOpaque(false);
		IMG_layout = new JPanel();
		IMG_layout.setBounds(10,70,80,320);
		IMG_layout.setLayout(new GridLayout(0,1));
		IMG_layout.setOpaque(false);
		
		for(int i =0;i<names.size();i++) {
			IMF[i] = new JLabel(names.get(i).getText());
			IMF[i].setHorizontalAlignment(JLabel.CENTER);
			IMF[i].setFont(new Font("굴림", Font.BOLD, 15));
			layout.add(IMF[i]);
			IMG[i] = new JLabel();
			IMG[i].setIcon(OverlapIMG);
			IMG_layout.add(IMG[i]);
		}
		add(IMG_layout);
		add(layout);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(Overlap, 0, 0, this.getWidth(), this.getHeight(), this);

	}
}