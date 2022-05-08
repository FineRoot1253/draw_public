package Gameboard_Screen;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.ImageIcon;

import Default.Default_Button_Event;
import Default.Default_Socket;
import Main_Screen.Main_Background;
import Util.GIF_Thread;
import Util.SendServer;

public class Rolling_Button extends Default_Button_Event {
	// 주사위 굴리기 버튼
	private ImageIcon Dice_Button = new ImageIcon(
			Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/DICE_BUTTON.png"));
	private ImageIcon Dice_Button_ENTER = new ImageIcon(
			Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/DICE_BUTTON_ENTER.png"));
	private static GameBaord_Background GBB;

	public Rolling_Button(GameBaord_Background GBB) {//수정
		this.GBB = GBB;
		setIcon(Dice_Button);
		setBorderPainted(false);
		setFocusable(false);
		setContentAreaFilled(false);
		setEnabled(false);
		setBounds(755, 655, Dice_Button.getIconWidth(), Dice_Button.getIconHeight());
		//addMouseListener(this);

	}

	public void mouseEntered(MouseEvent e) {
		setIcon(Dice_Button_ENTER);// 흰색으로 바뀜
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setIcon(Dice_Button);// 다시 원상태로
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}

	@Override
	public void mousePressed(MouseEvent e) {//수정

		SendServer.SendData(Default_Socket.getOutData(), "REQ_DICE");
		// Dice_Screen DS = new Dice_Screen(Rolling_Button.DiceResult);
		System.out.println("호출완료");
		this.setEnabled(false);
		this.removeMouseListener(this);
		//setVisible(false);
		
		
	}

	public static void useDiceScreen(int i) {
		Dice_Screen DS = new Dice_Screen(i);

		Rolling_Button.GBB.add(DS);
		Rolling_Button.GBB.revalidate();
		Rolling_Button.GBB.repaint();
		new Thread(new GIF_Thread(Rolling_Button.GBB, DS, 1200)).start();
	}

}
