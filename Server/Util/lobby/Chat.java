package lobby;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import character.GameCharacter;
import common.Receive;
import common.Send;
import room.Room;

public class Chat implements Runnable {
	private GameCharacter user;
	private Socket chat;
	private Room user_room;
	private ArrayList<GameCharacter> user_room_cli;
	private DataInputStream inChat;
	private DataOutputStream outChat;
	private String ChatText;
	
	public Chat(GameCharacter user){
		
		this.user= user;
		this.chat = user.getChat();
		//클라이언트의 유저 정보 Socket을 받아옴
		try {
			this.inChat = new DataInputStream(chat.getInputStream());
			this.outChat = new DataOutputStream(chat.getOutputStream());
		} catch (IOException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
	}

	public void run() {
		common.Send.sendData(outChat, "접속하신걸 환영합니다.");
		while(user.getChatState()) {
			ChatText = Receive.ReceiveData(inChat);
			user_room = Channel.getRoom(user.getChannelNumber(), user.getRoomNumber()); // 채널과 방번호로 룸 클래스 받아옴
			user_room_cli = user_room.getArrayList(); // 받아온 룸 클래스로 접속자 어레이 리스트를 받아옴 
			
			if(ChatText.startsWith("/w ")) { 
				boolean Suc = false;
				System.out.println("귓속말 실행");
				// /w하고 이름을 붙여쓰는 경우 방지
				ChatText = ChatText.substring(3);
				String[] words = ChatText.split("\\s", 2);
				try {
				for (GameCharacter target : user_room_cli) {
					if(target.getNickName().equals(words[0])) {
						Send.sendData(target.getChatOut(),"SYSW "+user.getNickName()+"님으로 부터 받은 메세지 : "+words[1]);
						Send.sendData(user.getChatOut(),"SYSW "+ user.getNickName()+"님이 보낸 메세지 : "+words[1]);
						Suc =  true; // 귓속말 성공
						
					}
				}
				System.out.println("설마 여기?" + words[0]);
					if(Suc == false) // 귓속말 실패시
						Send.sendData(user.getChatOut(),"SYSW " +words[0]+"의 닉네임을 가진 유저가 없습니다.");
					else // 귓속말 성공시 초기화
						Suc = false;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else if(!ChatText.equals("Error")) {
				ChatText = user.getNickName() +" : "+ ChatText;
				Send.sendAll(ChatText,user_room_cli,1);
			}
		}
	}
}
