package Lobby_Screen;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Default.Default_ScrollBar_UI;

public class Lobby_PlayList_Scroll extends JPanel{
	private JScrollPane ListScroll;
	public Lobby_PlayList_Scroll() {
		setLayout(null); 
		setOpaque(false);
		setBounds(50, 260, 1131, 485);
		ListScroll = new JScrollPane(Lobby_Background.PL);
		ListScroll.setVisible(true);
		//ListScroll.setBounds(57, 260, 1130, 485);
		ListScroll.setBounds(0, 0, 1130, 485);
		ListScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ListScroll.getVerticalScrollBar().setUI(new Default_ScrollBar_UI());
		ListScroll.setOpaque(false);
		ListScroll.getViewport().setOpaque(false);
		ListScroll.getViewport().setBorder(null);
		ListScroll.setBorder(null);
		ListScroll.setVisible(true);
		add(ListScroll);
		setVisible(true);
	}

}
