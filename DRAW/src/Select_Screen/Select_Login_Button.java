package Select_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Login_Screen.Login_Background;
import Main_Screen.Main_Background;

public class Select_Login_Button extends Default_Button_Event{
	// 셀렉 화면에서 로그인 화면으로 보내주는 버튼 
	private ImageIcon LOGIN_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/LOGIN_ENTER.png"));
	private ImageIcon LOGIN_IN = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/LOGIN_IN.png"));
	private Default_Frame DF;
	
	public Select_Login_Button(ImageIcon icon, Default_Frame DF) {
		this.DF = DF;
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(1062,218, icon.getIconWidth(), icon.getIconHeight());
		addMouseListener(this);
		setVisible(true);
	}
	public void mouseEntered(MouseEvent e) {
		setIcon(LOGIN_ENTER);//흰색으로 바뀜
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(LOGIN_IN);// 다시 원상태로
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {
		DF.getContentPane().removeAll();
		DF.add(new Login_Background(DF));
		DF.revalidate();
	}
}
