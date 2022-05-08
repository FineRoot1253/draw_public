package Lobby_Screen;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Default.Default_ScrollBar_UI;

public class PlayerList_Scroll extends JPanel{
	// 유저 리스트의 스크롤을 나타내는 클래스
	private JScrollPane PlayerScroll;
	public PlayerList_Scroll() {
		setLayout(null); 
		setOpaque(false);
		setBounds(1235, 260, 370, 395);
		PlayerScroll = new JScrollPane(Lobby_Background.PLS);
		PlayerScroll.setVisible(true);
		//ListScroll.setBounds(57, 260, 1130, 485);
		PlayerScroll.setBounds(0, 0, 370, 395);
		PlayerScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		PlayerScroll.getVerticalScrollBar().setUI(new Default_ScrollBar_UI());
		PlayerScroll.setOpaque(false);
		PlayerScroll.getViewport().setOpaque(false);
		PlayerScroll.getViewport().setBorder(null);
		PlayerScroll.setBorder(null);
		PlayerScroll.setVisible(true);
		add(PlayerScroll);
		setVisible(true);
	}
}
