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
		BbGame bbGame = new BbGame();

		bbGame.generateNumber = "123";
		// 숫자생성
		// 사용자 입력
		// 숫자 비교
		// 비교 결과

		GuessResolve oneStrikeTwoBall = new GuessResolve(false, 1, 2);
		GuessResolve threeStrike = new GuessResolve(true, 3, 0);
		GuessResolve out = new GuessResolve(false, 0, 0);

		resultCheck(bbGame, "321", oneStrikeTwoBall);
		resultCheck(bbGame, "123", threeStrike);
		resultCheck(bbGame, "678", out);

	}

	private void resultCheck(BbGame bbGame, String inputNumber, GuessResolve guessResolve) {
		try {
			bbGame.guessResult(inputNumber, guessResolve);
		} catch (IllegalArgumentException e) {
		}
	}
}
