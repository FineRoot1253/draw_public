package Signup_Screen;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Default.Default_Frame;
import Default.Default_Socket;
import Main_Screen.Main_Background;
import Select_Screen.Select_Background;
import Util.AccessServer;
import Util.SendServer;

public class Signup_Background extends JPanel{
	// 회원가입 화면을 나타내는 클래스 
	private Image Sig_Background = new ImageIcon(Main_Background.class.getResource("/Image/SIGNUP_SCREEN/SIGNUP_SCREEN.png")).getImage();
	private ImageIcon SIGNUP_BACK = new ImageIcon(Main_Background.class.getResource("/Image/SIGNUP_SCREEN/SIGNUP_BACK.png"));
	private ImageIcon SIGNUP_BACK_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/SIGNUP_SCREEN/SIGNUP_BACK_ENTER.png"));
	private ImageIcon SIGNUP_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/SIGNUP_SCREEN/SIGNUP_ENTER.png"));
	private JButton SIGNUP_BACKBUTTON = new JButton(SIGNUP_BACK);
	private Signup_Button SB;
	private Default_Frame DF;
	private Signup_Back_Button SBB;
	public static JTextField ID_TextField = new JTextField();
	public static JTextField PW_TextField = new JTextField();
	public static JTextField NAME_TextField = new JTextField();
	public static JTextField Birth_TextField = new JTextField("ex) 19970101 ");
	public static JTextField NickName_TextField = new JTextField();
	
	public Signup_Background(Default_Frame DF) {

		this.DF = DF;
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// Å©±â °íÁ¤
		setLayout(null);
		SBB = new Signup_Back_Button(SIGNUP_BACK,DF,this);
		SB = new Signup_Button(DF,this);
		NAME_TextField.setBounds(830, 265, 500, 100); // 아이디적는 텍스트 필드 생성
		NAME_TextField.setBorder(null); // 택스트 필드 투명화
		NAME_TextField.setFont(new Font("Bernard MT",Font.HANGING_BASELINE,50)); // 폰트 지정 
		NAME_TextField.setOpaque(false);
		ID_TextField.setBounds(830, 375, 500, 100); // 아이디적는 텍스트 필드 생성
		ID_TextField.setBorder(null); // 택스트 필드 투명화
		ID_TextField.setFont(new Font("Bernard MT",Font.HANGING_BASELINE,50)); // 폰트 지정 
		ID_TextField.setOpaque(false);
		PW_TextField.setBounds(830, 485, 500, 100); // 아이디적는 텍스트 필드 생성
		PW_TextField.setBorder(null); // 택스트 필드 투명화
		PW_TextField.setFont(new Font("Bernard MT",Font.HANGING_BASELINE,50)); // 폰트 지정 
		PW_TextField.setOpaque(false);
		Birth_TextField.setBounds(830, 595, 500, 100); // 아이디적는 텍스트 필드 생성
		Birth_TextField.setBorder(null); // 택스트 필드 투명화
		Birth_TextField.setFont(new Font("Bernard MT",Font.HANGING_BASELINE,50)); // 폰트 지정 
		Birth_TextField.setOpaque(false);
		NickName_TextField.setBounds(830, 705, 500, 100); // 아이디적는 텍스트 필드 생성
		NickName_TextField.setBorder(null); // 택스트 필드 투명화
		NickName_TextField.setFont(new Font("Bernard MT",Font.HANGING_BASELINE,50)); // 폰트 지정 
		NickName_TextField.setOpaque(false);
		
		
		add(ID_TextField);
		add(PW_TextField);
		add(NAME_TextField);
		add(Birth_TextField);
		add(NickName_TextField);
		add(SB);	
		add(SBB);
		AccessServer.AccessUserInfo();
		SendServer.SendData(Default_Socket.getOutData(), "signup");
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(Sig_Background, 0, 0, this.getWidth(), this.getHeight(), this);
		

	}

	public static String[] getInfo() {
		//19970321
		String birth = Birth_TextField.getText().substring(0, 4) + "-" + Birth_TextField.getText().substring(4, 6) + "-" + Birth_TextField.getText().substring(6);
		String[] info = {ID_TextField.getText(),PW_TextField.getText(),NAME_TextField.getText(),NickName_TextField.getText(),birth};
		
		return info;
	}
	
	public void setTextField() {
		ID_TextField.setText("");
		PW_TextField.setText("");
		NAME_TextField.setText("");
		Birth_TextField.setText("");
		NickName_TextField.setText("");
	}

}
