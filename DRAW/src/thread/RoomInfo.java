package thread;

import Default.Default_Frame;
import Default.Default_Socket;
import Lobby_Screen.Lobby_Background;
import Util.ReceiveServer;

public class RoomInfo implements Runnable{
//	방 정보를 받아옴
	private Default_Frame DF;
	
	public RoomInfo(Default_Frame DF) {
		new Thread(this).start();
		this.DF = DF;
	}
	
	@Override
	public void run() {

		while(true) {
			String roomName = ReceiveServer.ReceiveData(Default_Socket.getInRoomInfo());
			if(roomName.equals("Start")) {
				new Thread(new Gameboard_RoomInfo(DF)).start();
				break;
			}
			if(roomName.equals("Logout")) 
				break;
			Lobby_Background.PL.removeAll();
			if(roomName.equals(""))
				break;
			while(!roomName.equals("End")) {
				int roomNum = Integer.parseInt(ReceiveServer.ReceiveData(Default_Socket.getInRoomInfo()));
				
				if(roomNum == 0) {
					Lobby_Background.PL.revalidate();
					Lobby_Background.PL.repaint();
				}else {
					Lobby_Background.AddPlaylistButton(roomName,roomNum,DF);
				}
				roomName = ReceiveServer.ReceiveData(Default_Socket.getInRoomInfo());
			}
		}
	}
}
