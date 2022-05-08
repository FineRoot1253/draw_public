package thread;

import java.awt.Color;

import javax.swing.JTextArea;

import Default.Default_Socket;
import Util.ReceiveServer;


public class ChatThread implements Runnable {
	private static JTextArea Chat_TextArea;
	private String text;
	public ChatThread() {
		new Thread(this).start();
		this.text = null;
	}
	
	public static void SetTextArea(JTextArea TA) {
		Chat_TextArea = TA;
	}
	
	
	public void run() {
		while(true) {
			text = ReceiveServer.ReceiveData(Default_Socket.getInChat());
		if(text.equals("Logout")) 
				break;
			 if(text.startsWith("SYSW ")) {
				text = text.substring(5); //SYSW 를 지우기 위해서 사용
			}
			Chat_TextArea.append(text + "\n");
			Chat_TextArea.setCaretPosition(Chat_TextArea.getDocument().getLength());
			
			
		}
		
	}

}
