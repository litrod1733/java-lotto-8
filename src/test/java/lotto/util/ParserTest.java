package lotto.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

	@Test
	@DisplayName("쉼표로 구분된 정수를 올바르게 파싱한다")
	void parseCommaSeparatedInts() {
		List<Integer> nums = Parser.parseInts("1,2,3,4,5,6");
		assertEquals(List.of(1,2,3,4,5,6), nums);
	}

	@Test
	@DisplayName("공백이 포함된 문자열도 정상적으로 파싱한다")
	void trimSpaces() {
		List<Integer> nums = Parser.parseInts("1 , 2 , 3 , 4 , 5 , 6 ");
		assertEquals(List.of(1,2,3,4,5,6), nums);
	}

	@Test
	@DisplayName("숫자가 아닌 값이 포함되면 예외를 던진다")
	void invalidTokenThrows() {
		assertThrows(IllegalArgumentException.class, () -> Parser.parseInts("1,2,a,4,5,6"));
	}
}
