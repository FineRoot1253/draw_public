package Select_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Main_Screen.Main_Background;

public class Select_Exit_Button extends Default_Button_Event{
	// 셀렉화면에서 셋팅화면으로 가게하는 
	private ImageIcon Exit_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/SETTING_ENTER.png"));
	private ImageIcon Exit_IN = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/SETTING_IN.png"));
	private Default_Frame DF;
	
	public Select_Exit_Button(ImageIcon icon, Default_Frame DF) {
		this.DF = DF;
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(1074,544, Exit_IN.getIconWidth(), Exit_IN.getIconHeight());
		addMouseListener(this);
		setVisible(true);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setIcon(Exit_ENTER);//흰색으로 바뀜
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(Exit_IN);// 다시 원상태로
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.exit(0);
	}
}
