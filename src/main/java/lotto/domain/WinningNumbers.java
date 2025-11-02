package lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinningNumbers {
	private final List<Integer> numbers;

	public WinningNumbers(List<Integer> numbers) {
		validate(numbers);
		this.numbers = List.copyOf(numbers);
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
		}

		boolean outOfRange = numbers.stream().anyMatch(n -> n < 1 || n > 45);
		if (outOfRange) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이여야 합니다.");
		}

		long distinct = numbers.stream().distinct().count();
		if (distinct != 6) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
		}
	}

	public List<Integer> numbers() {
		return Collections.unmodifiableList(numbers);
	}

	public boolean contains(int number) {
		return numbers.contains(number);
	}
}
