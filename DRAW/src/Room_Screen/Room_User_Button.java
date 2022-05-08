package Room_Screen;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Main_Screen.Main_Background;

public class Room_User_Button extends Default_Button_Event{
	// 방안의 사용자들을 그리는 클래스 
	private ImageIcon USER_LIST_BUTTON = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/ROOM_PLAYER.png"));
	
	
	public Room_User_Button() {
		setIcon(USER_LIST_BUTTON);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		addMouseListener(this);
	}

}
