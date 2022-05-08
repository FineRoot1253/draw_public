package game;

import java.io.IOException;

import character.GameCharacter;
import lobby.Channel;

public class Game_UserInfo implements Runnable {
	// 아직 유저인포와 룸인포를 어떻게 사용할지 못나눔

	private GameCharacter user;
	private InGame gaming;

	public Game_UserInfo(GameCharacter user) throws IOException {
		this.user = user;
		gaming = Channel.getRoom(user.getChannelNumber(), user.getRoomNumber()).getGame();
	}

	public void run() {

	}
}