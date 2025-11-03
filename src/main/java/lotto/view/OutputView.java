package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.domain.Tickets;

public class OutputView {

	private OutputView() {}

	public static void printPurchasedTicket(Tickets tickets) {
		System.out.printf("%d개를 구매했습니다.%n", tickets.size());
		tickets.values().forEach(ticket -> System.out.println(ticket.lottoNumbers()));
	}

	public static void printStatistics(LottoResult result, double profitRate) {
		System.out.println("당첨 통계");
		System.out.println("---------");
		result.getResults().forEach((rank, count) -> {
			if (rank == Rank.MISS) return;

			printRankResult(rank, count);
		});

		System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
	}

	private static void printRankResult(Rank rank, int count) {
		if (rank == Rank.SECOND) {
			System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n",
				rank.getMatchCount(),
				formatMoney(rank.getPrize()),
				count);
			return;
		}

		System.out.printf("%d개 일치 (%s원) - %d개%n",
			rank.getMatchCount(),
			formatMoney(rank.getPrize()),
			count);
	}

	private static String formatMoney(int amount) {
		return String.format("%,d", amount);
	}
}
