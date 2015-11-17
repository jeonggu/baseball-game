package com.eyeq.kjg;

public class GuessResolve {

	private boolean result;
	private int strike;
	private int ball;
	
	public GuessResolve() {
		
	}
	
	public GuessResolve(boolean result, int strike, int ball) {
		super();
		this.result = result;
		this.strike = strike;
		this.ball = ball;
	}

	public boolean isResult() {
		return result;
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}
	
	
}
