package com.eyeq.kjg;

public class Score {
		
	public Score() {
	}

	public static int getScore(int nthGame, Result result) {
		// 몇번 째 게임인지
		// 맞지 않으면 -100점
		int gameScore = 1000;
		if(result.isResult()) {
			gameScore = gameScore-(nthGame-1)*100;
		} else {
			gameScore = 0;
		}
		return gameScore;
	}

	
}
