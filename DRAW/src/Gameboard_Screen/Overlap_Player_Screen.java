package Gameboard_Screen;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Default.Default_Socket;
import Main_Screen.Main_Background;
import Util.SendServer;
// 정혁이가 만졌음 
public class Overlap_Player_Screen extends JPanel implements MouseListener{
	// 중첩된 사람 올렸을때 정보뜨는 창 
	
	private Image Overlap_big = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/Overlap_Player_Screen_Big.png")).getImage();
	private ImageIcon OverlapIMG = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/CHARACTER/CHARACTER.png"));
	private JPanel layout;
	private JLabel[] IMF = new JLabel[5];
	private JPanel[] imformation = new JPanel[5];
	private JLabel[] IMG = new JLabel[5];
	private Overlap_Player_Screen_Cancle_Button OPSC;
	private ArrayList<JLabel> names=new ArrayList<JLabel>();
	public Overlap_Player_Screen(ArrayList<JLabel> names) {
		names=names;
		OPSC = new Overlap_Player_Screen_Cancle_Button();
		setLayout(null); 
		setVisible(true);
		setBounds(558,200,479,632);
		setOpaque(false);
		layout = new JPanel();
		layout.setBounds(30,100,450,450);
		layout.setLayout(new GridLayout(0,1));
		layout.setOpaque(false);
		add(OPSC);
		
		for(int i =0;i<names.size();i++) {
			imformation[i] = new JPanel();
			imformation[i].setBounds(30,100,410,90);
			imformation[i].setLayout(null);
			imformation[i].setOpaque(false);
			IMF[i] = new JLabel(names.get(i).getText());
			IMF[i].setHorizontalAlignment(JLabel.CENTER);
			IMF[i].setBounds(80, 0, 370, 90);
			IMF[i].setFont(new Font("굴림", Font.BOLD, 15));
			imformation[i].add(IMF[i]);
			IMG[i] = new JLabel();
			IMG[i].setBounds(0, 0, 80, 90);
			IMG[i].setIcon(OverlapIMG);
			//imformation[i].addMouseListener(this);
			imformation[i].add(IMG[i]);
			
			layout.add(imformation[i]);
		}
		add(layout);
			
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(Overlap_big, 0, 0, this.getWidth(), this.getHeight(), this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		// 여기서 눌렀을때 보내는거 넣으면 됨 
		System.out.println("ㅎㅇ루");
		int index= 0;
		for (int i = 0; i < IMF.length; i++) {
			if(imformation[i].equals(this))
				index = i;
		}
		SendServer.SendData(Default_Socket.getOutData(),"Enemy:"+IMF[index].getText());
		GameBaord_Background.onUcs();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		setCursor(new Cursor(Cursor.HAND_CURSOR));// 커서가 손가락 모양으로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// 커서가 기본으로
	}
	public ArrayList<JLabel> getNames(){
		return this.names;
	}

}
