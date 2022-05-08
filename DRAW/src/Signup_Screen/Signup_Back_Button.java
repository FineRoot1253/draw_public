package Signup_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Default.Default_Socket;
import Main_Screen.Main_Background;
import Select_Screen.Select_Background;
import Util.SendServer;

public class Signup_Back_Button extends Default_Button_Event{
	// 회원가입에서 셀렉 화면으로 가게 해주는 버튼 
	private ImageIcon SIGNUP_BACK = new ImageIcon(Main_Background.class.getResource("/Image/SIGNUP_SCREEN/SIGNUP_BACK.png"));
	private ImageIcon SIGNUP_BACK_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/SIGNUP_SCREEN/SIGNUP_BACK_ENTER.png"));
	private Default_Frame DF;
	private Signup_Background SB;
	
	public  Signup_Back_Button(ImageIcon icon, Default_Frame DF,Signup_Background SB) {
		this.DF = DF;
		this.SB = SB;
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(34,326, icon.getIconWidth(), icon.getIconHeight());
		addMouseListener(this);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(SIGNUP_BACK_ENTER);//흰색으로 바뀜
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(SIGNUP_BACK);// 다시 원상태로
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {
		SB.setTextField();
		
		SendServer.SendData(Default_Socket.getOutData(),"System");
		
		DF.getContentPane().removeAll();
		DF.add(new Select_Background(DF));//Select_Background 패널 불러옴 
		DF.revalidate();
	}
}
