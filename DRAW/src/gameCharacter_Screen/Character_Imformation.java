package gameCharacter_Screen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Main_Screen.Main_Background;

public class Character_Imformation extends JPanel{
	
	
	private Image Character_BAK = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/CHARACTER/CHARACTER_BACKGROUND.png")).getImage();
	private ArrayList<JLabel> names;
	private JPanel Character_Imfor;
	private int position=0;
	private Character_IMG_Button CIB;
	private Character_supIMG CSI;
	
	public Character_Imformation() {
				
		names = new ArrayList<JLabel>();
		setLayout(new BorderLayout());
		setSize(80, 80);
		setOpaque(false);
		setVisible(false);
		names.add(new JLabel());
		CIB = new Character_IMG_Button();
		CSI = new Character_supIMG();
		Character_Imfor = new JPanel();
		
		Character_Imfor.setSize(80, 80);;
		Character_Imfor.setLayout(new FlowLayout(FlowLayout.LEFT));
		Character_Imfor.setOpaque(false);
		
		add(Character_Imfor, BorderLayout.NORTH);
		add(CIB, BorderLayout.SOUTH);
		names.get(0).setSize(55, 37);
		names.get(0).setHorizontalTextPosition(JLabel.CENTER);
		
	}

	public void setName(String nick) {
		names.removeAll(names);
		Character_Imfor.removeAll();
		
		names.add(new JLabel(nick));
		Character_Imfor.add(names.get(0));
	}
	
	public void setMany() {
		Character_Imfor.removeAll();
		

		Character_Imfor.add(new JLabel("Many"));
	}
	
	public void setTileNum(int position) {
		this.position=position;
	}
	
	public int getTileNum() {
		return position;
	}
	
	public String getName() {
		CIB.setName(names.get(0).getText());
		return names.get(0).getText();
	}
	
	public void addName(String name) {
		names.add(new JLabel(name));
	}
	
	public void removeName(String name) {
		for(int i = 0; i < names.size();i++) {
			if(names.get(i).getText().equals(name))
				names.remove(i);
		}
		
		if(names.size() == 1) {
			Person();
		}else {
			CSI.set(names.size(),names);
		}
		repaints();
	}
	
public void People(int size) {
		
		CSI.set(size,names);
		remove(CIB);
		add(CSI);
	}
	
	public void Person() {
	setName(names.get(0).getText());
	remove(CSI);
	add(CIB);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(Character_BAK, 0, 0, this.getWidth(), this.getHeight(), this);

	}
	public void setOnCIB() {
		
		CIB.addMouseListener(CIB);
	//	System.out.println(CIB.getMouseListeners());
	}
	public void setOffCIB() {
		CIB.removeMouseListener(CIB);
	}
	public void setOnCSI() {
		CSI.addMouseListener(CSI);
	}
	public void setOffCSI() {
		CSI.removeMouseListener(CSI);
	}
	public void repaints() {
		revalidate();
		repaint();
	}
}
