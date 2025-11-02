package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class Result {
	private final Map<Rank, Integer> results = new EnumMap<>(Rank.class);

	public Result() {
		for (Rank rank : Rank.values()) {
			results.put(rank, 0);
		}
	}

	public void record(Rank rank) {
		results.put(rank, results.get(rank) + 1);
	}

	public Map<Rank, Integer> getResults() {
		return results;
	}

	public double calculateProfitRate(Money purchaseMoney) {
		long totalPrize = results.entrySet().stream().mapToLong(entry -> entry.getKey().getPrize() * entry.getValue()).sum();

		return (double) totalPrize / purchaseMoney.amount() * 100;
	}
}