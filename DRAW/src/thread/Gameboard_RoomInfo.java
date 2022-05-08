package thread;

import Default.Default_Frame;
import Default.Default_Socket;
import Gameboard_Screen.GameBaord_Background;
import Gameboard_Screen.Rolling_Button;
import Util.ReceiveServer;
import gameCharacter_Screen.Position_Screen;

public class Gameboard_RoomInfo implements Runnable {

	private Default_Frame DF;
	
	public Gameboard_RoomInfo(Default_Frame DF) {
		this.DF = DF;
	}
	
	public void run() {
		while (true) {
			String Messege = ReceiveServer.ReceiveData(Default_Socket.getInRoomInfo());

			if (Messege.startsWith("Position")) {
				System.out.println(Messege);
				String[] words = Messege.split(":");
				Position_Screen.ChoosePosition(words[1], words[2], words[3]);
			} else if (Messege.startsWith("MOVEUP")) {
				String[] words = Messege.split(":");
				try {
					Position_Screen.moveUp(words[1], words[2], Integer.parseInt(words[3]), Integer.parseInt(words[4]));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (Messege.startsWith("MOVEDOWN")) {
				String[] words = Messege.split(":");
				try {
					Position_Screen.moveDown(words[1], words[2], Integer.parseInt(words[3]),
							Integer.parseInt(words[4]));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (Messege.startsWith("PlayerNum")) {
				String[] Words = Messege.split(":");
				System.out.println(Words[1]);
				Gameboard_Screen.GameBaord_Background.setUserNum(Integer.parseInt(Words[1]));
			} else if (Messege.startsWith("DiceResult")) {
				String[] Words = Messege.split(":");
				Rolling_Button.useDiceScreen(Integer.parseInt(Words[1]));
			}else if(Messege.startsWith("Table")) {
				Gameboard_Screen.GameBaord_Background.setTable(Messege);
			}else if(Messege.startsWith("weather")){
				String[] words = Messege.split(":");
				GameBaord_Background.getWS().changeIcon(words[1]);
				GameBaord_Background.CutSceen(words[1]);
			}else if(Messege.startsWith("Result")) {
				String[] words = Messege.split(":");
				GameBaord_Background.CutSceen(words[1]);
				
			}else {
				GameBaord_Background.gameEnd(DF);
				break;
			}
		}
	}
}
