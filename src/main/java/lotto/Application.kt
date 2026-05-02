package lotto

import lotto.service.LottoService
import lotto.ui.InputView
import lotto.ui.OutputView


fun main() {
    val service = LottoService()

    val amount = OutputView.retryOnError { InputView.readPurchaseAmount() }
    val result = service.purchase(amount)
    OutputView.printPurchaseResult(result)

    val winningNumber = OutputView.retryOnError { InputView.readWinningNumber() }
    val statistics = service.statistics(result, winningNumber)
    OutputView.printStatistics(statistics)
}