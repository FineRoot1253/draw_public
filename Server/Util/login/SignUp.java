package login;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import DB.MEMDAO;
import common.Disconnect_User;
import common.Receive;
import common.Send;

public class SignUp implements Runnable{

	private Socket userInfo;
	private DataOutputStream outData;
	private DataInputStream inData;

	public SignUp(Socket userInfo) throws IOException {
		this.userInfo = userInfo;
		this.inData = new DataInputStream(userInfo.getInputStream());
		this.outData = new DataOutputStream(userInfo.getOutputStream());
	}

	public void Disconnet() {
		Disconnect_User.DisconnectStream(inData);
		Disconnect_User.DisconnectStream(outData);
		Disconnect_User.DisconnectSocket(userInfo);
	}

	public void run() {

		String SignUp_Receive_Data;
		while(true) {
			SignUp_Receive_Data = Receive.ReceiveData(inData);

			if(SignUp_Receive_Data.equals("System")) {
			
				Disconnet();
				break;
			}

			String[] words = SignUp_Receive_Data.split(":");

			System.out.println(SignUp_Receive_Data);

			if(MEMDAO.getInstance().insertMEM(words[0], words[1], words[2], words[3], words[4])) {
				System.out.println("회원가입 성공");
				Send.sendData(outData, "SignUpAccept");

				Disconnet();
				break;
			}else {
				System.out.println("회원가입 실패");
				Send.sendData(outData, "Error");
			}
		}
	}
}
