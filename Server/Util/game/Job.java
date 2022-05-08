package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import character.GameCharacter;
import room.Room;

public class Job {
	
	private final static Integer[] FourMan = {1,3,4};    
	private final static Integer[] RandomMan = {2,5};      // 부관과 배신자 중 랜덤
	private final static Integer[] FiveeMan = {1,2,3,4,5};
//	직업 1 : 보안관 , 2 : 부관 , 3,4 : 무법자 , 5 : 배신자  
	
	public static void SelectJob(ArrayList<GameCharacter> users) {
		
		switch(users.size()) { // 방의 인원에 따라 직업 풀이 결정
		case 4: 
			FourJob(users);
			break;
		case 5: 
			FiveJob(users);
			break;
		}
	}

	
	public static void FourJob(ArrayList<GameCharacter> users) {
		
		ArrayList<Integer> Jobs = new ArrayList<Integer>(Arrays.asList(FourMan));
		Jobs.add(RandomMan[(int)(Math.random() * 2)]);
		
		Collections.shuffle(Jobs);
		
		for(GameCharacter user : users) 
			user.setJob(Jobs.remove(0));
	}
	
	public static void FiveJob(ArrayList<GameCharacter> users) {
		ArrayList<Integer> Jobs = new ArrayList<Integer>(Arrays.asList(FiveeMan));
		
		Collections.shuffle(Jobs);
	
		for(GameCharacter user : users)
			user.setJob(Jobs.remove(0));
	}
}
