package Gameboard_Screen;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Default.Default_ScrollBar_UI;
import Default.Default_Socket;
import Util.SendServer;

public class Game_Chat extends JPanel implements ActionListener{
	// 게임 시 체팅 을 나타내는 패널 클래스
	private static String newline = "\n";
	private JTextField Chat_TextField = new JTextField();
	private JTextArea Chat_TextArea = new JTextArea();
	private JScrollPane Chat_TextArea_Scroll = new JScrollPane(Chat_TextArea);
	public Game_Chat() {
		setLayout(null); 
		setOpaque(false);
		setBounds(1405, 730, 267, 300);
		add(Chat_TextField);
		add(Chat_TextArea_Scroll);
		Chat_TextArea_Scroll.setVisible(true);
		Chat_TextArea_Scroll.setBounds(0, 0, 267, 260);
		Chat_TextArea_Scroll.getViewport().setOpaque(false);// 이거까지 넣어줘야지 다 투명화가 됨 
		Chat_TextArea_Scroll.getViewport().setBorder(null);
		Chat_TextArea.setLineWrap(true);
		Chat_TextArea_Scroll.setOpaque(false);
		Chat_TextArea_Scroll.setBorder(null);
		Chat_TextArea_Scroll.getVerticalScrollBar().setUI(new Default_ScrollBar_UI());// 스크롤 ui 
		Chat_TextArea.setOpaque(false);
		Chat_TextArea.setBorder(null);
		Chat_TextArea.setFont(new Font("굴림", Font.BOLD, 18));
		Chat_TextArea.setEditable(false);
		thread.ChatThread.SetTextArea(Chat_TextArea);
		Chat_TextField.setBounds(0, 260, 267, 30);
		Chat_TextField.setBorder(null);
		Chat_TextField.setFont(new Font("굴림", Font.BOLD, 18));
		Chat_TextField.setOpaque(false);
		Chat_TextField.requestFocus();
		Chat_TextField.addActionListener(this);
		
		
	}
	public void actionPerformed(ActionEvent evt) {
		String text = Chat_TextField.getText();
		SendServer.SendData(Default_Socket.getOutChat(), text);
		//Chat_TextArea.append(text + newline); //area �ʵ忡 ���� ���� �� 
		Chat_TextField.selectAll();
		//Chat_TextArea.setCaretPosition(Chat_TextArea.getDocument().getLength());// ���� �޾� ���̴� �� 
		Chat_TextField.setText("");
	}
}
