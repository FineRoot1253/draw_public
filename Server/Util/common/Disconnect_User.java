package common;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import DB.STDAO;
import character.GameCharacter;
import lobby.Channel;
import lobby.UserInfo;

public class Disconnect_User{
	//!!!
	public static void Disconnect(GameCharacter user,String Logout) throws IOException {
		Channel.getRoom(user.getChannelNumber(), user.getRoomNumber()).removeUser(user);
		STDAO.getInstance().update(user.getId(), 0, 0);
		UserInfo.SendUserInfo(user);
		
		Send.sendData(user.getChatOut(), Logout);
		Send.sendData(user.getRoomOut(), Logout);
		Send.sendData(user.getRoomOut(), -1 + "");
		Send.sendData(user.getUserOut(), Logout);
		
		DisconnectSocket(user.getChat());
		DisconnectSocket(user.getRoomInfo());
		user.Disconnect();
	}
	
	public static void Disconnect(GameCharacter user) {
		Channel.getRoom(user.getChannelNumber(), user.getRoomNumber()).removeUser(user);
		STDAO.getInstance().update(user.getId(), 0, 0);
		UserInfo.SendUserInfo(user);
		
		DisconnectSocket(user.getChat());
		DisconnectSocket(user.getRoomInfo());
		user.Disconnect();
	}
	
	public static void DisconnectSocket(Socket socket) {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("소켓을 닫을 수 없음");
		}
	}
	
	public static void DisconnectStream(DataInputStream inStream) {
		try {
			inStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("InputStream을 닫을 수 없음");
		}
	}
	
	public static void DisconnectStream(DataOutputStream outStream) {
		try {
			outStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("OutputStream을 닫을 수 없음");
		}
	}
}
