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
		assertEquals(true, bbGame.guessResult("123").isResult());
		assertEquals(3, bbGame.guessResult("123").getStrike().getValue());
		assertEquals(0, bbGame.guessResult("123").getBall().getValue());
	}

	// 사용자 입력 값 횟수제한 테스트
	@Test
	public void testlimitOfInputNumber() {
		// 게임 생성
		BbGame bbGame = new BbGame();
		// 숫자 생성
		bbGame.generateNumber = "123";

		// 사용자 입력
		bbGame.limitOfInputNumber("243");
		bbGame.limitOfInputNumber("231");
		
		// 게임 종료 플래그(

	}
	
	// 10번 시도중 맞췄을 때 게임 종료 테스트
	
}
