package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test

class LottoTest {
    @Test
    fun `정상 케이스`() {
        Lotto(listOf(1, 2, 3, 4, 5, 6))
        Lotto(listOf(7, 8, 9, 10, 11, 12))
        Lotto(listOf(13, 14, 15, 16, 17, 18))
    }

    @Test
    fun `로또 번호가 6개가 아니면 예외 발생`() {
        assertThatThrownBy { Lotto(listOf(1, 2, 3, 4, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `로또 번호에 중복이 있으면 예외 발생`() {
        assertThatThrownBy { Lotto(listOf(1, 2, 3, 4, 5, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `로또 번호가 범위를 벗어나면 예외 발생`() {
        assertThatThrownBy { Lotto(listOf(0, 1, 2, 3, 4, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}