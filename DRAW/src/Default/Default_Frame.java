package Default;

import javax.swing.JFrame;

import Main_Screen.Main_Background;


public class Default_Frame extends JFrame {
	// 화면의 밑바탕이 되는 프레임 
	//네트워크
	private static Default_Frame DF;
	public static final int SCREEN_WIDTH = 1680; 
	public static final int SCREEN_HEIGHT = 1050;
	
	public Default_Frame() {
		
		add(new Main_Background(this));// Main_Background 의 패널 추가
		setSize(Default_Frame.SCREEN_WIDTH, Default_Frame.SCREEN_HEIGHT);// 프레임 화면 고정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 껐을때 작업관리자 창에서 꺼지는거
		setTitle("Draw!"); // 타이틀 명 "Draw!"
		setResizable(false);// 창 크기 고정
		setLocationRelativeTo(null);// 화면 떴을때 내 모니터의 중간으로 이동시키는거
		setVisible(true); // 출력을 시키는거 
		
	}
	public static void main(String[] args) {
		DF = new Default_Frame();
	}
	public static Default_Frame getDF() {
		return DF;
	}
}
