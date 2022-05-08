package Lobby_Screen;

import Default.Default_Frame;
import Default.Default_Socket;
import Util.ReceiveServer;

public class Lobby_RoomInfo implements Runnable{
//	방 정보를 받아옴
	private Default_Frame DF;
	
	public Lobby_RoomInfo(Default_Frame DF) {
		new Thread(this).start();
		this.DF = DF;
	}
	
	@Override
	public void run() {

		while(true) {
			int roomNum = ReceiveServer.ReceiveInt(Default_Socket.getInRoomInfo());
			String roomName = ReceiveServer.ReceiveData(Default_Socket.getInRoomInfo());
			if(roomName.equals("Logout")) 
				break;
			
			else 
				Lobby_Background.AddPlaylistButton(roomName,roomNum,DF);
			
		}
	}
}
