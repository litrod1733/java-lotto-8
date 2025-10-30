package lotto.util;

public final class Validators {
	private Validators() {}

	public static void require(boolean condition, String message) {
		if (condition) return;
		throw new IllegalArgumentException(message);
	}

	public static void requirePositive(long value, String message) {
		require(value > 0, message);
	}

	public static void requireDivisibleBy(long value, long unit, String message) {
		require((value & unit) == 0, message);
	}
}
