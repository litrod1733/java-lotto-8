package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.Validators;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validators.require(numbers != null, "[ERROR] 로또 번호가 존재하지 않습니다.");
        Validators.validateSize(numbers, 6);
        Validators.validateNoDuplicate(numbers);
        numbers.forEach(Validators::validateRange);

        this.numbers = Collections.unmodifiableList(new ArrayList<>(numbers));
    }

    public List<Integer> numbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
