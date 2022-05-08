package Create_screen;

import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Lobby_Screen.Lobby_Background;
import Lobby_Screen.Lobby_Chat;
import Main_Screen.Main_Background;

public class User_List extends Default_Button_Event{
	// 유저 목록에 있는 버튼을 나타내는 클래스 
	private ImageIcon User_List = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/PlayList/USERLIST_BUTTON.png"));

	public User_List(String userName) {
		setIcon(User_List);
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
