package lotto.domain

class Lotto(numbers: List<Int>) {
    companion object {
        const val LOTTO_PRICE = 1_000
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
            "The lotto number must be ${LOTTO_SIZE}."
        }
        require(numbers.toSet().size == LOTTO_SIZE) {
            "There are duplicate numbers in the numbers."
        }
        require(numbers.all { it in LOTTO_MIN..LOTTO_MAX }) {
            "The lotto number must be between ${LOTTO_MIN}~${LOTTO_MAX}."
        }
    }

    fun contains(number: Int): Boolean = number in numbers

}