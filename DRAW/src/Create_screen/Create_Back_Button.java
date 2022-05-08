package Create_screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Frame;
import Lobby_Screen.Lobby_Background;
import Main_Screen.Main_Background;

public class Create_Back_Button extends Default_Button_Event{
	// 방생성 화면에서 로비로 돌아가는 버튼 
	private ImageIcon CREATE_BACK_IN = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/CREATE/CREATE_BACK_BUTTON_IN.png"));
	private ImageIcon CREATE_BACK_ENTER = new ImageIcon(Main_Background.class.getResource("/Image/LOBBY_SCREEN/CREATE/CREATE_BACK_BUTTON_ENTER.png"));
	private Lobby_Background LB;
	
	public Create_Back_Button(ImageIcon icon, Lobby_Background LB) {
		this.LB = LB;
		setIcon(icon);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setBounds(744,580, icon.getIconWidth(), icon.getIconHeight());
		addMouseListener(this);
	}
	public void mouseEntered(MouseEvent e) {
		setIcon(CREATE_BACK_ENTER);//������� �ٲ�
		setCursor(new Cursor(Cursor.HAND_CURSOR));// Ŀ���� �հ��� �������
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(CREATE_BACK_IN);// �ٽ� �����·�
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// Ŀ���� �⺻����
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Create_Background.CREATE_TextField.setText("");
		Lobby_Background.CreateSetvisible();
		
	}

}
