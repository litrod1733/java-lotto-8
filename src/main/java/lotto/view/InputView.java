package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;

public final class InputView {
	private InputView() {}

	public static Money readPurchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		String line = Console.readLine();
		long amount = parseLong(line);
		return Money.of(amount);
	}

	private static long parseLong(String line) {
		try {
			return Long.parseLong(line.trim());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(("[ERROR] 구입 금액은 숫자여야 합니다."));
		}
	}
}
