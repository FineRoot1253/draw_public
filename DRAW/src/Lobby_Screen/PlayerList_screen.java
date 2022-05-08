package Lobby_Screen;

import java.awt.FlowLayout;
import javax.swing.JPanel;

import Default.WrapLayout;

public class PlayerList_screen extends JPanel{
	// 유저 목록을 나타내는 패널
	public PlayerList_screen() {
		setLayout(new WrapLayout(0)); 
		setOpaque(false);
		setBounds(0, 0, 370, 395);

	}
}
