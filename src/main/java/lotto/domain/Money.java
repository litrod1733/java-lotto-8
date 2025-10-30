package lotto.domain;

import lotto.util.Validators;

public final class Money {
	public static final int PRICE_PER_TICKET = 1_000;

	private final long amount;

	private Money(long amount) {
		this.amount = amount;
	}

	public static Money of(long amount) {
		Validators.requirePositive(amount, "[ERROR] 구입 금액은 0보다 커야 합니다.");
		Validators.requireDivisibleBy(amount, PRICE_PER_TICKET, "[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
		return new Money(amount);
	}

	public long amount() {
		return amount;
	}

	public int toTicketCount() {
		return (int) (amount / PRICE_PER_TICKET);
	}
}