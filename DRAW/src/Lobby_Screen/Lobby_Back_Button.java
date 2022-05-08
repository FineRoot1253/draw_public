package Lobby_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Default.Default_Socket;
import Login_Screen.Login_Background;
import Main_Screen.Main_Background;
import Util.SendServer;

public class Lobby_Back_Button extends Default_Button_Event{
	// 로비에서 로그인 버튼으로 돌아가는 버튼 
	private ImageIcon LOBBY_BACK = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_BACK.png"));
	private ImageIcon LOBBY_BACK_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/LOBBY_BACK_ENTER.png"));
	private Default_Frame DF;
	
	public Lobby_Back_Button(ImageIcon icon, Default_Frame DF) {
		this.DF = DF;
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(1225,900, icon.getIconWidth(), icon.getIconHeight());
		addMouseListener(this);
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(LOBBY_BACK_ENTER);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(LOBBY_BACK);
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		SendServer.SendData(Default_Socket.getOutData(), "Logout");
		Util.Commend.sleep(500);
		DF.getContentPane().removeAll();
		DF.add(new Login_Background(DF)); 
		DF.revalidate();
	}
}
