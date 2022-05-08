package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import character.GameCharacter;
import common.Commend;
import common.Receive;
import common.Send;

public class InGame implements Runnable {
	private GameCharacter Sheriff = null; // 보안관
	private GameCharacter Deputy = null; // 부관
	private GameCharacter OutLaw1 = null; // 무법자
	private GameCharacter OutLaw2 = null; // 무법자
	private GameCharacter Renegade = null;// 스파이
	private String[] jobs = { "보안관", "부관", "무법자", "무법자", "배신자" };
	private static ArrayList<Integer> aliveJob = new ArrayList<Integer>();
	private ArrayList<GameCharacter> users; // 방안에있는 유저리스트
	private ArrayList<GameCharacter> orders = new ArrayList<GameCharacter>(); // 순서대로 만든 유저 리스트

	private GameField gf;

	private String weather[] = { "SUNNY", "MIST", "DARK", "WILDS", "TORNADO" }; // 날씨
	private String selectedWeather = "";
	private int turn = 0; // 턴 수

	public InGame(ArrayList<GameCharacter> users) throws IOException {

		this.users = users;
		gf = new GameField(users.size());
	}

	public void setPlayerJobs(ArrayList<GameCharacter> users) {
		/*
		 * 게임 클래스 내에 각각의 직업에 유저를 담아둔다. 보안관을 제외한 플레이어들은 선정하는 과정에서 순서 배열에 담는다. 보안관은 항상
		 * 첫번째로 플레이하기때문에 선정이 완료된 뒤에 담는다.
		 */
		Job.SelectJob(users);
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).getJob() + "직업번호");
			aliveJob.add(users.get(i).getJob());

			switch (users.get(i).getJob()) {
			case 1:
				Sheriff = users.get(i); // 1이면 보안관
				if (users.size() == 5)
					Sheriff.setHp(5);
				else
					Sheriff.setHp(6);
				System.out.println(Sheriff.getNickName());
				break;
			case 2:
				Deputy = users.get(i);
				Deputy.setHp(5);
				System.out.println(Deputy.getNickName());
				orders.add(Deputy);
				break;
			case 3:
				OutLaw1 = users.get(i);
				OutLaw1.setHp(5);
				System.out.println(OutLaw1.getNickName());
				orders.add(OutLaw1);
				break;
			case 4:
				OutLaw2 = users.get(i);
				OutLaw2.setHp(5);
				System.out.println(OutLaw2.getNickName());
				orders.add(OutLaw2);
				break;
			case 5:
				Renegade = users.get(i);
				Renegade.setHp(5);
				System.out.println(Renegade.getNickName());
				orders.add(Renegade);
				break;
			}
		}
		Collections.shuffle(orders);
		orders.add(0, Sheriff);
	}

	public void TeachJob(ArrayList<GameCharacter> users) {
		if (orders.size() == 4)
			try {
				Send.sendData(Sheriff.getChatOut(), "당신의 직업은 보안관입니다.");
				Send.sendAll(Sheriff.getNickName() + "님이 보안관입니다. ", orders, 1);
				Send.sendData(OutLaw1.getChatOut(), "당신의 직업은 무법자입니다.");
				Send.sendData(OutLaw2.getChatOut(), "당신의 직업은 무법자입니다.");
				if (Renegade == null)
					Send.sendData(Deputy.getChatOut(), "당신의 직업은 부관입니다.");
				else
					Send.sendData(Renegade.getChatOut(), "당신의 직업은 배신자입니다.");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			try {
				Send.sendData(Sheriff.getChatOut(), "당신의 직업은 보안관입니다.");
				Send.sendAll(Sheriff.getNickName() + "님이 보안관입니다. ", orders, 1);
				Send.sendData(OutLaw1.getChatOut(), "당신의 직업은 무법자입니다.");
				Send.sendData(OutLaw2.getChatOut(), "당신의 직업은 무법자입니다.");
				Send.sendData(Deputy.getChatOut(), "당신의 직업은 부관입니다.");
				Send.sendData(Renegade.getChatOut(), "당신의 직업은 배신자입니다.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public ArrayList<GameCharacter> getOrder() {
		return orders;
	}

	public void draw(GameCharacter user) throws IOException {
		// 카드 주기 , 1205 수정
		ArrayList<Card> cards = new ArrayList<Card>();
		if (user.getCard().size() == 5)
			return;

		if (user.getCard().size() < 4) {
			Card drawCard = new Card();
			user.addCard(new Card());
			cards.add(drawCard);
		}
		Card drawCard = new Card();
		user.addCard(new Card());
		cards.add(drawCard);

		System.out.println(Card.CardtoString(user, cards));
		Send.sendData(user.getUserOut(), Card.CardtoString(user, cards));

	}

	public void firstDraw(GameCharacter user) throws IOException {
		// 1205 수정
		ArrayList<Card> cards = new ArrayList<Card>();
		if (user.getJob() == 1) { // 보안관 (1번)이면 5장을 뽑는다.
			for (int i = 0; i < 5; i++) {
				Card drawCard = new Card();
				user.addCard(drawCard);
				cards.add(drawCard);
			}
		} else { // 보안관이 아닌 직업군은 4장을 뽑는다.
			for (int i = 0; i < 4; i++) {
				Card drawCard = new Card();
				user.addCard(drawCard);
				cards.add(drawCard);
			}
		}
		Send.sendData(user.getUserOut(), Card.CardtoString(user, cards));
	}

	/*
	 * public void useCircumCard(GameCharacter user, Card useCard) {
	 * user.getCard().remove(user.getCard().indexOf(useCard.Circum));
	 * useCard.usingCircumCard(); }
	 */
	public void changeWeather() {// 1205 수정
		// 날씨 변경하기
		System.out.println("날씨변경전");
		if (turn == 0) {
			selectedWeather = weather[0];
			Send.sendAll("weather:" + selectedWeather, orders, 2);
			Send.sendAll("날씨가 바뀌었습니다.", orders, 1);
		} else {
			selectedWeather = weather[(int) (Math.random() * 5)];
			Send.sendAll("weather:" + selectedWeather, orders, 2);
			Send.sendAll("날씨가 바뀌었습니다.", orders, 1);
		}
		System.out.println("날씨변경후");
		// Send.sendAll("날씨가 바뀌었습니다.", users, 1);
	}

	public void phase1(GameCharacter user) throws IOException {// 수정
		// 플레이어에게 턴 권한을 준다. 그 후 드로우 2장
		Send.sendAll(orders.get(turn % orders.size()).getNickName() + "님의 턴 시작", orders, 1);
		Send.sendData(user.getUserOut(), "TurnStart");
		if (turn > orders.size() - 1)
			draw(user);

	}

	public void phase2(GameCharacter user) throws IOException {
		String act = "";
		int DiceResult = (int) (Math.random() * 6) + 1;
		int UserPosition;

		String CanAttack = "";
		ArrayList<GameCharacter> CA;
		// 주사위를 굴리고 이동할 방향을 정한 뒤 이동
		Send.sendData(user.getUserOut(), "ActiveRoll");
		// ! 클라이언트한테 주사위 굴릴수 있다고 말해줌
		act = getAct(user); // ! 클라이언트에게 답이 오면
		if (act.equals("REQ_DICE")) {
			System.out.println(DiceResult);
			Send.sendAll("DiceResult:" + DiceResult + "", orders, 2);
		}
		act = getAct(user);
		if (act.equals("RIGHT")) {
			UserPosition = DiceResult + user.getPosition();
			if (UserPosition > 29)
				UserPosition = UserPosition - 30;
			gf.moveUser(user, UserPosition);

			Send.sendAll("MOVEUP:" + user.getNickName() + ":" + DiceResult + ":" + gf.getField(UserPosition).getSize()
					+ ":" + UserPosition, orders, 2);
		}
		// 위치를 오른쪽으로 랜덤값만큼 움직이라고 해줌
		else if (act.equals("LEFT")) {
			UserPosition = user.getPosition() - DiceResult;
			if (UserPosition < 0)
				UserPosition = UserPosition + 30;
			gf.moveUser(user, UserPosition);

			Send.sendAll("MOVEDOWN:" + user.getNickName() + ":" + DiceResult + ":" + gf.getField(UserPosition).getSize()
					+ ":" + UserPosition, orders, 2);
		}
		System.out.println("현재날씨 : " + gf.getField(user.getPosition()).getRange() + getRangeSelect());
		CA = gf.canBangUser(gf.getField(user.getPosition()).getRange() + getRangeSelect(), user);
		// 위치를 왼쪽으로 랜덤값만큼 움직이라고 해줌
		for (int i = 0; i < CA.size(); i++) {

			CanAttack += CA.get(i).getNickName() + ":";

		}
		System.out.println(CanAttack);
		Send.sendData(user.getUserOut(), "Range:" + CanAttack);
	}

	public void phase3(GameCharacter user) throws IOException {
		// 카드를 사용한다. 턴을 종료한다.
		String act = "";
		Send.sendData(user.getUserOut(), "ActiveCard");
		while (!act.equals("END")) {
			act = getAct(user);
			System.out.println(act);
			if (act.startsWith("Bang")) {
				String cardName = act;
				act = getAct(user);
				String words[] = act.split(":");
				act = getAct(user);
				System.out.println(act);
				if (act.equals("yes")) {
					Send.sendData(user.getUserOut(), "Wait");
					if ((int) ((Math.random() * 2) + 1) == 1
							&& (selectedWeather.equals("LightOut") || selectedWeather.equals("Tornado"))) {
						for (int i = 0; i < orders.size(); i++) {
							if (orders.get(i).getNickName().equals(words[1])) {
								Card.Bang(orders.get(i), orders);
								user.removeCard(cardName);
								sendTable(orders,users);
								break;
							}

						}
					} else if (selectedWeather.equals("LightOut")) {
						Send.sendAll("너무 어두워서 빗나갔습니다!", orders, 1);
						user.removeCard(cardName);
						sendTable(orders,users);
					} else if (selectedWeather.equals("Tornado")) {
						Send.sendAll("바람에 총알이 튄다.", orders, 1);
						Card.Bang(orders.get((int) (Math.random() * orders.size())), orders);
						user.removeCard(cardName);
						sendTable(orders,users);
					} else {
						for (int i = 0; i < orders.size(); i++) {
							if (orders.get(i).getNickName().equals(words[1])) {
								System.out.println("맑은날 뱅인식함"+orders.get(i));
								Card.Bang(orders.get(i), orders);
								user.removeCard(cardName);
								sendTable(orders,users);
								break;
							}
						}

					}
					Send.sendData(user.getUserOut(), "Resume");
				}
			} else if (act.startsWith("IndianAmbush")) {
				Send.sendData(user.getUserOut(), "Wait");
				Card.IndianAmbush(gf.getUserIndex(user));
				user.removeCard(act);
				Send.sendData(user.getUserOut(), "Resume");
				sendTable(orders,users);
			} else if (act.startsWith("VarietyStore")) {
				// Card.VarietyStore(gf.getUserIndex(user));
				user.removeCard(act);
				sendTable(orders,users);

			} else if (act.startsWith("Fighting")) { 
				String cardName = act;
				GameCharacter ENEMY = null;
				act = getAct(user);
				String[] words = act.split(":");
				for (int i = 0; i < orders.size(); i++) {
					if(orders.get(i).getNickName().equals(words[1])) {
						ENEMY = orders.get(i);
						System.out.println(ENEMY.getNickName());
						break;
					}
				}
				act = getAct(user);
				if(act.equals("yes")) {
					Send.sendData(user.getUserOut(), "Wait");
					Card.Fighting(user, ENEMY);
					
					user.removeCard(cardName);
					sendTable(orders,users);
					Send.sendData(user.getUserOut(), "Resume");
					
				}
			}

			else if (act.startsWith("GatlingGun")) {
				Send.sendData(user.getUserOut(), "Wait");
				Card.GatlingGun(gf.getUserIndex(user));
				user.removeCard(act);
				Send.sendData(user.getUserOut(), "Resume");
				sendTable(orders,users);
			} else if (act.startsWith("Beer")) {
				user.UpHP();
				user.removeCard(act);
				Send.sendAll("Result:Beer",users, 2);
				sendTable(orders,users);
			}

		}
		Send.sendData(user.getUserOut(), "TurnEnd");
		Send.sendAll(orders.get(turn % orders.size()).getNickName() + "님의 턴 종료", orders, 1);
		this.turn++;

	}

	/*
	 * public void phase3_1(GameCharacter user) throws IOException {
	 * Send.sendData(user.getUserOut(),"SemiTurn"); String act = getAct(user);
	 * if(act.equals("SHIELD")) Send.sendAll("방어 성공", orders, 1); else
	 * Send.sendAll("방어 실패", orders, 1); Send.sendData(user.getUserOut(),"SemiEnd");
	 * 
	 * 
	 * }
	 */
	public void FirstPosition() throws IOException {

		for (int i = 0; i < orders.size(); i++) {
			Send.sendData(orders.get(i).getUserOut(), "Position");
			String act = getAct(orders.get(i));
			int num = Integer.parseInt(act) * 6;
			gf.AddUser(orders.get(i), num);
			Send.sendAll(orders.get(i).getNickName() + "의 자리는 " + num + "입니다 .", orders, 1);
			Send.sendAll("Position:" + orders.get(i).getNickName() + ":5:" + num, orders, 2); // hp설정을 안해서 5로 통일
			if (i != orders.size() - 1)
				Send.sendAll("다음은 " + orders.get(i + 1).getNickName() + "의 위치지정 차례입니다 ", orders, 1);
		}
	}

	public void run() {
		int gameEnd = -1;

		Commend.sleep(1000);
		Send.sendAll("PlayerNum:" + users.size(), users, 2);
		setPlayerJobs(users);
		TeachJob(users);
		for (int i = 0; i < orders.size(); i++) {
			try {
				sendProfile(orders.get(i));
				firstDraw(orders.get(i));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sendTable(orders,users);
		try {
			FirstPosition();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		while (gameEnd == -1) {
			// true를 게임 종료조건으로 바꿔야함.
			if (turn % orders.size() == 0)
				// 나눠서 나머지가 0일땐 보안관의 턴일 때
				changeWeather();

			try {
				System.out.println("페이즈 시작");
				phase1(orders.get(turn % orders.size()));
				System.out.println("페이즈1 종료");
				phase2(orders.get(turn % orders.size()));
				System.out.println("페이즈2 종료");
				phase3(orders.get(turn % orders.size()));
				System.out.println("페이즈 종료");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gameEnd = Rule.endRule(aliveJob);
			System.out.println(gameEnd);
		}

		System.out.println("겜끝");
		End.gameEnd(users); // 게임 끝
	}

	static public String getAct(GameCharacter user) throws IOException {
		// 현재 턴인 유저에게서 응답을 기다림
		String act = Receive.ReceiveData(user.getUserIn());
		System.out.println("활동" + act);
		return act;

	}

	public void sendTable(ArrayList<GameCharacter> orders,ArrayList<GameCharacter> send) {
		String s = "Table";

		for (int i = 0; i < orders.size(); i++)
			s += String.format(":%s:%d:%d", orders.get(i).getNickName(), orders.get(i).getHp(),
					orders.get(i).getCard().size());

		Send.sendAll(s, send, 2);
	}

	public void sendProfile(GameCharacter user) throws IOException {
		Send.sendData(user.getUserOut(),
				String.format("Profile:%s:%d:%s", user.getNickName(), user.getHp(), jobs[user.getJob() - 1]));
	}

	public int getRangeSelect() {
		if (selectedWeather.equals("Fog"))
			return -1;
		else if (selectedWeather.equals("WasteLand"))
			return 1;
		else
			return 0;
	}
}
