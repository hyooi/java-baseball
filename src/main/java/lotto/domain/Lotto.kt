package lotto.domain

class Lotto(numbers: List<Int>) {
    constructor(vararg numbers: Int): this(numbers.toList())

    companion object { // const = static final
        const val LOTTO_PRICE: Int = 1_000
        const val LOTTO_SIZE: Int = 6
        const val LOTTO_MIN: Int = 1
        const val LOTTO_MAX: Int = 45
    }

    val numbers: List<Int>

    init {
        require(numbers.size == LOTTO_SIZE) { "The lotto number must be ${LOTTO_SIZE}." }
        require(numbers.toSet().size == LOTTO_SIZE) { "There are duplicate numbers in the numbers." }
        require(numbers.all { it in LOTTO_MIN..LOTTO_MAX }) {
            "The lotto number must be between ${LOTTO_MIN}~${LOTTO_MAX}."
        }

        this.numbers = numbers
    }

    fun countMatch(winningNumbers: List<Int>): Int =
        numbers.count { it in winningNumbers }
    fun contains(number: Int): Boolean = number in numbers

    override fun toString(): String = numbers.toString()
}