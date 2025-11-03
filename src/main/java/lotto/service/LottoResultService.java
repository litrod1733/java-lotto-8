package lotto.service;

import lotto.domain.*;
import java.util.List;

public class LottoResultService {

	public LottoResult calculateResult(List<LottoTicket> tickets, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
		LottoResult result = new LottoResult();

		for (LottoTicket ticket : tickets) {
			int matchCount = countMatches(ticket, winningNumbers);
			boolean matchBonus = ticket.contains(bonusNumber.getNumber());
			Rank rank = Rank.valueOf(matchCount, matchBonus);
			result.record(rank);
		}

		return result;
	}

	private int countMatches(LottoTicket ticket, WinningNumbers winningNumbers) {
		return (int) ticket.lottoNumbers().stream().filter(winningNumbers::contains).count();
	}
}
