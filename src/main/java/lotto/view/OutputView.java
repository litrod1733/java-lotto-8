package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.Rank;
import lotto.domain.Tickets;

public class OutputView {

	public static void printStatistics(LottoResult result, double profitRate) {
		System.out.println("당첨 통계");
		System.out.println("---------");
		result.getResults().forEach((rank, count) -> {
			if (rank == Rank.MISS) return;

			printRankResult(rank, count);
		});

		System.out.printf("총 수익률은 %.2f%%입니다.%n", profitRate);
	}

	public static void printPurchasedTicket(Tickets tickets) {
		System.out.printf("%d개를 구매했습니다.%n", tickets.size());
		tickets.values().forEach(ticket -> System.out.println(ticket.lottoNumbers()));
	}

	private static void printRankResult(Rank rank, int count) {
		if (rank == Rank.SECOND) {
			System.out.printf("%d개 일치, 보너스 볼 일치 (%d원) - %d개%n",
				rank.getMatchCount(),
				rank.getPrize(),
				count);
			return;
		}

		System.out.printf("%d개 일치 (%d원) - %d개%n",
			rank.getMatchCount(),
			rank.getPrize(),
			count);
	}
}
