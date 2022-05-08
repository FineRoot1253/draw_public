package Room_Screen;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Room_UserList extends JPanel {
	// 방안의 유저들이 있는 패널을 그리는 클래스 
	private static Room_User_Button RUB1;
	private static Room_User_Button RUB2;
	private static Room_User_Button RUB3;
	private static Room_User_Button RUB4;
	private static Room_User_Button RUB5;
	
	public Room_UserList() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setOpaque(false);
		setBounds(57, 200, 1110, 540);
		RUB1 = new Room_User_Button();
		RUB2 = new Room_User_Button();
		RUB3 = new Room_User_Button();
		RUB4 = new Room_User_Button();
		RUB5 = new Room_User_Button();
		add(RUB1);
		add(RUB2);
		add(RUB3);
		add(RUB4);
		add(RUB5);
		setVisible(true);
	}
	public static Room_User_Button getButton(int num) {
		Room_User_Button btn = null;
		switch(num) {
		case 0:
			btn = RUB1;
			break;
		case 1:
			btn = RUB2;
			break;
		case 2:
			btn = RUB3;
			break;
		case 3:
			btn = RUB4;
			break;
		case 4:
			btn = RUB5;
			break;
		}
		return btn;
	}
}
