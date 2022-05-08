package Gameboard_Screen;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
// 간다아 
public class Imformation_Screen extends JPanel{
	//화상채팅 + 닉네임 을 나타내는 패널
	private JLabel Name;
	private JLabel HP;
	private JLabel Cards;
	private JLabel IF_H;
	private JLabel IF_C;
	public Imformation_Screen() {
		
		Name = new JLabel("1");
		HP = new JLabel("HP");
		Cards = new JLabel("JOB");
		IF_H = new JLabel("2");
		IF_C = new JLabel("3");
		Name.setBounds(15, 320, 150, 20);
		Name.setFont(new Font("굴림", Font.BOLD, 15));
		Name.setHorizontalAlignment(JLabel.CENTER);
		IF_C.setBounds(183, 320, 60, 30);
		IF_C.setFont(new Font("굴림", Font.BOLD, 20));
		IF_H.setBounds(150, 320, 30, 30);
		IF_H.setFont(new Font("굴림", Font.BOLD, 20));
		HP.setBounds(150, 290, 30, 30);
		HP.setFont(new Font("굴림", Font.BOLD, 15));
		Cards.setBounds(180, 290, 60, 30);
		Cards.setFont(new Font("굴림", Font.BOLD, 15));
		
		
		
		setLayout(null); 
		setVisible(true);
		setBounds(1400,330,280,375);
		setOpaque(false);
		add(Name);
		add(IF_C);
		add(IF_H);
		add(HP);
		add(Cards);
			
	}
	public void setProfile(String name, String hp, String job) {
		Name.setText(name);
		IF_H.setText(hp);
		IF_C.setText(job);
	}
	public void setHP(String hp) {
		IF_H.setText(hp);
	}
}
