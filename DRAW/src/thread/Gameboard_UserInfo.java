package thread;

import Default.Default_Socket;
import Gameboard_Screen.Card_Screen;
import Gameboard_Screen.GameBaord_Background;
import Util.ReceiveServer;
import Util.SendServer;
import gameCharacter_Screen.Position_Screen;

public class Gameboard_UserInfo implements Runnable {

	public void run() {
		while(true) {
			String Messege = ReceiveServer.ReceiveData(Default_Socket.getInData());
			if(Messege.equals("TurnStart"))
				GameBaord_Background.myTurnStart();
			else if(Messege.equals("TurnEnd"))
				GameBaord_Background.myTurnEnd();
			else if(Messege.equals("SemiTurn")) {
				GameBaord_Background.SemiTurnStart();
			}else if(Messege.equals("SemiFighting")) {
				GameBaord_Background.SemiFightStart();
			}else if(Messege.equals("SemiEnd"))
				GameBaord_Background.SemiTurnEnd();
			else if(Messege.equals("Wait"))
				GameBaord_Background.SemiTurnEnd();
			else if(Messege.equals("Resume"))
				GameBaord_Background.Resume();
			else if(Messege.equals("Position")) {
				System.out.println(Messege);
				Position_Screen.MyPosition();
			}
			else if(Messege.equals("ActiveRoll")) {
				System.out.println(Messege);
				GameBaord_Background.onPhase2();
			}
			else if(Messege.equals("ActiveCard")) {
				System.out.println(Messege);
				GameBaord_Background.onPhase3();
			}
			else if (Messege.startsWith("Hands")) {
				System.out.println(Messege);
				Card_Screen.Draw_Card(Messege);
				GameBaord_Background.cardRepaint();
			}
			else if (Messege.startsWith("Range")) {
				GameBaord_Background.setAttackList(Messege);
			}
			else if(Messege.startsWith("Profile")) {
				String [] words= Messege.split(":");
				GameBaord_Background.setInfo(words[1],words[2],words[3]);
			}else {
				System.out.println("겜유인"+Messege);
				SendServer.SendData(Default_Socket.getOutRoomInfo(), "End");
				System.out.println("여기");
				break;
			}
		}
	}
	
	
	
	
}
