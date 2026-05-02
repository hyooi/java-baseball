package lotto.domain

class WinningNumber(lotto: Lotto, bonus: Int) {
    val lotto: Lotto
    val bonus: Int

    init {
        validate(lotto, bonus)

        this.lotto = lotto
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

}