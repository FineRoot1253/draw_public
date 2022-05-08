package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import character.GameCharacter;
import common.Send;

public class Card {
	public String Act, Circum;
	private String[] Active = { "Bang", "Beer", "Avoid", "GatlingGun", "Fighting", "VarietyStore", "IndianAmbush",
			"TavernBrawl" };
	private String[] circumstance = { "Bright", "Fog", "LightOut", "Wilderness", "Tornado", "Snow" };

	public Card() {
		Act = Active[(int)( Math.random() * 8)];
		
		//Circum = circumstance[(int) Math.random() * 6];
	}
	public String getActive() {
		return Act;
	}
	public String toString() {
		return Act;
	}
	public String getCircumstance() {
		return Circum;
	}
	public boolean isBeer() {
		return this.toString().equals("Beer");
	}
	public boolean isAvoid() {
		return this.toString().equals("Avoid");
	}

	static public void Bang(GameCharacter user, ArrayList<GameCharacter> orders) throws IOException {
		String react;
			
			react = Turn.Bang_SemiTurn(user);
			System.out.println(react);
			if(react.equals("Avoid")) {
				user.removeCard(react);
				Send.sendAll("Result:Avoid", orders, 2);
			}
			else if(react.equals("Beer")) {
				user.removeCard(react);
				Send.sendAll("Result:Beer", orders, 2);
			}
		
			else {
			Send.sendAll("Result:Bang", orders, 2);
			user.DownHp();	
			}
	
		
	}
	
	
	
	static public String CardtoString(GameCharacter user, ArrayList<Card> cards) {//수정
		String C2S = "Hands:";
		for (int i = 0; i < cards.size(); i++) {
			C2S += cards.get(i).toString() + ":";
		}
		
		return C2S;
	}
	
	static public void Bear(GameCharacter user) {
		user.setHp((user.getHp()+1));
	
	}

	static public void GatlingGun(ArrayList<GameCharacter> orders) throws IOException {
		for(int i = 1; i < orders.size();i++) {
			Bang(orders.get(i),orders);
		}
	}

	static public void Fighting(GameCharacter Duelist, GameCharacter Receiver) throws IOException {
		String act;
		boolean DuelistT = false;
		boolean Fighting = true;
		while(Fighting){
			if(!DuelistT) {
				act = Turn.FightingSemiturn(Receiver);
				if(act.equals("Bang"))
					DuelistT = true;
				else {
					Fighting = false;
					Receiver.DownHp();
				}
				
			}
			else {
				act = Turn.FightingSemiturn(Duelist);
				if(act.equals("Bang"))
					DuelistT = false;
				else {
					Fighting = false;
					Duelist.DownHp();
				}
			}
			
			
			
		}
		
	}

	static public void VarietyStore(ArrayList<GameCharacter> orders) throws IOException {
		ArrayList<Card> card = new ArrayList<Card>();
		String cards = "";
		int choice;
		for (int i = 0; i < orders.size(); i++) {
			card.add(new Card());
			
		}
		for (int i = 0; i <orders.size(); i++) {
			for (int j = 0; j < card.size(); j++) {
				cards += card.get(i)+":";
			}
			Send.sendAll(cards,orders, 1);
			choice = Turn.VarietyStore_SemiTurn(orders.get(i % orders.size()),cards);
			if(orders.get(i).getCard().size() < 5)
				orders.get(i).addCard(card.get(choice));
			
			card.remove(choice);
			cards = "";
		}
	}

	static public void IndianAmbush(ArrayList<GameCharacter> orders ) throws IOException {
		for(int i = 0; i < orders.size();i++) {
			Bang(orders.get(i),orders);
		}
	}

	static public void TavernBrawl(GameCharacter user, ArrayList<GameCharacter> orders) throws  IOException, InterruptedException {
		ArrayList<Integer> Dice = new ArrayList<Integer>();
		int [] result =  new int[orders.size()];
		int max = 0;
		for (int i = 1; i <= 100; i++) {
			Dice.add(i);
		}
		Collections.shuffle(Dice);
		for (int i = 0; i < orders.size(); i++) {
			result[i] = Dice.remove(0);
			if(max < result[i])
				max = result[i];
			Send.sendAll(orders.get(i) + ":" +result[i], orders, 1);
			Thread.sleep(500);
		}
		for (int i = 0; i < result.length; i++) {
			if (max > result[i]) {
				orders.get(i).DownHp();
				//피연동 추가
				Send.sendData(orders.get(i).getChatOut(), "운나쁘면 맞아야지");
			}
		}
	
	
	}
	/*
	private void Bright() {
		
	}

	private void Fog() {
		
	}
	
	private void LightOut() {
		
	}
	private void Wilderness() {
		
	}
	private void Tornado() {
		
	}
	private void Snow() {
		
	}
	public void usingCircumCard() {
		
		switch (Circum) {
		case "Bright" : Bright();
					break;
		case "Fog" : Fog();
					break;
		case "LightOut" : LightOut();
					break;
		case "Wilderness" : Wilderness();
					break;
		case "Tornado" : Tornado();
					break;
		default : Snow();
					break;
		}
	}
	*/
}