package AddFriends_screen;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Create_screen.Create_Back_Button;
import Default.Default_Frame;
import Lobby_Screen.Lobby_Background;
import Main_Screen.Main_Background;

public class AddFriends_Background extends JPanel{
	// 친구추가 화면을 나타내는 패널 
	private Image FreindsAdd_Background = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/FRIENDS/FRIENDS_SCREEN.png")).getImage();
	private ImageIcon ADDFRIENDS_BACK_IN = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/FRIENDS/FRIENDS_BACK_BUTTON_IN.png"));
	private ImageIcon ADD_IN = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/FRIENDS/FRIENDS_ADD_BUTTON_IN.png"));
	public static JTextField ADD_TextField = new JTextField();
	private Default_Frame DF;
	private AddFriends_Back_Button ABB;
	private Lobby_Background LB;
	private AddFriends_Add_Button AAB;
	
	
	public AddFriends_Background(Default_Frame DF) {
		this.DF = DF;
		setLayout(null);
		setBounds(100,200,1137, 485);
		ABB = new AddFriends_Back_Button(ADDFRIENDS_BACK_IN, LB);
		AAB = new AddFriends_Add_Button(ADD_IN, DF);
		ADD_TextField.setBounds(77, 245, 978, 100);
		ADD_TextField.setBorder(null);
		ADD_TextField.setFont(new Font("Bernard MT",Font.HANGING_BASELINE,50));
		ADD_TextField.setOpaque(false);
		add(ABB);
		add(AAB);
		add(ADD_TextField);
	}
	public void paintComponent(Graphics g) {
	
		g.drawImage(FreindsAdd_Background, 0, 0, this.getWidth(), this.getHeight(), this);		

	}
}
