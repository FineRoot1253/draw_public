package game;

import java.util.ArrayList;

import character.GameCharacter;
import common.Send;

public class End {

	public static void gameEnd(ArrayList<GameCharacter> users) {
		for(int i = 0; i < users.size();i++) {
			users.get(i).EndGaming();
			users.get(i).reset();
		}
		Send.sendAll("End", users, 2);
	}
	
}
