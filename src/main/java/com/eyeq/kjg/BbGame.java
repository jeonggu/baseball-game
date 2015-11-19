package com.eyeq.kjg;

import java.util.Scanner;

public class BbGame {

	public static void main(String[] args) {

	}

	public String generateNumber;

	public int nthGame;

	public void guess(String inputNumber) {
		if (inputNumber == null) {
			throw new IllegalArgumentException("값을 입력해주세요.");
		}

		if (inputNumber.length() != 3) {
			throw new IllegalArgumentException("숫자를 3개만 넣어주세요.");
		}

		for (char ch : inputNumber.toCharArray()) {
			if (ch < '0' || ch > '9') {
				throw new IllegalArgumentException("0~9까지의 숫자만 넣어주세요.");
			}
		}

		if (inputNumber.charAt(0) == inputNumber.charAt(1) || inputNumber.charAt(1) == inputNumber.charAt(2)
				|| inputNumber.charAt(0) == inputNumber.charAt(2)) {
			throw new IllegalArgumentException("중복된 값이 들어갈 수 없습니다.");
		}
	}

	// 스트라이크가 3개일 때 게임이 끝나는지
	public Result guessResult(String inputNumber) {
		BbGame bbGame = new BbGame();
		int strike = 0;
		int ball = 0;
		boolean result = false;

		nthGame++;

		// 스트라이크와 볼 체크
		for (int i = 0; i < inputNumber.length(); i++) {
			if (generateNumber.charAt(i) == inputNumber.charAt(i)) {
				strike++;
			}
			for (int j = 0; j < inputNumber.length(); j++) {
				if (generateNumber.charAt(i) != inputNumber.charAt(i)
						&& generateNumber.charAt(i) == inputNumber.charAt(j)) {
					ball++;
				}
			}
		}
		// 스트라이크가 3개면 게임 끝
		if (strike == 3) {
			result = true;
		}

		return new Result(result, new Strike(strike), new Ball(ball));
	}

	public boolean isGameOver(Result result) {
		if (result.isResult()) {
			return true;
		}
		if (nthGame == 10) {
			return true;
		}

		return false;
	}
}
