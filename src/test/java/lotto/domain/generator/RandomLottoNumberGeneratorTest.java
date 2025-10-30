package lotto.domain.generator;

import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RandomLottoNumberGeneratorTest {

	private final LottoNumberGenerator generator = new RandomLottoNumberGenerator();

	@RepeatedTest(5)
	@DisplayName("로또 번호는 6개, 1~45 범위, 중복 없음, 오름차순 정렬")
	void generateLottoNumbers() {
		LottoTicket ticket = generator.generate();
		List<Integer> numbers = ticket.lottoNumbers();

		assertEquals(6, numbers.size());

		assertTrue(numbers.stream().allMatch(n -> n >= 1 && n <= 45));

		long distinct = numbers.stream().distinct().count();
		assertEquals(6, distinct);

		for (int i = 0; i < numbers.size() - 1; i++) {
			assertTrue(numbers.get(i) < numbers.get(i + 1));
		}
	}
}
