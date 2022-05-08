package common;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import DB.BFDAO;
import DB.GRDAO;
import DB.MEMDAO;
import DB.ROOMDAO;
import DB.STDAO;
import login.Login;
import login.SignUp;


public class Access {             
// Client 가 Server에 최초로 접속
	private static ServerSocket ChatServer; 	// 채팅 서버 소켓
	private static ServerSocket RoomInfoServer; // 룸 정보 서버 소켓
	private static ServerSocket Info;			// 유저 정보 서버 소켓
	private Socket userInfo; 
	
	public Access() {
		
		try {
			Info = new ServerSocket(9000);
			ChatServer = new ServerSocket(9001);
			RoomInfoServer = new ServerSocket(9002);
		// 	서버와 클라이언트간 유저 정보 Port : 9000 
			BFDAO.getInstance();
			GRDAO.getInstance();
			MEMDAO.getInstance();
			ROOMDAO.getInstance();
			STDAO.getInstance();
		//  DB랑 연결시작	
			while(true) {
		//	Server의 Main 쓰레드는 무한 반복을 하여 클라이언트의 접속을 기다림 
				userInfo = Info.accept();
		
				String select = Receive.ReceiveData(new DataInputStream(userInfo.getInputStream()));
				if(select.equals("login"))
					new Thread(new Login(userInfo)).start();
				else {
					new Thread(new SignUp(userInfo)).start();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Socket startChat() {
	//	Chatting 쓰레드 생성
		Socket Chat = null;
		
		try {
			Chat = ChatServer.accept();
		}catch (IOException e) {
			System.out.println("채팅 쓰레드 생성부분에서 예외 발생");
		}
		
		return Chat;
	}
	
	public static Socket startRoomInfo() {
	//	RoomInfo 쓰레드 생성
		Socket RoomInfo = null;
		
		try {
			RoomInfo = RoomInfoServer.accept();

		} catch (IOException e) {
			System.out.println("롬정보 쓰레드 생성부분에서 예외 발생");
		}
		
		return RoomInfo;
	}
}
