package lotto.ui

import lotto.domain.Amount

object InputView {
    fun readPurchaseAmount(): Amount {
        println("[SYSTEM] Please enter the purchase amount.")
        val input = readlnOrNull()?.trim()?.toIntOrNull()
            ?: throw IllegalArgumentException("The amount must be numeric.")

        return Amount(input)
    }
}