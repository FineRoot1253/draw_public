package Create_screen;

import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Default.Default_Socket;
import Lobby_Screen.Lobby_Background;
import Main_Screen.Main_Background;
import Room_Screen.Room_Background;
import Util.SendServer;

public class PlayList_Button extends Default_Button_Event{
	// 방 버튼
	private ImageIcon PLAY_LIST_BUTTON = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_PLAYLIST_BUTTON.png"));
	private int roomNum;
	private Default_Frame DF;
	
	public PlayList_Button(String roomName,int roomNum,Default_Frame DF) {
		setIcon(PLAY_LIST_BUTTON);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		addMouseListener(this);
		
		this.DF = DF;
		this.roomNum = roomNum;
		
		setText(roomNum + " " + roomName);
	    setHorizontalTextPosition(JButton.CENTER);
	    setFont(new Font("굴림체", Font.BOLD, 45));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		SendServer.SendData(Default_Socket.getOutRoomInfo(), "Join");
		SendServer.SendData(Default_Socket.getOutRoomInfo(), roomNum);
		SendServer.SendData(Default_Socket.getOutData(), "InRoom");
		SendServer.SendData(Default_Socket.getOutData(), "InRoomInfo");

		DF.getContentPane().removeAll();
		DF.add(new Room_Background(DF));
		DF.revalidate();
		
		
	}
}
