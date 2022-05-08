package Room_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Default.Default_Socket;
import Gameboard_Screen.GameBaord_Background;
import Main_Screen.Main_Background;
import Util.SendServer;

public class Room_Start_Button extends Default_Button_Event{
	
	private ImageIcon ROOM_IN = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/ROOM_START.png"));
	private ImageIcon ROOM_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/ROOM_START_ENTER.png"));
	private Default_Frame DF;
	
	public Room_Start_Button(ImageIcon icon, Default_Frame DF) {
		this.DF = DF;
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(1225,790, icon.getIconWidth(), icon.getIconHeight());
		addMouseListener(this);
		setVisible(false);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(ROOM_ENTER);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(ROOM_IN);
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//if(Room_Background.getCanStart() == true) // 시작할 수 있는 단계
			SendServer.SendData(Default_Socket.getOutRoomInfo(),"Start");
	
		
		/*DF.getContentPane().removeAll();
		DF.add(new GameBaord_Background(DF));//Select_Background */
		DF.revalidate();
	}
}
