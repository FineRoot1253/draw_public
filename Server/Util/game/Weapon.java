package game;

public class Weapon {

	/*
	 * 	3   9   15   21   27  스나
	 *	1   7   13   19   25  리볼버
	 *	5   11  17   23   29 샷건
	 * 	나머지 권총 
	 */

	private int weapon;
	private int range;
	
	public Weapon(int weapon, int range) {
		this.weapon = weapon;
		this.range = range;
	}
	
	public static Weapon getWeapon(int position){
		
		int Weapon = position % 6;
		
		switch (Weapon) {
		
		case 1: 
		//	리볼버
			return new Weapon(1, 1);
		case 3:
		//  스나
			return new Weapon(3, 2);
		case 5:
		//  샷건
			return new Weapon(5, 1);
		default:
			return new Weapon(0, 1);
		}
	}

	public int getWeapon() {
		return weapon;
	}

	public int getRange() {
		return range;
	}
}
