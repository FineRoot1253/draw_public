package common;

import java.io.DataInputStream;
import java.io.IOException;

public class Receive {		
// 데이터를 받아오는 클래스
	
	public static String ReceiveData(DataInputStream inData)  {
		try {
		
			return inData.readUTF();
		} catch (IOException e) {
			return "Error";
		//	통신이 갑자기 꺼질 경우 return
		} 
	}
	
	public static int ReceiveInt(DataInputStream inData) {
		try {
			return inData.readInt();
		} catch (IOException e) {

			return -1;
		//	통신이 갑자기 꺼질 경우 return
		}
	}
}
