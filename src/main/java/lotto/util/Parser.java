package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

	public static List<Integer> parseInts(String input) {
		try {
			return Arrays.stream(input.split(",")).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 올바른 숫자 형식이 아닙니다.");
		}
	}
}
