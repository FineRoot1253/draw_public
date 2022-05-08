package Main_Screen;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Default.Default_Frame;
import Select_Screen.Select_Background;

public class Main_Background extends JPanel {
	// 맨처음 타이틀 화면을 출력하는 클래스다.
	private Image M_Background = new ImageIcon(Main_Background.class.getResource("/Image/Background/MAINBACKGROUND.png")).getImage();
	private ImageIcon PRESS_ENTER_BLACK = new ImageIcon(Main_Background.class.getResource("/Image/Background/PRESS_BLACK.png"));
	private Default_Frame DF;
	private Press_Button Press;

	public Main_Background(Default_Frame DF) {
		
		this.DF = DF; // 디폴트 프레임을 기본 프레임으로 받는다는 것 
		Press = new Press_Button(PRESS_ENTER_BLACK, DF); // PRESS 버튼을 선언
		add(Press); // PRESS 버튼 추가
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// 사이즈를 Default 프레임에 있는 사이즈
		setLayout(null); // 레이아웃은 방식은 null 로 절대 지정 방식
		setVisible(true); // 출력을 하는것 
		

	}

	public void paintComponent(Graphics g) {
	// 패널 배경화면을 그리는 메소드
		g.drawImage(M_Background, 0, 0, this.getWidth(),this.getHeight(),this);	
		// 그릴 이미지를 설정함 
	}

}
