package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class LottoResultTest {

	@Test
	@DisplayName("결과 기록 시 등수별 카운트가 누적된다")
	void recordCounts() {
		LottoResult result = new LottoResult();

		result.record(Rank.FIFTH);
		result.record(Rank.FIFTH);
		result.record(Rank.FOURTH);
		result.record(Rank.MISS);

		assertEquals(2, result.getResults().get(Rank.FIFTH));
		assertEquals(1, result.getResults().get(Rank.FOURTH));
		assertEquals(1, result.getResults().get(Rank.MISS));
		assertEquals(0, result.getResults().get(Rank.THIRD));
	}

	@Test
	@DisplayName("총 상금 합을 기반으로 수익률을 계산한다")
	void profitRate() {
		LottoResult result = new LottoResult();

		result.record(Rank.THIRD);
		result.record(Rank.FIFTH);
		result.record(Rank.FIFTH);

		Money purchase = Money.of(100_000);
		double rate = result.calculateProfitRate(purchase);

		assertEquals(1510.0, rate, 0.0001);
	}
}
