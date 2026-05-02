package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test

class AmountTest {
    @Test
    fun `정상 케이스`() {
        Amount(1000)
        Amount(2500)
    }

    @Test
    fun `0이하면 에러 발생`() {
        assertThatThrownBy { Amount(0) }
            .isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { Amount(-1) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}