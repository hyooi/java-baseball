package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test

class WinningNumberTest {
    @Test
    fun `정상 케이스`() {
        WinningNumber(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
    }

    @Test
    fun `보너스 번호가 1~45가 아니면 예외 발생`() {
        assertThatThrownBy { WinningNumber(Lotto(listOf(1, 2, 3, 4, 5, 6)), 50) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되면 예외 발생`() {
        assertThatThrownBy { WinningNumber(Lotto(listOf(1, 2, 3, 4, 5, 6)), 5) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun matchTest() {
        val winningNumber = WinningNumber(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
        assertThat(winningNumber.match(Lotto(listOf(1,2,3,4,5,6))))
            .isEqualTo(Rank.FIRST)
        assertThat(winningNumber.match(Lotto(listOf(1,2,3,4,5,7))))
            .isEqualTo(Rank.SECOND)
        assertThat(winningNumber.match(Lotto(listOf(1,2,3,4,5,10))))
            .isEqualTo(Rank.THIRD)
        assertThat(winningNumber.match(Lotto(listOf(1,2,3,4,9,10))))
            .isEqualTo(Rank.FOURTH)
        assertThat(winningNumber.match(Lotto(listOf(1,2,3,8,9,10))))
            .isEqualTo(Rank.FIFTH)
        assertThat(winningNumber.match(Lotto(listOf(1,2,7,8,9,10))))
            .isEqualTo(Rank.MISS)
    }
}