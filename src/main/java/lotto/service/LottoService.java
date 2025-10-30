package lotto.service;

import lotto.domain.Money;
import lotto.domain.Tickets;
import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.generator.RandomLottoNumberGenerator;

public class LottoService {
	private final LottoNumberGenerator generator = new RandomLottoNumberGenerator();

	public Tickets purchase(Money money) {
		int count = money.toTicketCount();
		return Tickets.ofGenerated(count, generator);
	}
}
