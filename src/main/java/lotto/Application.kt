package lotto

import lotto.service.LottoService
import lotto.ui.InputView
import lotto.ui.OutputView


fun main() {
    val service = LottoService()

    val purchaseAmount = OutputView.retryOnError { InputView.readPurchaseAmount() }

}