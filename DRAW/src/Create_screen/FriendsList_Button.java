package Create_screen;

import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Default.Default_Button_Event;
import Lobby_Screen.Lobby_Background;
import Lobby_Screen.Lobby_Chat;
import Main_Screen.Main_Background;

public class FriendsList_Button extends Default_Button_Event{
	// 친구 목록에 있는 버튼을 나타내는 클래스
	private ImageIcon FRIENDS_LIST_BUTTON;
	
	public FriendsList_Button(String userName,int state) {
		
		if (state == 0) {
			FRIENDS_LIST_BUTTON = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/PlayList/FRIENDSLIST_OFF.png"));
		}else {
			FRIENDS_LIST_BUTTON  = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/PlayList/FRIENDSLIST_ON.png"));
		}
		
		setIcon(FRIENDS_LIST_BUTTON);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		addMouseListener(this);	
		
		setText(userName);
	    setHorizontalTextPosition(JButton.CENTER);
	    setFont(new Font("굴림체", Font.BOLD, 45));
	}
	public void mousePressed(MouseEvent e) {
		Lobby_Background.getJT().setText(String.format("/w %s", this.getText()));
	}
}
