package lotto.ui

import lotto.domain.Amount
import lotto.domain.Lotto
import lotto.domain.WinningNumber

object InputView {
    fun readPurchaseAmount(): Amount {
        println("[SYSTEM] Please enter the purchase amount.")
        val input = readlnOrNull()?.trim()?.toIntOrNull()
            ?: throw IllegalArgumentException("The amount must be numeric.")

        return Amount(input)
    }

    fun readWinningNumber(): WinningNumber {
        println("[SYSTEM] Please enter the winning number.")
        val winningNumber = readlnOrNull()
            ?.trim()
            ?.split(",")
            ?.map { it.trim().toInt() }
            ?.let { Lotto(it) }
            ?: throw IllegalArgumentException("The winning numbers must be numeric.")

        println("[SYSTEM] Please enter the bonus number.")
        val bonusNumber = readlnOrNull()?.trim()?.toIntOrNull()
            ?: throw IllegalArgumentException("The bonus number must be numeric.")

        return WinningNumber(winningNumber, bonusNumber)
    }
}