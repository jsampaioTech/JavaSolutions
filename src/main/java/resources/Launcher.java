package resources;

import java.io.IOException;
import java.util.Scanner;

import resources.sortingballs.Ball;
import resources.sortingballs.BallList;

public class Launcher {

	private static final String CHOOSE_EXERCISE = "Choose Exercixe:";
	private static final String SORTING_BALLS = "Sorting Balls - Press Key 1";
	private static final String SPELLS_IT_OUT = "Spells it out - Press Key 2";
	private static final String INTRO_SORTING_BALLS = "**SORTING BALLS**";
	private static final String INTRO_SPELLS_IT_OUT = "**SPELLS IT OUT**";
	private static final String INSERT_NUMBER = "Insert Number";
	private static final String PRESS_ENTER_START = "Press Enter to Start or Press 'e' to Exit";
	private static final String INVALID_INPUT = "Invalid Input";
	private static final String FINISH = "FINISH";
	private static final String OUTPUT = "OUTPUT:";
	private static final String EXIT = "e";

	private Scanner sc;

	public void runLauncher(){

		System.out.println(CHOOSE_EXERCISE);
		System.out.println(SORTING_BALLS);
		System.out.println(SPELLS_IT_OUT);

		sc = new Scanner(System.in);
		int key = sc.nextInt();

		switch (key) {
		case 1:{
			try {
				System.out.println(INTRO_SORTING_BALLS);
				runSortingBalls();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
		case 2:{
			try {
				System.out.println(INTRO_SPELLS_IT_OUT);
				runSpellsItOut();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}
		}
	}

	//run sorting balls exercise
	public void runSortingBalls() throws IOException {
		sc = null;

		try{
			sc = new Scanner(System.in);
			BallList ballList = new BallList();
			System.out.println(PRESS_ENTER_START);

			while (!(sc.nextLine().equals(EXIT))) {
				System.out.println(INSERT_NUMBER);
				int numberball = sc.nextInt();
				Ball ball = new Ball(numberball);

				if(!ballList.containsBall(ball) && ballList.isValidSize(ballList.getBalls().length) && ball.isValidNumber(numberball)){
					ballList.addBall(ball);
					System.out.println(OUTPUT);
					ballList.printBallsArray();
				}else{
					System.out.println(INVALID_INPUT);
				}
			}
		}finally {
			closeScanner();
		}

	}

	//run spells it out exercise
	public void runSpellsItOut() throws IOException{
	}

	private void closeScanner() {
		System.out.println(FINISH);
		sc.close();
	}

}
