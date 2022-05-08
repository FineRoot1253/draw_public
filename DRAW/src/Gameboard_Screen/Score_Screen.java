package Gameboard_Screen;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Default.WrapLayout;
import Main_Screen.Main_Background;
//정혁이 작업해따 
public class Score_Screen extends JPanel {
	
	private JPanel Player_Count; 
	private JLabel[] PCO = new JLabel[5];
	private JLabel[] IF = new JLabel[3];
	private JPanel Player_IMF;
	private JPanel Players;
	private Player_Score_Screen[] PSS = new Player_Score_Screen[5];
	
	public Score_Screen() {
		setLayout(null);
		Player_Count = new JPanel();
		Player_Count.setLayout(new GridLayout(5,1));
		Player_Count.setBounds(10, 30, 30, 270);
		Player_Count.setOpaque(false);
		Player_IMF = new JPanel();
		Player_IMF.setLayout(null);
		Player_IMF.setBounds(40, 10,240 , 20);
		Player_IMF.setOpaque(false);
		Players = new JPanel();
		Players.setBounds(40, 30, 240, 280);
		Players.setLayout(new GridLayout(5, 1));
		Players.setOpaque(false);
		

		for(int i = 0 ; i <5;i++) {// 보안관 명시 해줘야해서 수정
			if(i==0) {
				PCO[i] = new JLabel("★");
				PCO[i].setFont(new Font("굴림", Font.BOLD, 15));
				Player_Count.add(PCO[i]);
			}else {
				PCO[i] = new JLabel(i+1+"P");
				PCO[i].setFont(new Font("굴림", Font.BOLD, 15));
				Player_Count.add(PCO[i]);
			}
		}
		for(int i = 0 ; i <3;i++) {
			IF[i] = new JLabel();
			IF[i].setHorizontalAlignment(JLabel.CENTER);
			IF[i].setOpaque(false);
			Player_IMF.add(IF[i]);
		}
		for(int i = 0;i<5;i++) {
			PSS[i] = new Player_Score_Screen();
			Players.add(PSS[i]);
		}

		IF[0].setText("Nick Name");
		IF[0].setBounds(0,0,150, 20);	
		IF[1].setText("HP");
		IF[1].setBounds(150,0,40, 20);
		IF[2].setText("Card");
		IF[2].setBounds(190,0,40, 20);
		add(Player_Count);
		add(Player_IMF);
		add(Players);
		setLayout(null); 
		setVisible(true);
		setBounds(1400,0,280,300);
		setOpaque(false);
			
	}
	public Player_Score_Screen[] getPSS() {
		return PSS;
	}
}

