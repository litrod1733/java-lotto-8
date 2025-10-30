package lotto.util;

import lotto.view.InputView;

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

	public static void validateRange(int n) {
		require(1 <= n && n <= 45, "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
	}

	public static void validateSize(java.util.List<Integer> nums, int size) {
		require(nums.size() == size, "[ERROR] 로또 번호는 " + size + "개여야 합니다.");
	}

	public static void validateNoDuplicate(java.util.List<Integer> nums) {
		require(nums.stream().distinct().count() == nums.size(), "[ERROR] 로또 번호는 중복될 수 없습니다.");
	}
}
