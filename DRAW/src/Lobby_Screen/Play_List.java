package Lobby_Screen;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Default.Default_ScrollBar_UI;
import Default.WrapLayout;

public class Play_List extends JPanel {
	// 방목록이 표시되는 패널을 나타넴 (영역이라고 생각하면 편함)
	public Play_List() {
		setLayout(new WrapLayout(0)); 
		setOpaque(false);
		setBounds(0, 0, 1110, 480);
		
		//setSize(1110, 480);
		//setPreferredSize(new Dimension(1110,480));
	}
}
