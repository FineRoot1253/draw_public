package Create_screen;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Default.Default_Frame;
import Lobby_Screen.Lobby_Background;
import Main_Screen.Main_Background;

public class Create_Background extends JPanel{
	// 방생성  화면을 나타내는 패널 
	private Image Create_Background = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/CREATE/CREATE_SCREEN.png")).getImage();
	private ImageIcon CREATE_BACK = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/CREATE/CREATE_BACK_BUTTON_IN.png"));
	private ImageIcon CREATE_IN = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/CREATE/CREATE_CREATE_BUTTON_IN.png"));
	public static JTextField CREATE_TextField = new JTextField();
	private Default_Frame DF;
	private Lobby_Background LB;
	private Create_Back_Button CBB;
	private Create_Button CB;
	
	public Create_Background(Default_Frame DF) {
		this.DF = DF;
		setLayout(null);
		setBounds(100,200,1137, 663);
		CBB = new Create_Back_Button(CREATE_BACK, LB);
		CB = new Create_Button(CREATE_IN, DF);
		CREATE_TextField.setBounds(75, 280, 970, 100);
		CREATE_TextField.setBorder(null);
		CREATE_TextField.setFont(new Font("Bernard MT",Font.HANGING_BASELINE,50));
		CREATE_TextField.setOpaque(false);
		add(CBB);	
		add(CB);
		add(CREATE_TextField);
	}
	public void paintComponent(Graphics g) {
	
		g.drawImage(Create_Background, 0, 0, this.getWidth(), this.getHeight(), this);		

	}

}
