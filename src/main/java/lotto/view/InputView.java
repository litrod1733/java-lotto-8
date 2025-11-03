package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.domain.BonusNumber;
import lotto.util.Parser;

import java.util.List;

public final class InputView {
	private InputView() {}

	public static Money readPurchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		String line = Console.readLine();
		long amount = parseLong(line);
		return Money.of(amount);
	}

	public static WinningNumbers readWinningNumbers() {
		System.out.println("당첨 번호를 입력해 주세요.");
		String input = Console.readLine();
		List<Integer> numbers = Parser.parseInts(input);
		return new WinningNumbers(numbers);
	}

	public static BonusNumber readBonusNumber(WinningNumbers winningNumbers) {
		System.out.println("보너스 번호를 입력해 주세요.");
		int number = Integer.parseInt(Console.readLine());
		return new BonusNumber(number, winningNumbers);
	}

	private static long parseLong(String line) {
		try {
			return Long.parseLong(line.trim());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(("[ERROR] 구입 금액은 숫자여야 합니다."));
		}
	}
}
