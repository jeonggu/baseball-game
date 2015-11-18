package com.eyeq.kjg;

public class GuessResolve {
	private boolean result;
	private Strike strike;
	private Ball ball;
	
	public GuessResolve(boolean result, Strike strike, Ball ball) {
		super();
		this.result = result;
		this.strike = strike;
		this.ball = ball;
	}
	public boolean isResult() {
		return result;
	}
	public Strike getStrike() {
		return strike;
	}
	public Ball getBall() {
		return ball;
	}
}
