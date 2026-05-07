package lotto.domain

class WinningNumber(winningLotto: Lotto, bonus: Int) {
    val winningLotto: Lotto
    val bonus: Int

    init {
        validate(winningLotto, bonus)

        this.winningLotto = winningLotto
        this.bonus = bonus
    }

    private fun validate(lotto: Lotto, bonusNumber: Int) {
        require(bonusNumber in Lotto.LOTTO_MIN..Lotto.LOTTO_MAX) {
            "The bonus number must be between ${Lotto.LOTTO_MIN}~${Lotto.LOTTO_MAX}."
        }
        require(!lotto.contains(bonusNumber)) {
            "Bonus numbers cannot be duplicated with winning numbers."
        }
    }

    fun match(lotto: Lotto): Rank {
        val matchCount = lotto.countMatch(winningLotto.numbers)
        val bonusMatch = lotto.contains(bonus)

        return Rank.of(matchCount, bonusMatch)
    }

}