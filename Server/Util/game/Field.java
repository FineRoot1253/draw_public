package game;

import java.util.ArrayList;

import character.GameCharacter;

public class Field {
	private ArrayList<GameCharacter> users;
	private Weapon Weapon;
	private int fieldNum;
	
	public Field(int FieldNum) {
		users = new ArrayList<GameCharacter>();
		this.fieldNum = FieldNum; 
		
		Weapon = Weapon.getWeapon(FieldNum);
	}
	
	public void removeUser(GameCharacter user) {
		users.remove(user);
	}
	
	public void addUser(GameCharacter user) {
		user.setPosition(fieldNum);
		users.add(user);
	}
	
	public ArrayList<GameCharacter> getUser() {
		return users;
	}

	public int getSize() {
		return users.size();
	}
	
	public int getRange() {
		return Weapon.getRange();
	}
	
	public int getWeapon() {
		return Weapon.getWeapon();
	}
}
