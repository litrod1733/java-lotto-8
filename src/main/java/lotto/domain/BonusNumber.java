package lotto.domain;

public class BonusNumber {
	private final int number;

	public BonusNumber(int number, WinningNumbers winningNumbers) {
		validate(number, winningNumbers);
		this.number = number;
	}

	private void validate(int number, WinningNumbers winningNumbers) {
		if (number <1 || number > 45) {
			throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이여야 합니다.");
		}

		if (winningNumbers.contains(number)) {
			throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
		}
	}

	public int getNumber() {
		return number;
	}
}
