package com.eyeq.kjg;

public class BbGame {

	public static void main(String[] args) {

	}

	public String generateNumber;

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

	public void guessResult(String inputNumber, GuessResolve guessResolve) {
		int strike = 0;
		int ball = 0;
		boolean result = false;
		String randomValue = "123";

		// 스트라이크와 볼 체크
		for (int i = 0; i < inputNumber.length(); i++) {
			if (randomValue.charAt(i) == inputNumber.charAt(i)) {
				strike++;
			}
			for (int j = 0; j < inputNumber.length(); j++) {
				if (randomValue.charAt(i) != inputNumber.charAt(i) && randomValue.charAt(i) == inputNumber.charAt(j)) {
					ball++;
				}
			}
		}
		// 스트라이크가 3개면 게임 끝
		if (strike == 3) {
			result = true;
		}

		// 예상되는 결과값이 매치가 되는지 확인
		if (guessResolve.getStrike() != strike || guessResolve.getBall() != ball || guessResolve.isResult() != result) {

			throw new IllegalArgumentException("잘못된 결과 값입니다.");
		}

		System.out.println("strike : " + strike + " ball : " + ball);
		System.out.println("다시시작");

	}

}
