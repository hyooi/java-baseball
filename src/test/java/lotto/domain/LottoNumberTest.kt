package lotto.domain

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.Test

class LottoNumberTest {
    @Test
    fun `번호가 같으면 같은 로또 번호이다`() {
        LottoNumber(1) shouldBe LottoNumber(1)
        LottoNumber(1) shouldNotBe LottoNumber(5)
    }
}