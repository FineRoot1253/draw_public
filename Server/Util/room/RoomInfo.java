package room;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

import character.GameCharacter;
import common.Commend;
import common.Receive;
import common.Send;
import lobby.Channel;
import lobby.UserInfo;

public class RoomInfo implements Runnable {
//	소켓이 필요할 수 있어서 일단 받아옴
	private DataInputStream request;// 	Receive에 필요함
	private GameCharacter user;
	private int channel;

	public RoomInfo(GameCharacter user) {
		//클라이언트의 유저 정보 Socket을 받아옴
		try {
			this.user = user;
			this.channel = user.getChannelNumber();
			this.request = user.getRoomIn();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run() {
		
		roomUpdate();
		//	최초 유저의 로비에 방목록을 뿌려줌
		
		while(user.getinLobby()) {
			switch(Receive.ReceiveData(request)) {
		//	클라이언트로부터 방 생성 및 방 접속 신호를 받아옴
			case "Create":
				createRoom();
				break;
			case "Join":
				joinRoom(Receive.ReceiveInt(request));
				break;
			case "back":
				removeRoom();
				break;
			case "reload":
				roomUpdate();
				break;
			case "Error":
				break;
			case "Ready":
				userReady(user);
				break;
			case "Start":
				gameStart(user);
				break;
			case "InGame":
				try {
					new Thread(new game.Game_RoomInfo(user)).start();
					System.out.println("빰빰");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}	
		}
		System.out.println(user.getNickName() + "쓰레드 꺼짐");
	
	}
	
	public void createRoom() {
	//	방 생성
		System.out.println("실행");
		String roomName = Receive.ReceiveData(request);
		int roomSize = Channel.getRoomsSize(user.getChannelNumber());
		Channel.getRoom(channel,user.getRoomNumber()).removeUser(user);
		if(roomSize == Room.roomNum) {
			Channel.getRooms(channel).put(Room.roomNum++, new Room(Room.roomNum-1,roomName, user));
			Room.roomNum++;
		}else {
			for (int i = 1; i < Room.roomNum; i++) {
				if(Channel.getRoom(user.getChannelNumber(),i) == null) {
					Channel.getRooms(channel).put(i, new Room(i,roomName, user));
					break;
				}
			}
		}
		roomUpdate();
		try {
			Send.sendData(user.getUserOut(), "Move");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void joinRoom(int roomNum) {
	//	방 접속
		if(Channel.getRoom(user.getChannelNumber(), roomNum).getRoomSize() <= 5) {
			Channel.getRoom(channel,user.getRoomNumber()).removeUser(user);
			Channel.getRoom(channel,roomNum).addUser(user);
			
			try {
				Send.sendData(user.getUserOut(), "Move");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Channel.getRoom(user.getChannelNumber(), roomNum).userInOut();
		}else {	// 5명 넘어갈때 어케 처리할지 결정
				
		}
		
	}
	
	public void roomUpdate() {
		
		Commend.sleep(100);
	
		int roomNum = Channel.getRooms(channel).size();

		for(int i = 1; i < Room.roomNum; i++) {
			if(Channel.getRoom(channel, i) != null) {
				Send.sendAll(Channel.getRoom(channel,i).getRoomName(),Channel.getRoom(channel, 0).getArrayList(),2);
				Send.sendAll(Channel.getRoom(channel,i).getRoomNumber()+"",Channel.getRoom(channel, 0).getArrayList(),2);
			}
		}
		if(roomNum == 1) {
			Send.sendAll(Channel.getRoom(channel,0).getRoomName(),Channel.getRoom(channel, 0).getArrayList(),2);
			Send.sendAll(0+"",Channel.getRoom(channel, 0).getArrayList(),2);
		}
		Send.sendAll("End",Channel.getRoom(channel, 0).getArrayList(),2);
	}
	
	synchronized public void removeRoom() {
		
		int beforeRoomNum = user.getRoomNumber();
		try {
			Send.sendData(user.getUserOut(), "Move");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!Channel.getRoom(channel,user.getRoomNumber()).getRoomName().equals("lobby")) {
			if(Channel.getRoom(channel,user.getRoomNumber()).getRoomSize() != 1){
				if(user.getReady() == true) {
					//레디 박은 유저가 나갔을 때 
					user.ReadyOff();
				}
				Channel.getRoom(channel,user.getRoomNumber()).backUser(user);
				Channel.getRoom(user.getChannelNumber(), beforeRoomNum).userInOut();
				UserInfo.SendInRoomUserInfo(user,beforeRoomNum);
				
			}
			else {
				Channel.getRoom(channel,user.getRoomNumber()).backUser(user);
				Channel.getRooms(channel).remove(beforeRoomNum);   
			}
		}
		
		roomUpdate();
		
	}
	public void userReady(GameCharacter user) {
		int i;
		user.setReady();
		Room userR = Channel.getRoom(user.getChannelNumber(), user.getRoomNumber());
		ArrayList<GameCharacter> user_room = userR.getArrayList();
		for ( i = 0; i < user_room.size(); i++) {
			if(user.getNickName().equals(user_room.get(i).getNickName()))
				break;
		}
		if(user.getReady() == true) {
			Send.sendAll("ReadyOn"+i,user_room, 0);
			userR.userReadyAction();
		}
		else {
			Send.sendAll("ReadyOff"+i,user_room, 0);
			userR.userReadyAction();
		}
			
	}
	public void gameStart(GameCharacter user) {
		Room userR = Channel.getRoom(user.getChannelNumber(), user.getRoomNumber());
		ArrayList<GameCharacter> user_room = userR.getArrayList();
		Send.sendAll("Start",user_room, 0);
		try {
			userR.GameStart();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
