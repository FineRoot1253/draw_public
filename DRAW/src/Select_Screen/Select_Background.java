package Select_Screen;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Default.Default_Frame;
import Main_Screen.Main_Background;

public class Select_Background extends JPanel {
	// 메인화면 다음의 로그인, 회원가입, 설정 선택할수 있는 화면의 패널
	private Image Sel_Background = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/SELECT_BACKGROUND.png")).getImage();
	private ImageIcon LOGIN_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/LOGIN_ENTER.png"));
	private ImageIcon LOGIN_IN = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/LOGIN_IN.png"));
	private ImageIcon SETTING_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/SETTING_ENTER.png"));
	private ImageIcon SETTING_IN = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/SETTING_IN.png"));
	private ImageIcon SIGNUP_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/SIGNUP_ENTER.png"));
	private ImageIcon SIGNUP_IN = new ImageIcon(Main_Background.class.getResource("/Image/SELECT_SCREEN/SIGNUP_IN.png"));


	private Default_Frame DF;
	private Select_Login_Button SLB;
	private Select_Exit_Button SSB;
	private Select_Signup_Button SSiB;

	public Select_Background(Default_Frame DF) {
		this.DF = DF;
		
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// Å©±â °íÁ¤
		setLayout(null);
		SLB = new Select_Login_Button(LOGIN_IN, DF);
		SSB = new Select_Exit_Button(SETTING_IN, DF);
		SSiB = new Select_Signup_Button(SIGNUP_IN, DF);
		add(SLB); // 로그인으로 가는 버튼 추가
		add(SSB); // 셋팅으로 가는 버튼 추가
		add(SSiB);  // 회원가입 가는 버튼 추가
		setVisible(true);
		
	}
	public void paintComponent(Graphics g) {
		g.drawImage(Sel_Background, 0, 0, this.getWidth(),this.getHeight(),this);
		
		
	}


}
