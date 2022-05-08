package Main_Screen;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Select_Screen.Select_Background;

public class Press_Button extends Default_Button_Event {
	// 메인화면의 press 버튼을 담당하는 클래스
	private ImageIcon PRESS_ENTER_WHITE = new ImageIcon(Main_Background.class.getResource("/Image/Background/PRESS_WHITE.png"));
	private ImageIcon PRESS_ENTER_BLACK = new ImageIcon(Main_Background.class.getResource("/Image/Background/PRESS_BLACK.png"));
	private Default_Frame DF;

	public Press_Button(ImageIcon icon, Default_Frame DF) {
		this.DF = DF;
		setIcon(icon); // 버튼 이미지는 아이콘을 받는것
		setBorderPainted(false); // 버튼의 선 불투명화
		setFocusable(false); // 버튼 불투명화
		setContentAreaFilled(false); // 버튼의 영역 불투명화
		setBounds(470, 450, icon.getIconWidth(), icon.getIconHeight()); // 버튼 크기지정
		addMouseListener(this); // 버튼의 액션 
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// 버튼위에 마우스가 갔을때
		setIcon(PRESS_ENTER_WHITE);// 흰색으로 바뀜
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// 버튼위에 마우스가 떨어졌을때
		setIcon(PRESS_ENTER_BLACK);// 다시 원상태로
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// 버튼이 눌릴떄
		DF.getContentPane().removeAll(); // 현재 그려져있는 것을 다 지움
		DF.add(new Select_Background(DF));// Select_Background 패널 불러옴
		DF.revalidate(); // 불러온것을 보이기 위해 다시 그림 

	}
	public void mouseMoved(MouseEvent e) {
		setIcon(PRESS_ENTER_BLACK);
	}

}
