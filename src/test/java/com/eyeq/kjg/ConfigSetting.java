package com.eyeq.kjg;

public class ConfigSetting {
	// 사용자 입력 횟수 제한
	private static final int LIMITED = 10;
	// 게임 종료 체크
	private boolean endGame = false;
	
	public ConfigSetting() {
	
	}

	public ConfigSetting(boolean endGame) {
		super();
		this.endGame = endGame;
	}

	public boolean isEndGame() {
		return endGame;
	}

	public static int getLimited() {
		return LIMITED;
	}
}
