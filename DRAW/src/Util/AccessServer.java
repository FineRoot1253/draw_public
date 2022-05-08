package Util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import Default.Default_Frame;
import Default.Default_Socket;

public class AccessServer {
	//  �꽌踰꾩뿉 �젒�냽�븯湲� �쐞�빐 �궗�슜
	
	public static void AccessUserInfo() {
		try {
			Default_Socket.setClientSocket(new Socket(InetAddress.getByName("127.0.0.1"), 9000));
			Default_Socket.setOutData(new DataOutputStream(Default_Socket.getClientSocket().getOutputStream()));
			Default_Socket.setInData(new DataInputStream(Default_Socket.getClientSocket().getInputStream()));
		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to the host ");
		}
	}
	
	public static void AccessRoomChat() {
		try {
			Default_Socket.setChat(new Socket(InetAddress.getByName("127.0.0.1"), 9001));
			Default_Socket.setOutChat(new DataOutputStream(Default_Socket.getChat().getOutputStream()));
			Default_Socket.setInChat(new DataInputStream(Default_Socket.getChat().getInputStream())); 

		} catch (UnknownHostException e) {
			System.out.println("여기 실행됨");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to the host ");
		}
		
		try {
			Default_Socket.setRoomInfo(new Socket(InetAddress.getByName("127.0.0.1"), 9002));
			Default_Socket.setOutRoomInfo(new DataOutputStream(Default_Socket.getRoomInfo().getOutputStream()));
			Default_Socket.setInRoomInfo(new DataInputStream(Default_Socket.getRoomInfo().getInputStream())); 

		} catch (UnknownHostException e) {
			System.out.println("여기 실행됨");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to the host ");
		}
	}
}
