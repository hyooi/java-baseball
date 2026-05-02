package lotto.ui

import lotto.domain.Lotto
import lotto.domain.Rank

object OutputView {
    fun printError(message: String) {
        println(message)
    }

    fun <T> retryOnError(block: () -> T): T {
        while (true) {
            try {
                return block()
            } catch (e: IllegalArgumentException) {
                printError("[ERROR] ${e.message}")
            }
        }
    }

    fun printPurchaseResult(lottos: List<Lotto>) {
        println("[SYSTEM] ${lottos.size} purchased.")
        lottos.forEach { println(it) }
    }

    fun printStatistics(statistics:  Map<Rank, Int>) {
        println("[SYSTEM] Winning Statistics")
        println("[SYSTEM] ---")
        statistics.forEach { (rank, value) ->
            println("[SYSTEM] ${rank.matchCount} matches (${rank.prize}) won - ${value} piece")
        }
    }

    fun printRevenue(revenue: Double) {
        println("[SYSTEM] The total revenue is ${"%.1f".format(revenue)}%.")
    }
}