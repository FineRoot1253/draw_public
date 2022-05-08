package Login_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Default.Default_Socket;
import Main_Screen.Main_Background;
import Select_Screen.Select_Background;
import Util.SendServer;

public class Login_Back_Button extends Default_Button_Event{
	// 로그인 창에서 셀렉 화면으로 보내는 버튼 
	private ImageIcon LOGIN_BACK = new ImageIcon(Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_BACK.png"));
	private ImageIcon LOGIN_BACK_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOGIN_SCREEN/LOGIN_BACK_ENTER.png"));
	private Default_Frame DF;
	
	public Login_Back_Button(ImageIcon icon, Default_Frame DF) {
		this.DF = DF;
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(34,326, icon.getIconWidth(), icon.getIconHeight());
		addMouseListener(this);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(LOGIN_BACK_ENTER);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(LOGIN_BACK);
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		SendServer.SendData(Default_Socket.getOutData(),"System");
		DF.getContentPane().removeAll();
		DF.add(new Select_Background(DF));//Select_Background 
		DF.revalidate();
	}
}
