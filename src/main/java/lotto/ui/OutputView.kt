package lotto.ui

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
}