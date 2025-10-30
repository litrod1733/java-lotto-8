package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoTicket;

public final class RandomLottoNumberGenerator implements LottoNumberGenerator {

	@Override
	public LottoTicket generate() {
		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).stream().sorted().collect(Collectors.toList());
		return new LottoTicket(numbers);
	}
}
