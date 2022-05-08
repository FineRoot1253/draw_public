package AddFriends_screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import Default.Default_Button_Event;
import Default.Default_Frame;
import Default.Default_Socket;
import Lobby_Screen.Lobby_Background;
import Main_Screen.Main_Background;
import Util.SendServer;

public class AddFriends_Add_Button extends Default_Button_Event{
	//친구 추가 화면에서 친구 추가를 담당하는 버튼 
	private ImageIcon ADD_IN = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/FRIENDS/FRIENDS_ADD_BUTTON_IN.png"));
	private ImageIcon ADD_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/FRIENDS/FRIENDS_ADD_BUTTON_ENTER.png"));
	private Default_Frame DF;
	
	public AddFriends_Add_Button(ImageIcon icon, Default_Frame DF) {
		this.DF = DF;
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(25,390, icon.getIconWidth(), icon.getIconHeight());
		addMouseListener(this);	
	}
	public void mouseEntered(MouseEvent e) {
		setIcon(ADD_ENTER);//흰색으로 바뀜
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(ADD_IN);// 다시 원상태로
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {
		SendServer.SendData(Default_Socket.getOutData(),"AddFriend");
		SendServer.SendData(Default_Socket.getOutData(), AddFriends_Background.ADD_TextField.getText());
		
		Lobby_Background.AddfriendsSetvisible();
	}
}
