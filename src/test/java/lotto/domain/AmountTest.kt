package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class AmountTest {
    @ValueSource(ints = [1000, 25000])
    @ParameterizedTest
    fun `정상 케이스` (value: Int){
        Amount(value)
    }

    @Test
    fun `0이하면 에러 발생`() {
        assertThatThrownBy { Amount(0) }
            .isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { Amount(-1) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}