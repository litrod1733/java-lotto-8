package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.generator.LottoNumberGenerator;

public final class Tickets {
	private final List<LottoTicket> values;

	public Tickets(List<LottoTicket> values) {
		this.values = List.copyOf(values);
	}

	public static Tickets ofGenerated(int count, LottoNumberGenerator generator) {
		List<LottoTicket> list = new ArrayList<>();
		IntStream.range(0, count).forEach(i -> list.add(generator.generate()));
		return new Tickets(list);
	}

	public int size() {
		return values.size();
	}

	public List<LottoTicket> values() {
		return Collections.unmodifiableList(values);
	}
}
