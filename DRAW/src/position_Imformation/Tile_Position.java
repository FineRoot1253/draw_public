package position_Imformation;

import java.awt.GridLayout;

import javax.swing.JPanel;

import gameCharacter_Screen.Character_Imformation;

public class Tile_Position extends JPanel {
	// 각타일 위치를 표시해주는 패널 
	private Character_Imformation CI;
	private int position = 0;
	
	public Tile_Position(int list,Character_Imformation CI) {
		setVisible(true);
		setOpaque(false);
		setLayout(null);
		this.CI=CI;
		add(CI);
		switch (list) {
		case 0: 	setBounds(545, 41, 80, 80);		break;
		case 1:		setBounds(679, 23, 80, 80);		break;
		case 2:		setBounds(723, 118, 80, 80);	break;
		case 3:		setBounds(838, 108, 80, 80);	break;
		case 4:		setBounds(879, 203, 80, 80);	break;
		case 5:		setBounds(971, 181, 80, 80);	break;
		case 6:		setBounds(1028, 289, 80, 80);	break;
		case 7:		setBounds(1030, 396, 80, 80);	break;
		case 8:		setBounds(941, 450, 80, 80);	break;
		case 9:		setBounds(963, 560, 80, 80);	break;
		case 10:	setBounds(864, 595, 80, 80);	break;  
		case 11:	setBounds(875, 715, 80, 80);	break;
		case 12:	setBounds(792, 735, 80, 80);	break;
		case 13:	setBounds(712, 802, 80, 80);	break;
		case 14:	setBounds(628, 740, 80, 80);	break;
		case 15:	setBounds(545, 806, 80, 80);	break;
		case 16:	setBounds(450, 748, 80, 80);	break;
		case 17:	setBounds(360, 805, 80, 80);	break;
		case 18:	setBounds(265, 748, 80, 80);	break;
		case 19:	setBounds(142, 679, 80, 80);	break;
		case 20:	setBounds(174, 584, 80, 80);	break;
		case 21:	setBounds(79, 520, 80, 80);		break;
		case 22:	setBounds(107, 430, 80, 80);	break;
		case 23:	setBounds(17, 380, 80, 80);		break;
		case 24:	setBounds(32, 251, 80, 80);		break;
		case 25:	setBounds(101, 155, 80, 80);	break;
		case 26:	setBounds(205, 177, 80, 80);	break;
		case 27:	setBounds(267, 88, 80, 80);		break;
		case 28:	setBounds(366, 111, 80, 80);	break;
		case 29:	setBounds(416, 20, 80, 80);		break;
	
		default:									break;
		}

		revalidate();
		repaint();
	}
	public void setTP(int list) {
		
		switch (list) {
		case 0: 	setBounds(545, 41, 80, 80);		break;
		case 1:		setBounds(679, 23, 80, 80);		break;
		case 2:		setBounds(723, 118, 80, 80);	break;
		case 3:		setBounds(838, 108, 80, 80);	break;
		case 4:		setBounds(879, 203, 80, 80);	break;
		case 5:		setBounds(971, 181, 80, 80);	break;
		case 6:		setBounds(1028, 289, 80, 80);	break;
		case 7:		setBounds(1030, 396, 80, 80);	break;
		case 8:		setBounds(941, 450, 80, 80);	break;
		case 9:		setBounds(963, 560, 80, 80);	break;
		case 10:	setBounds(864, 595, 80, 80);	break;  
		case 11:	setBounds(875, 715, 80, 80);	break;
		case 12:	setBounds(792, 735, 80, 80);	break;
		case 13:	setBounds(712, 802, 80, 80);	break;
		case 14:	setBounds(628, 740, 80, 80);	break;
		case 15:	setBounds(545, 806, 80, 80);	break;
		case 16:	setBounds(450, 748, 80, 80);	break;
		case 17:	setBounds(360, 805, 80, 80);	break;
		case 18:	setBounds(265, 748, 80, 80);	break;
		case 19:	setBounds(142, 679, 80, 80);	break;
		case 20:	setBounds(174, 584, 80, 80);	break;
		case 21:	setBounds(79, 520, 80, 80);		break;
		case 22:	setBounds(107, 430, 80, 80);	break;
		case 23:	setBounds(17, 380, 80, 80);		break;
		case 24:	setBounds(32, 251, 80, 80);		break;
		case 25:	setBounds(101, 155, 80, 80);	break;
		case 26:	setBounds(205, 177, 80, 80);	break;
		case 27:	setBounds(267, 88, 80, 80);		break;
		case 28:	setBounds(366, 111, 80, 80);	break;
		case 29:	setBounds(416, 20, 80, 80);		break;
	
		default:									break;
		}

		revalidate();
		repaint();
	}
	public void setCI(Character_Imformation CI) {
		this.CI=CI;
	}
	public Character_Imformation getCI() {
		return CI;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}

}
