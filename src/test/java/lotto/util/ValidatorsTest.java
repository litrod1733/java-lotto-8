package lotto.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorsTest {

	@Test
	@DisplayName("require가 true이면 예외가 발생하지 않는다.")
	void requireTrueDoesNotThrow() {
		assertDoesNotThrow(() -> Validators.require(true, "[ERROR]"));
	}

	@Test
	@DisplayName("require가 false이면 예외를 던진다.")
	void requireFalseThrows() {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Validators.require(false, "[ERROR] 메시지"));
		assertTrue(e.getMessage().startsWith("[ERROR]"));
	}

	@Test
	@DisplayName("requireOsitive는 양수일 때 통과하고 0이나 음수면 예외 발생")
	void requirePositiveTest() {
		assertDoesNotThrow(() -> Validators.requirePositive(1, "[ERROR]"));
		assertThrows(IllegalArgumentException.class, () -> Validators.requirePositive(0, "[ERROR]"));
		assertThrows(IllegalArgumentException.class, () -> Validators.requirePositive(-5, "[ERROR]"));
	}

	@Test
	@DisplayName("requireDivisibleBy는 단위 배수이면 통과, 아니면 예외 발생")
	void requireDivisibleByTest() {
		assertDoesNotThrow(() -> Validators.requireDivisibleBy(2000, 1000, "[ERROR]"));
		assertThrows(IllegalArgumentException.class, () -> Validators.requireDivisibleBy(2500, 1000, "[ERROR]"));
	}
}
