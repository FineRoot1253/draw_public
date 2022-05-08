package Util;

public class Check {

   public static boolean CheckValue(String[] value) {
      
      for (int i = 0; i < value.length; i++) 
         if(CheckString(value[i]))
            return false;
      
      return true;
   }
   
   public static boolean CheckString(String str) {
      return str.equals("");
   }
}