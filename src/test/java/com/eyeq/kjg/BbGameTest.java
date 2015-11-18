package com.eyeq.kjg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

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
		// 입력 횟수 제한(게임셋팅)
		ConfigSetting setting = new ConfigSetting();
		// 게임종료 플래그
		boolean endGame = false;
		// 사용자 입력 값
		String[] inputNumber = { "324", "543", "456", "785", "231", "976", "675", "956", "765", "231" };

		// 아홉번째일 때를 체크해서 10번째에도 맞추지 못하면 게임을 종료해야한다.
		for (int i = 0; i < setting.getLimited(); i++) {
			if (bbGame.generateNumber == inputNumber[i]) {
				bbGame.resultOfWinORDefeat(true);
			} else {
				bbGame.resultOfWinORDefeat(false);
			}

			if (i == 9) {
				assertEquals(false, setting.isEndGame());
				// '패배하였습니다'란 메세지를 뿌리는 부분
				break;
			}
		}
	}

	// 10번 시도중 맞췄을 때 게임 종료 테스트
	@Test
	public void 열번시도중맞췄을때게임종료() {
		// 게임 생성
		BbGame bbGame = new BbGame();
		// 숫자 생성
		bbGame.generateNumber = "123";
		// 입력 횟수 제한(게임셋팅), 게임종료 플래그
		ConfigSetting setting = new ConfigSetting();
		// 사용자 입력 값
		String[] inputNumber = { "324", "543", "456", "785", "123", "976", "675", "956", "765", "231" };

		for (int i = 0; i < setting.getLimited(); i++) {
			if (bbGame.generateNumber == inputNumber[i]) {
				bbGame.resultOfWinORDefeat(true);
			} else {
				bbGame.resultOfWinORDefeat(false);
			}

			if (setting.isEndGame()) {
				assertEquals(true, setting.isEndGame());
				// '승리하였습니다'란 메세지를 뿌리는 부분
				break;
			}
		}
	}
}
