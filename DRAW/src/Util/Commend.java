package Util;

public class Commend {

	public static void sleep(int sTime) {
//	쓰레드를 멈추게 하기 위해서 사용하는 용도
		try {
			Thread.currentThread().sleep(sTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
