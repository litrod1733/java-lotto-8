package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BonusNumberTest {

	@Test
	@DisplayName("보너스 번호가 올바른 범위이면서 당첨 번호와 중복되지 않으면 생성 성공")
	void validBonusNumber() {
		WinningNumbers win = new WinningNumbers(List.of(1, 3, 5, 14, 22, 45));
		assertDoesNotThrow(() -> new BonusNumber(7, win));
	}

	@Test
	@DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외 발생")
	void bonusMustBeInRange() {
		WinningNumbers win = new WinningNumbers(List.of(1, 3, 5, 14, 22, 45));
		assertThrows(IllegalArgumentException.class, () -> new BonusNumber(0, win));
		assertThrows(IllegalArgumentException.class, () -> new BonusNumber(46, win));
	}

	@Test
	@DisplayName("보너스 번호가 당첨 번호와 중복되면 예외 발생")
	void bonusMustNotDuplicateWinning() {
		WinningNumbers win = new WinningNumbers(List.of(1, 3, 5, 14, 22, 45));
		assertThrows(IllegalArgumentException.class, () -> new BonusNumber(5, win));
	}
}
