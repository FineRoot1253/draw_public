package Gameboard_Screen;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;



import Default.Default_Socket;
import Default.WrapLayout;
import Main_Screen.Main_Background;
import card_Imformation.Avoid_Card;
import card_Imformation.Bang_Card;
import card_Imformation.Beer_Card;
import card_Imformation.Draw_Card;
import card_Imformation.Fighting_Card;
import card_Imformation.GatlingGun_Card;
import card_Imformation.IndianAmbush_Card;
import card_Imformation.TavernBrawl_Card;
import card_Imformation.VarietyStore_Card;
import gameCharacter_Screen.Position_Screen;

public class Card_Screen extends JPanel{
	// 카드 놓는곳 영역 패널 
	//private ImageIcon Fight_Card = new ImageIcon(Main_Background.class.getResource("/Image/GAMEBOARD_SCREEN/CARD/기관총1.png"));
	static private ArrayList<JPanel> Card = new ArrayList<JPanel>();
	//static private JPanel[] Card = new JPanel[5];
	static private ArrayList<Draw_Card> DC = new ArrayList<Draw_Card>();
	static private Card_Screen a;
	
	public Card_Screen() {
		 a = this;
		setLayout(new GridLayout(1, 5)); 
		setVisible(true);
		setBounds(420,825,750,200);
		setOpaque(false);
		for(int i=0;i<5;i++) {
			Card.add(i,new JPanel()); 
			Card.get(i).setLayout(null);
			Card.get(i).setSize(120,200);
			Card.get(i).setOpaque(false);
			add(Card.get(i));
		}
		//Card[0].add(DC);
	//	Card[1].add(DC1);
	//	Card[2].add(DC2);
	//	Card[3].add(DC3);
	//	Card[4].add(DC4);
			
	}
	static public void Draw_Card(String cards) {// 수정
		String words[] = cards.split(":");
		System.out.println(words);
		for (int i = 1; i < words.length; i++) {
			//System.out.println("여기 컷씬 넣으면 돼");
			switch(words[i]) {
			case "Bang":
				//DC.add();
				DC.add(DC.size(), new Bang_Card());
				Card.get(DC.size()-1).add(DC.get(DC.size()-1));
				break;
			case "Beer":
				DC.add(new Beer_Card());
				//Card.get(i-1).add(DC.get(i-1));
				Card.get(DC.size()-1).add(DC.get(DC.size()-1));
				break;
			case "Avoid":
				DC.add(new Avoid_Card());
				//Card.get(i-1).add(DC.get(i-1));
				Card.get(DC.size()-1).add(DC.get(DC.size()-1));
				break;
			case "Fighting":
				DC.add(new Fighting_Card());
				//Card.get(i-1).add(DC.get(i-1));
				Card.get(DC.size()-1).add(DC.get(DC.size()-1));
				break;
			case "GatlingGun":
				DC.add(new GatlingGun_Card());
				//Card.get(i-1).add(DC.get(i-1));
				Card.get(DC.size()-1).add(DC.get(DC.size()-1));
				break;
			case "IndianAmbush":
				DC.add(new IndianAmbush_Card());
				//Card.get(i-1).add(DC.get(i-1));
				Card.get(DC.size()-1).add(DC.get(DC.size()-1));
				break;
			case "TavernBrawl":
				DC.add(new TavernBrawl_Card());
				//Card.get(i-1).add(DC.get(i-1));
				Card.get(DC.size()-1).add(DC.get(DC.size()-1));
				break;
			case "VarietyStore":
				DC.add(new VarietyStore_Card());
				//Card.get(i-1).add(DC.get(i-1));
				Card.get(DC.size()-1).add(DC.get(DC.size()-1));
				break;
			}
			
		}
	}
	

	static public void useCard(Draw_Card card) {
		String s = "";
		for (int i = 0; i < DC.size(); i++) {
			if(DC.get(i) == card) {
				Card.get(i).remove(DC.get(i));
				DC.remove(i);
				a.remove(Card.remove(i));	
				Card.add(new JPanel()); 
				Card.get(Card.size()-1).setLayout(new FlowLayout(0,0,40));
				Card.get(Card.size()-1).setSize(120,200);
				Card.get(Card.size()-1).setOpaque(false);
				a.add(Card.get(Card.size()-1));
				a.repaint();
				a.revalidate();
			}
			
		}
		s = card.getName();
		System.out.println("선택 카드"+s );
			Util.SendServer.SendData(Default_Socket.getOutData(), s);
		
	}
	
	public static void resetCard() {
		Card.removeAll(Card);
		DC.removeAll(DC);
	}
}
	

