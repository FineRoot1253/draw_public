package gameCharacter_Screen;

import java.util.ArrayList;

import javax.swing.JPanel;



import Gameboard_Screen.GameBaord_Background;
import position_Imformation.Tile_Position;

//!
public class Position_Screen extends JPanel {
	// 처음 캐릭터 위치 선택하는 클래스

	private static ArrayList<Position> p;
	private static boolean many = false;
	
	public static Tile_Position[] TP = new Tile_Position[5];

	public Position_Screen() {
		p = new ArrayList<Position>();
		p.add(new Position(483, 55, 0));
		p.add(new Position(982, 273, 1));
		p.add(new Position(770, 710, 2));
		p.add(new Position(217, 703, 3));
		p.add(new Position(25, 242, 4));

		for (int i = 0; i < 5; i++) {
			TP[i] = new Tile_Position(i * 6, new Character_Imformation());
		}

		setLayout(null);
		setVisible(true);
		setBounds(230, 0, 1136, 918);
		setOpaque(false);

		for (int i = 0; i < 5; i++) {
			
			add(TP[i]);
			add(p.get(i));
		}
	}

	public static void moveUp(String name, String rollR, int size, int position) throws InterruptedException {

		ArrayList<Integer> names = new ArrayList<Integer>();

		for (int i = 0; i < 5; i++) {
			if (TP[i].getCI().getName().equals(name)) {
				int beforePosition = TP[i].getPosition();
				TP[i].getCI().Person();
				TP[i].setPosition(position);

				for (int j = 0; j < Integer.parseInt(rollR); j++) {
					if (TP[i].getCI().getTileNum() == 29) {
						TP[i].setTP(0);
						TP[i].getCI().setTileNum(0);
						Thread.sleep(500);
					} else {
						TP[i].setTP(TP[i].getCI().getTileNum() + 1);
						TP[i].getCI().setTileNum(TP[i].getCI().getTileNum() + 1);
						// System.out.println(TP[i].getCI().getName()+"가
						// 움직였습니다."+TP[i].getCI().getTileNum());
						Thread.sleep(500);
					}

				}

				checkUser(size, position, name, names, i, beforePosition);
				break;
			}

		}
	}

	public static void moveDown(String name, String rollR, int size, int position) throws InterruptedException {

		ArrayList<Integer> names = new ArrayList<Integer>();

		for (int i = 0; i < 5; i++) {
			if (TP[i].getCI().getName().equals(name)) {
				int beforePosition = TP[i].getPosition();
				TP[i].getCI().Person();
				TP[i].setPosition(position);

				for (int j = 0; j < Integer.parseInt(rollR); j++) {
					if (TP[i].getCI().getTileNum() == 0) {
						TP[i].setTP(29);
						TP[i].getCI().setTileNum(29);
						Thread.sleep(500);
					} else {
						TP[i].setTP(TP[i].getCI().getTileNum() - 1);
						TP[i].getCI().setTileNum(TP[i].getCI().getTileNum() - 1);
						Thread.sleep(500);
					}
				}

				checkUser(size, position, name, names, i, beforePosition);
				break;
			}

		}
	}

	
	public static void checkUser(int size, int position, String name,ArrayList<Integer> names, int index, int beforePosition) {
	// 타일에 유저가 겹쳐있는지 확인하고 겹쳐있으면 이미지 변경
		
		TP[index].getCI().setName(name);
		
		for(int i = 0; i <  TP.length; i++) {
			if(TP[i].getPosition() == beforePosition) {
				TP[i].getCI().removeName(name);
			}
		}
		
		if(size >= 2) {
			for(int j = 0; j < TP.length; j++) {
				if(TP[j].getPosition() == position) {
					TP[j].getCI().People(size);
					if(!TP[j].getCI().getName().equals(name)) {
						TP[j].getCI().addName(name);
						names.add(j);
						TP[j].getCI().setMany();
					}
				}
			}
			for(int k = 0; k < names.size(); k++) {
				TP[index].getCI().addName(TP[names.get(k)].getCI().getName());
			}
			TP[index].getCI().setMany();// 여기 건들여따 
		}
		
		TP[index].getCI().repaints();
	}


	static public void ChoosePosition(String name, String HP, String positionSt) {
		//Character_Imformation CI = null;
		int position = Integer.parseInt(positionSt);
		TP[position / 6].setPosition(position);
		TP[position / 6].getCI().setTileNum(position);
		TP[position/6].getCI().setName(name);
		//CI = TP[position / 6].getCI();
		p.get(position / 6).use();

		//CI.setTileNum(position);
//		CI.setHp(HP);
		//CI.setName(name);
	//	TP[position / 6].setCI(CI);
		TP[position / 6].getCI().Person();
		//TP[position/6].getCI().setOnCIB();
		TP[position/6].setTP(position);
		TP[position / 6].getCI().setVisible(true);
		TP[position/6].getCI().repaints();
	}

	static public void MyPosition() {

		for (int i = 0; i < 5; i++) {
			if (p.get(i).getSET())
				p.get(i).addMouseListener(p.get(i));
		}
	}

	static public void NoPosition() {

		for (int i = 0; i < 5; i++) {
			p.get(i).removeMouseListener(p.get(i));
		}
	}

	static public void addListener(int num) {
		if (num == 1) {
			ArrayList<String> ATL = GameBaord_Background.getAttackList();
			for (int a = 0; a < ATL.size(); a++)
				System.out.println(ATL.get(a).toString());
			for (int i = 0; i < TP.length; i++) {
				for (int j = 0; j < ATL.size(); j++) {
					System.out.println(TP[i].getCI().getName()+" "+ATL.get(j)+" "+TP[i].getCI().getName().equals(ATL.get(j)));
					if (TP[i].getCI().getName().equals(ATL.get(j))) {
						System.out.println("실행됨");
						if(!many) {
							TP[i].getCI().setOnCIB();	
						}
						TP[i].getCI().setOnCSI();
						
					}

				}

			}
		} else
			for (int i = 0; i < TP.length; i++) {
				TP[i].getCI().setOnCIB();
			}
	}

	static public void removeListener() {
		ArrayList<String> ATL = GameBaord_Background.getAttackList();
		for (int i = 0; i < TP.length; i++) {
			TP[i].getCI().setOffCIB();

		}

	}
	public static boolean getmany() {
		return many;
	}
	public static void setmany() {
		many = !many;
	}
	public static void Bang(String name) {
		   //   가제목 니들이 바꿔서 쓰셈
		   //   이름은 뒤진 세끼 이름
		      for(int i = 0; i < TP.length;i++) {
		         
		         Character_Imformation CI = TP[i].getCI();
		         
		         if(CI.getName().equals(name)) {
		            TP[i].setVisible(false);
		            TP[i] = null;
		         }
		         else 
		            CI.removeName(name);
		      }
		   }
}
