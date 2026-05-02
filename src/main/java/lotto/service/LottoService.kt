package lotto.service

import lotto.domain.Amount
import lotto.domain.Lotto
import lotto.domain.WinningNumber

class LottoService {
    fun purchase(amount: Amount): List<Lotto> =
        List(amount.value / Lotto.LOTTO_PRICE) {
            Lotto((Lotto.LOTTO_MIN..Lotto.LOTTO_MAX)
                .shuffled()
                .take(Lotto.LOTTO_SIZE)
            )
        }

    fun statistics(lottos: List<Lotto>, winningNumber: WinningNumber) {

    }
}