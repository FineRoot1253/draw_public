package Default;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Default_Socket {
	
	
	private static Socket clientSocket;// 기본 접속 정보 => 유저정보 소켓
	private static DataInputStream inData;// 기본 접속 정보 => 유저정보 수신
	private static DataOutputStream outData ; // 기본 접속 정보 => 유저정보 송신
	private static Socket Chat ;//	채팅 소켓
	private static DataInputStream inChat; // 채팅 수신
	private static DataOutputStream outChat; // 채팅 송신
	private static Socket RoomInfo;//	방정보 소켓
	private static DataInputStream inRoomInfo;// 	방정보 수신
	private static DataOutputStream outRoomInfo;// 방정보 송신
	public static Socket getClientSocket() {
		return clientSocket;
	}
	public static void setClientSocket(Socket clientSocket) {
		Default_Socket.clientSocket = clientSocket;
	}
	public static DataInputStream getInData() {
		return inData;
	}
	public static void setInData(DataInputStream inData) {
		Default_Socket.inData = inData;
	}
	public static DataOutputStream getOutData() {
		return outData;
	}
	public static void setOutData(DataOutputStream outData) {
		Default_Socket.outData = outData;
	}
	public static Socket getChat() {
		return Chat;
	}
	public static void setChat(Socket chat) {
		Chat = chat;
	}
	public static DataInputStream getInChat() {
		return inChat;
	}
	public static void setInChat(DataInputStream inChat) {
		Default_Socket.inChat = inChat;
	}
	public static DataOutputStream getOutChat() {
		return outChat;
	}
	public static void setOutChat(DataOutputStream outChat) {
		Default_Socket.outChat = outChat;
	}
	public static Socket getRoomInfo() {
		return RoomInfo;
	}
	public static void setRoomInfo(Socket roomInfo) {
		RoomInfo = roomInfo;
	}
	public static DataInputStream getInRoomInfo() {
		return inRoomInfo;
	}
	public static void setInRoomInfo(DataInputStream inRoomInfo) {
		Default_Socket.inRoomInfo = inRoomInfo;
	}
	public static DataOutputStream getOutRoomInfo() {
		return outRoomInfo;
	}
	public static void setOutRoomInfo(DataOutputStream outRoomInfo) {
		Default_Socket.outRoomInfo = outRoomInfo;
	}
	
	

}
