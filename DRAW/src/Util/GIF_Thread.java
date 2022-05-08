package Util;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Gameboard_Screen.GameBaord_Background;

public class GIF_Thread implements Runnable{

	private JPanel field;
	private JLabel d;
	private int count;
	
	public GIF_Thread(JPanel field,JLabel d,int count) {
		this.field = field;
		this.d = d;
		this.count = count;
	}
	
	public void run() {
		try {
			Thread.sleep(count);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		field.remove(d);
		field.revalidate();
		field.repaint();
		if(GameBaord_Background.getMyTurn())
			GameBaord_Background.MoveLR();
	}
}
