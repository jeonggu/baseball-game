package com.eyeq.kjg;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.Result;

public class BbGameTest {

	@Test
	public void canCreate() {
		BbGame bbGame = new BbGame();
	}

	@Test
	public void testInputInvalid_throwIllegalArgumentException() {
		BbGame bbGame = new BbGame();
		bbGame.generateNumber = "123";

		assertInputInvalid(bbGame, null);
		assertInputInvalid(bbGame, "12");
		assertInputInvalid(bbGame, "12a");
		assertInputInvalid(bbGame, "aaa");
		assertInputInvalid(bbGame, "112");
		assertInputInvalid(bbGame, "222");

	}

	private void assertInputInvalid(BbGame bbGame, String inputNumber) {
		try {
			bbGame.guess(inputNumber);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void testExactMatchingNumber_returnSolvedResult() {
		// 게임 생성
		BbGame bbGame = new BbGame();
		// 숫자 생성
		bbGame.generateNumber = "123";

		// 사용자 입력
		resultCheck(bbGame, "321", bbGame.generateNumber);
		resultCheck(bbGame, "123", bbGame.generateNumber);
		resultCheck(bbGame, "678", bbGame.generateNumber);

	}

	private void resultCheck(BbGame bbGame, String inputNumber, String randomNumber) {
		try {
			// 숫자 비교
			bbGame.guessResult(inputNumber, randomNumber);
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void testlimitOfInputNumber() {
		// 게임 생성
		BbGame bbGame = new BbGame();
		// 숫자 생성
		bbGame.generateNumber = "123";

		// 사용자 입력
		limitOfInputNumber(bbGame, "243", bbGame.generateNumber);
		limitOfInputNumber(bbGame, "231", bbGame.generateNumber);
		limitOfInputNumber(bbGame, "543", bbGame.generateNumber);
		limitOfInputNumber(bbGame, "267", bbGame.generateNumber);
		limitOfInputNumber(bbGame, "976", bbGame.generateNumber);
		limitOfInputNumber(bbGame, "569", bbGame.generateNumber);
		limitOfInputNumber(bbGame, "754", bbGame.generateNumber);
		limitOfInputNumber(bbGame, "543", bbGame.generateNumber);
		limitOfInputNumber(bbGame, "643", bbGame.generateNumber);
		limitOfInputNumber(bbGame, "236", bbGame.generateNumber);
		limitOfInputNumber(bbGame, "152", bbGame.generateNumber);

	}

	private void limitOfInputNumber(BbGame bbGame, String inputNumber, String randomNumber) {
		try {
			bbGame.limitOfInputNumber(inputNumber, randomNumber);
		} catch (IllegalArgumentException e) {
		}

		// 설정 초과 시 (메세지출력)
	}
}
