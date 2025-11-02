package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class WinningNumbersTest {

	@Test
	@DisplayName("올바른 6개 숫자 입력 시 생성 성공")
	void validWinningNumbers() {
		assertDoesNotThrow(() -> new WinningNumbers(List.of(1, 3, 5, 14, 22, 45)));
	}

	@Test
	@DisplayName("당첨 번호는 정확히 6개여야 한다")
	void sizeMustBeSix() {
		assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(List.of(1, 2, 3, 4, 5)));
	}

	@Test
	@DisplayName("당첨 번호는 1~45 범위를 벗어나면 예외 발생")
	void numbersMustBeInRange() {
		assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(List.of(0, 2, 3, 4, 5, 6)));
		assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 46)));
	}

	@Test
	@DisplayName("당첨 번호는 중복될 수 없다")
	void numbersMustBeUnique() {
		assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(List.of(1, 1, 2, 3, 4, 5)));
	}
}
