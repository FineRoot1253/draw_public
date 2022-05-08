package Lobby_Screen;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Default.Default_Frame;
import Default.Default_ScrollBar_UI;
import Util.SendServer;
import Util.ReceiveServer;

public class Lobby_Chat extends JPanel implements ActionListener {
	// 로비화면의 채팅을 담당하는 패널 
	private JTextField Chat_TextField = new JTextField();
	private JTextArea Chat_TextArea = new JTextArea();
	private JScrollPane Chat_TextArea_Scroll = new JScrollPane(Chat_TextArea);

	public  JTextField getChat_TextField() {
		return Chat_TextField;
	}
	
	public Lobby_Chat() {
		setLayout(null); 
		setOpaque(false);
		setBounds(50, 790, 1131, 200);
		add(Chat_TextField);
		add(Chat_TextArea_Scroll);
		Chat_TextArea_Scroll.setVisible(true);
		Chat_TextArea_Scroll.setBounds(3, 0, 1130, 125);
		Chat_TextArea_Scroll.getViewport().setOpaque(false);// 이거까지 넣어줘야지 다 투명화가 됨 
		Chat_TextArea_Scroll.getViewport().setBorder(null);
		Chat_TextArea.setLineWrap(true);
		Chat_TextArea_Scroll.setOpaque(false);
		Chat_TextArea_Scroll.setBorder(null);
		Chat_TextArea_Scroll.getVerticalScrollBar().setUI(new Default_ScrollBar_UI());// 스크롤 ui 
		Chat_TextArea.setOpaque(false);
		Chat_TextArea.setBorder(null);
		Chat_TextArea.setFont(new Font("����", Font.BOLD, 18));
		Chat_TextArea.setEditable(false);
		Chat_TextField.setBounds(0, 130, 1130, 65);
		Chat_TextField.setBorder(null);
		Chat_TextField.setFont(new Font("����", Font.BOLD, 50));
		Chat_TextField.setOpaque(false);
		Chat_TextField.requestFocus();
		Chat_TextField.addActionListener(this);
		
		thread.ChatThread.SetTextArea(Chat_TextArea);
	

	}
	
	
	public void actionPerformed(ActionEvent evt) {
		String text = Chat_TextField.getText();
		SendServer.SendData(Default.Default_Socket.getOutChat(), text);
		Chat_TextField.selectAll();
		Chat_TextField.setText("");
	}
}
