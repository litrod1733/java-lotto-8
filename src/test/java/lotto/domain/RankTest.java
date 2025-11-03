package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class RankTest {

	@Test
	@DisplayName("매칭 개수와 보너스 여부에 따라 올바른 Rank가 결정된다")
	void rankMapping() {
		assertEquals(Rank.FIRST, Rank.valueOf(6, false));
		assertEquals(Rank.SECOND, Rank.valueOf(5, true));
		assertEquals(Rank.THIRD, Rank.valueOf(5, false));
		assertEquals(Rank.FOURTH, Rank.valueOf(4, false));
		assertEquals(Rank.FIFTH, Rank.valueOf(3, false));
		assertEquals(Rank.MISS, Rank.valueOf(2, false));
	}

	@Test
	@DisplayName("등수별 상금이 정확해야 한다")
	void prizeAmounts() {
		assertEquals(2_000_000_000, Rank.FIRST.getPrize());
		assertEquals(30_000_000, Rank.SECOND.getPrize());
		assertEquals(1_500_000, Rank.THIRD.getPrize());
		assertEquals(50_000, Rank.FOURTH.getPrize());
		assertEquals(5_000, Rank.FIFTH.getPrize());
		assertEquals(0, Rank.MISS.getPrize());
	}
}
