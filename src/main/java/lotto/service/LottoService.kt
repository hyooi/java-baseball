package lotto.service

import lotto.domain.Amount
import lotto.domain.Lotto
import lotto.domain.Rank
import lotto.domain.WinningNumber
import kotlin.math.roundToInt

class LottoService {
    fun purchase(amount: Amount): List<Lotto> =
        List(amount.value / Lotto.LOTTO_PRICE) {
            Lotto((Lotto.LOTTO_MIN..Lotto.LOTTO_MAX)
                .shuffled()
                .take(Lotto.LOTTO_SIZE)
            )
        }

    fun result(lottos: List<Lotto>, winningNumber: WinningNumber): Map<Rank, Int> {
        val counts = lottos
            .map { winningNumber.match(it) }
            .groupingBy { it }
            .eachCount()

        return Rank.entries
            .filter { it != Rank.MISS }
            .associateWith { counts.getOrDefault(it, 0) }
    }

    fun revenue(amount: Amount, statistics: Map<Rank, Int>): Double {
        val totalPrize = statistics.entries.sumOf { (rank, count) -> rank.prize * count }
        return totalPrize.toDouble() / amount.value * 100
    }
}