package game;

import java.io.IOException;
import java.util.ArrayList;

import character.GameCharacter;
import common.Send;

public class Turn {

	 static public String Bang_SemiTurn(GameCharacter user) throws IOException {
			Send.sendData(user.getUserOut(),"SemiTurn");
			String act = InGame.getAct(user);
			Send.sendData(user.getUserOut(),"SemiEnd");
			return act;
			
		}
	 static public int VarietyStore_SemiTurn(GameCharacter user, String Cards)  throws IOException {
		 
		 Send.sendData(user.getUserOut(),"SemiDraw");
		 
			//유저 수만큼 드로우
			 // 뱅:뱅:맥주:뱅 목록 보내줌
			 String act = InGame.getAct(user);	
			 Send.sendData(user.getUserOut(),"SemiEnd");
			 return Integer.parseInt(act);
		 
		 
	 }
	 static public String FightingSemiturn(GameCharacter user) throws IOException {
		 Send.sendData(user.getUserOut(),"SemiFighting");
		 String act = InGame.getAct(user);
		 Send.sendData(user.getUserOut(),"SemiEnd");
		 return act;
	 }


}
