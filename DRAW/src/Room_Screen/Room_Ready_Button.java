package Room_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Socket;
import Gameboard_Screen.GameBaord_Background;
import Main_Screen.Main_Background;
import Util.SendServer;

public class Room_Ready_Button extends Default_Button_Event{
	//방에 레디버튼을 나타내는 클래스
	private ImageIcon READY_IN = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/ROOM_READY_BUTTON.png"));
	private ImageIcon READY_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/ROOM_SCREEN/ROOM_READY_BUTTON_ENTER.png"));
	
	public Room_Ready_Button() {
		setIcon(READY_IN);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(1225,790, READY_IN.getIconWidth(), READY_IN.getIconHeight());
		addMouseListener(this);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(READY_ENTER);//������� �ٲ�
		setCursor(new Cursor(Cursor.HAND_CURSOR));// Ŀ���� �հ��� �������
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(READY_IN);// �ٽ� �����·�
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// Ŀ���� �⺻����
	}
	public void mousePressed(MouseEvent e) {
		SendServer.SendData(Default_Socket.getOutRoomInfo(),"Ready");
		//Room_Background.InputReady();
	}
}
