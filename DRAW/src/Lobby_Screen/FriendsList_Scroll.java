package Lobby_Screen;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Default.Default_ScrollBar_UI;

public class FriendsList_Scroll extends JPanel{
	//친구 목록 스크롤을 나타내는 클래스 
	private JScrollPane FriendsScroll;
	public FriendsList_Scroll() {
		setLayout(null); 
		setOpaque(false);
		setBounds(1235, 260, 370, 395);
		FriendsScroll = new JScrollPane(Lobby_Background.FLS);
		FriendsScroll.setVisible(true);
		//ListScroll.setBounds(57, 260, 1130, 485);
		FriendsScroll.setBounds(0, 0, 370, 395);
		FriendsScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		FriendsScroll.getVerticalScrollBar().setUI(new Default_ScrollBar_UI());
		FriendsScroll.setOpaque(false);
		FriendsScroll.getViewport().setOpaque(false);
		FriendsScroll.getViewport().setBorder(null);
		FriendsScroll.setBorder(null);
		FriendsScroll.setVisible(true);
		add(FriendsScroll);
		setVisible(false);
	}

}
