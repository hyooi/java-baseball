package lotto.service

import lotto.domain.Amount
import lotto.domain.Lotto
import lotto.domain.Rank
import lotto.domain.WinningNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class LottoServiceTest {
    @Test
    fun purchase() {
        val result = LottoService().purchase(Amount(5000))

        assertThat(result).hasSize(5)
        result.forEach { lotto ->
            assertThat(lotto.numbers).hasSize(6)
            assertThat(lotto.numbers).allMatch { it in 1..45 }
            assertThat(lotto.numbers).doesNotHaveDuplicates()
        }
    }

    @Test
    fun result() {
        val winningNumber = WinningNumber(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),  // 1등
            Lotto(listOf(1, 2, 3, 4, 5, 7)),  // 2등
            Lotto(listOf(1, 2, 3, 4, 5, 8)),  // 3등
            Lotto(listOf(8, 9, 10, 11, 12, 13)), // 낙첨
        )

        val result = LottoService().result(lottos, winningNumber)
        assertThat(result[Rank.FIRST]).isEqualTo(1)
        assertThat(result[Rank.SECOND]).isEqualTo(1)
        assertThat(result[Rank.THIRD]).isEqualTo(1)
        assertThat(result[Rank.FOURTH]).isEqualTo(0)
        assertThat(result[Rank.FIFTH]).isEqualTo(0)
    }
}