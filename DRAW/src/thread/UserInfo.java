package thread;

import Default.Default_Socket;
import Lobby_Screen.Lobby_Background;
import Room_Screen.Room_Background;
import Util.ReceiveServer;
import Util.SendServer;

public class UserInfo implements Runnable{
	
	public UserInfo() {
		new Thread(this).start();
	}
	
	public static void getUserInfo() {
		// 유저 정보를 받아오는 메서드
		SendServer.SendData(Default_Socket.getOutData(), "UserInfo");
	}
	
	public void run() {
		while(true) {
			String userName = ReceiveServer.ReceiveData(Default_Socket.getInData());
			int state;
			
			if(userName.equals("Logout")) {
				break;
			}else if(userName.equals("User")) {
			
				
				Lobby_Background.PLS.removeAll();//	유저 목록을 초기화
				
				userName = ReceiveServer.ReceiveData(Default_Socket.getInData());
				
				while(!userName.equals("End")){
					

						
					Lobby_Background.AddUserlistButton(userName);
					
					userName = ReceiveServer.ReceiveData(Default_Socket.getInData());
				}
			}else if(userName.equals("Friend")) {
				
				Lobby_Background.FLS.removeAll();
				
				userName = ReceiveServer.ReceiveData(Default_Socket.getInData());
				
				while(!userName.equals("End")) {
					state = ReceiveServer.ReceiveInt(Default_Socket.getInData());
					Lobby_Background.AddFriendlistButton(userName, state);
					
					userName = ReceiveServer.ReceiveData(Default_Socket.getInData());
				}
			}
			else if(userName.equals("Move")) {
				//InRoom_UserInfo로 간다.
				new InRoom_UserInfo();
				break;
				
			}
		}
	}
	
}
