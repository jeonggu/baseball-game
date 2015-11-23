package com.eyeq.kjg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.eyeq.kjg.strategy.GenerationNumberStrategy;

public class BbGameTest {

	private BbGame bbGame;

	@Before
	public void setUp() {
		bbGame = new BbGame();

	}

	private void generateNumber(String number) {
		bbGame.setStrategy(new GenerationNumberStrategy() {

			@Override
			public String generateNumber() {
				// TODO Auto-generated method stub
				return number;
			}
		});
		bbGame.startGame();

	}

	@Test
	public void testInputInvalid_throwIllegalArgumentException() {
		generateNumber("123");

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
		// 숫자 생성
		generateNumber("123");
		// 사용자 입력
		assertEquals(true, bbGame.guessResult("123").isResult());
		assertEquals(3, bbGame.guessResult("123").getStrike().getValue());
		assertEquals(0, bbGame.guessResult("123").getBall().getValue());
	}

	// 정해진 횟수만큼 사용자가 입력 했을 때 게임 종료 여부 테스트
	@Test
	public void test3() {
		generateNumber("123");
		for (int i = 1; i <= 10; i++) {
			bbGame.guessResult("456");
		}

		// assertTrue(bbGame.isGameOver());
	}

	// 정해진 횟수만큼 사용자가 입력 했을 때 게임 종료 여부 테스트
	// 10번 중에 맞추는 테스트도 포함
	@Test
	public void 종료여부테스트() {
		generateNumber("123");
		Result result = bbGame.guessResult("123");
		bbGame.isGameOver(result);
	}

	// 점수 1000점 이후는 한번당 100점씩 감점
	// 10번째에서 맞추면 100점
	// scroe 객체 생성
	// 게임 점수 계산해주는 메소드만들고 테스트
	// 게임이 종료 되었을 때 몇번째

	@Test
	public void 점수관리테스트() {
		// * 한번에 맞췄을 때 점수 테스트
		// 랜덤값 생성
		generateNumber("123");
		// 사용자 입력 시 랜덤값과 비교하여 결과값 반환
		Result result = bbGame.guessResult("123");
		// 몇번째 게임인지 확인하고 점수 확인
		assertEquals(1000, Score.getScore(bbGame.nthGame, result));

		// * 중간에 맞췄을 때 점수 테스트
		// 새로운 게임 생성
		bbGame = new BbGame();
		// 랜덤값 생성
		generateNumber("123");
		// 사용자 입력값 여러번 넣기
		result = bbGame.guessResult("546");
		result = bbGame.guessResult("786");
		result = bbGame.guessResult("123");
		// 몇번째 게임인지 확인하고 점수 확인
		assertEquals(800, Score.getScore(bbGame.nthGame, result));

		// * 하나도 못맞췄을 경우 점수 테스트
		// 새로운 게임 생성
		bbGame = new BbGame();
		// 랜덤값 생성
		generateNumber("123");
		// 사용자 입력값 생성
		String[] userInput = { "234", "132", "543", "263", "543", "765", "587", "986", "567", "654" };
		// 하나도 못맞췄을 경우 0점 반환
		for (int i = 0; i < 10; i++) {
			result = bbGame.guessResult(userInput[i]);
		}
		assertEquals(0, Score.getScore(bbGame.nthGame, result));
	}
}
