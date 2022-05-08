package game;

import java.util.ArrayList;
import java.util.Collections;

import character.GameCharacter;

public class GameField {
	private ArrayList<Node> Nodes = new ArrayList<GameField.Node>();
	
	class Node<Integer,GameCharacter>{
		private int num = 0;
		private GameCharacter user;
		Node(int num, GameCharacter user){
			this.num = num;
			this.user = user;
			
			Nodes.add(this);
		}
	}
   private ArrayList<Field> field;
   private ArrayList<Integer> Range;
   private int MaxUser;  // 사정거리를 계산시 필요
   
   public GameField(int MaxUser) {
      
      this.MaxUser = MaxUser;
      field = new ArrayList<Field>();
      Range = new ArrayList<Integer>();
      
      for (int i = 0; i < 30; i++) {
         field.add(new Field(i));
      }
   }
   public ArrayList<Integer> takeRange() {
	   return Range;
   }
   public void AddUser(GameCharacter user,int position) {
//   최초 유저가 꼭짓점에 말판을 둘 경우, 이동시킬 경우 사용할 메서드      
      addRange(position);
      field.get(position).addUser(user);
   }
   public ArrayList<GameCharacter> getUserIndex(GameCharacter user){
	   ArrayList<GameCharacter> orders = new ArrayList<GameCharacter>();
	   int position = Range.indexOf(user.getPosition());
	   
	   for(int i = 0; i < Range.size();i++) {
		   
		   for(int j= 0;j<field.get(Range.get(position%Range.size())).getSize();j++) {
			   orders.add(field.get(Range.get(position%Range.size())).getUser().get(j));
		   }
		   position += 1;
	   }
	   if(orders.indexOf(user)!=0) {
		   orders.remove(user);
		   orders.add(0,user);
	   }
	   return orders;
   }
   public void moveUser(GameCharacter user,int position) {
//   유저가 주사위를 굴릴경우 말 이동시킬때 사용할 메서드 position 매개변수는 주사위 수
      if(Range.size() == MaxUser)
         Range.remove((Integer)user.getPosition());
         
      field.get(user.getPosition()).removeUser(user);
      AddUser(user, position);
   }
   
   public void addRange(int position) {
//   유저끼리의 사정거리를 저장하기 위해서 사용하는 메서드
      if(checkRange(position)) {
         Range.add(position);
         Collections.sort(Range);
      }
   }
   
   public boolean checkRange(int range) {
//   유저가 있는 타일에 이미 다른 유저가 있는 경우 Range가 필요가 없다.
      if(Range.indexOf(range) == -1) {
         return true;
      }else {
         return false;
      }
   }
   
   public int getRange(int myPosition,int destination) {
//   공격이 가능한지 알아보는 메서드
      int range = field.get(myPosition).getRange();
      int mR,dR;
      int rRange;
      
      if(myPosition == destination) {
         return field.get(myPosition).getWeapon(); // 같은 타일에 있을 경우, 무기 return
      }else {
         mR = Range.indexOf(myPosition);
         dR = Range.indexOf(destination);
         rRange = Math.abs(mR-dR);
         
         if(rRange == 1 || rRange == MaxUser-1)
            return 1; // 사거리가 1이상 일 경우, 무기 return
         else if(range == 2)
            return 2; // 사거리가 2인 경우, 일단 3으로 지정하고 무기나 이런게 결정되면 해당 유저의 무기로 return
         else
            return 100; // 사거리에 안될경우 
      }
      // 1 2 3 4 5
      // 0 1 2 3 4
   }
   public ArrayList<GameCharacter> canBangUser(int Range, GameCharacter user){
	   ArrayList<GameCharacter> CanAttack = new ArrayList<GameCharacter>();
	   ArrayList<GameCharacter> orders = getUserIndex(user);
	   int MY = user.getPosition();
	 
	   for (int i = 1; i < orders.size(); i++) {
		
			if(getRange(MY, orders.get(i).getPosition()) <= Range)
				CanAttack.add(orders.get(i));
		
	}
		
	   return CanAttack;
   }
   public Field getField(int position) {
	   
	   
	   return field.get(position);
   }
}