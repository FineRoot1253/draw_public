package Util;

import java.io.DataInputStream;

public class ReceiveServer {

	public static String ReceiveData(DataInputStream in) {
		
		String data;
		
		try {
			data = in.readUTF();
		} catch (Exception e) {
			// TODO: handle exception
			data = null;
		}
		
		return data;
	}
	
	public static int ReceiveInt(DataInputStream in) {
		
		int data;
		
		try {
			data = in.readInt();
		} catch (Exception e) {
			// TODO: handle exception
			data = -1;
		}
		
		return data;
	}

}
