package lobby;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import DB.BFDAO;
import DB.STDAO;
import character.GameCharacter;
import common.Commend;
import common.Disconnect_User;
import common.Receive;
import common.Send;
import login.Login;
import room.Room;

public class UserInfo implements Runnable {
	private GameCharacter user;
	
	public UserInfo(GameCharacter user) throws IOException {
		this.user = user;
	}
	
	public static void SendUserInfo(GameCharacter user) {
		
		Room lobby = Channel.getRoom(user.getChannelNumber(), 0);
		
		Send.sendAll("User", lobby.getArrayList(),0);
		
		for(int i = 0; i < Channel.getRoomsSize(user.getChannelNumber()); i++) {
			
			Room room = Channel.getRoom(user.getChannelNumber(), i);
			System.out.println(room != null);
			if(room != null) {
				for(int j = 0; j < room.getRoomSize(); j++)
					Send.sendAll(room.getUserName(j), lobby.getArrayList(),0); // 여기가 유저 전체 목록 전송
			}
		}
		Send.sendAll("End", lobby.getArrayList(),0); // 여기가 유저 목록 전체 전송
	}
	
public static void SendInRoomUserInfo(GameCharacter user, int RoomNum) {
		
		Room InRoom = Channel.getRoom(user.getChannelNumber(), RoomNum);
		
		Commend.sleep(InRoom.getDelay() * 50);
		InRoom.setDelay();
		
		Send.sendAll("InRoomUser", InRoom.getArrayList(),0);
		for(int i = 0; i <InRoom.getArrayList().size(); i++) {
			Send.sendAll(InRoom.getUserName(i)+":"+InRoom.getUserReady(i), InRoom.getArrayList(),0); // 여기가 유저 전체 목록 전송
		}
		Send.sendAll("End", InRoom.getArrayList(),0); // 여기가 유저 목록 전체 전송
	}
	
	public static void SendFriendInfo(GameCharacter user) throws IOException {
		
		HashMap<String, Integer> bf_map = new HashMap<>();   // 친구 목록을 받기위한 Map
		bf_map=BFDAO.getInstance().selectBF(user.getId()); 	 // 친구 목록을 DB에서 받아옴
		Iterator<String> it = bf_map.keySet().iterator();
		
		Send.sendData(user.getUserOut(), "Friend");
		
		while(it.hasNext()) {
			String name = it.next();
			Send.sendData(user.getUserOut(), name);
			Send.sendData(user.getUserOut(), bf_map.get(name));
		}
		
		Send.sendData(user.getUserOut(), "End");
	}
	
	public void run() {
		while(user.getinLobby()) {
			try {
				String UserInfoData = Receive.ReceiveData(user.getUserIn());
				
				Commend.sleep(200);

				if(UserInfoData.equals("Logout")) {
					Disconnect_User.Disconnect(user,UserInfoData);
					new Login(user.getUserInfo());
					break;
				}else if(UserInfoData.equals("UserInfo")) {
					SendUserInfo(user);
				}else if(UserInfoData.equals("Friend")) {
					SendFriendInfo(user);
				}else if(UserInfoData.equals("AddFriend")){
					String friend = Receive.ReceiveData(user.getUserIn());
					BFDAO.getInstance().insert(user.getId(), friend);
				}else if(UserInfoData.equals("InRoomInfo")) {
					SendInRoomUserInfo(user,user.getRoomNumber());
				}
				else if(UserInfoData.equals("InGame")) {
					break;
				}else if(UserInfoData.equals("Error")) {
					Disconnect_User.Disconnect(user);
				}
					
			} catch (Exception e) {
				System.out.println("여기임");
				e.printStackTrace();
			}
		}
		System.out.println("여기2;");
		
	}
}
