package common;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import character.GameCharacter;
public class Send {       
// 전송
	
	public static void sendData(DataOutputStream outData,String data) {
		try {
			outData.writeUTF(data);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void sendData(DataOutputStream outData,int data) {
		try {
			outData.writeInt(data);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public static  void sendAll(String data, ArrayList<GameCharacter> clients, int num) {
//	평소 전달	
		/*
		 * 0 : UserInfo
		 * 1 : Chat
		 * 2 : RoomInfo
		 */
		
		switch(num) {
		case 0:
			for (GameCharacter gameCharacter : clients) {
				try {
					sendData(new DataOutputStream(gameCharacter.getUserOut()),data);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			break;
		case 1:
			 for (GameCharacter gameCharacter : clients) {
					try {
						sendData(new DataOutputStream(gameCharacter.getChatOut()),data);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			 break;
		case 2:
			 for (GameCharacter gameCharacter : clients) {

					try {
						sendData(new DataOutputStream(gameCharacter.getRoomOut()),data);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			 break; 
		}
		
	}
	
	public static void whisper() {
//	귓속말 기능
	}
}
