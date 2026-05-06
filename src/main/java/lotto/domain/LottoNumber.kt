package lotto.domain

@JvmInline
value class LottoNumber(private val number: Int) { // 파라미터가 하나면 value class사용하고, 두개 이상이면 data class
}