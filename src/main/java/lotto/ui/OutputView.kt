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
    }
}