package character;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Character{	
	// 시스템 적인 부분에서 사용되는 character
	private boolean ChatState = false;
	
	private boolean onGame = false; // onGame이 true면 게임을 하고있다는 뜻
	private boolean inLobby = false; // inLobby가 true면 로비에 있다는 뜻
	
	private String nickName;	// 유저의 닉네임
	private Socket userInfo; 	// 로그인, 유저정보등 통신 소켓
	private Socket chat;		// 채팅용 통신 소켓
	private Socket roomInfo;	// 방 정보 최신화용 통신 소켓
	private String id; 			// 유저의 아이디 
	private int channelNumber;		// 채널
	private int roomNumber;		// 방번호
	private boolean ready = false; // 레디상태 기본적으로 false
	
	public Character(String id,String nickName,Socket userInfo,Socket chat, Socket roomInfo, int channelNumber){
		this.id = id;
		this.nickName = nickName;
		this.userInfo = userInfo;
		this.chat = chat;
		this.roomInfo = roomInfo;
		this.channelNumber = channelNumber;
		this.roomNumber = 0; // 최초 유저는 방번호 0인 로비에 접속하게 된다.
	}
	
	public String getId() {
		return id;
	}
	
	public String getNickName() {
		return nickName;
	}

	public Socket getUserInfo() {
		return userInfo;
	}
	public DataInputStream getUserIn() throws IOException {
		return new DataInputStream(userInfo.getInputStream());
	}
	public DataOutputStream getUserOut() throws IOException {
		return new DataOutputStream(userInfo.getOutputStream());
	}
	
	
	public Socket getChat() {
		return chat;
	}
	public DataInputStream getChatIn() throws IOException {
		return new DataInputStream(chat.getInputStream());
	}
	public DataOutputStream getChatOut() throws IOException {
		return new DataOutputStream(chat.getOutputStream());
	}


	
	public Socket getRoomInfo() {
		return roomInfo;
	}
	public DataInputStream getRoomIn() throws IOException {
		return new DataInputStream(roomInfo.getInputStream());
	}
	public DataOutputStream getRoomOut() throws IOException {
		return new DataOutputStream(roomInfo.getOutputStream());
	}
	

	
	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	
	public int getChannelNumber() {
		return channelNumber;
	}

	public void setChannelNumber(int channelNumber) {
		this.channelNumber = channelNumber;
	}
	
	public void setReady() {
		//레디 눌렀을 때 상태를 변경
		ready = !ready;
	}
	public void ReadyOff() {
		ready = false;
	}
	public boolean getReady() {
		//레디 값을 받아옴
		return ready;
	}
	
	
	public void Connect() {
		ChatState = true;
		inLobby = true;
	}
	public void Disconnect() {
		ChatState = false;
		inLobby = false;
	}
	public void StartGaming() {
		inLobby = false;
		onGame = true;
	}
	public void EndGaming() {
		onGame = false;
		inLobby = true;
	}
	
	public boolean getinLobby() {
		return inLobby;
	}
	public boolean getonGaming() {
		return onGame;
	}
	public boolean getChatState() {
		return ChatState;
	}
	
}