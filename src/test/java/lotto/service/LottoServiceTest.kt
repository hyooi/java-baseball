package lotto.service

import lotto.domain.Amount
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class LottoServiceTest {
    @Test
    fun `정상 케이스`() {
        val result = LottoService().purchase(Amount(5000))

        assertThat(result).hasSize(5)
        result.forEach { lotto ->
            assertThat(lotto.numbers).hasSize(6)
            assertThat(lotto.numbers).allMatch { it in 1..45 }
            assertThat(lotto.numbers).doesNotHaveDuplicates()
        }
    }
}