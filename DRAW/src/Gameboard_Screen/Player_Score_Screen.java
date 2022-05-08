package Gameboard_Screen;

import javax.swing.JLabel;
import javax.swing.JPanel;
//이잉 앗살라마이궁 
public class Player_Score_Screen extends JPanel{
	
	private JLabel[] PIF = new JLabel[3];
	public Player_Score_Screen() {
		for(int i =0;i<3;i++) {
			PIF[i] = new JLabel();
			PIF[i].setHorizontalAlignment(JLabel.CENTER);
			PIF[i].setOpaque(false);
			this.add(PIF[i]);
		}
		setLayout(null);
		setSize(240, 54);
		setVisible(true);
		setOpaque(false);
		PIF[0].setText("NONE");
		PIF[0].setBounds(0,10,150, 20);	
		PIF[1].setText("0");
		PIF[1].setBounds(150,10,40, 20);
		PIF[2].setText("0");
		PIF[2].setBounds(190,10,40, 20);
	}
	public void setPIF(String name,String hp ,String card) {
		if(hp.equals("0")) {
			PIF[1].setText("DEAD");
			PIF[2].setText("DEAD");
		}
		PIF[0].setText(name);
		PIF[1].setText(hp);
		PIF[2].setText(card);
	}
	public JLabel[] getIMF() {
		return PIF;
	}
	
}
