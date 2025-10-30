package lotto.domain;

import org.junit.jupiter.api.Test;
import  org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {

	@Test
	@DisplayName("양수이면서 1000원 단위인 금액은 생성 성공")
	void validMoney() {
		assertDoesNotThrow(() -> Money.of(8000));
	}

	@Test
	@DisplayName("0원 또는 음수일 때 예외 발생")
	void invalidMoneyNegativeOrZero() {
		assertThrows(IllegalArgumentException.class, () -> Money.of(0));
		assertThrows(IllegalArgumentException.class, () -> Money.of(-1000));
	}

	@Test
	@DisplayName("toTicketCount()는 구입 금액을 1000으로 나눈 개수를 반환")
	void toTicketCount() {
		Money money = Money.of(8000);
		assertEquals(8, money.toTicketCount());
	}
}
