package lotto.service;

import lotto.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LottoResultServiceTest {

	@Test
	@DisplayName("티켓/당첨/보너스 비교로 등수별 결과가 정확히 집계된다")
	void calculateResult() {
		WinningNumbers winning = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
		BonusNumber bonus = new BonusNumber(7, winning);

		LottoTicket first = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
		LottoTicket second = new LottoTicket(List.of(1, 2, 3, 4, 5, 7));
		LottoTicket third = new LottoTicket(List.of(1, 2, 3, 4, 5, 8));
		LottoTicket fourth = new LottoTicket(List.of(1, 2, 3, 4, 8, 9));
		LottoTicket fifth = new LottoTicket(List.of(1, 2, 3, 10, 11, 12));
		LottoTicket miss = new LottoTicket(List.of(1, 10, 11, 12, 13, 14));

		LottoResultService service = new LottoResultService();
		LottoResult result = service.calculateResult(
			List.of(first, second, third, fourth, fifth, miss),
			winning,
			bonus
		);

		assertEquals(1, result.getResults().get(Rank.FIRST));
		assertEquals(1, result.getResults().get(Rank.SECOND));
		assertEquals(1, result.getResults().get(Rank.THIRD));
		assertEquals(1, result.getResults().get(Rank.FOURTH));
		assertEquals(1, result.getResults().get(Rank.FIFTH));
		assertEquals(1, result.getResults().get(Rank.MISS));
	}
}
