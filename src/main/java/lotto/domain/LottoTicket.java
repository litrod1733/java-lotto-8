package lotto.domain;

import java.util.List;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.util.Validators;

public final class LottoTicket {
	private final Lotto lotto;

	public LottoTicket(List<Integer> numbers) {
		List<Integer> sorted = sort(numbers);
		validate(sorted);
		this.lotto = new Lotto(sorted);
	}

	public List<Integer> lottoNumbers() {
		return lotto.numbers();
	}

	private static List<Integer> sort(List<Integer> numbers) {
		Validators.require(Objects.nonNull(numbers), "[ERROR] 로또 번호가 존재하지 않습니다.");
		return numbers.stream().sorted().collect(Collectors.toList());
	}

	private static void validate(List<Integer> numbers) {
		Validators.validateSize(numbers, 6);
		Validators.validateNoDuplicate(numbers);
		numbers.forEach(Validators::validateRange);
	}
}
