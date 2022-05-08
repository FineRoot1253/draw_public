package game;

import java.util.ArrayList;

public class Rule {

	public static int endRule(ArrayList<Integer> aliveJob) {
	
		ArrayList<Integer> alive = aliveJob; 
		
		if(alive.indexOf(1) == -1)
			if(alive.size() == 1 && alive.indexOf(5) != -1)
				return 5;   // 보안관이 죽고, 배신자 혼자 살아남았을 경우 배신자 승리
			else{
				return 3;   // 아닐경우 무법자 승리
			}
		else if(alive.indexOf(3) + alive.indexOf(4) + alive.indexOf(5) == -3)
			return 1;       // 무법자와 배신자가 모두 탈락할 경우 승리
		else
			return -1;      // 게임이 안끝났음
	}
}
