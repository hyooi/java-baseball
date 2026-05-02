package lotto.domain

class Lotto(numbers: List<Int>) {
    companion object {
        const val LOTTO_SIZE = 6
        const val LOTTO_MIN = 1
        const val LOTTO_MAX = 45
    }

    val numbers: List<Int>

    init {
        validate(numbers)
        this.numbers = numbers
    }

    private fun validate(numbers: List<Int>) {
        require(numbers.size == LOTTO_SIZE) {
            "로또 번호는 ${LOTTO_SIZE}개여야 합니다."
        }
        require(numbers.toSet().size == LOTTO_SIZE) {
            "로또 번호에 중복된 숫자가 있습니다."
        }
        require(numbers.all { it in LOTTO_MIN..LOTTO_MAX }) {
            "로또 번호는 ${LOTTO_MIN}~${LOTTO_MAX} 사이의 숫자여야 합니다."
        }
    }
}