package lotto.domain

class Amount(val value: Int) {
    init {
        require(value > 0) {
            "The purchase amount must be greater than 0 won."
        }
    }
}