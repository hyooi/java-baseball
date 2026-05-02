package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test

class WinningLottoTest {
    @Test
    fun `정상 케이스`() {
        WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
    }

    @Test
    fun `보너스 번호가 1~45가 아니면 예외 발생`() {
        assertThatThrownBy { WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 50) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되면 예외 발생`() {
        assertThatThrownBy { WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 5) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}