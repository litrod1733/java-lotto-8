package lotto.controller;

import lotto.domain.*;
import lotto.service.*;
import lotto.view.*;

public class LottoController {
	private final LottoService lottoService = new LottoService();
	private final LottoResultService resultService = new LottoResultService();

	public void run() {
		Money money = InputView.readPurchaseAmount();

		Tickets tickets = lottoService.purchase(money);
		OutputView.printPurchasedTicket(tickets);

		WinningNumbers winningNumbers = InputView.readWinningNumbers();
		BonusNumber bonusNumber = InputView.readBonusNumber(winningNumbers);

		LottoResult result = resultService.calculateResult(
			tickets.values(),
			winningNumbers,
			bonusNumber
		);

		double profitRate = result.calculateProfitRate(money);
		OutputView.printStatistics(result, profitRate);
	}
}
