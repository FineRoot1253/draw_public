package Util;

import java.io.DataOutputStream;
import java.io.IOException;

public class SendServer {
	public static void SendData(DataOutputStream out, String data) {
		try {
			out.writeUTF(data);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public static void SendData(DataOutputStream out, int data) {
		try {
			out.writeInt(data);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
