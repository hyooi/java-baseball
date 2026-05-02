package lotto.domain

class WinningLotto(lotto: Lotto, bonusNumber: Int) {
    val lotto: Lotto
    val bonusNumber: Int

    init {
        validate(lotto, bonusNumber)

        this.lotto = lotto
        this.bonusNumber = bonusNumber
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