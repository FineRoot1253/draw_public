package game;

import java.io.IOException;
import java.util.ArrayList;

import character.GameCharacter;
import common.Receive;
import common.Send;
import lobby.Channel;
import lobby.UserInfo;
import room.RoomInfo;

public class Game_RoomInfo implements Runnable {
	
	private ArrayList<GameCharacter> users;
	private GameCharacter user;
	private InGame gaming;
	
	public Game_RoomInfo(GameCharacter user) throws IOException {
		this.users = Channel.getRoom(user.getChannelNumber(), user.getRoomNumber()).getArrayList();
		user.StartGaming();
		user.setReady();
		this.user = user;
		gaming = Channel.getRoom(user.getChannelNumber(), user.getRoomNumber()).getGame();
	}
	
	
	public void run() {
		try {

			Receive.ReceiveData(user.getRoomIn());
			
			Send.sendData(user.getUserOut(), "End");
			
			Receive.ReceiveData(user.getRoomIn());
			
			new Thread(new RoomInfo(user)).start();
			new Thread(new UserInfo(user)).start();
			

			UserInfo.SendInRoomUserInfo(user, user.getRoomNumber());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
