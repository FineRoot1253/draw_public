package room;

import java.io.IOException;
import java.util.ArrayList;

import DB.STDAO;
import character.GameCharacter;
import common.Send;
import game.InGame;
import lobby.Channel;

public class Room  {
	// 방 클래스
	public static int roomNum = 1;
	private ArrayList<GameCharacter> users = new ArrayList<GameCharacter>();
//	방 안에 있는 유저정보
	private int roomNumber;
	private String roomName;
	private int ReadyUsers;
	private boolean CanStart;
	private InGame gaming = null;
	private GameCharacter user;
	private int delay;
	
	public Room(int roomNum,String roomName, GameCharacter user) {
		ReadyUsers = 0;
		this.roomNumber = roomNum;
		this.roomName = roomName;
		this.user = user;
		users.add(user);
		user.setRoomNumber(roomNumber);
		STDAO.getInstance().update(user.getId(), user.getChannelNumber(),user.getRoomNumber());
	}
	
	public void addUser(GameCharacter user) {
//	방에 유저 접속
		users.add(user);
		user.setRoomNumber(roomNumber);
		STDAO.getInstance().update(user.getId(), user.getChannelNumber(),user.getRoomNumber());
	}
	
	public void removeUser(GameCharacter user) {
		users.remove(user);
	}
	
	public void backUser(GameCharacter user) {
		removeUser(user);
		Channel.getRoom(user.getChannelNumber(), 0).addUser(user);	
		STDAO.getInstance().update(user.getId(), user.getChannelNumber(),user.getRoomNumber());
	}
	
	public int getDelay() {
		delay++;
		return delay;
	}
	
	public void setDelay() {
//	딜레이 초기화
		if(delay >= 4)
			delay = 0;
	}
	
	public String getUserName(int i) {
		return users.get(i).getNickName();
	}
	public boolean getUserReady(int i) {
		return users.get(i).getReady();
	}
	
	public int getRoomSize() {
		return users.size();
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public String getRoomName() {
		return String.format("%s", roomName);
	//	방 제목을 받아옴
	}
	public ArrayList<GameCharacter> getArrayList() {
		return users;
	}
	public void userReadyAction() {
		
		StartCheck(getReadyCount());
	}
	public int getReadyCount() {
		int ReadyCount = 0;
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getReady() == true) {
				ReadyCount++;
			}
		}
		
		return ReadyCount;
	}
	public void userInOut() {
		StartCheck(getReadyCount());
	}
	public void StartCheck(int ReadyUsers) {
		System.out.println(ReadyUsers+"as"+users.size());
		if(CanStart == false && ReadyUsers == users.size()) {
			Send.sendAll("방장이 한번 더 레디버튼을 누르시면 시작합니다.", users, 1);
			try {
				if(users.size()!= 0)
					Send.sendData( users.get(0).getUserOut(),"Can Start" ); // 시작할 수 있다고 보내줌
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				Send.sendData( users.get(0).getUserOut(),"Can't Start" );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void GameStart() throws IOException {
		
		Send.sendAll("Start", users, 2);
		delay = 0;
		gaming = new InGame(users);
		new Thread(gaming).start();

	}
	public InGame getGame() {
		return gaming;
	}
}
