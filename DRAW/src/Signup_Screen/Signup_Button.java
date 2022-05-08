package Signup_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Default.Default_Socket;
import Main_Screen.Main_Background;
import Select_Screen.Select_Background;
import Util.Check;
import Util.ReceiveServer;
import Util.SendServer;

public class Signup_Button extends Default_Button_Event{
	// 회원 가입을 시키는 버튼 
	private ImageIcon SIGNUP_IN = new ImageIcon(Main_Background.class.getResource("/Image/SIGNUP_SCREEN/SIGNUP_IN.png"));
	private ImageIcon SIGNUP_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/SIGNUP_SCREEN/SIGNUP_ENTER.png"));
	private Default_Frame DF;
	private Signup_Background SB;
	
	public Signup_Button(Default_Frame DF,Signup_Background SB) {
		this.DF = DF;
		this.SB = SB;
		setIcon(SIGNUP_IN);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(1258,800, SIGNUP_IN.getIconWidth(), SIGNUP_IN.getIconHeight());
		addMouseListener(this);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(SIGNUP_ENTER);//흰색으로 바뀜
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(SIGNUP_IN);// 다시 원상태로
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {
		String[] value = Signup_Background.getInfo();

		if(Check.CheckValue(value))
			SendServer.SendData(Default_Socket.getOutData(), value[0] + ":" + value[1] + ":" + value[2] + ":" + value[3] + ":" + value[4]);
		
		SB.setTextField();
		
		String answer = ReceiveServer.ReceiveData(Default_Socket.getInData());
		
		if(answer.equals("SignUpAccept")) {
			DF.getContentPane().removeAll();
			DF.add(new Select_Background(DF));
			DF.revalidate();
		}
	}
}
