package thread;

import Default.Default_Socket;
import Room_Screen.Room_Background;
import Util.ReceiveServer;
import Util.SendServer;

public class InRoom_UserInfo implements Runnable {
	
	public InRoom_UserInfo() {
		new Thread(this).start();
	}
	
	public void run() {
		while(true) {
			
			String userName = ReceiveServer.ReceiveData(Default_Socket.getInData());
			System.out.println("inroom" + userName);
			if(userName.equals("InRoomUser")) {
				int count = 0;
				Room_Background.ClearUser();
				while(true) {
					
					userName = ReceiveServer.ReceiveData(Default_Socket.getInData());
					if(userName.equals("End"))
						break;
					
					String[] words = userName.split(":");
					System.out.println(userName);
					Room_Background.SetUser(count, words[0],words[1]);
					System.out.println(count+words[0]+words[1]);
					count++;
				}
			}
			else if(userName.startsWith("Ready")) { //레디 사인
				userName = userName.substring(5);
				if(userName.startsWith("On")) {
					userName = userName.substring(2);
					int num = Integer.parseInt(userName);
					Room_Background.OnReady(num);
				}
				else {
					userName = userName.substring(3);
					int num =(Integer.parseInt(userName));
					Room_Background.OffReady(num);
				}
			}
			
			else if(userName.startsWith("Can ")) // 시작할 수 있다
				Room_Background.setCanStart();
			else if(userName.startsWith("Can't ")) // 시작 못한다
				Room_Background.setCantStart();
			else if(userName.startsWith("Start")) {  // 시작~
				Room_Background.gameStart();
				new Thread(new Gameboard_UserInfo()).start();
				break;
			}
			else if(userName.equals("Move")) {
				new UserInfo();
				break;
			}
		}
	}

}
