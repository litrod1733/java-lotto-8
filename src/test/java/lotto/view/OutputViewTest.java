package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.domain.Money;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class OutputViewTest {

	private final	PrintStream originalOut = System.out;
	private ByteArrayOutputStream out;

	@BeforeEach
	void setUp() {
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
	}

	@AfterEach
	void tearDown() {
		System.setOut(originalOut);
	}

	@Test
	@DisplayName("헤더/등수별 라인/보너스 문구/수익률 포맷을 올바르게 출력한다")
	void printStatistics_formatsCorrectly() {
		LottoResult result = new LottoResult();

		result.record(Rank.SECOND);
		result.record(Rank.FOURTH);
		result.record(Rank.FIFTH);
		result.record(Rank.FIFTH);
		result.record(Rank.MISS);

		double profitRate = result.calculateProfitRate(Money.of(100_000));

		OutputView.printStatistics(result, profitRate);
		String printed = out.toString().replace("\r\n", "\n");

		assertTrue(printed.contains("당첨 통계"));
		assertTrue(printed.contains("---------"));

		assertTrue(printed.contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 1개"));
		assertTrue(printed.contains("4개 일치 (50,000원) - 1개"));
		assertTrue(printed.contains("3개 일치 (5,000원) - 2개"));
		assertFalse(printed.contains("MISS"));

		assertTrue(printed.matches("(?s).*총 수익률은 \\d+\\.\\d%입니다\\..*"));
	}
}
