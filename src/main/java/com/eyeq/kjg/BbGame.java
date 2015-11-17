package com.eyeq.kjg;

import java.util.Scanner;

public class BbGame {

	public static void main(String[] args) {

	}

	public String generateNumber;

	// 입력 횟수 제한
	public static final int LIMITED = 10;

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

	public void guessResult(String inputNumber, String randomNumber) {
		BbGame bbGame = new BbGame();
		int strike = 0;
		int ball = 0;
		boolean result = false;

		// 스트라이크와 볼 체크
		for (int i = 0; i < inputNumber.length(); i++) {
			if (randomNumber.charAt(i) == inputNumber.charAt(i)) {
				strike++;
			}
			for (int j = 0; j < inputNumber.length(); j++) {
				if (randomNumber.charAt(i) != inputNumber.charAt(i)
						&& randomNumber.charAt(i) == inputNumber.charAt(j)) {
					ball++;
				}
			}
		}
		// 스트라이크가 3개면 게임 끝
		if (strike == 3) {
			result = true;
		}
		bbGame.guessResolve(result, new Strike(strike), new Ball(ball));
	}

	// 비교 결과
	private void guessResolve(boolean result, Strike strike, Ball ball) {
		if (result && strike.getValue() == 3 && ball.getValue() == 0) {
			System.out.println("승리하였습니다.");
		} else {
			Scanner scanner = new Scanner(System.in);
			System.out.println("다시 숫자를 입력하세요");
		}
	}

	public void limitOfInputNumber(String inputNumber, String randomNumber) {
		
		
	}
}
